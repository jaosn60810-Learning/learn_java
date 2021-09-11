package com.company;


public class Soldier {
    public int soliderLife;//士兵數值
    public int soliderNumber;//士兵人數
    public int soliderProduce = 1;//士兵生產速度 (軍營)
    public int soliderLevel = 1;//士兵等級=房屋等級 (兵工廠)
    public int soliderTime;//士兵時間=增加時間

    public void soliderLife(int life) {
        this.soliderLife = life;
    }

    public void soliderNumber(int soliderNumber) {
        this.soliderNumber = soliderNumber;
    }

    public void soliderAdd() {
        this.soliderNumber += soliderProduce;
        //士兵人數 = 士兵人數+生產速度
    }

    @Override
    public String toString() {
        return "solider{" +
                "soliderLife=" + soliderLife +
                ", soliderNumber=" + soliderNumber +
                ", soliderProduce=" + soliderProduce +
                ", soliderLevel=" + soliderLevel +
                ", soliderTime=" + soliderTime +
                '}';
    }
}
