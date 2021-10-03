package com.company;

import java.util.ArrayList;

    //戰士
    public enum WarriorCard implements CardEffect {
        CARD1(1, "照顧新人的戰士\t", 1, "自己之後打出的卡片數值 * 2", 5, 2, 1, 1) {
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
        CARD5(5, "多拿一把劍的戰士\t", 2, "抽一張牌", 5, 2, 1, 3) {
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

        private WarriorCard(int cardNumber, String cardName, int cardPoint, String cardeffect, int cardValue, int cardCost, int type, int effectCount) {
            this.number = cardNumber;
            this.name = cardName;
            this.effect = cardeffect;
            this.point = cardPoint;
            this.value = cardValue;
            this.cost = cardCost;
            this.type = type;
            this.effectCount = effectCount;
        }

        //返回指定的牌
        @Override
        public Card getThisCard(){
            WarriorCard thisCard = this;
            return new CardBuilder().setName(thisCard.getName())
                    .setNumber(thisCard.number)
                    .setPoint(thisCard.point)
                    .setEffect(thisCard.effect)
                    .setValue(thisCard.value)
                    .setCost(thisCard.cost)
                    .setType(thisCard.type)
                    .setEffectCount(thisCard.effectCount)
                    .build();
        }

        //返回該職業所有牌
        @Override
        public Card[] getAllCard() {
            //卡牌陣列長度==enum存幾張牌
            Card[] card = new Card[WarriorCard.values().length];
            int i = 0;

            for (WarriorCard allCard : WarriorCard.values()) {
                card[i++] = new CardBuilder().setName(allCard.getName())
                        .setNumber(allCard.number)
                        .setPoint(allCard.point)
                        .setEffect(allCard.effect)
                        .setValue(allCard.value)
                        .setCost(allCard.cost)
                        .setType(allCard.type)
                        .setEffectCount(allCard.effectCount)
                        .build();

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




