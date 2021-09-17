package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 學生資料庫物件
        StudentArray studentArray = new StudentArray();

        // 讓使用者持續輸入
        while (true) {
            System.out.println("請輸入功能");
            // 讓使用者輸入功能編號
            int opt = sc.nextInt();
            // 吃掉上面的換行符號
            sc.nextLine();
            switch (opt) {
                // 新增一名學生到學生陣列，使用 Input 自動產生座號、成績、姓名
                case 1:
                    studentArray.add(new Student.Builder()
                            .setSeat(Input.randomInputNum("自動產生座號: ", 1, 100))
                            .setScore(Input.randomInputNum("自動產生成績: ", 0, 100))
                            .setName(Input.randomInputString("自動產生姓名: ", 2, 3))
                            .build()
                    );
                    break;
                // 排序學生陣列
                case 2:
                    System.out.println("請輸入排序方法編號: 1.依照座號 2.依照成績 3.依照姓名 ");
                    // 讓使用者輸入篩選規則編號
                    int sortFuncNum = sc.nextInt();
                    // 吃掉上面的換行符號
                    sc.nextLine();
                    // 排序學生陣列(依據剛才的選擇編號 sortFuncNum)
                    sortFunc(studentArray, sortFuncNum);
                    // 印出學生陣列內所有學生物件
                    printAllStu(studentArray);
                    break;
                case 3:
                    // 隨機排序學生陣列
                    randomSequence(studentArray);
                    // 印出學生陣列內所有學生物件
                    printAllStu(studentArray);
                    break;
                case 4:
                    // 印出學生陣列內所有學生物件
                    printAllStu(studentArray);
                    break;
                case 5:
                    // 離開系統
                    System.exit(0);
                    break;
            }
        }
    }

    /** 印出學生陣列內所有學生物件
     * @param studentArray
     */
    public static void printAllStu(StudentArray studentArray) {
        // 迴圈掃過學生陣列內所有物件並印出
        for (int i = 0; i < studentArray.getCount(); i++) {
            System.out.println(studentArray.getStudentByIndex(i));
        }
        // 分隔線
        System.out.println("--------------------------------");
    }

    /** 排序學生陣列的各種方法
     * @param studentArray 要排序的學生陣列
     * @param sortFuncNum 要選擇排序的規則
     */
    public static void sortFunc(StudentArray studentArray, int sortFuncNum) {
        // 創建一個暫時的學生陣列
        StudentArray result;
        // 看輸入哪個規則編號決定排序方式
        switch (sortFuncNum) {
            // 使用座號排列(由小到大)
            case 1:
                // 將排序後的學生陣列放到暫時的學生陣列
                result = studentArray.sort((s1, s2) -> s1.getSeat() - s2.getSeat());
                // 將原本的學生陣列設置成暫時的學生陣列(排好的)
                studentArray.setArr(result.getArr());
                break;
            // 使用成績排列(由小到大)
            case 2:
                // 將排序後的學生陣列放到暫時的學生陣列
                result = studentArray.sort(((s1, s2) -> s1.getScore() - s2.getScore()));
                // 將原本的學生陣列設置成暫時的學生陣列(排好的)
                studentArray.setArr(result.getArr());
                break;
            // 使用姓名排列(由a到z)
            case 3:
                // 將排序後的學生陣列放到暫時的學生陣列
                result = studentArray.sort(((s1, s2) -> s1.getName().compareTo(s2.getName())));
                // 將原本的學生陣列設置成暫時的學生陣列(排好的)
                studentArray.setArr(result.getArr());
                break;
            // 若輸入沒有此規則編號
            default:
                System.out.println("沒有此排序方法編號");
                break;
        }
    }

    /** 將學生物件重新打亂排序
     * @param studentArray 要打亂順序的學生陣列
     */
    public static void randomSequence(StudentArray studentArray) {
        // 將學生陣列淺拷貝到 sequence
        Student[] sequence = studentArray.getArr();
        // 創建隨機物件
        Random random = new Random();
        // 使用迴圈將每個打亂順序
        for (int i = 0; i < studentArray.getCount(); i++) {
            // 隨機產生 0 ~ (studentArray.getCount() - 1) 的正整數
            int p = random.nextInt(studentArray.getCount());
            // 創建暫時的學生物件用來保留學生 ( sequence[i] )
            Student tmp = sequence[i];
            // 將學生 ( sequence[i] ) 換成隨機位置的學生( sequence[p] )
            sequence[i] = sequence[p];
            // 將隨機位置的學生( sequence[p] ) 換成學生 ( sequence[i] )
            sequence[p] = tmp;
        }
        // 將重新排序的學生陣列賦予到學生陣列
        studentArray.setArr(sequence);
    }
}

