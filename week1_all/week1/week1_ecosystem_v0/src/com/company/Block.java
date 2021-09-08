package com.company;

/**
 * 空格
 */
public class Block extends Sprite {
    public Block(int x, int y, Ecosystem ecosystem) {
        super(x, y, '.');
        setEcosystem(ecosystem);
    }

    @Override
    public void move() {
    }
}
