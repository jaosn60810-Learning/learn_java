package com.company;

import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double height;
    private final String name = "長方形";

    public Rectangle(double width, double height, int x, int y) {
        super.setPoint(new Point(x,y));
        this.width = width;
        this.height = height;
    }


    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
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
