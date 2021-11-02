package com.company;

public class Main {

    public static void main(String[] args) {
        //這個地方可以給你隨意更動 讓你測試
        //不會列入分數
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println("add 1 3 4 7 5 9");
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(5);
        list.add(9);
        System.out.println(list.printAllNode());

        System.out.println("delete index 3");
        list.tryDelete(3);
        System.out.println(list.printAllNode());

        System.out.println("insert index 4");
        list.tryInsert(4, 2);
        System.out.println(list.printAllNode());

        System.out.println("sort");
        list.sort((data1, data2) -> data1 - data2);
        System.out.println(list.printAllNode());

    }
}
