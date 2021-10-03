package com.company;

public class WareHouse {
    private String occupation;

    public WareHouse(String occupation) {
        this.occupation = occupation;
    }

    public Card[] setMyFirstCardSet(int fate) {
        Card[] myFirstCardSet = new Card[20];
        WarriorSet warriorSet = new WarriorSet();
        for (int i = 0; i < warriorSet.getWarriorSet().length; i++) {
            myFirstCardSet[i] = warriorSet.getWarriorSet()[i];
        }

        for (int i = 10; i < 20; i++) {
            myFirstCardSet[i] = warriorSet.getWarriorSet()[i];
        }
        return myFirstCardSet;
    }

//    public Card[] setMyFirstCardSet(int fate) {
//        Card[] myFirstCardSet = new Card[20];
//        int index = 0;
//        for (int i = 0; i < AllWareHouse.length; i++) {
//            if (AllWareHouse[i].job == fate) {
//                myFirstCardSet[index] = Card.copy(AllWareHouse[i]);
//                index++;
//            }
//        }
//        for (int i = 10; i < 20; i++) {
//            myFirstCardSet[i] = Card.copy(myFirstCardSet[index - 1]);
//            index--;
//        }
//        return myFirstCardSet;
//    }

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



}
