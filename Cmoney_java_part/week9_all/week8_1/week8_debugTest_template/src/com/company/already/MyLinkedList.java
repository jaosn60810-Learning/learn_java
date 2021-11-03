package com.company.already;

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
        //9長度應該要確認有加 才加1
        if (root == null) {
            root = newNode;

            //1
            lastNode = root;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }

        length += 1;
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
        //8 長度應該要確認完是否有要插入的點再加1

        Node<T> singleNode = getNodeByIndex(index);
        if (singleNode == null) {
            //如果找不到要插入的節點 則視為無法插入
            return isSuccess;
        }

        Node<T> insertData = new Node<>(inputData);

        //插入新結點
        Node<T> temp = singleNode.next;
        singleNode.next = insertData;
        insertData.next = temp;

        //2
        //更新最後的節點
        if (index == length - 1) {
            lastNode = insertData;
        }

        //10
        isSuccess = true;
        length += 1;

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

        //如果刪除掉第一個
        if (index == 0) {
            if (root != null) {
                if (root.next == null) {
                    //當節點剩一個
                    root = null;
                    lastNode = null;
                } else {
                    root = root.next;
                }
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        }

        Node<T> previousNode = null;
        for (int i = 0; i < index; i++) {
            previousNode = singleNode;
            singleNode = singleNode.next;
        }

        //3
        //如果有前一個節點
        if (previousNode != null) {
            previousNode.next = singleNode.next;
            isSuccess = true;
        }

        //如果有刪除東西 則將其他東西重置
        if (isSuccess) {
            //注意 這樣是為了預防原本的節點還有一個東西指著會無法被回收
            if (singleNode != null && singleNode.next != null) {
                singleNode.next = null;
            }

            //4
            if (index == length - 1) {
                lastNode = previousNode;
            }

            length -= 1;
        }

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
            //5
            for (int j = 0; j < length - i - 1; j++) {
                if (compare.compare(getDataByIndex(j), getDataByIndex(j + 1)) > 0) {
                    //Swap
                    Node<T> firstNode = getNodeByIndex(j);
                    Node<T> secondNode = getNodeByIndex(j + 1);

                    //6
                    //之前我是連節點本身都交換 但這樣比較複雜
                    //所以我這次只交換資料本身
                    T temp = firstNode.data;
                    firstNode.data = secondNode.data;
                    secondNode.data = temp;
                }
            }
        }

        //7 不用加長度
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

    //--------------複製進你的程式碼中

    /**
     * 取得最後節點
     *
     * @return
     */
    public T lastNode() {
        return this.lastNode.data;
    }

    public String showAllData() {
        StringBuilder sb = new StringBuilder();
        Node<T> data = root;
        if (root == null) {
            sb.append("沒有內容");
        } else {
            for (int i = 0; i < length; i++) {
                sb.append(data.data + " ");
                data = data.next;
            }
        }
        return sb.toString();
    }

    //----------------
}
