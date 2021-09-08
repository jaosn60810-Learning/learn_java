import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature extends Sprite implements Cloneable{
    private int level;
    private int life;
    private String name;

    public Creature(int x, int y, char ic, int level, int life, String name) {
        super(x, y, ic);
        this.level = level;
        this.life = life;
        this.name = name;
    }

    public void move() {
        Direction direction = decideMovingDirection(getAvailableMovingDirections());

        if (direction == Direction.NO_DIRECTION)
            setLife(getLife() - 1);  //不移動 生命減少
        else {
            int newX = getX() + direction.getDx();
            int newY = getY() + direction.getDy();

            if (canEat(getEcosystem().getSpriteAt(newX, newY)))  //等級較高 吃掉
                    eat();

            getEcosystem().updateSpriteLocation(this, newX, newY); //最後才真正移動
        }


    }

    protected List<Direction> getAvailableMovingDirections() {
        List<Direction> availableDirections = new ArrayList<>();
        for (Direction direction : Direction.getMovingDirections()) {
            int x = getX() + direction.getDx();
            int y = getY() + direction.getDy();

            if (x >= 0 && y >= 0 &&  /*邊界檢查*/
                    x < getEcosystem().getWidth() && y < getEcosystem().getHeight()) {
                Sprite sprite = getEcosystem().getSpriteAt(x, y);
                if (sprite instanceof Block || canEat(sprite))
                    availableDirections.add(direction);
            }
        }
        return availableDirections;
    }


    protected abstract Direction decideMovingDirection(List<Direction> availableDirections);

    public void eat() {
        this.life ++;

        if (new Random().nextInt(100) < 50)  // 1/2機率繁殖
            breed();
    }

    private boolean canEat(Sprite sprite) {
        return sprite instanceof Creature &&
                getLevel() >= ((Creature) sprite).getLevel() && // 只能吃比自己等級低的生物
                (!(sprite instanceof NewbornCreature) ||
                        ((NewbornCreature) sprite).getParent() != this); // 但不吃自己的孩子
    }

    public void breed() {
        getEcosystem().putSprite(new NewbornCreature(this));
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Creature clone() {
        try {
            return (Creature) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
