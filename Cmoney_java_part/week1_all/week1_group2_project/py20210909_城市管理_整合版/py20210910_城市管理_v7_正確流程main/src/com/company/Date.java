package com.company;

public class Date {
    public int civilLevel = 1;
    public int time; //時間
    public int addTime; //增加時間
    public int houseLevel = 1; //先暫放房屋等級
    public int passTime = 0;

    public void time(int time) {
        this.time = time;
    }

    public void nextHour() {
        addTime = 1;
    }

    public void nextHalfDay() {
        addTime = 12;
    }

    public void nextDay() {
        addTime = 24;
    }
}
