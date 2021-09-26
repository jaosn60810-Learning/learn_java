package com.company;

public class Main {

    public static void main(String[] args) {
        CLinkedList l1 = new CLinkedList();
        CArrayList a1 = new CArrayList();
        for (int i = 0; i < 10; i++) {
            l1.add(i + 1);
            a1.add(i + 1);
        }

        Iterator iterator = a1;

        while (iterator.hasNext()) {
            int data = iterator.next();
            System.out.println(data);
        }

        iterator = l1;

        while (iterator.hasNext()) {
            int data = iterator.next();
            System.out.println(data);
        }
    }
}
