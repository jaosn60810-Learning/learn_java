package com.company;

/**
 * 所有遊戲物件
 */
public abstract class Sprite implements EcosystemAware {
    private int x;
    private int y;
    private char ic;
    private Ecosystem ecosystem;

    public Sprite(int x, int y, char ic) {
        this.x = x;
        this.y = y;
        this.ic = ic;
    }

    public Ecosystem getEcosystem() {
        return ecosystem;
    }

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

    @Override
    public void setEcosystem(Ecosystem ecosystem) {
        this.ecosystem = ecosystem;
    }

    public abstract void move();

    @Override
    public String toString() {
        return String.valueOf(getIc());
    }
}
