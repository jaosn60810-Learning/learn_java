package com.company;

public class WarriorSet extends WareHouse {

    private Card[] warriorSet = new Card[10];
    public WarriorSet() {
        super("warrior");
        Card[] warriorSet = { new cardWarrior1(), new cardWarrior2(), new cardWarrior3(), new cardWarrior4(), new cardWarrior5(), new cardWarrior6(), new cardWarrior7() , new cardWarrior8(), new cardWarrior9(), new cardWarrior10()};
    }


    public class cardWarrior1 extends Card{

        public cardWarrior1() {
            setNumber(1);
            setName("照顧新人的戰士\t");
            setPoint(1);
            setEffect("自己之後打出的卡片數值 * 2");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(1);
            setEffectCount(1);
        }
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                p1.addEffects(new Effect() {

                    @Override
                    public void doBuff(Player p1, Player p2) {

                        com.company.Card a = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                        a.setPoint(a.getPoint() * 2);

                    }
                });
            }
        }
    }

    public class cardWarrior2 extends Card{

        public cardWarrior2() {
            setNumber(5);
            setName("多拿一把劍的戰士\\t");
            setPoint(2);
            setEffect("抽一張牌");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(3);
            setEffectCount(1);
        }
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                p1.addEffects(new Effect() {

                    @Override
                    public void doBuff(Player p1, Player p2) {

                        com.company.Card a = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                        a.setPoint(a.getPoint() * 2);

                    }
                });
            }
        }
    }

    public class cardWarrior3 extends Card {

        public cardWarrior3() {
            setNumber(9);
            setName("遇強則強的戰士\t");
            setPoint(3);
            setEffect("目前分數若是低於對手，則抽一張牌");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(3);
            setEffectCount(1);
        }

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
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                p1.setHandCard(addToCardSet(p1.getHandCard(), com.company.Card.copy(p1.getCardSet()[0])));
                p1.setCardSet(removeCardFromCardSet(p1.getCardSet(), 0));
            }
        }
    }

    public class cardWarrior4 extends Card {

        public cardWarrior4() {
            setNumber(13);
            setName("針對人的戰士\t\t");
            setPoint(4);
            setEffect("對手戰鬥區中數值介於 3 ~ 6 之間的卡片數值 - 2");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(2);
            setEffectCount(1);
        }

        @Override
        public boolean canEffect(Player p1, Player p2) {
            return true;
        }

        @Override
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                for (int i = 0; i < p2.getCardonDesk().length; i++) {
                    if (p2.getCardonDesk()[i].getPoint() >= 3 && p2.getCardonDesk()[i].getPoint() <= 6) {
                        p2.getCardonDesk()[i].setPoint(p2.getCardonDesk()[i].getPoint() - 2);
                    }
                }
            }
        }
    }

    public class cardWarrior5 extends Card {

        public cardWarrior5() {
            setNumber(21);
            setName("你手牌多就扣你的戰士");
            setPoint(6);
            setEffect("對手手牌大於等於 4 張時，對手戰鬥區中隨機一張牌數值減少 2");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(2);
            setEffectCount(1);
        }

        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getHandCard().length >= 4 && p2.getCardonDesk().length > 0;
        }

        @Override
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                int r = random(0, p2.getCardonDesk().length - 1);
                com.company.Card tmp = p2.getCardonDesk()[r];
                tmp.setPoint(tmp.getPoint() - 2);
            }
        }
    }

    public class cardWarrior6 extends Card {

        public cardWarrior6() {
            setNumber(25);
            setName("路過的鬍渣戰士\t");
            setPoint(7);
            setEffect("無特殊效果");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(4);
            setEffectCount(1);
        }




    }

    public class cardWarrior7 extends Card {

        public cardWarrior7() {
            setNumber(26);
            setName("複雜的牧師\t\t");
            setPoint(7);
            setEffect("對方戰鬥區的上一張卡片數值 – (對方目前卡片數值總和 / 10 的餘數)");
            setValue(5);
            setCost(2);
            setJob(2);
            setType(2);
            setEffectCount(1);
        }
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return p2.getCardonDesk().length > 0;
        }

        @Override
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                int position = p2.getCardonDesk().length - 1;
                int sumPoint = 0;
                for (int i = 0; i < position + 1; i++) {
                    sumPoint += p2.getCardonDesk()[i].getPoint();
                }
                p2.getCardonDesk()[position].setPoint(p2.getCardonDesk()[position].getPoint() - sumPoint % 10);
            }
        }
    }

    public class cardWarrior8 extends Card {

        public cardWarrior8() {
            setNumber(29);
            setName("路過的超強戰士\t");
            setPoint(8);
            setEffect("無特殊效果");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(4);
            setEffectCount(1);
        }
    }

    public class cardWarrior9 extends Card {

        public cardWarrior9() {
            setNumber(30);
            setName("殉道的牧師\t\t");
            setPoint(8);
            setEffect("將自己戰鬥區第一張卡片送入棄牌區，也把對方戰鬥區中第一張卡片送入棄牌區");
            setValue(5);
            setCost(2);
            setJob(2);
            setType(2);
            setEffectCount(1);
        }
        @Override
        public boolean canEffect(Player p1, Player p2) {
            return ((p1.getCardonDesk().length > 0) && (p2.getCardonDesk().length > 0));
        }

        @Override
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
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
    }

    public class cardWarrior10 extends Card {

        public cardWarrior10() {
            setNumber(33);
            setName("君子復仇十年不晚的戰士");
            setPoint(9);
            setEffect("打出此卡時，若是自己棄牌區的卡片數量超過 10 張，則對手隨機一張卡片數值 - 5");
            setValue(5);
            setCost(2);
            setJob(1);
            setType(2);
            setEffectCount(1);
        }
        @Override
        public boolean canEffect(Player p1, Player p2) {

            return p1.getCardOut().length > 10;
        }

        @Override
        protected void actionForAll(Player p1, Player p2) {
            com.company.Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
            if (card.getEffectCount() > 0) {
                int position = p2.getCardonDesk().length - 1;
                int index = random(0, position);

                p2.getCardonDesk()[index].setPoint(p2.getCardonDesk()[index].getPoint() - 5);


            }

        }
    }


}
