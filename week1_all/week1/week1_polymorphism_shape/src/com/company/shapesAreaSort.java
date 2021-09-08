package com.company;

import java.util.Comparator;

public class shapesAreaSort implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        if ((s1.area() - s2.area()) < 1 && (s1.area() - s2.area()) > 0)
            return 1;
        else if ((s1.area() - s2.area()) < 0 && (s1.area() - s2.area()) > -1)
            return -1;
        else
            return (int) (s1.area() - s2.area());
    }
}
