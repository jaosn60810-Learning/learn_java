/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.gameobj;

/**
 *
 * @author k1207
 */
public class Circle extends Shape {

    public Circle(double left, double top, double right, double bottom) {
        super(left, top, right, bottom);
    }

    public Circle(double ox, double oy, double r) {
        super(ox - r, oy - r, ox + r, oy + r);
    }

    public Circle(Circle circle) {
        super(circle.left, circle.top, circle.right, circle.bottom);
    }

    public final double exactRadius() {
        return (right - left) / 2f;
    }

    public final double radius() {
        return (right - left) / 2;
    }

    public boolean overlap(Circle c) {
        double r = exactRadius() + c.exactRadius();
        double d = Math.sqrt(
                Math.pow(exactCenterX() - c.exactCenterX(), 2)
                + Math.pow(exactCenterY() - c.exactCenterY(), 2)
        );
        return r >= d;
    }

}
