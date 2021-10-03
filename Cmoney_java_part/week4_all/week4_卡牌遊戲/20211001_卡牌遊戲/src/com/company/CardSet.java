package com.company;

public class CardSet {
    private Card[] cards;

    public CardSet(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards(){
        return this.cards;
    }

    public void remove(int cardDeck,Player player) throws InterruptedException {
        System.out.println("-----以下為本牌組的所有卡片-----");
        Thread.sleep(500);//1000毫秒=1秒
        for(int i = 0; i < player.getTotalCardSets()[cardDeck].getCards().length;i++){//getCards()是Card陣列
            System.out.print("【本副牌組的第"+(i+1)+"張卡片】 ");
            player.getTotalCardSets()[0].getCards()[i].printOutInfo();//印出該牌組有幾張卡

        }
    }

    public void removeCard(int cardNumberRemove,int cardDeck,Player player){//要刪除牌組陣列的第cardDeck格中的第cardNumberRemove張
        Card tmpCard = player.getTotalCardSets()[cardDeck].getCards()[cardNumberRemove];//將要移除的指定牌組中的指定卡牌暫存進tmpCard
        player.addCardIntoPlayerWareHouse(tmpCard);//將tmpCard加入玩家倉庫區
        player.getTotalCardSets()[cardDeck].getCards()[cardNumberRemove] = null;//將"要移除的指定牌組中的指定卡牌"在"指定牌組"中的存放陣列格子改為空值
        CardSet tmpCardSet = new CardSet(newRemovedArr(player.getTotalCardSets()[cardDeck].getCards(),cardNumberRemove));//把已經有null的卡牌陣列進行轉移，使新的卡牌陣列長度-1且沒有null，存入暫存類別"CardSet"
        player.setTotalCardSets(cardDeck,tmpCardSet);//將"新的CardSet"丟回原本玩家手中的CardSet
    }


    public static Card[] newRemovedArr(Card[]arr, int position) {
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

}
