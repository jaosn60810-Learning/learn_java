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

    private int buffIndex;// buff 位置

    int effectCount;


    // 卡片是有特殊(1: 當下作用 2: 上buff 3: 抽卡 4: 沒效果)
    private int type;
    // 影響回合(一次：1,持續：99999999)
    private int round;


//    boolean canEffect(Player p1, Player p2);
//
//    void actionOnetime(Player p1, Player p2);
//
//    void actionAllTheTime(Player p1, Player p2);
//
//
//    public Card[] getAllCard();
//
//    public Card getThisCard();
//
//    public String toString();
//
//    public Card[] removeCardFromCardSet(Card[] updateCardSet, int position);
//
//    public Card[] addToCardSet(Card[] originalCardSet, Card newCard);


    public Card(int cardNumber, String cardName, int cardPoint, String cardeffect, int cardValue, int cardCost, int type, int effectCount) {
        this.number = cardNumber;
        this.name = cardName;
        this.effect = cardeffect;
        this.point = cardPoint;
        this.value = cardValue;
        this.cost = cardCost;
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
                card.type,
                card.effectCount

        ) {
            @Override
            protected boolean canEffect(Player p1, Player cpu) {
                return card.canEffect(p1, cpu);
            }

//            @Override // 這個沒用到
//            protected int action(Player p1, Player cpu) {
//                return card.action(p1, cpu);
//            }

            @Override
            protected void actionForOneTime(Player p1, Player cpu) {
                card.actionForOneTime(p1, cpu);
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

    protected void actionForOneTime(Player p1, Player cpu) {

    }

    protected void actionForAllTheTime(Player p1, Player cpu) {

    }

    protected void actionForRemove(Player p1, Player cpu, int index) {

    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static Card[] removeCardFromCardSet(Card[] updateCardSet, int position) {
        Card[] newCard = new Card[updateCardSet.length - 1];
        for (int i = 0; i < updateCardSet.length - 1; i++) {
            if (i < position) {
                newCard[i] = updateCardSet[i];
            } else {
                newCard[i] = updateCardSet[i + 1];
            }
        }
        return newCard;
    }

    public static Card[] addToCardSet(Card[] originalCardSet, Card newCard) {
        Card[] newCardSet = new Card[originalCardSet.length + 1];
        for (int i = 0; i < originalCardSet.length; i++) {
            newCardSet[i] = originalCardSet[i];
        }
        newCardSet[newCardSet.length - 1] = newCard;
        return newCardSet;
    }

    public Card[] getAllCard() {
        return null;
    }

    public Card getThisCard() {
        return this;
    }


}
