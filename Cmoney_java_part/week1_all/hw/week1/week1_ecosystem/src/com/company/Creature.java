package com.company;

import java.util.List;

public abstract class Creature {
    private int x;
    private int y;
    private int level;
    private int life;
    private String name;
    private  char ic;
    private Ecosystem ecosystem;

    public Creature(int x, int y, int level, int life, String name, char ic) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.life = life;
        this.name = name;
        this.ic = ic;
    }

    public void move() {
        Direction direction = decideMovingDirection(getAvailableMovingDirections());
        int newX = getX() + direction.getDx();
        int newY = getY() + direction.getDy();
        setLife(getLife() - 1);
        getEcosystem().updateSpriteLocation(this, newX, newY,getLife()); //最後才真正移動
    }

    protected abstract Direction decideMovingDirection(List<Direction> availableDirections);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getIc() {
        return ic;
    }

    public Ecosystem getEcosystem() {
        return ecosystem;
    }

    public void setEcosystem(Ecosystem ecosystem) {
        this.ecosystem = ecosystem;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return String.valueOf(getIc());
    }
}
