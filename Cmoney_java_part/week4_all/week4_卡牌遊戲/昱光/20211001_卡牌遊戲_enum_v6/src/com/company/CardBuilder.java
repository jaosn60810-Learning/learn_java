package com.company;

public class CardBuilder {
    public CardBuilder setNumber(int number) {
        this.number = number;
        return this;
    }

    public CardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CardBuilder setEffect(String effect) {
        this.effect = effect;
        return this;
    }

    public CardBuilder setPoint(int point) {
        this.point = point;
        return this;
    }

    public CardBuilder setValue(int value) {
        this.value = value;
        return this;
    }

    public CardBuilder setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public CardBuilder setOwner(int owner) {
        this.owner = owner;
        return this;
    }

    public CardBuilder setBuffIndex(int buffIndex) {
        this.buffIndex = buffIndex;
        return this;
    }

    public CardBuilder setEffectCount(int effectCount) {
        this.effectCount = effectCount;
        return this;
    }

    public CardBuilder setType(int type) {
        this.type = type;
        return this;
    }

    public CardBuilder setRound(int round) {
        this.round = round;
        return this;
    }

    public Card build(){
        return new Card(number,name,point,effect,value,cost,type,effectCount);
    }

    // 卡片編號
    private int number;
    // 卡片名稱
    private String name;
    // 卡片效果說明
    private String effect;
    // 卡片數值
    private int point;
    // 卡片買入金額
    private int value;
    // 卡片賣出金額
    private int cost;
    /**
     * 卡片屬於誰(0:自己 1：電腦)
     */
    private int owner;

    private int buffIndex;

    private int effectCount;

    // 卡片是有特殊(1:無特殊 2:更改牌面數值 3:有更改動作)
    private int type;
    // 影響回合(一次：1,持續：99999999)
    private int round;



}
