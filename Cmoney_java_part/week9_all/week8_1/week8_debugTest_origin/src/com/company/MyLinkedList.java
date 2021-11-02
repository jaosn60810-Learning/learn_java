package com.company;

/**
 * Linkedlist
 *
 * @param <T>
 */
public class MyLinkedList<T> {

    /**
     * 比較界面
     *
     * @param <T>
     */
    public interface Comparator<T> {
        int compare(T data1, T data2);
    }

    /**
     * 節點
     *
     * @param <t>
     */
    private class Node<t> {

        /**
         * 資料
         */
        private t data;

        /**
         * 下一個節點
         */
        private Node<t> next;

        /**
         * 建構子 直接給予資料這樣就不用再另外指定data
         *
         * @param inputData 節點資料
         */
        Node(t inputData) {
            this.data = inputData;
        }
    }

    /**
     * 建構子
     */
    public MyLinkedList() {
        length = 0;
    }

    /**
     * 根節點
     */
    private Node<T> root;

    /**
     * 目前最後的節點
     */
    private Node<T> lastNode;

    /**
     * 目前節點數量
     */
    private int length;

    /**
     * 新增一個資料到最後面
     *
     * @param inputData 要新增的資料
     */
    public void add(T inputData) {
        Node<T> newNode = new Node<T>(inputData);
        length += 1;

        if (root == null) {
            root = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    /**
     * 試著將資料插入到指定的格子中
     *
     * @param index     要插到哪一格之後
     * @param inputData 要插入的資料
     * @return 是否成功
     */
    public boolean tryInsert(int index, T inputData) {
        boolean isSuccess = false;
        length += 1;

        Node<T> singleNode = getNodeByIndex(index);
        if (singleNode == null) {
            return isSuccess;
        }

        Node<T> insertData = new Node<>(inputData);

        Node<T> temp = singleNode.next;
        singleNode.next = insertData;
        insertData.next = temp;
        return isSuccess;
    }

    /**
     * 試著將指定的節點刪除
     *
     * @param index 要刪除第幾個節點
     * @return 是否刪除成功
     */
    public boolean tryDelete(int index) {
        boolean isSuccess = false;
        if (index > length || index < 0) {
            return isSuccess;
        }

        Node<T> singleNode = root;
        Node<T> previousNode = null;
        for (int i = 0; i < index; i++) {
            previousNode = singleNode;
            singleNode = singleNode.next;
        }

        previousNode.next = singleNode.next;

        singleNode.next = null;

        length -= 1;

        isSuccess = true;
        return isSuccess;
    }

    /**
     * 取得指定的節點
     *
     * @param index 指定第幾個節點
     * @return 節點
     */
    private Node<T> getNodeByIndex(int index) {
        if (index > length || index < 0) {
            return null;
        }

        Node<T> result = root;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * 取得指定節點的資料
     *
     * @param index 取得指定節點資料
     * @return 節點資料
     */
    private T getDataByIndex(int index) {
        Node<T> result = getNodeByIndex(index);
        return result == null ? null : result.data;
    }

    /**
     * 將結點進行排序(依據輸入的比較界面決定順序)
     *
     * @param compare 排序方式
     */
    public void sort(Comparator<T> compare) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i; j++) {
                if (compare.compare(getDataByIndex(j), getDataByIndex(j + 1)) > 0) {
                    Node<T> firstNode = getNodeByIndex(j);
                    Node<T> secondNode = getNodeByIndex(j + 1);

                    firstNode.data = secondNode.data;
                    secondNode.data = firstNode.data;
                }

            }
        }

        length += 1;
    }

    /**
     * 分行印出所有節點
     *
     * @return 資訊
     */
    public String printAllNode() {
        StringBuilder sb = new StringBuilder();
        Node<T> data = root;
        if (root == null) {
            sb.append("沒有內容");
        } else {
            for (int i = 0; i < length; i++) {
                sb.append("第" + i + "個物件：" + data.data);
                sb.append("\r\n");
                data = data.next;
            }
        }
        return sb.toString();
    }

    /**
     * 取得節點數量
     *
     * @return 節點數量
     */
    public int length() {
        return this.length;
    }
}
