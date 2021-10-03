package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Desk {

    /**
     * 牌桌上面有這些卡牌陣列
     */
    private Player player1;
    private Player computer;
    boolean p1CanPlay = true, p2CanPlay = true;

    public Desk(Player p1, Player cpu) {

        this.player1 = p1;
        this.computer = cpu;
    }

    /**
     * 單一回合,傳入一開始的出牌順序,AI模式,戰鬥模式(快速,一般)
     */
    public void Fight(int priority, int AI, int mode, int rounds) throws InterruptedException {
        /**
         * 打亂牌組順序
         */
        randomCardSet(player1.getCardSet());
        randomCardSet(computer.getCardSet());

        if (rounds == 2) {
            rounds = 3;
        }
        int p1SumScore = 0, p2SumScore = 0;
        int p1Wins = 0, p2Wins = 0;
        player1.setHandCard(new ArrayList<>());
        computer.setHandCard(new ArrayList<>());

        /**
         * 戰鬥開始,依照回合數跑for迴圈
         */
        for (int i = 0; i < rounds; i++) {
            System.out.println("\n__________戰鬥開始____________");
            //單局分數歸0
            player1.setPlayerScore(0);
            computer.setPlayerScore(0);
            //清空狀態列
            player1.cleanEffect();
            computer.cleanEffect();
            player1.setBuffIndex(0);
            computer.setBuffIndex(0);

            //兩位玩家抽五張牌
            getFiveCards();

            System.out.println("偷偷告訴你電腦這局的手牌...");
            showHandCard(computer);
            System.out.println("===================================\n");

            //判斷出牌順序
            if (priority == 0) {
                System.out.println("========玩家先出牌==========");
                /**
                 * 玩家先出牌function
                 */
                playerFirst(AI, mode);
            } else {
                System.out.println("========電腦先出牌==========");
                /**
                 * 電腦先出牌function
                 */
                computerFirst(AI, mode);
            }

            System.out.println("*****************牌桌清空*********************");
            cleanDesk();

            /**
             * 更新下一局的順序
             */
            if (player1.getPlayerScore() > computer.getPlayerScore()) {
                System.out.println("~~~~~~你贏了這回合");
                priority = 1;
                p1Wins++;
            } else if (player1.getPlayerScore() < computer.getPlayerScore()) {
                System.out.println("~~~~~~~你輸了這回合");
                priority = 0;
                p2Wins++;
            } else {
                System.out.println("~~~~~~~這回合平手");
                priority = random(0, 1);
            }
            //計算總分
            p1SumScore += player1.getPlayerScore();
            p2SumScore += computer.getPlayerScore();
            System.out.println("\n你的積分加總:" + p1SumScore + "\t電腦的積分加總:" + p2SumScore + "\n");
        }
        System.out.println("你贏了" + p1Wins + "次");
        if (p1Wins > p2Wins) {
            if (Math.abs(p1SumScore - p2SumScore) > 15) {
                System.out.println("獲得10金幣!!!");
                player1.setMoney(player1.getMoney() + 10);
            } else if (Math.abs(p1SumScore - p2SumScore) < 10) {
                System.out.println("獲得5金幣!!!");
                player1.setMoney(player1.getMoney() + 5);
            } else {
                System.out.println("獲得7金幣!!!");
                player1.setMoney(player1.getMoney() + 7);
            }
        } else {
            System.out.println("You got nothing!!!!!!!!!!!!!!!!!!!!嫩!!!!!!!!!!!!");
        }
    }

    private void modeFast(Player player, int mode) {
        if (mode == 2) {
            if (player.getCardonDesk().size() == 3) {
                if (player == player1) {
                    int arylong = player.getCardonDesk().size();
                    showOnDesk();
                    int input = input("請選擇一張丟棄:", 1, arylong, false);
                    //先將牌桌上的牌加到棄牌區
                    player.setCardOut(addToCardSet(player.getCardOut(), player.getCardonDesk().get(input - 1)));
                    //再將牌桌上的牌移除掉
                    player.setCardonDesk(removeCardFromCardSet(player.getCardonDesk(), input - 1));
                } else {
                    //如果是電腦,隨機丟棄一張
                    int arylong = player.getCardonDesk().size() - 1;
                    showOnDesk();
                    int input = input("請選擇一張丟棄:", 0, arylong, true);
                    //先將牌桌上的牌加到棄牌區
                    player.setCardOut(addToCardSet(player.getCardOut(), player.getCardonDesk().get(input)));
                    //再將牌桌上的牌移除掉
                    player.setCardonDesk(removeCardFromCardSet(player.getCardonDesk(), input));
                }

            }
        }
    }

    private void cleanDesk() {
        for (int j = player1.getCardonDesk().size() - 1; j >= 0; j--) {
            //先將牌桌上的牌加到棄牌區
            player1.setCardOut(addToCardSet(player1.getCardOut(), player1.getCardonDesk().get(j)));
            //再將牌桌上的牌移除掉
            player1.setCardonDesk(removeCardFromCardSet(player1.getCardonDesk(), j));
        }
        for (int j = computer.getCardonDesk().size()  - 1; j >= 0; j--) {
            computer.setCardOut(addToCardSet(computer.getCardOut(), computer.getCardonDesk().get(j)));
            computer.setCardonDesk(removeCardFromCardSet(computer.getCardonDesk(), j));
        }
    }

    /**
     * 秀出手牌
     */
    private void showHandCard(Player player) {
        for (int j = 0; j < player.getHandCard().size() ; j++) {
            System.out.print((j + 1) + "\t");
            player.getHandCard().get(j).printOutInfo();
        }
    }

    private void getFiveCards() {
        System.out.println("抽出五張手牌~");
        //抽五張牌
        for (int j = 4; j >= 0; j--) {
            player1.setHandCard(addToCardSet(player1.getHandCard(), Card.copy(player1.getCardSet().get(j))));
            player1.setCardSet(removeCardFromCardSet(player1.getCardSet(), j));
        }
        //電腦抽五張牌
        System.out.println("===================================");
        for (int j = 4; j >= 0; j--) {
            computer.setHandCard(addToCardSet(computer.getHandCard(), Card.copy(computer.getCardSet().get(j))));
            computer.setCardSet(removeCardFromCardSet(computer.getCardSet(), j));
        }
    }

    //將戰鬥區數值小於等於0的卡丟到棄牌區
    private void checkOnDesk(Player player) {
        int checkPoint = player.getCardonDesk().size()  - 1;
        //用遞減迴圈,因為牌組陣列會漸漸縮小
        for (int i = checkPoint; i >= 0; i--) {
            Card tmp = player.getCardonDesk().get(i);
            if (tmp.getPoint() <= 0) {
                System.out.println("編號" + player.getCardonDesk().get(i).number + ",數值歸0,丟掉!!!");
                effectDeBuff(player, tmp);
                cardEffectCountZero(player);
                player.setCardOut(addToCardSet(player.getCardOut(), player.getCardonDesk().get(i)));
                player.setCardonDesk(removeCardFromCardSet(player.getCardonDesk(), i));
            }
        }
    }

    private void computerFirst(int AI, int mode) throws InterruptedException {
        /**預設一開始雙方的出牌許可都是true*/
        p1CanPlay = true;
        p2CanPlay = true;
        do {

            /**
             * 每場分數歸0
             */
            player1.setPlayerScore(0);
            computer.setPlayerScore(0);
            if (p2CanPlay == true) {
                //如果是快速戰鬥,出牌前丟棄
                modeFast(computer, mode);
                //電腦依照AI模式出牌
                computerPlay(AI);
                showOnDesk();
            }

            if (p1CanPlay == true) {
                //如果是快速戰鬥,出牌前丟棄
                modeFast(player1, mode);
                //秀出手牌
                System.out.println("你的手牌:");
                showHandCard(player1);

                //輸入出牌位置
                int index = input("請輸入卡片位置出牌,輸入-1本回合不再出牌", -1, player1.getHandCard().size(), false);
                /**
                 * 傳入玩家要出的卡牌編號或-1至出牌function
                 */
                if (index == -1 || player1.getHandCard().size() == 0) {
                    p1CanPlay = false;
                }
                if (p1CanPlay == true) {
                    //將選擇的手牌加到戰鬥區
                    player1.setCardonDesk(addToCardSet(player1.getCardonDesk(), player1.getHandCard().get(index-1)));
                    //手牌減少該張卡片
                    player1.setHandCard(removeCardFromCardSet(player1.getHandCard(), index - 1));
                    //檢查狀態列
                    checkBuff(player1);
                    //檢查被狀態列影響後,自己的牌哪是否有數值歸0的,若有,則丟到棄牌區
                    checkOnDesk(player1);

                    System.out.println("你的出牌:");
                    if (player1.getCardonDesk().size() > 0) {
                        player1.getCardonDesk().get(player1.getCardonDesk().size() - 1).printOutInfo();
                    }


                    //發動該張卡片當下效果
                    checkType(player1);
                    //檢查發動本回合出牌的效果後,對手牌區是否有歸0的卡,若有,則丟到棄牌區
                    checkOnDesk(computer);


                    showOnDesk();

                }
            }

            /**手牌歸0或選擇不出牌以後,出牌權力為false*/
            if (player1.getHandCard().size() <= 0) {
                p1CanPlay = false;
            }
            if (computer.getHandCard().size() <= 0) {
                p2CanPlay = false;
            }
        } while (p1CanPlay == true || p2CanPlay == true);

        System.out.println("回合結束,此時你的戰鬥區有:");
        showOnDesk();

    }

    private void playerFirst(int AI, int mode) throws InterruptedException {
        /**預設一開始雙方的出牌許可都是true*/
        p1CanPlay = true;
        p2CanPlay = true;
        do {
            /**
             * 每場分數歸0
             */
            player1.setPlayerScore(0);
            computer.setPlayerScore(0);

            if (p1CanPlay == true) {
                modeFast(player1, mode);
                System.out.println("你的手牌:");
                showHandCard(player1);
                int index = input("請輸入卡片位置出牌,輸入-1本回合不再出牌", -1, player1.getHandCard().size(), false);
                /**
                 * 傳入玩家要出的卡牌編號或-1至出牌function
                 */
                if (index == -1 || player1.getHandCard().size() == 0) {
                    p1CanPlay = false;
                }
                if (p1CanPlay == true) {
                    //↓這是要出的牌
                    //p1HandCard[index-1].number;
                    //將選擇的手牌加到戰鬥區
                    player1.setCardonDesk(addToCardSet(player1.getCardonDesk(), player1.getHandCard().get(index-1)));
                    //手牌減少該張卡片
                    player1.setHandCard(removeCardFromCardSet(player1.getHandCard(), index - 1));


                    checkBuff(player1);
                    //檢查被狀態列影響後,自己的牌哪是否有數值歸0的,若有,則丟到棄牌區
                    checkOnDesk(player1);

                    System.out.println("你的出牌:");
                    if (player1.getCardonDesk().size() > 0) {
                        player1.getCardonDesk().get(player1.getCardonDesk().size() - 1).printOutInfo();
                    }

                    checkType(player1);
                    //檢查發動本回合出牌的效果後,對手牌區是否有歸0的卡,若有,則丟到棄牌區
                    checkOnDesk(computer);


                    showOnDesk();


                }
            }
            if (p2CanPlay == true) {
                modeFast(computer, mode);
                computerPlay(AI);
                showOnDesk();
            }

            /**手牌歸0或選擇不出牌以後,出牌權力為false*/
            if (player1.getHandCard().size() <= 0) {
                p1CanPlay = false;
            }
            if (computer.getHandCard().size() <= 0) {
                p2CanPlay = false;
            }
        } while (p1CanPlay == true || p2CanPlay == true);
        System.out.println("回合結束:");
        showOnDesk();
    }

    private void showOnDesk() {
        System.out.println("\n-----------------------------------\n你的戰鬥區有:");
        player1.setPlayerScore(0);
        for (Card k : player1.getCardonDesk()
        ) {
            k.printOutInfo();
            player1.setPlayerScore(player1.getPlayerScore() + k.point);
        }
        System.out.println("你此時的積分是:" + player1.getPlayerScore());
        computer.setPlayerScore(0);
        System.out.println("\n電腦的戰鬥區有:");
        for (Card k : computer.getCardonDesk()
        ) {
            k.printOutInfo();
            computer.setPlayerScore(computer.getPlayerScore() + k.point);
        }
        System.out.println("電腦此時的積分是:" + computer.getPlayerScore() + "\n-----------------------------------\n");
    }

    private void cardEffectCountZero(Player player) {
        int index = player.getCardonDesk().size() - 1;
        Card thatCard = player.getCardonDesk().get(index);
        thatCard.setEffectCount(thatCard.getEffectCount() - 1);
    }

    private void checkType(Player player) {

        if (player.getCardonDesk().size() > 0) {
            int index = player.getCardonDesk().size() - 1;
            Card temp = player.getCardonDesk().get(index);
            switch (temp.getType()) {
                case 1:
                    effectRightNow(player, temp);
                    temp.setBuffIndex(player.getBuffIndex());
                    player.setBuffIndex(player.getBuffIndex() + 1);
                    break;
                case 2:
                    effectRightNow(player, temp);
                    break;
                case 3:
                    effectRightNow(player, temp);
                    break;
                case 4:
                default:
                    break;

            }
        } else {
            return;
        }

    }


    private void checkBuff(Player player) {

        for (int i = 0; i < player.getEffects().size(); i++) {
            if (player == player1) {
                player.getEffects().get(i).doBuff(player1, computer);
            } else {
                player.getEffects().get(i).doBuff(computer, player1);
            }

        }
    }

    private void effectDeBuff(Player player, Card card) {
        if (player == player1) {
            if (player.getEffects().size() > 0) {
                card.actionForRemove(player1, computer, card.getBuffIndex());
            }

        } else {
            if (player.getEffects().size() > 0) {
                card.actionForRemove(computer, player1, card.getBuffIndex());
            }

        }
    }

    private void effectRightNow(Player player, Card card) {
        if (player == player1) {
            if (card.canEffect(player1, computer)) {
                card.actionForAll(player1, computer);
            } else {
                return;
            }
        } else {
            if (card.canEffect(computer, player1)) {
                card.actionForAll(computer, player1);
            } else {
                return;
            }
        }

    }

    /**
     * 電腦出牌邏輯
     */
    public void computerPlay(int AI) throws InterruptedException {
        //聰明模式
        if (AI == 1) {
            int sump1 = 0, sump2 = 0;
            for (int i = 0; i < player1.getCardonDesk().size(); i++) {
                sump1 += player1.getCardonDesk().get(i).getPoint();
            }
            for (int i = 0; i < computer.getCardonDesk().size(); i++) {
                sump2 += computer.getCardonDesk().get(i).getPoint();
            }
            if (sump1 - sump2 > 11) {
                System.out.println("電腦被你的霸氣震懾,瑟瑟發抖...\n");
                p2CanPlay = false;
                return;
            }
            int count = 0;
            //tmp陣列存的是符合條件的卡牌位置int,懶得用doubleArray,直接給他20格的陣列
            int[] tmp = new int[20];
            for (int i = 0; i < computer.getHandCard().size(); i++) {
                if (computer.getHandCard().get(i).canEffect(computer, player1)) {
                    tmp[count++] = i;
                }
            }
            //如果有符合發動條件的牌做以下動作
            if (count > 0) {
                //tmp陣列存的是符合條件的卡牌位置int,因此可以隨機tmp陣列的位置取得該卡牌的位置
                int index = random(0, count - 1);
                int cardToPlay = tmp[index];
                computer.setCardonDesk(addToCardSet(computer.getCardonDesk(), computer.getHandCard().get(cardToPlay)));
                computer.setHandCard(removeCardFromCardSet(computer.getHandCard(), cardToPlay));
                checkBuff(computer);
                //看電腦有沒有被buff影響到歸0的牌
                checkOnDesk(computer);

                System.out.println("電腦出牌:");
                computer.setPlayerScore(0);
                if (computer.getCardonDesk().size() > 0) {
                    computer.getCardonDesk().get(computer.getCardonDesk().size() - 1).printOutInfo();
                }


                checkType(computer);
                //看玩家有沒有被效果影響到歸0的牌
                checkOnDesk(player1);


            }
            //如果沒有符合發動條件的牌,則找數值最大的牌出
            else {
                Card result = computer.getHandCard().get(0);
                int max = 0;
                //找出數值最大的牌的位置
                for (int i = 0; i < computer.getHandCard().size(); i++) {
                    if (result.getPoint() < computer.getHandCard().get(i).getPoint()) {
                        result = computer.getHandCard().get(i);
                        max = i;
                    }
                }
                computer.setCardonDesk(addToCardSet(computer.getCardonDesk(), computer.getHandCard().get(max)));
                computer.setHandCard(removeCardFromCardSet(computer.getHandCard(), max));
                checkBuff(computer);
                //看電腦有沒有被buff影響到歸0的牌
                checkOnDesk(computer);

                System.out.println("電腦出牌:");
                computer.setPlayerScore(0);
                if (computer.getCardonDesk().size() > 0) {
                    computer.getCardonDesk().get(computer.getCardonDesk().size() - 1).printOutInfo();
                }
                //看電腦出的牌
                checkType(computer);
                //看玩家有沒有被效果影響到歸0的牌
                checkOnDesk(player1);
                //卡片效果發動次數歸0


            }

        }
        //笨蛋模式
        else if (AI == 2) {
            computer.setCardonDesk(addToCardSet(computer.getCardonDesk(), computer.getHandCard().get(0)));
            computer.setHandCard(removeCardFromCardSet(computer.getHandCard(), 0));
            checkBuff(computer);
            //看電腦有沒有被buff影響到歸0的牌
            checkOnDesk(computer);
            //顯示出的那張牌
            System.out.println("電腦出牌:");
            computer.setPlayerScore(0);
            if (computer.getCardonDesk().size() > 0) {
                computer.getCardonDesk().get(computer.getCardonDesk().size() - 1).printOutInfo();
            }

            checkType(computer);
            //看玩家有沒有被效果影響到歸0的牌
            checkOnDesk(player1);


        }
    }


    /**
     * 打亂牌組順序
     */
    private void randomCardSet(ArrayList<Card> cardSet) {
        Card tmp;
        for (int i = 0; i < cardSet.size(); i++) {
            int randomIndex = random(0, cardSet.size() - 1);
            tmp = Card.copy(cardSet.get(i));
            cardSet.set(i,Card.copy(cardSet.get(randomIndex)))  ;
            cardSet.set(randomIndex,tmp);
        }
    }


    /**
     * 將選擇的牌從原本的牌組移除
     */
    public ArrayList<Card> removeCardFromCardSet(ArrayList<Card> updateCardSet, int position) {
        updateCardSet.remove(position);
        return updateCardSet;
    }


    /**
     * 將選擇的牌從加進牌組
     */
    public ArrayList<Card> addToCardSet(ArrayList<Card> originalCardSet, Card newCard) {
       originalCardSet.add(newCard);
        return originalCardSet;
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
