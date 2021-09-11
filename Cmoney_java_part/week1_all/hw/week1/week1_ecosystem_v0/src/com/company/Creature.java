package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature extends Sprite {
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
        int newX = getX() + direction.getDx();
        int newY = getY() + direction.getDy();
        setLife(getLife() - 1);
        getEcosystem().updateSpriteLocation(this, newX, newY,getLife()); //最後才真正移動
    }

    protected List<Direction> getAvailableMovingDirections() {
        List<Direction> availableDirections = new ArrayList<>();
        for (Direction direction : Direction.getMovingDirections()) {
            int x = getX() + direction.getDx();
            int y = getY() + direction.getDy();

            if (x >= 0 && y >= 0 &&  /*邊界檢查*/
                    x < getEcosystem().getWidth() && y < getEcosystem().getHeight()) {
                Sprite sprite = getEcosystem().getSpriteAt(x, y);
                if (sprite instanceof Block)
                    availableDirections.add(direction);
            }
        }
        return availableDirections;
    }


    protected abstract Direction decideMovingDirection(List<Direction> availableDirections);

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


}
