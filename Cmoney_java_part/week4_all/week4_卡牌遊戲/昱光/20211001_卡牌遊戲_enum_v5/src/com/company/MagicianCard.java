package com.company;

import java.util.ArrayList;

//法師
public enum MagicianCard implements CardEffect {
    Card3(3, "鼓舞現場的法師\t", 1, "自己之前打出所有卡片，數值 * 2", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                for (int i = 0; i < p1.getCardonDesk().length - 1; i++) {
                    p1.getCardonDesk()[i].setPoint(p1.getCardonDesk()[i].getPoint() * 2);
                }

            }

        }
    },
    Card7(7, "加持頭尾的法師\t", 2, "戰鬥區中第一張以及目前最後一張的牌數值都 * 2", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p1.getCardonDesk().length >= 2;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p1.getCardonDesk()[0].setPoint(p1.getCardonDesk()[0].getPoint() * 2);
                p1.getCardonDesk()[p1.getCardonDesk().length - 2].setPoint(p1.getCardonDesk()[p1.getCardonDesk().length - 2].getPoint() * 2);

            }

        }
    },
    Card11(11, "干擾對手的法師\t", 3, "對手戰鬥區中上一張牌以及上兩張牌數值都減少 2", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getCardonDesk().length >= 2;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                p2.getCardonDesk()[p2.getCardonDesk().length - 1].setPoint(p2.getCardonDesk()[p2.getCardonDesk().length - 1].getPoint() - 2);
                p2.getCardonDesk()[p2.getCardonDesk().length - 2].setPoint(p2.getCardonDesk()[p2.getCardonDesk().length - 2].getPoint() - 2);

            }

        }
    },
    Card15(15, "傳奇大法師-積掰郎\t", 4, "取消對手戰鬥區中上一張卡片的效果", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            if (p2.getCardonDesk().length == 0) {
                return false;
            }
            return true;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            //   p2.removeEffect(p2.getCardonDesk()[p2.getCardonDesk().length-1].getBuffIndex());
        }
    },
    Card19(19, "照顧自己最弱者的法師", 5, "自己戰鬥區中一張數值最低的卡片數值 + 2", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p1.getCardonDesk().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                Card tmp = p1.getCardonDesk()[0];
                int index = 0;
                for (int i = 0; i < p1.getCardonDesk().length; i++) {
                    if (p1.getCardonDesk()[i].getPoint() < tmp.getPoint()) {
                        tmp = p1.getCardonDesk()[i];
                        index = i;
                    }
                }
                p1.getCardonDesk()[index].setPoint(p1.getCardonDesk()[index].getPoint() + 2);

            }

        }
    },
    Card23(23, "愛小三的法師\t\t", 6, "自己手牌中數值小於 3 的牌全部 + 1", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p1.getHandCard().length > 0;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                for (int i = 0; i < p1.getHandCard().length; i++) {
                    if (p1.getHandCard()[i].getPoint() < 3) {
                        Card tmp = p1.getHandCard()[i];
                        tmp.setPoint(tmp.getPoint() + 1);
                    }
                }

            }


        }
    },
    Card27(27, "隨便的法師\t\t", 7, "對手戰鬥區隨機一張卡片數值 - 3", 5, 2) {
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

                p2.getCardonDesk()[index].setPoint(p2.getCardonDesk()[index].getPoint() - 3);


            }

        }
    },
    Card31(31, "欺弱怕強的法師\t", 8, "若是目前自己的戰鬥區中數值總和低於 15 (不包含此牌)，則此牌數值 - 4", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            int sumPoint = 0;
            for (int i = 0; i < p1.getCardonDesk().length - 1; i++) {
                sumPoint += p1.getCardonDesk()[i].getPoint();
            }
            return sumPoint < 15;
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
    Card35(35, "之後來的都減一的法師", 9, "對手之後出的每張卡片數值 - 1", 5, 2) {
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
                        tmp.setPoint(tmp.getPoint() - 1);
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
    Card39(39, "懶惰的法師\t\t", 10, "自己戰鬥區前一張牌的數值若是大於 5，則此牌的數值為 7", 5, 2) {
        @Override
        public boolean canEffect(Player p1, Player p2) {
            if (p1.getCardonDesk().length > 1) {
                int position = p1.getCardonDesk().length - 2;
                return p1.getCardonDesk().length > 0 && p1.getCardonDesk()[position].getPoint() > 5;
            }
            return false;
        }

        @Override
        public void actionForAll(Player p1, Player p2) {
            Card card = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
            if (card.getEffectCount() > 0) {
                int position = p1.getCardonDesk().length - 1;

                p1.getCardonDesk()[position].setPoint(7);


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

    private MagicianCard(int cardNumber, String cardName, int cardPoint, String cardeffect, int type, int effectCount) {
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
        MagicianCard thisCard = this;
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
        Card[] card = new Card[MagicianCard.values().length];
        Card addCard;
        int i = 0;

        //掃過enum全部的牌，一張張丟進arr然後回傳
        for (MagicianCard allCard : MagicianCard.values()) {
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




