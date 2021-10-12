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

    public static Card getProfessionOneCard(int fate, int cardNum) {
        switch (fate) {
            case 1:
                for (WarriorCard w : WarriorCard.values()) {
                    if (w.getNumber() == cardNum) {
                        return w.getThisCard();
                    }
                }
            case 2:
                for (PriestCard p : PriestCard.values()) {
                    if (p.getNumber() == cardNum) {
                        return p.getThisCard();
                    }
                }
            case 3:
                for (MagicianCard mg : MagicianCard.values()) {
                    if (mg.getNumber() == cardNum) {
                        return mg.getThisCard();
                    }
                }
            case 4:
                for (MonkCard mo : MonkCard.values()) {
                    if (mo.getNumber() == cardNum) {
                        return mo.getThisCard();
                    }
                }
        }
        return null;
    }

    public void printAllCard() {
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
}

