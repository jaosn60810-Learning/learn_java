package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        WareHouse wareHouse = new WareHouse();
        /**
         * 選擇職業
         */
        int fate = input("歡迎來到血與魔法的卡片鬥技場\n★☆★☆★☆★☆★☆★☆★☆\n新來的傢伙，選擇你的職業: 1.戰士 2.牧師 3.法師 4.武僧", 1, 4, false);
        /**new一個player,傳入他選擇的職業,生成第一副牌組,生成牌組陣列裡面有一個牌組,生成倉庫裡面有已有的卡片*/
        Player player = new Player(fate);

        int start = input("想做什麼: 1.開始戰鬥 2.進入商店 3.編輯牌組 4.結束遊戲", 1, 4, false);
        do {
            switch (start) {
                case 1:
                    /**
                     * 進去戰鬥模式
                     */
                    int rounds = input("選擇回合數: 1.一回合戰鬥 2.三戰兩勝制", 1, 2, false);
                    int AI = input("選擇難度: 1.聰明的AI 2.笨蛋的AI", 1, 2, false);
                    int mode = input("選擇戰鬥模式: 1.一般戰鬥 2.快速戰鬥", 1, 2, false);
                    Game newGame = new Game(rounds, AI, mode, player);
                    newGame.gameStart();

                    start = input("想做什麼: 1.開始戰鬥 2.進入商店 3.編輯牌組 4.結束遊戲", 1, 4, false);
                    break;
                case 2:
                    System.out.println("請輸入指定指令：1.購買卡片 2.顯示所有可買卡牌");

                    Shop newshop = new Shop(player);

                    newshop.shop();
                    start = input("請選擇: 1,開始戰鬥 2.進入商店 3.編輯牌組 4.結束遊戲", 1, 4, false);
                    break;

                case 3:
                    int order = input("請選擇: 1,顯示所有卡片 2.顯示所有牌組 3.編輯牌組 4.回上一層", 1, 4, false);
                    do {
                        switch (order) {
                            case 1:
                                for (int i = 0; i < WareHouse.AllWareHouse.length; i++) {
                                    WareHouse.AllWareHouse[i].printOutInfo();
                                }
                                order = input("請選擇: 1,顯示所有卡片 2.顯示所有牌組 3.編輯牌組 4.回上一層", 1, 4, false);
                                break;
                            case 2:
                                System.out.println("共有" + (player.getTotalCardSets().length) + "副牌組");
                                for (int j = 0; j < player.getTotalCardSets().length; j++) {
                                    System.out.println("第" + (j + 1) + "副牌組共有" + player.getTotalCardSets()[j].getCards().length + "張卡片");
                                }
                                for (int j = 0; j < player.getTotalCardSets().length; j++) {
                                    System.out.println("---第" + (j + 1) + "副牌組---");
                                    for (int i = 0; i < player.getTotalCardSets()[j].getCards().length; i++) {
                                        System.out.print("【第" + (j + 1) + "副牌組的第" + (i + 1) + "張卡片】 ");
                                        player.getTotalCardSets()[0].getCards()[i].printOutInfo();
                                    }
                                }
                                order = input("請選擇: 1,顯示所有卡片 2.顯示所有牌組 3.編輯牌組 4.回上一層", 1, 4, false);
                                break;
                            case 3:
                                System.out.println("請輸入牌組編號：");
                                int cardDeck = sc.nextInt()-1;
                                System.out.println("請輸入要對本牌組做的指令： 1.新增卡片到牌組-addCard\t 2.從牌組移除卡片-remove");
                                int thisOrder  = sc.nextInt();
                                switch (thisOrder) {
                                    case 1://1.新增卡片到牌組-addCard
                                        System.out.println("此牌組是某職業,可以新增的卡片有:");

                                        System.out.println("請輸入卡片編號：");
                                        int cardNumber = sc.nextInt();
                                        break;
                                    case 2://2.從牌組移除卡片-remove
                                        player.getTotalCardSets()[cardDeck].remove(cardDeck,player);//進行移除前的前置說明
                                        Thread.sleep(500);//1000毫秒=1秒
                                        System.out.print("請輸入要移除第幾張卡片：");
                                        int cardNumberRemove = sc.nextInt();
                                        System.out.println("cardNumberRemove："+cardNumberRemove);
                                        player.getTotalCardSets()[cardDeck].removeCard(cardNumberRemove-1,cardDeck,player);
                                        break;
                                    default:
                                        break;
                                }
                                order = input("請選擇: 1,顯示所有卡片 2.顯示所有牌組 3.編輯牌組 4.回上一層", 1, 4, false);
                                break;
                            case 4://回上一層
                                break;
                            default:
                                break;
                        }
                    } while (order != 4);

                    start = input("請選擇: 1,開始戰鬥 2.進入商店 3.編輯牌組 4.結束遊戲", 1, 4, false);
                    break;
                /**
                 * 回到選單重複選擇
                 */
                case 4:
                    System.exit(0);
                default:
                    break;

            }


        } while (start > 0 && start < 5);

    }


    public static int input(String hint, int min, int max, boolean isRandom) {
        Scanner sc = new Scanner(System.in);
        int r = 0;
        if (isRandom) {
            r = random(min, max);
            System.out.println("(自動產生)" + hint + ":" + r);
            return r;
        }
        System.out.println(hint);
        boolean flag;
        do {
            try {
                flag = false;
                System.out.println("Enter a side length (in units):");
                r = sc.nextInt();

            }
            catch(InputMismatchException e){
                System.out.println("Must input number");
                //this line frees the buffer
                sc.next();
                flag = true;
            }
        } while (flag);

        return r;
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
