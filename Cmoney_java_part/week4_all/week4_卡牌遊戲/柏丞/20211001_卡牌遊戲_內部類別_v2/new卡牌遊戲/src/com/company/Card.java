package com.company;

import com.company.Player;

public  abstract class Card {

    /**
     * 基本卡牌條件
     */

    // 卡片編號
    public int number;
    // 卡片名稱
    private String name;
    // 卡片效果說明
    private String effect;
    // 卡片職業
    public int job;
    // 卡片數值
    public int point;
    // 卡片買入金額
    private int value;
    // 卡片賣出金額
    private int cost;
    /**
     * 卡片屬於誰(0:自己 1：電腦)
     */
    private int owner;

    private int buffIndex;

    int effectCount;


    // 卡片是有特殊(1:無特殊 2:更改牌面數值 3:有更改動作)
    private int type;
    // 影響回合(一次：1,持續：99999999)
    private int round;

    public Card() {

    }


    public void printOutInfo() {
        System.out.println("\t編號：" + number + "\t\t名稱：" + name + "\t數值：" + point + "\t" + "\t效果：" + effect);
    }

    protected boolean canEffect(Player p1, Player cpu) {
        return false;
    }


    protected void actionForAll(Player p1, Player cpu) {

    }

    protected void actionForRemove(Player p1, Player cpu, int index) {

    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getBuffIndex() {
        return buffIndex;
    }

    public void setBuffIndex(int buffIndex) {
        this.buffIndex = buffIndex;
    }

    public int getEffectCount() {
        return effectCount;
    }

    public void setEffectCount(int effectCount) {
        this.effectCount = effectCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }




}
