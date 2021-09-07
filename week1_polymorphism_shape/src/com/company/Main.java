package com.company;

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
                        System.out.print("請輸入半徑:");
                        shapes.add(new Circle(sc.nextDouble()));
                    } else if (whichShapes == 2) {
                        System.out.print("請輸入寬和高(例如:10 20):");
                        shapes.add(new Rectangle(sc.nextDouble(), sc.nextDouble()));
                    } else if (whichShapes == 3) {
                        System.out.print("請輸入寬:");
                        shapes.add(new Square(sc.nextDouble()));
                    }else{
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
                    System.exit(0);
            }
        }
    }
}

