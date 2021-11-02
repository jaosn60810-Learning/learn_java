package com.company;


public class CLinkedList<T> implements Iterator {

    public interface Comparator<T> {
        public int compare(T t1, T t2);
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
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

    /**
     * 新增到最尾端
     *
     * @param data 新增的資料
     */
    public void add(T data) {
        // 原本最後一個的下一個變成新的資料
        last.next = new Node(data);
        // 現在的最後一個變成原本最後一個的下一個
        last = last.next;
        // 增加 Node 數量
        count++;
    }

    /** 取得位置為 index 的 Node 的 data
     * @param index 位置
     * @return T
     */
    public T get(int index) {
        // 把位置為 index 的 Node 存到 tmp
        Node tmp = getNode(index);
        // 如果 tmp 不是 null 回傳他的 data
        if (tmp != null) {
            return tmp.data;
        }
        return null;
    }

    /** 取得位置為 index 的 Node
     * @param index 位置
     * @return 指定位置的 Node
     */
    public Node getNode(int index) {
        // 如果輸入小於 0 或 大於等於 count 的不合理情況，輸出 null
        if (index < 0 || index >= count) {
            return null;
        }
        // 把頭先存起來
        Node tmp = root;
        // 迴圈找到 位置在 index 的 node，index 加一是因為 i 是 0 的時候是 root
        for (int i = 0; i < index + 1; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    /** 移除位置為 index 的 Node
     * @param index
     */
    public void remove(int index) {
        // 如果輸入小於 0 或 大於等於 count 的不合理情況，輸出 null
        if (index < 0 || index >= count) {
            return;
        }
        // 把頭存到 tmp
        Node tmp = root;
        // 找到要移除的 Node 的前一個
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        // 移除的 Node 的前一個的下一個變成移除的 Node 的前一個的下下一個
        tmp.next = tmp.next.next;
        // 如果移除的 Node 的前一個的下一個如果是 null (代表不是最後一個)
        if (tmp.next == null) {
            // 最後一個是移除的 Node 的前一個
            last = tmp;
        }
        // Node 的數量減一
        count--;
    }

    public void insert(int index, T num) {
        // 如果輸入小於 0 或 大於等於 count 的不合理情況，直接 return
        if (index < 0 || index > count) {
            return;
        }
        // 把頭存到 tmp
        Node tmp = root;
        // 找要插入的位置的原本 Node 的前一個
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        // 要插入的位置的原本 Node
        Node target = tmp.next;
        // 要插入的位置的原本 Node 的前一個的下一個變成新增插入的 Node
        tmp.next = new Node(num);
        // 新增的 Node 的下一個是原本插入位置的 Node
        tmp.next.next = target;
        // 如果新增的 Node 的下一個是原本插入位置的 Node 是 null ，代表新增插入的 Node 是最後一個
        if (tmp.next.next == null) {
            last = tmp.next;
        }
        // 增加 Node 數量
        count++;
    }

    /** 泡沫排序
     * @param c
     */
    public void sort(Comparator<? super T> c) {
        for (int i = 0; i < count - 1; i++) {
            for (int n = 0; n < count - 1 - i; n++) {
                if (c.compare(get(n), get(n + 1)) > 0) {
                    swap(n, n + 1);
                }
            }
        }
    }

    /** 交換兩個 Node 的位置
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Node t1 = getNode(i);
        Node t2 = getNode(j);
        // 交換 t1 t2 裡面的 data
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
}
