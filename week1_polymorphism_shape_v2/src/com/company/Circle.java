package com.company;

import java.awt.*;

public class Circle extends Shape {
    private double r;
    private static final double pi = Math.PI;
    private final String name = "圓形";

    public Circle(double r, int x, int y) {
        super.setPoint(new Point(x,y));
        this.r = r;
    }


    @Override
    public double area() {
        return r * r * pi;
    }

    @Override
    public double perimeter() {
        return 2 * r * pi;
    }

    @Override
    public String getName() {
        return this.name;
    }



    public String toString() {
        return this.name +
                " => 面積: " + Math.round(this.area() * 100.0) / 100.0 +
                " 周長: " + Math.round(this.perimeter() * 100.0) / 100.0 +
                " 中心點: x:" + super.getPoint().x + " y:" + super.getPoint().y;
    }



}
