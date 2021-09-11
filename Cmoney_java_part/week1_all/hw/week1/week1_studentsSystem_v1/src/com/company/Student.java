package com.company;

public class Student {
    private int seat;
    private int score;
    private String schoolClass;
    private String name;

    public Student(int seat, String schoolClass, String name) {
        this(seat, schoolClass, name, 0);
    }

    public Student(int seat, String schoolClass, String name, int score) {
        this.setSeat(seat);
        this.schoolClass = schoolClass;
        this.name = name;
        this.setScore(score);
    }

    public int getSeat() {
        return this.seat;
    }

    public int getScore() {
        return this.score;
    }

    public String getSchoolClass() {
        return this.schoolClass;
    }

    public String getName() {
        return this.name;
    }

    public void setScore(int score) {
        if (score < 0 || score > 100)
            this.score = 1;
        this.score = score;
    }

    private void setSeat(int seat) {
        if (seat <= 0)
            this.seat = 1;
        this.seat = seat;
    }

    public void print() {
        System.out.println("座號 " + this.seat + " 班級 " + this.schoolClass + " 姓名 " + this.name + " 成績 " + this.score);
    }

    public int comapreTo(Student student) {
        return this.getScore() - student.getScore();
    }
}


