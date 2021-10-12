package com.company;

import java.util.Scanner;


public class Shop{

    private Player player1;

    public Shop(Player player) {
        this.player1 = player;
    }

    public void shop() {
        Scanner sc = new Scanner(System.in);
        System.out.println("歡迎來到商店");
        System.out.println("你目前擁有" + player1.getMoney() + "元");
//         呼叫可選卡片功能
        System.out.println("請輸入指令(1)buy (2)顯示所有可以購買的卡片");
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
                addNewCardFromWareHouse(player1.getFate(), input2);
                break;
            case 2:
                GetProfessionCard.printAllCard();
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

    public void addNewCardFromWareHouse(int fate, int setNumber) {
        // 新增一張欲增加的卡牌
                // 扣錢，錢不夠返回功能選單
                if (player1.getMoney() < 5) {
                    System.out.println("本店不歡迎窮鬼，滾去決鬥贏得獎金吧！");
                } else {
                    player1.setMoney(player1.getMoney() - 5);
                    player1.getWareHouse().addCardToWareHouse(GetProfessionCard.getProfessionOneCard(setNumber));
                    System.out.println("已購買編號" + setNumber + "的卡片!");
                    System.out.println("剩下" + player1.getMoney() + "元");
                }
    }

}
