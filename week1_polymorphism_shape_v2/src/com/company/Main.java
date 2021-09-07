package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        ArrayList<Shape> shapes = new ArrayList<>();
        while (true) {
            System.out.print("請選擇功能:");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("新增一個形狀(選擇1:圓形 2:長方形 3:正方形):");
                    int whichShapes = sc.nextInt();
                    if (whichShapes == 1) {
                        System.out.print("請輸入半徑和中心點(例如:1 2 3):");
                        shapes.add(new Circle(sc.nextDouble(), sc.nextInt(), sc.nextInt()));
                    } else if (whichShapes == 2) {
                        System.out.print("請輸入寬和高和中心點(例如:10 20 1 2):");
                        shapes.add(new Rectangle(sc.nextDouble(), sc.nextDouble(), sc.nextInt(), sc.nextInt()));
                    } else if (whichShapes == 3) {
                        System.out.print("請輸入寬和中心點(例如:1 2 3):");
                        shapes.add(new Square(sc.nextDouble(), sc.nextInt(), sc.nextInt()));
                    } else {
                        System.out.println("沒有這個形狀");
                    }
                    break;
                case 2:
                    System.out.print("請輸入指定形狀的位置:");
                    System.out.println(shapes.get(sc.nextInt()).toString());
                    break;
                case 3:
                    shapes.sort(new shapesAreaSort());
                    break;
                case 4:
                    shapes.sort(new shapesPerimeterSort());
                    break;
                case 5:
                    for (Shape shape : shapes) {
                        System.out.print(shape.toString());
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.print("請輸入兩個 \"陣列中的位置\" 計算兩個形狀的中心點距離(例如: 1 0):");
                    Shape s1 = shapes.get(sc.nextInt());
                    Shape s2 = shapes.get(sc.nextInt());
                    System.out.println(twoShapesDistance(s1, s2));
                    break;
                case 7:
                    System.out.print("請輸入兩個 \"座標(Point)\" 印出所有中心點在此座標範圍內的圖形(例如: 1 0 2 0):");
                    Point point1 = new Point(sc.nextInt(), sc.nextInt());
                    Point point2 = new Point(sc.nextInt(), sc.nextInt());
                    ArrayList<Shape> shapesInThisTwoPointsArea = shapesInThisTwoPointsArea(shapes,point1,point2);
                    for (Shape shape : shapesInThisTwoPointsArea) {
                        System.out.print(shape.toString());
                        System.out.println();
                    }
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static double twoShapesDistance(Shape s1, Shape s2) {
        double distance = Math.sqrt((s1.getPoint().x - s2.getPoint().x) * (s1.getPoint().x - s2.getPoint().x) + (s1.getPoint().y - s2.getPoint().y) * (s1.getPoint().y - s2.getPoint().y));
        return Math.round(distance * 100.0) / 100.0;
    }

    public static ArrayList<Shape> shapesInThisTwoPointsArea(ArrayList<Shape> shapes, Point point1, Point point2) {
        ArrayList<Shape> shapesInThisTwoPointsArea = new ArrayList<>();
        int leftBorder = Math.min(point1.x, point2.x);
        int rightBorder = Math.max(point1.x, point2.x);
        int bottomBorder = Math.min(point1.y, point2.y);
        int topBorder = Math.max(point1.y, point2.y);
        for (Shape shape : shapes) {
            if (shape.getPoint().x >= leftBorder && shape.getPoint().x <= rightBorder)
                if (shape.getPoint().y >= bottomBorder && shape.getPoint().y <= topBorder)
                    shapesInThisTwoPointsArea.add(shape);
        }
        return shapesInThisTwoPointsArea;
    }


}

