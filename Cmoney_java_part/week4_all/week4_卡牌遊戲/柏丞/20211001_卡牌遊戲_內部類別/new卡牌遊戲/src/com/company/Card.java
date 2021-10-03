package com.company;

public class Card {


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

    public Card(int cardNumber, String cardName, int cardPoint, String cardeffect, int cardValue, int cardCost, int job, int type,int effectCount) {
        this.number = cardNumber;
        this.name = cardName;
        this.effect = cardeffect;
        this.point = cardPoint;
        this.value = cardValue;
        this.cost = cardCost;
        this.job = job;
        this.type = type;
        this.effectCount = effectCount;
    }



    public static Card copy(Card card) {
        return new Card(
                card.number,
                card.name,
                card.point,
                card.effect,
                card.cost,
                card.value,
                card.job,
                card.type,
                card.effectCount

        ) {
            @Override
            protected boolean canEffect(Player p1, Player cpu) {
                return card.canEffect(p1, cpu);
            }

            @Override
            protected int action(Player p1, Player cpu) {
                return card.action(p1, cpu);
            }

            @Override
            protected void actionForAll(Player p1, Player cpu) {
                card.actionForAll(p1, cpu);
            }

            @Override
            protected void actionForRemove(Player p1, Player p2, int index) {
                card.actionForRemove(p1, p2, index);
            }
        };
    }

    public int getEffectCount() {
        return effectCount;
    }

    public void setEffectCount(int effectCount) {
        this.effectCount = effectCount;
    }

    public int getBuffIndex() {
        return buffIndex;
    }

    public void setBuffIndex(int buffIndex) {
        this.buffIndex = buffIndex;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public int getPoint() {
        return this.point;
    }

    public int getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    public int getJob() {
        return this.job;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getOwner() {
        return this.owner;
    }

    public void printOutInfo() {
        System.out.println("\t編號：" + number + "\t\t名稱：" + name + "\t數值：" + point + "\t" + "\t效果：" + effect);
    }

    protected boolean canEffect(Player p1, Player cpu) {
        return false;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    protected int action(Player p1, Player cpu) {
        return 0;
    }

    protected void actionForAll(Player p1, Player cpu) {

    }

    protected void actionForRemove(Player p1, Player cpu, int index) {

    }


}
