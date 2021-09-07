package com.company;

public class Circle implements Shape {
    private double r;
    private static final double pi = Math.PI;
    private String name = "圓形";

    public Circle(double r) {
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
        return this.name + " => 面積: " + Math.round(this.area()*100.0)/100.0 + " 周長: " + Math.round(this.perimeter()*100.0)/100.0;
    }

}
