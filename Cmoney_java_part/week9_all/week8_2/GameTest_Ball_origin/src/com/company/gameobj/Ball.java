/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.gameobj;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author k1207
 */
public class Ball extends GameObject {

    private Color color;
    private int ox, oy;

    public Ball(int x, int y, int r, Color color) {
        super(x, y, r);
        setColor(color);
        ox = x;
        oy = y;
    }

    public Ball(int x, int y, int r, Color color, Vector speed) {
        super(x, y, r);
        setColor(color);
        ox = x;
        oy = y;
    }

    public int ox() {
        return ox;
    }

    public int oy() {
        return oy;
    }

    public double disFromO() {
        double x = painter().exactCenterX() - ox;
        double y = painter().exactCenterY() - oy;
        return Math.sqrt(x * x + y * y);
    }

    public final void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(painter().left(), painter().top(), painter().width(), painter().height());
        g.setColor(Color.BLACK);
    }

    @Override
    public void update() {
    }

}
