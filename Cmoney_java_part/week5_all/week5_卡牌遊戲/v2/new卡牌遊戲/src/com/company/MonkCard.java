package com.company;

public enum MonkCard implements CardEffect {
    Card4(4, "恫嚇現場的武僧\t", 1, "對手之前打出所有卡片，數值 / 2", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                for (int i = 0; i < p2.getCardonDesk().length; i++) {
                    p2.getCardonDesk()[i].setPoint(p2.getCardonDesk()[i].getPoint() / 2);
                }

            }

        }
    },

    Card8(8, "不認輸的武僧\t\t", 2, "目前分數若是低於對手，則分數的差額會變成這張牌的數值", 2, 1) {
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
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int p1score = 0, p2score = 0;
                for (int i = 0; i < p1.getCardonDesk().length; i++) {
                    p1score += p1.getCardonDesk()[i].getPoint();
                }
                for (int i = 0; i < p2.getCardonDesk().length; i++) {
                    p2score += p2.getCardonDesk()[i].getPoint();
                }
                p1.getCardonDesk()[p1.getCardonDesk().length - 1].setPoint(p2score - p1score);

            }

        }
    },

    Card12(12, "照顧小弟的武僧\t", 3, "自己下一張牌以及下兩張牌的數值都加 1", 1, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p1.addEffects(new Effect() {
                    int count = 2;

                    @Override
                    public void doBuff(Player p1, Player p2) {

                        if (count <= 0) {
                            return;
                        }
                        Card a = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                        a.setPoint(a.getPoint() + 1);
                        count--;
                    }
                });

            }

        }

//        @Override
//        protected void actionForRemove(Player p1, Player p2, int index) {
//            p1.removeEffect(index);
//            {
//
//            }
//        }
    },

    Card16(16, "尋找弱者的武僧\t", 4, "若是我方戰鬥區中有兩張數值低於 3 的卡片，則此牌數值 + 2", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            int count = 0;
            for (int i = 0; i < p1.getCardonDesk().length; i++) {
                if (p1.getCardonDesk()[i].getPoint() < 3) {
                    count++;
                }
            }
            for (int i = 0; i < p2.getCardonDesk().length; i++) {
                if (p2.getCardonDesk()[i].getPoint() < 3) {
                    count++;
                }
            }
            return count >= 2;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                Card tmp = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                tmp.setPoint(tmp.getPoint() + 2);

            }

        }
    },

    Card20(20, "隨便打一個的武僧\t", 5, "對手戰鬥區的卡片中隨機一張卡片數值 - 3", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getCardonDesk().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int r = random(0, p2.getCardonDesk().length - 1);
                Card tmp = p2.getCardonDesk()[r];
                tmp.setPoint(tmp.getPoint() - 3);

            }

        }
    },

    Card24(24, "跟你下一張說拜拜的武僧", 6, "將對手下一張打出的牌直接丟到棄牌區，效果不發動", 1, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getHandCard().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p2.addEffects(new Effect() {
                    int count = 1;

                    @Override
                    public void doBuff(Player p1, Player p2) {
                        if (count <= 0) {
                            return;
                        }
                        int index = p1.getCardonDesk().length - 1;
                        System.out.println("卡片編號:" + p1.getCardonDesk()[index].number + "被丟掉了");
                        p1.addCardToCardOut(p1.getCardonDesk()[index]);
                        p1.setCardonDesk(removeCardFromCardSet(p1.getCardonDesk(), index));
                        count--;
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

    Card28(28, "亂來的武僧\t\t", 7, "自己戰鬥區隨機一張卡數值 + 3", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p1.getCardonDesk().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int position = p1.getCardonDesk().length - 1;
                int index = random(0, position);

                p1.getCardonDesk()[index].setPoint(p1.getCardonDesk()[index].getPoint() + 3);


            }

        }
    },

    Card32(32, "害怕強者的武僧\t", 8, "打出此卡時，若是對手戰鬥區中的數值總和高於 15，則此牌數值 - 4", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            int sumPoint = 0;
            for (int i = 0; i < p2.getCardonDesk().length; i++) {
                sumPoint += p2.getCardonDesk()[i].getPoint();
            }
            return sumPoint > 15;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int position = p1.getCardonDesk().length - 1;

                p1.getCardonDesk()[position].setPoint(p1.getCardonDesk()[position].getPoint() - 4);


            }

        }
    },

    Card36(36, "路過的少林寺方丈\t", 9, "無特殊效果", 4, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return false;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {

        }
    },

    Card40(40, "失誤殺人的武僧\t", 10, "對手戰鬥區隨機一張卡片數值變成 0", 2, 1) {
        @Override
        public boolean canEffect(Player p1, Player p2) {

            return p2.getCardonDesk().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int position = p2.getCardonDesk().length - 1;
                int index = random(0, position);
                p2.getCardonDesk()[index].setPoint(0);

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

    private MonkCard(int cardNumber, String cardName, int cardPoint, String cardeffect, int type, int effectCount) {
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
        MonkCard thisCard = this;
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
        Card[] card = new Card[MonkCard.values().length];
        Card addCard;
        int i = 0;

        //掃過enum全部的牌，一張張丟進arr然後回傳
        for (MonkCard allCard : MonkCard.values()) {
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
