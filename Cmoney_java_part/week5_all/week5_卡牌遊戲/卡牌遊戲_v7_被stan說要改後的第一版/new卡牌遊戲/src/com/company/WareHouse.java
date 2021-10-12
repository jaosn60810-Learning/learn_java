package com.company;

public class WareHouse {
    private Card[] cards;

    public WareHouse(int fate) {
        cards = GetProfessionCard.getProfessionAllCard(fate);
    }
    public Card[] getCards(){
        return cards;
    }

    public void addCardToWareHouse(Card card){
        Card[] temp = new Card[cards.length+1];
        for (int i = 0; i < cards.length; i++) {
            temp[i] = cards[i];
        }
        temp[temp.length - 1] = card;
        cards = temp;
    }

    public Card[] setMyFirstCardSet(int fate) {
        Card[] myFirstCardSet = new Card[20];
        Card[] temp ;
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

    public void printWareHouseCard(){
        for (int i = 0; i < cards.length; i++) {
            System.out.print("第" + (i+1) + "張卡片:");
            cards[i].printOutInfo();
        }
    }
}
