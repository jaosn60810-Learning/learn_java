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
public abstract class Shape {

    protected double left;
    protected double top;
    protected double right;
    protected double bottom;

    protected Shape(double left, double top, double right, double bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public final int centerX() {
        return (int) (left + right) / 2;
    }

    public final int centerY() {
        return (int) (top + bottom) / 2;
    }

    public final double exactCenterX() {
        return (left + right) / 2f;
    }

    public final double exactCenterY() {
        return (top + bottom) / 2f;
    }

    public final Shape translate(double dx, double dy) {
        this.left += dx;
        this.right += dx;
        this.top += dy;
        this.bottom += dy;
        return this;
    }

    public final Shape translateX(double dx) {
        this.left += dx;
        this.right += dx;
        return this;
    }

    public final Shape translateY(double dy) {
        this.top += dy;
        this.bottom += dy;
        return this;
    }

    public final int left() {
        return (int) left;
    }

    public final void setLeft(double left) {
        this.left = left;
    }

    public final int top() {
        return (int) top;
    }

    public final void setTop(double top) {
        this.top = top;
    }

    public final int right() {
        return (int) right;
    }

    public final void setRight(double right) {
        this.right = right;
    }

    public final int bottom() {
        return (int) bottom;
    }

    public final void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public final int width() {
        return (int) (this.right - this.left);
    }

    public final int height() {
        return (int) (this.bottom - this.top);
    }

    public final void setCenter(int x, int y) {
        translate(x - centerX(), y - centerY());
    }
}
