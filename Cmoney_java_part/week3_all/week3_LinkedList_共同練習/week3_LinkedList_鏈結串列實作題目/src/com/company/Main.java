package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLinkedListStudent l1 = new CLinkedListStudent();
        while (true) {
            l1.newStudent();
            System.out.println("跳出輸入-1 繼續輸入2");
            int opt = sc.nextInt();
            if(opt == -1){
                break;
            }
        }

        // 移除學生
        l1.remove(l1.get(0));

        // 排序
        l1.sort();

        // 印出所有學生
        l1.printList();
    }
}
