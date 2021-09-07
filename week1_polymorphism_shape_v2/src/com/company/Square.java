package com.company;

public class Square extends Rectangle {
    public Square(double width, int x, int y) {
        super(width, width, x, y);
    }

    public String toString() {
        String name = "正方形";
        return name +
                " => 面積: " + Math.round(this.area() * 100.0) / 100.0 +
                " 周長: " + Math.round(this.perimeter() * 100.0) / 100.0+
                " 中心點: x:" + super.getPoint().x + " y:" + super.getPoint().y;
    }
}
