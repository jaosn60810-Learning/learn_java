package com.company;


public class Soldier {
    public int soldierLife=0;//士兵數值
    public int soldierNumber=0;//士兵人數
    public int soldierLifeLevel=0;
    public int soldierProduce = 0;//士兵生產速度 (軍營)
    public int soldierProduceLevel = 0;//士兵等級=房屋等級 (兵工廠)
//    public int soldierTime;//士兵時間=增加時間

    public void soldierLife(int life) {
        this.soldierLife = life + soldierLifeLevel*3;
    }

    public void soldierNumber(int soldierNumber) {
        this.soldierNumber = soldierNumber;
    }

    public void soldierAdd() {
        this.soldierNumber += soldierProduce;
        //士兵人數 = 士兵人數+生產速度
    }

    @Override
    public String toString() {
        return "士兵生命值=" + soldierLife +
                "\t士兵總數=" + soldierNumber +
                "\t生兵效率=" + soldierProduce +
                "\t士兵等級=" + soldierLifeLevel ;
    }
}
