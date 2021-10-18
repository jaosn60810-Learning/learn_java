package com.company;


public class NumberLinkedList {

    // 節點
    private static class Node {

        // 節點資料
        private int data;
        // 下一個節點
        private Node next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
        }
    }


    // 第一格節點
    private Node root;
    // 節點點數量(不包含第一個節點)
    private int count;
    // 現在的節點
    private Node current;

    public NumberLinkedList() {
        current = root = new Node();
        count = 0;
    }

    // 新增
    public void add(int data) {
        Node tmp = root;
        //找到最後一個節點
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        //在最後一個節點的下一個節點 new 一個 node 並把資料放進去
        tmp.next = new Node(data);
        // 增加長度
        count++;
    }

    // 移除
    public void remove(int index) {
        // 第一個節點
        Node p = root;
        // 經過的節點數量
        int passCount = 0;
        // 從頭跑到尾
        while (p.next != null) {
            // 如果經過的節點數量 == 刪除節點的 index
            if (passCount == index) {
                // 暫時存刪除節點的下一個節點在 tmp
                Node temp = p.next.next;
                // 將下一個節點連到 tmp
                p.next = temp;
                break;
            }
            // 繼續往下個節點
            p = p.next;
            // 增加經過節點數
            passCount++;
        }
    }

    // 搜尋(用數值搜)
    public int findNumber(int number) {
        // 第一個節點
        Node tmp = root;
        // 從頭跑到尾
        for (int i = 0; i < count; i++) {
            // 如果此數值 ==  number
            if (tmp.data == number) {
                // 扣掉第一個節點 (i == 0 時 tmp 是第一個節點 假如 index == 0 i 是 1)
                return i - 1;
            }
            // 找下一個節點
            tmp = tmp.next;
        }
        // 找不到傳 -1
        return -1;
    }

    // 搜尋(用 index 搜)
    public int get(int index) {
        // index 不合理的情況
        if (index < 0 || index >= count) {
            return -1;
        }
        // 第一個節點
        Node tmp = root;
        // 從頭跑到 index + 1 (i == 0 時 tmp 是第一個節點 假如 index == 0 i 是 1)
        for (int i = 0; i < index + 1; i++) {
            // 找下一個節點
            tmp = tmp.next;
        }
        // 回傳節點資料
        return tmp.data;
    }


    // 編輯
    public void editNumber(int index, int newNumber) {
        // index 不合理的情況
        if (index < 0 || index >= count) {
            return;
        }
        // 第一個節點
        Node tmp = root;
        // 從頭跑到 index + 1 (i == 0 時 tmp 是第一個節點 假如 index == 0 i 是 1)
        for (int i = 0; i < index + 1; i++) {
            // 找下一個節點
            tmp = tmp.next;
        }
        // 修改節點資料
        tmp.data = newNumber;
    }

    // 印出所有節點
    public void printAll() {
        // 第二個節點
        Node currNode = root.next;
        // 從頭跑到尾
        while (currNode != null) {
            // 印出節點資料
            System.out.println(currNode.data);
            // 前往下一個節點
            currNode = currNode.next;
        }
    }

    // 排序(泡沫排序)
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            Node p = root.next;
            for (int k = 0; k < count - i - 1; k++) {
                // 如果是最後一個節點 break
                if (p.next == null) {
                    break;
                }
                // 如果現在節點的資料 < 下一個節點的資料
                if (p.data < p.next.data) {
                    // p 和下一個節點交換
                    swap(p);
                } else {
                    // 找下一個節點
                    p = p.next;
                }
            }
        }
    }

    // 和下一個節點交換
    public void swap(Node change) {
        // 第一個節點
        Node p = root;
        // 如果要交換的不是最後一個
        if (change.next != null) {
            //找到要交換的節點前一個節點
            while (p.next != change) {
                p = p.next;
            }
            //要交換的節點下一個節點
            Node temp1 = change.next;
            //要交換的節點下下一個節點
            Node temp2 = change.next.next;
            //要交換的節點下一個節點 變成 要交換的節點下下一個節點
            change.next = temp2;
            //找到要交換的節點前一個節點 變成 要交換的節點下一個節點
            p.next = temp1;
            // 要交換的節點下下一個節點 變成 要交換的節點
            temp1.next = change;
        }
    }
}
