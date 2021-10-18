package com.company;

public class Main {

    public static void main(String[] args) {

        NumberLinkedList nl = new NumberLinkedList();
        System.out.println("新增 1 3 4");
        nl.add(1);
        nl.add(3);
        nl.add(4);
        nl.printAll();
        System.out.println();

        System.out.println("刪除 index == 0");
        nl.remove(0);
        nl.printAll();
        System.out.println();

        System.out.println("新增 5");
        nl.add(5);
        nl.printAll();
        System.out.println();

        System.out.println("搜尋 數值 5");
        System.out.println(nl.findNumber(5));
        System.out.println();

        System.out.println("修改 index == 0 改成 7");
        nl.editNumber(0, 7);
        nl.printAll();
        System.out.println();

        System.out.println("新增 1 2 3 6");
//        nl.add(1);
//        nl.add(2);
//        nl.add(3);
//        nl.add(6);
        nl.printAll();
        System.out.println();

        System.out.println("排序(由大到小)");
        nl.sort();
        nl.printAll();
        System.out.println();

    }
}
