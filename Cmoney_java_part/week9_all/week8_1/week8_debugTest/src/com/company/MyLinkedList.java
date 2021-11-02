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

        public t getData() {
            return data;
        }
    }

    /**
     * 建構子
     */
    public MyLinkedList() {
        length = 0;
        root = lastNode = new Node(null);
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
        // 最後一個的下一個變成新的資料
        lastNode.next = new Node(inputData);
        // 現在的最後一個變成原本最後一個的下一個
        lastNode = lastNode.next;
        // 增加長度
        length++;
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
        // 如果輸入小於 0 或 大於等於 count 傳 isSuccess(false)
        if (index < 0 || index >= length) {
            return isSuccess;
        }
        // 把根節點存到 result
        Node result = root;
        // 找要插入的位置的原本 Node 的前一個
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        // 要插入的位置的原本 Node
        Node target = result.next;
        // 要插入的位置的原本 Node 的前一個的下一個變成新增插入的 Node
        result.next = new Node(inputData);
        // 新增的 Node 的下一個是原本插入位置的 Node
        result.next.next = target;
        // 如果要插入的位置的原本 Node 的前一個的下下一個是 null，代表新增插入的 Node 是最後一個
        if (result.next.next == null) {
            lastNode = result.next;
        }
        // 增加 Node 數量
        length++;
        // 插入成功
        isSuccess = true;
        // 回傳 isSuccess
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
        // 如果輸入小於 0 或 大於等於 count 輸出 isSuccess(false)
        if (index >= length || index < 0) {
            return isSuccess;
        }
        // 把根節點從存起來
        Node<T> singleNode = root;
        // 找到要移除的 Node 的前一個
        for (int i = 0; i < index; i++) {
            singleNode = singleNode.next;
        }
        // 移除的 Node 的前一個的下一個變成移除的 Node 的前一個的下下一個
        singleNode.next = singleNode.next.next;
        // 如果移除的 Node 的前一個的下一個如果是 null
        if (singleNode.next == null) {
            // 代表最後一個是移除的 Node 的前一個
            lastNode = singleNode;
        }
        // 長度減一
        length -= 1;

        // 移除成功
        isSuccess = true;
        // 回傳移除成功
        return isSuccess;
    }

    /**
     * 取得指定的節點
     *
     * @param index 指定第幾個節點
     * @return 節點
     */
    public Node<T> getNodeByIndex(int index) {
        // 如果 index 小於 0 或 大於等於 count 輸出 null
        if (index >= length || index < 0) {
            return null;
        }
        // 把根節點存起來
        Node<T> result = root;
        // 迴圈找到位置在 index 的 node，index 加一是因為 i 是 0 的時候是 root
        for (int i = 0; i < index + 1; i++) {
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
        // 把位置為 index 的 Node 存到 result
        Node<T> result = getNodeByIndex(index);
        // 如果 result 不是 null 回傳他的 data
        return result == null ? null : result.data;
    }

    /**
     * 將結點進行排序(依據輸入的比較界面決定順序)
     *
     * @param compare 排序方式
     */
    public void sort(Comparator<T> compare) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (compare.compare(getDataByIndex(j), getDataByIndex(j + 1)) > 0) {
                    swap(j, j + 1);
                }

            }
        }
    }

    /**
     * 交換兩個 Node 的位置
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Node t1 = getNodeByIndex(i);
        Node t2 = getNodeByIndex(j);
        // 交換 t1 t2 裡面的 data
        T tmp = (T) t1.data;
        t1.data = t2.data;
        t2.data = tmp;
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
            for (int i = 0; i < length + 1; i++) {
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
