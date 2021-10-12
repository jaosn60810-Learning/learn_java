package com.company;

import java.io.IOException;

public class CardSet {
    private Card[] cards;

    public CardSet(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return this.cards;
    }

    public void setCards(Card[] newCards) {
        cards = newCards;
    }

    public void remove(int cardDeck, Player player) throws InterruptedException {
        System.out.println("-----以下為本牌組的所有卡片-----");
        Thread.sleep(500);//1000毫秒=1秒
        for (int i = 0; i < player.getTotalCardSets()[cardDeck].getCards().length; i++) {//getCards()是Card陣列
            System.out.print("【本副牌組的第" + (i + 1) + "張卡片】 ");
            player.getTotalCardSets()[0].getCards()[i].printOutInfo();//印出該牌組有幾張卡
        }
    }

    public void removeCard(int cardNumberRemove) {//要刪除牌組陣列的第cardDeck格中的第cardNumberRemove張
        cards[cardNumberRemove] = null;
        cards = newRemovedArr(cards,cardNumberRemove);
    }

    public static Card[] newRemovedArr(Card[] arr, int position) {
        Card newArr[] = new Card[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            if (i < position) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = arr[i + 1];
            }
        }
        return newArr;
    }

    public void addCardToCardSet(int addCardNumber) throws IOException {
        Card[] temp = new Card[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            temp[i] = cards[i];
        }
        temp[cards.length] = GetProfessionCard.getProfessionOneCard(addCardNumber);
        cards = temp;
    }

}
