package com.company;

import java.awt.*;

public abstract class Shape {
    private Point point;

    public abstract double area();

    public abstract double perimeter();

    public abstract String getName();

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
