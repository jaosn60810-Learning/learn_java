package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private Card[] playerWareHouse;
    /**
     * ↑玩家的私人倉庫區
     */
    private int priority;
    /**
     * ↑出牌順序
     */
    private boolean canPlay;
    /**
     * ↑是否可以出牌
     */
    private int money = 0;
    /**
     * ↑存他贏的錢
     */

    private ArrayList<Card> HandCard;
    private ArrayList<Card> CardSet;
    private ArrayList<Card> CardonDesk;
    private ArrayList<Card> CardOut;
    private int playerScore;
    private int buffIndex;// buff 數量
//    private int[] buffPosition = new int[20]; 這行沒用到( 20 沒有意義 隨意填的數字)
    private ArrayList<Effect> Effects;


    public Player(int fate) {
        /**創建一個玩家時,先給他一個初始牌組存到他的牌組陣列中*/
        WareHouse wareHouse = new WareHouse();//new總牌庫的實體,可以取得裡面的卡
        Card[] myFirstCardSet = wareHouse.setMyFirstCardSet(fate);//去比較符合玩家輸入的職業的卡丟進卡牌陣列
        CardSet myCardsets = new CardSet(myFirstCardSet);//把剛剛得到的牌組存到一個牌組類別中
        CardSet[] myAllCardsets = new CardSet[1];//新增一個牌組陣列裡面可以放一個牌組
        myAllCardsets[0] = myCardsets;//將第一個牌組丟進牌組陣列
        this.totalCardSets = myAllCardsets;//存進這個玩家的牌組陣列
        this.HandCard = new ArrayList<>();
        this.CardonDesk = new ArrayList<>();
        this.CardOut = new ArrayList<>();
        this.Effects = new ArrayList<>();
        this.playerScore = 0;
        this.playerWareHouse = new Card[20];//玩家的私人倉庫區，初始有20格，以便存入初始選擇牌組
        for(int i = 0; i < playerWareHouse.length; i++){//將玩家選的初始牌組(第1副20張)，存入玩家的私人倉庫區
            playerWareHouse[i] = getTotalCardSets()[0].getCards()[i];
        }

    }

    /**
     * 下方程式為商店購買卡片後，將該卡片存入玩家倉庫區
     */
    public void addCardIntoPlayerWareHouse(Card card){
        /**
         * 先判斷倉庫陣列夠不夠大：倉庫有空位就將"新買來的卡片"丟入該空位、沒空位就陣列長度+1，
         * 並將"新買來的卡片"丟入該"+1"的空位
         */
        int count = 0;
        int i = 0;
        for(i = 0; i < playerWareHouse.length; i++){//playerAllCards.length=20
            if(playerWareHouse[i] == null){
                playerWareHouse[i] = card;
                break;
            }else{
                count++;//如果跑一次沒有空位就+1 (買第一張卡片時count最後會 = 20)
            }
        }
        //買第一張卡片時i最後會 = 20，因為要先i=20進不去for迴圈後才會往下跑
//        System.out.println("i是："+i);
//        System.out.println("count 是："+count);
//        System.out.println("playerWareHouse.length是："+playerWareHouse.length);
        if(count == playerWareHouse.length){
            playerWareHouse = doubleArr(playerWareHouse);
            playerWareHouse[i]= card;//新的arr最後會有21格()，index20其實是第21格
        }
//        System.out.println("playerWareHouse.length是："+playerWareHouse.length);
//        System.out.println("playerWareHouse[20].getNumber()是："+playerWareHouse[20].getNumber());
    }

    public static Card[] doubleArr(Card[]arr){//其實是+1 Arr
        Card newArr[] = new Card[arr.length+1];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
//        System.out.println("newArr.length是："+newArr.length);
        return newArr;
    }

    //沒用到 buffPosition 所以 setter 和 getter 沒用
//    public int getBuffposition(int index) {
//        return buffPosition[index];
//    }
//
//    public void setBuffPosition(int index, int buffIndex) {
//        this.buffPosition[index] = buffIndex;
//    }

    public int getBuffIndex() {
        return this.buffIndex;
    }

    public void setBuffIndex(int index) {
        this.buffIndex = index;
    }

    public Card[] getPlayerWareHouse() {
        return playerWareHouse;
    }

    public void setTotalCardSets(int cardDeck,CardSet tmpCardSet) {
        this.totalCardSets[cardDeck] = tmpCardSet;
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

    public void setHandCard(ArrayList<Card> handCard) {
        this.HandCard = handCard;
    }

    public ArrayList<Card>  getHandCard() {
        return this.HandCard;
    }


    public void setCardSet(ArrayList<Card>  Cardset) {
        this.CardSet = Cardset;
    }

    public ArrayList<Card>  getCardSet() {
        return this.CardSet;
    }

    public void setCardonDesk(ArrayList<Card>  CardonDesk) {
        this.CardonDesk = CardonDesk;
    }

    public ArrayList<Card>  getCardonDesk() {
        return this.CardonDesk;
    }

    public void setCardOut(ArrayList<Card>  CardOut) {
        this.CardOut = CardOut;
    }

    public ArrayList<Card>  getCardOut() {
        return this.CardOut;
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
    public ArrayList<Card> getOneOfCardset(int chooseCardSet) {
        /**指定位置(chooseCardSet)的牌組陣列(totalCardSets)中存的那個牌組(.getCards())*/
        ArrayList<Card> newArrayList = (ArrayList<Card>) Arrays.asList(this.totalCardSets[chooseCardSet - 1].getCards());
        return newArrayList;
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
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
