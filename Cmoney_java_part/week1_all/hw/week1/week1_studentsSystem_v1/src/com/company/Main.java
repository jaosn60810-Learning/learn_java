package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[1];
        Student student;
        int count = 0;
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
                    if (students.length == count) {
                        students = doubleArray(students, count);
                    }
                    student = new Student(seat, scoolClass, name, score);
                    students[count] = student;
                    count++;
                    student.print();
                    break;
                case 2:
                    System.out.print("請輸入要查詢成績的學生座號；");
                    student = findStudentBySeat(students, sc.nextInt(), count);
                    if (student == null)
                        System.out.println("沒有這個學生");
                    else
                        student.print();
                    break;
                case 3:
                    System.out.println("已依照成績由大到小排序學生");
                    sortByScore(students, count);
                    break;
                case 4:
                    System.out.println("已依照座號由小到大排序學生");
                    sortBySeat(students, count);
                    break;
                case 5:
                    System.out.print("請輸入要更改成績的學生座號；");
                    student = findStudentBySeat(students, sc.nextInt(), count);
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
                    printAll(students, count);
                    break;
            }
        }
    }

    public static void sortBySeat(Student[] students, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (students[j].getSeat() > students[j + 1].getSeat())
                    swap(students, j, j + 1);
            }
        }
    }

    public static void sortByScore(Student[] students, int count) {
        for (int i = 0; i < count - 1 - 1; i++) {
            for (int j = 0; j < count - 1 - i - 1; j++) {
                if (students[j].comapreTo(students[j + 1]) < 0)
                    swap(students, j, j + 1);
            }
        }
    }

    public static void swap(Student[] students, int i1, int i2) {
        Student tmpStudent = students[i1];
        students[i1] = students[i2];
        students[i2] = tmpStudent;
    }

    public static Student findStudentBySeat(Student[] students, int seat, int count) {
        for (Student student : students) {
            if (student.getSeat() == seat)
                return student;
        }
        for (int i = 0; i < count; i++) {
            if (students[i].getSeat() == seat)
                return students[i];
        }
        return null;
    }

    public static Student[] doubleArray(Student[] students, int count) {
        Student[] newStudents = new Student[count * 2];
        System.arraycopy(students, 0, newStudents, 0, count);
        return newStudents;
    }

    public static void printAll(Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            students[i].print();
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
