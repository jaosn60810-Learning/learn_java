package com.company;

public enum PriestCard implements CardEffect {
    Card2(2, "嘴賤的牧師\t\t", 1, "對手之後打出的卡片數值 / 2", 1, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p2.addEffects(new Effect() {

                    @Override
                    public void doBuff(Player p1, Player p2) {

                        Card tmp = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                        tmp.setPoint(tmp.getPoint() / 2);
                    }
                });

            }

        }

//        @Override
//        protected void actionForRemove(Player p1, Player p2, int index) {
//            p2.removeEffect(index);
//            {
//
//            }
//        }
    },

    Card6(6, "逼人懺悔的牧師\t", 2, "對手隨機捨棄一張手牌", 3, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getHandCard().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int r = random(0, p2.getHandCard().length - 1);
                p2.setCardOut(addToCardSet(p2.getCardOut(), p2.getHandCard()[r]));
                p2.setHandCard(removeCardFromCardSet(p2.getHandCard(), r));


            }

        }
    },

    Card10(10, "三倍的牧師\t\t", 3, "對手抽一張牌，此牌分數 * 3", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p2.setHandCard(addToCardSet(p2.getHandCard(), Card.copy(p2.getCardSet()[0])));
                p2.setCardSet(removeCardFromCardSet(p2.getCardSet(), 0));
                Card tmp = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                tmp.setPoint(tmp.getPoint() * 3);

            }

        }
    },

    Card14(14, "加持強者的牧師\t", 4, "自己打出的數值介於 5 ~ 8 的卡片數值 + 1", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                for (int i = 0; i < p1.getCardonDesk().length; i++) {
                    if (p1.getCardonDesk()[i].getPoint() >= 5 && p1.getCardonDesk()[i].getPoint() <= 8) {
                        p1.getCardonDesk()[i].setPoint(p1.getCardonDesk()[i].getPoint() + 1);
                    }
                }

            }

        }
    },

    Card18(18, "針對對手最弱者的牧師", 5, "對手戰鬥區中一張數值最低的卡片數值 - 2", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getCardonDesk().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                Card tmp = p2.getCardonDesk()[0];
                int index = 0;
                for (int i = 0; i < p2.getCardonDesk().length; i++) {
                    if (p2.getCardonDesk()[i].getPoint() < tmp.getPoint()) {
                        tmp = p2.getCardonDesk()[i];
                        index = i;
                    }
                }
                p2.getCardonDesk()[index].setPoint(p2.getCardonDesk()[index].getPoint() - 2);

            }

        }
    },

    Card22(22, "無能的牧師\t\t", 6, "無特殊效果", 4, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return false;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {

        }
    },

    Card26(26, "複雜的牧師\t\t", 7, "對方戰鬥區的上一張卡片數值 – (對方目前卡片數值總和 / 10 的餘數)", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getCardonDesk().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int position = p2.getCardonDesk().length - 1;
                int sumPoint = 0;
                for (int i = 0; i < position + 1; i++) {
                    sumPoint += p2.getCardonDesk()[i].getPoint();
                }
                p2.getCardonDesk()[position].setPoint(p2.getCardonDesk()[position].getPoint() - sumPoint % 10);


            }

        }
    },

    Card30(30, "殉道的牧師\t\t", 8, "將自己戰鬥區第一張卡片送入棄牌區，也把對方戰鬥區中第一張卡片送入棄牌區", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return ((p1.getCardonDesk().length > 0) && (p2.getCardonDesk().length > 0));
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                //自己先丟
                System.out.println("卡片編號:" + p1.getCardonDesk()[0].number + "被丟掉了");
                p1.setCardOut(addToCardSet(p1.getCardOut(), p1.getCardonDesk()[0]));
                p1.setCardonDesk(removeCardFromCardSet(p1.getCardonDesk(), 0));
                //換對手丟
                System.out.println("卡片編號:" + p2.getCardonDesk()[0].number + "被丟掉了");
                p2.setCardOut(addToCardSet(p1.getCardOut(), p2.getCardonDesk()[0]));
                p2.setCardonDesk(removeCardFromCardSet(p2.getCardonDesk(), 0));


            }

        }
    },

    Card34(34, "你4我就4的牧師\t", 9, "打出此卡時，若是對手戰鬥區的卡片超過 4 張，則此卡片的數值為 4", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {

            return p2.getCardonDesk().length > 4;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int position = p1.getCardonDesk().length - 1;

                p2.getCardonDesk()[position].setPoint(4);


            }

        }
    },

    Card38(38, "三八的牧師\t\t", 10, "若打出時自己牌組高於 10 張，則此牌的數值為 5", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {

            return p1.getCardSet().length > 10;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
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

    private PriestCard(int cardNumber, String cardName, int cardPoint, String cardeffect, int type, int effectCount) {
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
        PriestCard thisCard = this;
        Card addCard = new Card() {
            @Override
            public boolean canEffect(Player p1, Player p2) {
                return thisCard.canEffect(p1, p2);
            }

            @Override
            public void actionForAll(Player p1, Player p2) {
                thisCard.actionForAll(p1, p2);
            }
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
        Card[] card = new Card[PriestCard.values().length];
        Card addCard;
        int i = 0;

        //掃過enum全部的牌，一張張丟進arr然後回傳
        for (PriestCard allCard : PriestCard.values()) {
            addCard = new Card() {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return allCard.canEffect(p1, p2);
                }

                @Override
                public void actionForAll(Player p1, Player p2) {
                    allCard.actionForAll(p1, p2);
                }
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

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
