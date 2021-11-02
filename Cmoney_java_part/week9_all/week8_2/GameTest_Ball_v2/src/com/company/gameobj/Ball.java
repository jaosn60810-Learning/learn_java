/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.gameobj;

import com.company.utils.CommandSolver;
import com.company.utils.GameKernel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * @author k1207
 */
public class Ball extends GameObject implements GameKernel.GameInterface {


    private Color color;
    private int ox, oy;
    private boolean canMove;
    private boolean canShoot;
    private int id;

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

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
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
