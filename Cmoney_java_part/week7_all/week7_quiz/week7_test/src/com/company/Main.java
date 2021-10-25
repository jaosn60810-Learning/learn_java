package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static class Rect extends Shape{
        private double width;
        private double height;
        public Rect(double width, double height){
            this.width = width;
            this.height = height;
        }

        public double area() {
            return width * height;
        }
    }
    public static class Square extends Rect{
        public Square(double width) {
            super(width, width);
        }
    }
    public static class Circle extends Shape{
        private static final double PI = 3.14d;
        private double r;

        public Circle(double r){
            this.r = r;
        }

        @Override
        public double area() {
            return r * r * PI;
        }
    }

    public static void main(String[] args) {
        CLinkedList<Rect> l1 = new CLinkedList<>();
        l1.add(new Rect(5, 2));
        l1.add(new Square(5));
        l1.add(new Rect(2, 4));
        l1.add(new Square(7));
        l1.sort(new CLinkedList.Comparator<Shape>(){
            @Override
            public int compare(Shape t1, Shape t2) {
                return (int)(t1.area()) - (int)(t2.area());
            }
        });
        for(int i = 0;i<l1.size();i++){
            System.out.println(l1.get(i).area());
        }
//        l1.remove(0);
        l1.insert(1, new Rect(3,3));
       while(l1.hasNext()){
           System.out.println(l1.next().area());
       }

////        Integer 版
//        CLinkedList<Integer> I1 = new CLinkedList<>();
//        I1.add(3);
//        I1.add(5);
//        I1.add(4);
//        I1.add(6);
//        I1.sort(new CLinkedList.Comparator<Integer>(){
//            @Override
//            public int compare(Integer t1, Integer t2) {
//                return t1 - t2;
//            }
//        });



    }

    //允許傳入的泛型類別可以指定一定範圍的類別型態
    public static void print(ArrayList<? super Rect> arr){ // 如果ArrayList沒有定義型別，就會是一個object的arrayList
        arr.add(new Rect(5,5));
//        for(int i = 0; i < arr.size(); i++){
//            System.out.println(arr.get(i).area());
//        }
    }

    private static <T> void swap(T arr){ // 泛型方法，比較少用到

    }


}
