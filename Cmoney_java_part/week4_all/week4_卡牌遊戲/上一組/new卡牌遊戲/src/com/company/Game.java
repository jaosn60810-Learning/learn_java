package com.company;

import java.util.Scanner;

public class Game {

    private Desk desk;
    private Player player1;
    private Player player2;
    private int rounds; //玩家選擇的回合數
    private int AI; //選擇的難度(電腦出牌邏輯)
    private int mode; //選擇的戰鬥模式(快速or一般)

    public Game(int rounds, int AI, int mode, Player player) {
        /**將外面生成的選好職業的玩家傳入此遊戲*/
        this.player1 = player;
        this.rounds = rounds;
        this.AI = AI;
        this.mode = mode;
    }

    public void gameStart() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        /**創建一個電腦,隨機給他一個職業*/
        System.out.println("電腦生成中......");
        int a = random(1, 4);
        Player computer = new Player(a);
        this.player2 = computer;
        System.out.println("您有:" + player1.getCardSetCount() + "副牌組");
        System.out.println("電腦有:" + player2.getCardSetCount() + "副牌組");

        int chooseCardSet = input("請選擇牌組:", 1, player1.getCardSetCount(), false);

        player1.setCardSet(player1.getOneOfCardset(chooseCardSet));
        player2.setCardSet(player2.getOneOfCardset(1));

        //將玩家1的牌組設定屬於玩家
        for (int i = 0; i < player1.getOneOfCardset(chooseCardSet).length; i++) {
            player1.getOneOfCardset(chooseCardSet)[i].setOwner(0);
        }
        //將電腦的牌組設定屬於電腦
        for (int i = 0; i < player2.getOneOfCardset(1).length; i++) {
            player2.getOneOfCardset(1)[i].setOwner(1);
        }
        Desk newDesk = new Desk(player1,player2); //傳入玩家跟電腦的牌組進牌桌
        newDesk.Fight(random(0, 1), this.AI, this.mode, this.rounds);
    }


    public static int input(String hint, int min, int max, boolean isRandom) {
        Scanner sc = new Scanner(System.in);
        if (isRandom) {
            int r = random(min, max);
            System.out.println("(自動產生)" + hint + ":" + r);
            return r;
        }
        System.out.println(hint);
        int r = sc.nextInt();
        while (r < min || r > max) {
            System.out.println("input請重新輸入");
            r = sc.nextInt();
        }
        return r;
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
