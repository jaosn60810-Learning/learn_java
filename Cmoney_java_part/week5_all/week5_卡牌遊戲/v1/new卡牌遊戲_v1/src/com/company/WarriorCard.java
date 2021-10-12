package com.company;

import java.util.ArrayList;

//戰士
public enum WarriorCard implements CardEffect {
    CARD1(1, "照顧新人的戰士\t", 1, "自己之後打出的卡片數值 * 2", 1, 1) {

        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p1.addEffects(new Effect() {
                    @Override
                    public void doBuff(Player p1, Player p2) {
                        Card a = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                        a.setPoint(a.getPoint() * 2);
                    }
                });
            }
        }
    },
    CARD5(5, "多拿一把劍的戰士\t", 2, "抽一張牌", 1, 3) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p1.getCardSet().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p1.setHandCard(addToCardSet(p1.getHandCard(), Card.copy(p1.getCardSet()[0])));
                p1.setCardSet(removeCardFromCardSet(p1.getCardSet(), 0));
            }
        }
    },
    CARD9(9, "遇強則強的戰士\t", 3, "目前分數若是低於對手，則抽一張牌", 5, 2){
        @Override
        public boolean canEffect(Player p1, Player p2) {
            int sump1 = 0, sump2 = 0;
            for (int i = 0; i < p1.getCardonDesk().length; i++) {
                sump1 += p1.getCardonDesk()[i].getPoint();
            }
            for (int i = 0; i < p2.getCardonDesk().length; i++) {
                sump2 += p2.getCardonDesk()[i].getPoint();
            }
            return sump1 < sump2;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                p1.setHandCard(addToCardSet(p1.getHandCard(), Card.copy(p1.getCardSet()[0])));
                p1.setCardSet(removeCardFromCardSet(p1.getCardSet(), 0));

            }

        }
    },
    CARD13(13, "針對人的戰士\t\t", 4, "對手戰鬥區中數值介於 3 ~ 6 之間的卡片數值 - 2", 5, 2){
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                for (int i = 0; i < p2.getCardonDesk().length; i++) {
                    if (p2.getCardonDesk()[i].getPoint() >= 3 && p2.getCardonDesk()[i].getPoint() <= 6) {
                        p2.getCardonDesk()[i].setPoint(p2.getCardonDesk()[i].getPoint() - 2);
                    }
                }

            }

        }
    },
    CARD17(17, "路過的劍士\t\t", 5, "無特殊效果", 5, 2){
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {}
    },
    CARD21(21, "你手牌多就扣你的戰士", 6, "對手手牌大於等於 4 張時，對手戰鬥區中隨機一張牌數值減少 2", 5, 2){
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getHandCard().length >= 4 && p2.getCardonDesk().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                int r = WareHouse.random(0, p2.getCardonDesk().length - 1);
                Card tmp = p2.getCardonDesk()[r];
                tmp.setPoint(tmp.getPoint() - 2);
            }
        }
    },
    CARD25(25, "路過的鬍渣戰士\t", 7, "無特殊效果", 5, 2){
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {}
    },
    CARD29(29, "路過的超強戰士\t", 8, "無特殊效果", 5, 2){
        @Override
    public boolean canEffect(Player p1, Player p2) {
        return true;
    }

        @Override
        public void actionForAll(Player p1, Player p2) {}},
    CARD33(33, "君子復仇十年不晚的戰士", 9, "打出此卡時，若是自己棄牌區的卡片數量超過 10 張，則對手隨機一張卡片數值 - 5", 5, 2){
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p1.getCardOut().length > 10;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                int position = p2.getCardonDesk().length - 1;
                int index = WareHouse.random(0, position);

                p2.getCardonDesk()[index].setPoint(p2.getCardonDesk()[index].getPoint() - 5);
            }
        }
    },
    CARD37(37, "路過的戰士之王\t", 10, "無特殊效果", 5, 2){
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p1.getCardSet().length > 10;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                int position = p1.getCardonDesk().length - 1;

                p1.getCardonDesk()[position].setPoint(5);
            }
        }
    };

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }

    public int getOwner() {
        return owner;
    }

    public int getBuffIndex() {
        return buffIndex;
    }

    public int getEffectCount() {
        return effectCount;
    }

    public int getType() {
        return type;
    }

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

    private int type;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public int getPoint() {
        return point;
    }

    private WarriorCard(int cardNumber, String cardName, int cardPoint, String cardeffect, int type, int effectCount) {
        this.number = cardNumber;
        this.name = cardName;
        this.effect = cardeffect;
        this.point = cardPoint;
        this.value = 5;
        this.cost = 2;
        this.type = type;
        this.effectCount = effectCount;
    }

    //返回指定的牌
    @Override
    public Card getThisCard() {
        WarriorCard thisCard = this;
        Card addCard = new Card() {
            @Override
            public boolean canEffect(Player p1, Player p2) {
                return thisCard.canEffect(p1,p2);
            }

            @Override
            public void actionForAll(Player p1, Player p2){thisCard.actionForAll(p1,p2);}
        };
        addCard.setNumber(thisCard.number);
        addCard.setName(thisCard.name);
        addCard.setPoint(thisCard.point);
        addCard.setEffect(thisCard.effect);
        addCard.setValue(thisCard.value);
        addCard.setCost(thisCard.cost);
        addCard.setType(thisCard.type);
        addCard.setEffectCount(thisCard.effectCount);
        return addCard;
    }

    //返回該職業所有牌
    @Override
    public Card[] getAllCard() {
        //卡牌陣列長度==enum存幾張牌
        Card[] card = new Card[WarriorCard.values().length];
        Card addCard;
        int i = 0;

        //掃過enum全部的牌，一張張丟進arr然後回傳
        for (WarriorCard allCard : WarriorCard.values()) {
            addCard = new Card() {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return allCard.canEffect(p1,p2);
                }

                @Override
                public void actionForAll(Player p1, Player p2){allCard.actionForAll(p1,p2);}
            };
            addCard.setNumber(allCard.number);
            addCard.setName(allCard.name);
            addCard.setPoint(allCard.point);
            addCard.setEffect(allCard.effect);
            addCard.setValue(allCard.value);
            addCard.setCost(allCard.cost);
            addCard.setType(allCard.type);
            addCard.setEffectCount(allCard.effectCount);
            card[i++] = addCard;
        }
        return card;
    }

    @Override
    public String toString() {
        return "卡片編號:" + number +
                "\t名稱:" + name +
                "\t效果:" + effect +
                "\t數值:" + point +
                "\t販賣價格:" + value +
                "\t購買價格:" + cost;
    }

    @Override
    public Card[] removeCardFromCardSet(Card[] updateCardSet, int position) {
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

    @Override
    public Card[] addToCardSet(Card[] originalCardSet, Card newCard) {
        Card[] newCardSet = new Card[originalCardSet.length + 1];
        for (int i = 0; i < originalCardSet.length; i++) {
            newCardSet[i] = originalCardSet[i];
        }
        newCardSet[newCardSet.length - 1] = newCard;
        return newCardSet;
    }
}




