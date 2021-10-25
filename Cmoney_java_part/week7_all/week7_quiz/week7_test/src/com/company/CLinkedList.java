package com.company;

import com.company.Iterator;

public class CLinkedList<T> implements Iterator {

    public interface Comparator<T> {

        public int compare(T t1, T t2);  //如果沒先定義<T>  compare 會不知道T是什麼
    }

    private class Node {  //Node<T>

        private T data; //因為Node 是非靜態的內部類別，但如果Node有自己的T 會優先吃自己的T，
        //不然就會依賴到父類別的<T>，因此可以不寫<T>
        private Node next;

        public Node(T data) {
            this.data = data;
        }
        //set.get Data.Next 適用於Node 如果有獨立在外面的一個class時，取用的，last.next 就會變成 last.getNext 
        // 以及last.setNext(new Node(data));
        public final void setData(T data) {
            this.data = data;
        }
        public final T getData() {
            return data;
        }
        public final void setNext(Node next) {
            this.next = next;
        }
        public final Node getNext() {
            return next;
        }
    }

    private Node root;
    private int count;
    private Node current;
    private Node last;

    public CLinkedList() {
        last = current = root = new Node(null);
        count = 0;
    }

    public void push(T data){
        add(data);
    }

    public T pop(){
        T tmp = get(count -1);
        remove(count -1);
        return tmp;
    }

    public T pull(){
        T tmp = get(0);
        remove(0);
        return tmp;
    }

    public void add(T data) {
//        Node tmp = root;
//        while (tmp.next != null) {
//            tmp = tmp.next;
//        }
//        tmp.next = new Node(data); // 因為已經知道上面的tmp 是 Node<T> 的型態，所以可以省略T
//        count++;
        last = last.next = new Node(data);
        count++;
    }

    public T get(int index) {
        Node tmp = getNode(index);
        return (tmp != null)?tmp.data:null;
//        if(tmp != null){
//            return tmp.data;
//        }
//        return null;
    }

    public Node getNode(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        Node tmp = root;
        for (int i = 0; i < index + 1; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            return;
        }
        Node tmp = root;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        if(tmp.next == null){
            last = tmp;
        }
        count--;
    }

    public void insert(int index, T num) {
        if (index < 0 || index > count) {
            return;
        }
        Node tmp = root;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        Node targe = tmp.next;
        tmp.next = new Node(num);
        tmp.next.next = targe;
        if(tmp.next.next == null){
            last = tmp.next;
        }
        count++;
    }

    public void sort(Comparator<? super T> c) { // 下界通配，只進不出，才可以承接他及他的父類別方法
        for (int i = 0; i < count - 1; i++) {
            for (int n = 0; n < count - 1 - i; n++) {
                if (c.compare(get(n), get(n + 1)) > 0) {
                    Node t1 = getNode(n);
                    Node t2 = t1.next;
                    T tmp = t1.data;
                    t1.data = t2.data;
                    t2.data = tmp;
                }
            }
        }
    }

    private void swap(int i, int j) {
        Node t1 = getNode(i);
        Node t2 = getNode(j);
        T tmp = t1.data;
        t1.data = t2.data;
        t2.data = tmp;
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
    public T next() {
        current = current.next;
        return current.data;
    }

    public int size() {
        return count;
    }

}
