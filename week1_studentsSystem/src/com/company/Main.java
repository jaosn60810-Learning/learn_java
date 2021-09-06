package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        Student student;
        while (true) {
            System.out.print("請輸入功能；");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("請輸入學生資料；");
                    int seat = input(1, 20);
                    String scoolClass = input(1);
                    String name = input(3);
                    int score = input(1, 100);
                    student = new Student(seat, scoolClass, name, score);
                    students.add(student);
                    student.print();
                    break;
                case 2:
                    System.out.print("請輸入要查詢成績的學生座號；");
                    student = findStudentBySeat(students, sc.nextInt());
                    if (student == null)
                        System.out.println("沒有這個學生");
                    else
                        student.print();
                    break;
                case 3:
                    System.out.println("已依照成績由大到小排序學生");
                    sortByScore(students);
                    break;
                case 4:
                    System.out.println("已依照座號由小到大排序學生");
                    sortBySeat(students);
                    break;
                case 5:
                    System.out.print("請輸入要更改成績的學生座號；");
                    student = findStudentBySeat(students, sc.nextInt());
                    if (student == null)
                        System.out.println("沒有這個學生");
                    else {
                        System.out.print("請輸入更改成績；");
                        student.setScore(sc.nextInt());
                        student.print();
                    }
                    break;
                case 6:
                    System.exit(0);
                case 7:
                    printAll(students);
                    break;
            }
        }
    }

    public static void sortBySeat(ArrayList<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getSeat() > students.get(j + 1).getSeat())
                    Collections.swap(students, j, j + 1);
            }
        }
    }

    public static void sortByScore(ArrayList<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (students.get(j).comapreTo(students.get(j + 1)) < 0)
                    Collections.swap(students, j, j + 1);
            }
        }
    }

    public static Student findStudentBySeat(ArrayList<Student> students, int seat) {
        for (Student student : students) {
            if (student.getSeat() == seat)
                return student;
        }
        return null;
    }

    public static void printAll(ArrayList<Student> students) {
        for (Student student : students) {
            student.print();
        }
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int input(int min, int max) {
        return random(min, max);
    }

    public static String input(int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append((char) (char) random(97, 122));
        }
        return str.toString();
    }
}
