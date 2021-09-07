package com.company;

public class Square extends Rectangle{
    private String name = "正方形";
    public Square(double width) {
        super(width, width);
    }

    public String toString() {
        return this.name + " => 面積: " + Math.round(this.area()*100.0)/100.0 + " 周長: " + Math.round(this.perimeter()*100.0)/100.0;
    }
}
