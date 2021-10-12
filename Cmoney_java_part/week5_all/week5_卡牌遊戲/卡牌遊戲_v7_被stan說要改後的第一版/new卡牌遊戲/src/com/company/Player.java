package com.company;

import java.util.ArrayList;

public class Player {

    private int checkID;
    /**
     * ↑判斷是玩家還是電腦
     */
    private Card[] totalCards;
    /**
     * ↑玩家有的牌種
     */
    private CardSet[] totalCardSets;
    /**
     * ↑玩家的牌組陣列
     */
    /**

     * ↑玩家的私人倉庫區
     */
//    private int priority;
    /**
     * ↑出牌順序
     */
    private boolean canPlay;
    /**
     * ↑是否可以出牌
     */
    private int money = 100;
    /**
     * ↑存他贏的錢
     */

    private Card[] HandCard;
    private Card[] CardonDesk;
    private Card[] CardOut;
    private int playerScore;
    private int buffIndex;
    private int[] buffPosition = new int[20];
    private ArrayList<Effect> Effects;

    private WareHouse wareHouse;

    public int getFate() {
        return fate;
    }

    private int fate;

    public Player(int fate) {
        /**創建一個玩家時,先給他一個初始牌組存到他的牌組陣列中*/
        this.fate = fate;
        wareHouse = new WareHouse(fate);//new倉庫
        Card[] myFirstCardSet = wareHouse.setMyFirstCardSet(fate);//玩家職業卡丟進卡牌陣列
        this.totalCardSets = new CardSet[1];//給予第一組牌組
        totalCardSets[0] = new CardSet(myFirstCardSet);
        this.HandCard = new Card[0];
        this.CardonDesk = new Card[0];
        this.CardOut = new Card[0];
        this.Effects = new ArrayList();
        this.playerScore = 0;
    }

    public WareHouse getWareHouse() {
        return this.wareHouse;
    }

    /**
     * 下方程式為商店購買卡片後，將該卡片存入玩家倉庫區
     */

    public static Card[] doubleArr(Card[]arr){//其實是+1 Arr
        Card newArr[] = new Card[arr.length+1];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public int getBuffposition(int index) {
        return buffPosition[index];
    }

    public void setBuffPosition(int index, int buffIndex) {
        this.buffPosition[index] = buffIndex;
    }

    public int getBuffIndex() {
        return this.buffIndex;
    }

    public void setBuffIndex(int index) {
        this.buffIndex = index;
    }

    public void setTotalCardSets(int cardSetNumber,CardSet tmpCardSet) {
        this.totalCardSets[cardSetNumber] = tmpCardSet;
    }

    public CardSet[] getTotalCardSets() {
        return this.totalCardSets;
    }


    public void setPlayerScore(int score) {
        this.playerScore = score;
    }

    public int getPlayerScore() {
        return this.playerScore;
    }

    public void setHandCard(Card[] handCard) {
        this.HandCard = handCard;
    }

    public Card[] getHandCard() {
        return this.HandCard;
    }


    public void setCardSet(Card[] newCards) {
        totalCardSets[0].setCards(newCards);
    }

    public Card[] getCardSet() {
        return totalCardSets[0].getCards();
    }

    public void setCardonDesk(Card[] CardonDesk) {
        this.CardonDesk = CardonDesk;
    }

    public Card[] getCardonDesk() {
        return this.CardonDesk;
    }

    public void addCardToCardOut(Card abandonCard) {
        Card[] temp = new Card[this.CardOut.length+1];
        for (int i = 0; i < CardOut.length; i++) {
            temp[i] = CardOut[i];
        }
        temp[temp.length-1] = abandonCard;
        this.CardOut = temp;
    }

    public Card[] getCardOut() {
        return this.CardOut;
    }

    public void setCardOut(Card[] cardOut) {
        CardOut = cardOut;
    }

    public void addEffects(Effect effects) {
        Effects.add(effects);
    }

    public void cleanEffect() {
        Effects.clear();
    }

    public void removeEffect(int index) {
        Effects.remove(index);
    }

    public ArrayList<Effect> getEffects() {
        return this.Effects;
    }

    /**
     * 取得指定的牌組
     */
    public Card[] getOneOfCardset(int chooseCardSet) {
        /**指定位置(chooseCardSet)的牌組陣列(totalCardSets)中存的那個牌組(.getCards())*/
        return this.totalCardSets[chooseCardSet - 1].getCards();
    }

    public int getCardSetCount() {
        return this.totalCardSets.length;
    }

    /**
     * 外部可以更動
     */
    public void setCheckID(int id) {
        this.checkID = id;
    }

    /**
     * 外部可以更動
     */
    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    /**
     * 外部可以更動
     */
    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    /**
     * 外部可以更動
     */

}
