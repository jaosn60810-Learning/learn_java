package com.company;

import java.util.Scanner;

public class Student {
    private int studentID;
    private int ENScore;
    private int MATHScore;
    private int avrScore;

    public Student(int studentID) {
        this(studentID, -1, -1);
    }

    public Student(int studentID, int ENScore, int MATHScore) {
        this.studentID = studentID;

        this.avrScore = (setENScore(ENScore) +  setMATHScore(MATHScore)) / 2;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getENScore() {
        return ENScore;
    }

    public int setENScore(int ENScore) {
        Scanner sc = new Scanner(System.in);
        do {
            if (ENScore >= 0 && ENScore <= 100) {
                break;
            }
            System.out.println("ENScore 超出範圍,重新輸入");
            ENScore = sc.nextInt();

        }while(true);

        this.ENScore = ENScore;
        return ENScore;
    }

    public int setMATHScore(int MATHScore) {
        Scanner sc = new Scanner(System.in);
        do {
            if (MATHScore >= 0 && MATHScore <= 100) {
                break;
            }
            System.out.println("MATHScore 超出範圍,重新輸入");
            MATHScore = sc.nextInt();

        }while(true);

        this.MATHScore = MATHScore;
        return MATHScore;
    }

    public int getMATHScore() {
        return MATHScore;
    }

    public int getAvrScore() {
        return avrScore;
    }

    public void setAvrScore() {
        this.avrScore = (ENScore + MATHScore) / 2;
    }

    @Override
    public String toString() {
        return studentID + "\t\t" +
                ENScore + "\t\t" +
                MATHScore + "\t\t" +
                avrScore + "\t\t";
    }
}
