package com.company;

public class CLinkedList implements Iterator {

    private static class Node {

        private int data;
        private Node next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;
    private int count;
    private Node current;

    public CLinkedList() {
        current = root = new Node();
        count = 0;
    }

    public void add(int data) {
        Node tmp = root;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new Node(data);
        count++;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }

        Node tmp = root;
        for (int i = 0; i < index + 1; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public interface Action {
        public void action(int data);
    }

    public void map(Action action) {
        Node tmp = root;
        for (int i = 0; i < count; i++) {
            tmp = tmp.next;
            action.action(tmp.data);
        }
    }

    @Override
    public boolean hasNext() {
        if (current.next == null) {
            current = root;
            return false;
        }
        return true;
    }

    @Override
    public int next() {
        current = current.next;
        return current.data;
    }
}
