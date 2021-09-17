package com.company;

/**
 * 產生學生物件用
 */
public class Student {
    private int seat;
    private int score;
    private String name;

    /**
     * InnerBuilder
     *
     * @param builder
     */
    private Student(Builder builder) {
        setSeat(builder.seat);
        setScore(builder.score);
        setName(builder.name);
    }

    public static final class Builder {
        private int seat;
        private int score;
        private String name;

        public Builder() {
        }

        public Builder setSeat(int val) {
            seat = val;
            return this;
        }

        public Builder setScore(int val) {
            score = val;
            return this;
        }

        public Builder setName(String val) {
            name = val;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    // Getter and Setter

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 輸出學生物件的樣子

    @Override
    public String toString() {
        return "座號: " + seat +
                " 成績: " + score +
                " 姓名: " + name;
    }
}
