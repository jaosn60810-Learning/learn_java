package com.company;

import com.company.MyLinkedList;

public class Main {

    private static int grade;

    public static void main(String[] args) {
        grade = 100;

        System.out.println("-------addTest------");
        addTest();
        System.out.println("分數：" + grade);
        System.out.println("-------insertOutOfLimitTest------");
        insertOutOfLimitTest();
        System.out.println("分數：" + grade);
        System.out.println("-------sortTest------");
        sortTest();
        System.out.println("分數：" + grade);
        System.out.println("-------emptySortTest------");
        emptySortTest();
        System.out.println("分數：" + grade);
        System.out.println("-------normalInsertTest------");
        normalInsertTest();
        System.out.println("分數：" + grade);
        System.out.println("-------normalDeleteTest------");
        normalDeleteTest();
        System.out.println("分數：" + grade);
        System.out.println("-------emptyDeleteTest------");
        emptyDeleteTest();
        System.out.println("分數：" + grade);
        System.out.println("-------deleteAllTest------");
        deleteAllTest();
        System.out.println("分數：" + grade);
        System.out.println("-------deleteOutOfLimitTest------");
        deleteOutOfLimitTest();
        System.out.println("分數：" + grade);
        System.out.println("-------normalPrintTest------");
        normalPrintTest();
        System.out.println("分數：" + grade);
    }

    public static void addTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1);

        //長度 5
        //5 3 7 9 1
        if (!checkAnswer(list, 5, "5 3 7 9 1 ", 1)) {
            isSuccess = false;
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void normalInsertTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(5);
        list.add(3);
        list.tryInsert(1, 6);

        //長度 5
        //5 3 6
        //5 6 3
        if (!checkAnswer(list, 3, "5 3 6 ", 6) &&
                !checkAnswer(list, 3, "5 6 3 ", 3)) {
            isSuccess = false;
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void insertOutOfLimitTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        if (list.tryInsert(4, 9)) {
            isSuccess = false;
        }

        if (!checkAnswer(list, 1, "5 ", 5)) {
            isSuccess = false;
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void sortTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1);

        list.sort((data1, data2) -> data1 - data2 );

        //長度 5
        //5 3 7 9 1
        if (!checkAnswer(list, 5, "1 3 5 7 9 ", 9)) {
            isSuccess = false;
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void emptySortTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.sort((data1, data2) -> data1 - data2 );

        try {
            //長度 5
            //5 3 7 9 1
            if (!checkAnswer(list, 0, "沒有內容", 0)) {
                isSuccess = false;
            }
        } catch (NullPointerException e) {
            isSuccess = true;
        }


        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void normalDeleteTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(5);
        list.add(3);
        list.add(1);
        list.add(8);

        if (!list.tryDelete(2)) {
            isSuccess = false;
        }

        //長度 3
        //5 3 8
        if (!checkAnswer(list, 3, "5 3 8 ", 8) &&
                !checkAnswer(list, 3, "5 1 8 ", 8)) {
            isSuccess = false;
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void emptyDeleteTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        if (list.tryDelete(2)) {
            isSuccess = false;
        }

        if (isSuccess) {
            try {
                //長度 5
                //5 3 7 9 1
                if (!checkAnswer(list, 0, "沒有內容", 0)) {
                    isSuccess = false;
                }
            } catch (NullPointerException e) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void deleteAllTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(3);
        list.add(2);
        list.add(9);

        if (!list.tryDelete(0)) {
            isSuccess = false;
        }
        if (!list.tryDelete(0)) {
            isSuccess = false;
        }
        if (!list.tryDelete(0)) {
            isSuccess = false;
        }

        //沒資料不該成功
        if (list.tryDelete(0)) {
            isSuccess = false;
        }

        if (isSuccess) {
            try {
                //長度 5
                //5 3 7 9 1
                if (!checkAnswer(list, 0, "沒有內容", 0)) {
                    isSuccess = false;
                }
            } catch (NullPointerException e) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void deleteOutOfLimitTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(3);
        list.add(2);
        list.add(9);

        //沒資料不該成功
        if (list.tryDelete(5)) {
            isSuccess = false;
        }

        //長度 3
        //2 3 9
        if (!checkAnswer(list, 3, "3 2 9 ", 9)) {
            isSuccess = false;
        }


        if (!isSuccess) {
            grade -= 10;
        }
    }

    public static void normalPrintTest() {
        boolean isSuccess = true;
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(5);
        list.add(3);
        list.add(1);
        list.add(8);

        String answer = "第0個物件：5\r\n" +
                "第1個物件：3\r\n" +
                "第2個物件：1\r\n" +
                "第3個物件：8\r\n";

        String a = list.printAllNode();
        if (!answer.equals(a)) {
            isSuccess = false;
        }

        if (!isSuccess) {
            grade -= 10;
        }
    }

    /**
     * 檢查長度以及節點內容
     *
     * @param list
     * @param length
     * @param allNode
     * @return
     */
    public static boolean checkAnswer(MyLinkedList list, int length, String allNode, int lastNodeData) {
        boolean isSuccess = true;

        System.out.println("list長度：" + list.length());
        System.out.println("應有長度：" + length);
        if (list.length() != length) {
            isSuccess = false;
            System.out.println("錯誤");
        }

        System.out.println("list元素：" + list.showAllData());
        System.out.println("應有元素：" + allNode);
        if (!list.showAllData().equals(allNode)) {
            isSuccess = false;
            System.out.println("錯誤");
        }

        System.out.println("list最新元素：" + list.lastNode());
        System.out.println("應有最新元素：" + lastNodeData);
        if (!list.lastNode().equals(lastNodeData)) {
            isSuccess = false;
            System.out.println("錯誤");
        }

        return isSuccess;
    }
}
