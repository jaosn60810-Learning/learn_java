package com.company;

public class GetProfessionCard {

    public static Card[] getProfessionAllCard(int fate) {
        switch (fate) {
            case 1:
                return WarriorCard.CARD1.getAllCard();
            case 2:
                return PriestCard.Card2.getAllCard();
            case 3:
                return MagicianCard.Card3.getAllCard();
            case 4:
                return MonkCard.Card4.getAllCard();
        }
        return null;
    }

    public static Card getProfessionOneCard(int cardNum) {
                for (WarriorCard w : WarriorCard.values()) {
                    if (w.getNumber() == cardNum) {
                        return w.getThisCard();
                    }
                }
                for (PriestCard p : PriestCard.values()) {
                    if (p.getNumber() == cardNum) {
                        return p.getThisCard();
                    }
                }
                for (MagicianCard mg : MagicianCard.values()) {
                    if (mg.getNumber() == cardNum) {
                        return mg.getThisCard();
                    }
                }
                for (MonkCard mo : MonkCard.values()) {
                    if (mo.getNumber() == cardNum) {
                        return mo.getThisCard();
                    }
                }
        return null;
    }

    public static void printAllCard() {
        System.out.println("戰士卡牌:");
        for (WarriorCard w : WarriorCard.values()) {
            System.out.println(w);
        }
        System.out.println("牧師卡牌:");
        for (PriestCard p : PriestCard.values()) {
            System.out.println(p);
        }
        System.out.println("法師卡牌:");
        for (MagicianCard mg : MagicianCard.values()) {
            System.out.println(mg);
        }
        System.out.println("武僧卡牌:");
        for (MonkCard mo : MonkCard.values()) {
            System.out.println(mo);
        }
    }

    public static void printProfessionCard(int fate) {
        switch (fate) {
            case 1:
            System.out.println("戰士卡牌:");
            for (WarriorCard w : WarriorCard.values()) {
                System.out.println(w);
            }
            break;
            case 2:
            System.out.println("牧師卡牌:");
            for (PriestCard p : PriestCard.values()) {
                System.out.println(p);
            }
            break;
            case 3:
            System.out.println("法師卡牌:");
            for (MagicianCard mg : MagicianCard.values()) {
                System.out.println(mg);
            }
            break;
            case 4:
            System.out.println("武僧卡牌:");
            for (MonkCard mo : MonkCard.values()) {
                System.out.println(mo);
            }
        }
    }
}

