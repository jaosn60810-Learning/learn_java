package com.company;

public class Main {
    public static void main(String[] args) {
        CLinkedList<Shape> l1 = new CLinkedList<>();
        l1.add(new Rect(5, 2));
        l1.add(new Square(5));
        l1.add(new Rect(2, 4));
        l1.add(new Circle(1));
        System.out.println("add");
        print(l1);
        System.out.println();

        System.out.println("insert at index 1");
        l1.insert(1, new Rect(3, 3));
        print(l1);
        System.out.println();

        System.out.println("remove index 0");
        l1.remove(0);
        print(l1);
        System.out.println();

        System.out.println("get index 0 area");
        System.out.println(l1.get(0).area());
        System.out.println();

        System.out.println("sort");
        l1.sort((t1, t2) -> (int) (t1.area()) - (int) (t2.area()));
        print(l1);
        System.out.println();
    }


    public static void print(CLinkedList<? extends Shape> arr) {
        while (arr.hasNext()) {
            System.out.println(arr.next().area());
        }
    }
}
