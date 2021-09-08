import java.util.List;

public class NewbornCreature extends Creature {
    private Creature parent;
    public NewbornCreature(Creature parent) {
        super(parent.getX(), parent.getY(), 'n', 0, 1, "Newborn");
        this.parent = parent;
    }

    @Override
    public void move() {
        super.move();

        //一回合結束之後就不再是剛被繁殖的生物
        getEcosystem().updateSpriteLocation(parent.clone(), getX(), getY());
    }

    @Override
    protected Direction decideMovingDirection(List<Direction> availableDirections) {
        return Direction.NO_DIRECTION;  //被繁殖的生物第一回合不能移動
    }

    public Creature getParent() {
        return parent;
    }
}
