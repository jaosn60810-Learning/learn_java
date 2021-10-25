package com.company;

public class Circle extends Shape {
    private static final double PI = 3.14;
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return r * r * PI;
    }
}
