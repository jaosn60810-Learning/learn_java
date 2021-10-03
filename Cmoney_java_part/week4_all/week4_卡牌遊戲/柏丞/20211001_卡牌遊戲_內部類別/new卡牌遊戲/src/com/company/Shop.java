package com.company;

import java.util.Scanner;


public class Shop extends WareHouse {

    private Player player1;
    //private  Card[] player1TotalCard = player1.getPlayerWareHouse();

    public Shop(Player player) {
        this.player1 = player;

    }

    public void shop() {
        Scanner sc = new Scanner(System.in);
        // newPlayer player1 =new newPlayer(0);
        //System.out.println("歡迎來到商店");
        //System.out.println("你目前擁有" + player1.getMoney() + "元");
        // 呼叫可選卡片功能
        //System.out.println("請輸入指令(1)buy (2)顯示所有可以購買的卡片");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("歡迎來到商店\n\uD83D\uDCB0\uD83D\uDCB0\uD83D\uDCB0\uD83D\uDCB0\uD83D\uDCB0\uD83D\uDCB0");
                System.out.println("你目前擁有 " + player1.getMoney() + " 元");
                System.out.println("有錢的大人啊，請您輸入想買的卡片編號，或輸入 0 離開");
                int input2 = sc.nextInt();
                if (input2 == 0) {
                    break;
                }
                player1.getMoney();
                addNewCardFromWareHouse(input2);

                break;
            case 2:
                //掃描已用有卡牌
                int countDoubleCard = 0;//掃描重複卡牌之計數器
                int countBuyableCard = 0; //可買卡片放入可買陣列之計數器
                Card[] tmpCards = new Card[2];//放入可買之卡牌
                for (int i = 0; i < AllWareHouse.length; i++) {
                    for (int j = 0; j < player1.getPlayerWareHouse().length; j++) {
                        if (AllWareHouse[i].getNumber() ==
                                player1.getPlayerWareHouse()[j].getNumber()) {
                            countDoubleCard++;
                        }
                    }
                    if (countBuyableCard == tmpCards.length) {
                        tmpCards = arrPlusOne(tmpCards);//陣列長度加一
                    }
                    if (countDoubleCard != 2) {
                        tmpCards[countBuyableCard++] = AllWareHouse[i];
                    }
                    countDoubleCard = 0;
                }
//			System.out.println("玩家已有手牌如下");
//			for(int f = 0 ; f<player1.getPlayerWareHouse().length;f++)
//				System.out.println(player1.getPlayerWareHouse()[f].getNumber());

                System.out.println("冒險者您可購買卡牌如下");
                for (int k = 0; k < countBuyableCard; k++)
                    System.out.println(" 卡牌編號: " + tmpCards[k].getNumber() + " 卡牌名稱: " + tmpCards[k].getName() + "               " + " 卡牌效果: " + tmpCards[k].getEffect());
                break;
            default:
                break;
        }
    }

    private Card[] arrPlusOne(Card[] tmpCards) {
        Card[] newArr = new Card[tmpCards.length + 1];
        for (int i = 0; i < tmpCards.length; i++) {
            newArr[i] = tmpCards[i];
        }
        return newArr;
    }

    public void addNewCardFromWareHouse(int setNumber) {
        // 新增一張欲增加的卡牌
        // player1.getTotalCards();
        for (int i = 0; i < 40; i++) {
            if (i == setNumber - 1) {
                // 扣錢，錢不夠返回功能選單
                if (player1.getMoney() < 5) {
                    System.out.println("本店不歡迎窮鬼，滾去決鬥贏得獎金吧！");
                    //return null;

                } else {
                    player1.setMoney(player1.getMoney() - 5);
                    for (int j = 0; j < player1.getPlayerWareHouse().length; j++) {
                        if (player1.getPlayerWareHouse()[j] == null) {
                            player1.getPlayerWareHouse()[j] = AllWareHouse[setNumber - 1].copy(AllWareHouse[setNumber - 1]);
                            break;

                        }
                    }
                    System.out.println("已購買編號" + AllWareHouse[setNumber - 1].getNumber() + "卡片");
                    System.out.println("剩下" + player1.getMoney() + "元");

                }
            }
        }
        //return null;


    }

    public Card[] getcount() {
        return this.AllWareHouse;
    }


}
