package com.company;

public class WareHouse {
    Card[] cards;

    public WareHouse() {
    cards = new Card[10];
}
    public Card[] getCards(){
        return cards;
    }

    public void addCard(Card card){
        Card[] temp = new Card[cards.length+1];
        for (int i = 0; i < cards.length; i++) {
            temp[i] = cards[i];
        }
        temp[temp.length] = card;
        cards = temp;
    }

    public Card[] setMyFirstCardSet(int fate) {
        Card[] myFirstCardSet = new Card[20];
        Card[] temp = new Card[WarriorCard.values().length];
        temp = GetProfessionCard.getProfessionAllCard(fate);
        for (int i = 0; i < temp.length; i++){
            myFirstCardSet[i] = myFirstCardSet[i+10] = temp[i];
        }
        return myFirstCardSet;
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
}
