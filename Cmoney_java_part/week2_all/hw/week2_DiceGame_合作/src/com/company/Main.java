package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DiceGame newgame = new DiceGame();
        while(true){
            System.out.println("請選擇骰子數量：(3~6)");
            int amount = sc.nextInt();
            while (amount<3||amount>6){
                System.out.println("請選擇骰子數量：(3~6)");
                amount = sc.nextInt();
            }
            newgame.setPlayerDice(amount);
            System.out.println("請選擇遊戲規則：(1)點數大者勝 (2)點數小者勝 (3)相同點數多者勝");
            int rule = sc.nextInt();
            while (rule<1||rule>3){
                System.out.println("請選擇骰子數量：(3~6)");
                rule = sc.nextInt();
            }
            newgame.setRule(rule);
            System.out.println("請輸入遊戲回合數：");
            int round = sc.nextInt();
            while (round<=0||round%2==0){
                System.out.println("請輸入遊戲回合數：(不可輸入0及偶數)");
                round = sc.nextInt();
            }
            newgame.setRound(round);
            newgame.startGame();
        }
    }
}
