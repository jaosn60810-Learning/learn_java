package com.company;

import java.util.*;

public class Desk {

    /**
     * 牌桌上面有這些卡牌陣列
     */

    private Player player1;
    private Player computer;
    boolean p1CanPlay, p2CanPlay;
    int chooseCardSet;

    public Desk(Player p1, Player cpu) {
        this.player1 = p1;
        this.computer = cpu;
    }

    /**
     * 單一回合,傳入一開始的出牌順序,AI模式,戰鬥模式(快速,一般)
     */
    public void Fight(int priority, int AI, int mode, int rounds) throws InterruptedException {
        chooseCardSet = input("請選擇牌組:", 1, player1.getCardSetCount(), false) - 1;
        /**
         * 打亂牌組順序
         */
        randomCardSet(player1.getTotalCardSets()[chooseCardSet]);
        randomCardSet(computer.getTotalCardSets()[chooseCardSet]);

        int p1SumScore = 0, p2SumScore = 0;
        int p1Wins = 0, p2Wins = 0;
        player1.setHandCard(new Card[0]);
        computer.setHandCard(new Card[0]);

        /**
         * 戰鬥開始,依照回合數跑for迴圈
         */
        for (int i = 0; i < rounds; i++) {
            p1CanPlay = true;
            p2CanPlay = true;

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
            System.out.print("你");
            DrawCards(5, player1);
            System.out.print("電腦");
            DrawCards(5, computer);

            System.out.println("偷偷告訴你電腦這局的手牌...");
            showHandCard(computer);
            System.out.println("===================================\n");
            Thread.sleep(1000);

            System.out.println("比賽開始!\n");
            startPlay(priority, AI, mode);

            Thread.sleep(1000);
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
            if (player.getCardonDesk().length == 3) {
                if (player == player1) {
                    int arylong = player.getCardonDesk().length;
                    showOnDesk();
                    int input = input("請選擇一張丟棄:", 1, arylong, false);
                    //先將牌桌上的牌加到棄牌區
                    player.addCardToCardOut(player.getCardonDesk()[input - 1]);
                    //再將牌桌上的牌移除掉
                    player.setCardonDesk(removeCardFromCardSet(player.getCardonDesk(), input - 1));
                } else {
                    //如果是電腦,隨機丟棄一張
                    int arylong = player.getCardonDesk().length - 1;
                    showOnDesk();
                    int input = input("請選擇一張丟棄:", 0, arylong, true);
                    //先將牌桌上的牌加到棄牌區
                    player.addCardToCardOut(player.getCardonDesk()[input]);
                    //再將牌桌上的牌移除掉
                    player.setCardonDesk(removeCardFromCardSet(player.getCardonDesk(), input));
                }

            }
        }
    }

    private void cleanDesk() {
        for (int j = player1.getCardonDesk().length - 1; j >= 0; j--) {
            //先將牌桌上的牌加到棄牌區
            player1.addCardToCardOut(player1.getCardonDesk()[j]);
            //再將牌桌上的牌移除掉
            player1.setCardonDesk(removeCardFromCardSet(player1.getCardonDesk(), j));
        }
        for (int j = computer.getCardonDesk().length - 1; j >= 0; j--) {
            computer.addCardToCardOut(computer.getCardonDesk()[j]);
            computer.setCardonDesk(removeCardFromCardSet(computer.getCardonDesk(), j));
        }
    }

    /**
     * 秀出手牌
     */
    private void showHandCard(Player player) {
        for (int j = 0; j < player.getHandCard().length; j++) {
            System.out.print((j + 1) + ".\t");
            player.getHandCard()[j].printOutInfo();
        }
    }

    private void DrawCards(int drawNum, Player player) {
        System.out.println("抽出" + drawNum + "張手牌~");
        Card[] temp = new Card[drawNum];
        //抽五張牌
        for (int j = 0; j < drawNum; ++j) {
            temp[j] = player.getTotalCardSets()[chooseCardSet].getCards()[j];
            player.getTotalCardSets()[chooseCardSet].removeCard(j);
        }
        player.setHandCard(temp);
    }

    //將戰鬥區數值小於等於0的卡丟到棄牌區
    private void checkOnDesk(Player player) {
        int checkPoint = player.getCardonDesk().length - 1;
        //用遞減迴圈,因為牌組陣列會漸漸縮小
        for (int i = checkPoint; i >= 0; i--) {
            Card tmp = player.getCardonDesk()[i];
            if (tmp.getPoint() <= 0) {
                System.out.println("編號" + player.getCardonDesk()[i].number + ",數值歸0,丟掉!!!");
                effectDeBuff(player, tmp);
                cardEffectCountZero(player);
                player.addCardToCardOut(player.getCardonDesk()[i]);
                player.setCardonDesk(removeCardFromCardSet(player.getCardonDesk(), i));
            }
        }
    }

    private void startPlay(int priority, int AI, int mode) throws InterruptedException {
        /**預設一開始雙方的出牌許可都是true*/
        p1CanPlay = true;
        p2CanPlay = true;
        /**
         * 每場分數歸0
         */
        player1.setPlayerScore(0);
        computer.setPlayerScore(0);

        if (priority == 0) {
            playerPlay();
        }

        do {
            if (p2CanPlay == true) {
                //如果是快速戰鬥,出牌前丟棄
                modeFast(computer, mode);
                //電腦依照AI模式出牌
                computerPlay(AI);
                Thread.sleep(1000);
                showOnDesk();
            }

            if (p1CanPlay == true) {
                //如果是快速戰鬥,出牌前丟棄
                modeFast(player1, mode);
                playerPlay();
            }

            /**手牌歸0或選擇不出牌以後,出牌權力為false*/
            if (player1.getHandCard().length <= 0) {
                p1CanPlay = false;
            }
            if (computer.getHandCard().length <= 0) {
                p2CanPlay = false;
            }
        } while (p1CanPlay == true || p2CanPlay == true);

        System.out.println("回合結束,此時你的戰鬥區有:");
        showOnDesk();
    }

    private void playerPlay() {
        //秀出手牌
        System.out.println("你的手牌:");
        showHandCard(player1);

        //輸入出牌位置
        int index = input("請輸入卡片位置出牌,輸入-1本回合不再出牌", -1, player1.getHandCard().length, false);
        /**
         * 傳入玩家要出的卡牌編號或-1至出牌function
         */
        if (index == -1 || player1.getHandCard().length == 0) {
            p1CanPlay = false;
        }
        if (p1CanPlay == true) {
            //將選擇的手牌加到戰鬥區
            player1.setCardonDesk(addToCardSet(player1.getCardonDesk(), player1.getHandCard()[index - 1]));
            //手牌減少該張卡片
            player1.setHandCard(removeCardFromCardSet(player1.getHandCard(), index - 1));
            //檢查狀態列
            checkBuff(player1);
            //檢查被狀態列影響後,自己的牌哪是否有數值歸0的,若有,則丟到棄牌區
            checkOnDesk(player1);

            System.out.println("你的出牌:");
            if (player1.getCardonDesk().length > 0) {
                player1.getCardonDesk()[player1.getCardonDesk().length - 1].printOutInfo();
            }

            //發動該張卡片當下效果
            checkType(player1);
            //檢查發動本回合出牌的效果後,對手牌區是否有歸0的卡,若有,則丟到棄牌區
            checkOnDesk(computer);

            showOnDesk();
        }
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
        int index = player.getCardonDesk().length - 1;
        Card thatCard = player.getCardonDesk()[index];
        thatCard.setEffectCount(thatCard.getEffectCount() - 1);
    }

    private void checkType(Player player) {

        if (player.getCardonDesk().length > 0) {
            int index = player.getCardonDesk().length - 1;
            Card temp = player.getCardonDesk()[index];
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
                card.actionForOneTime(player1, computer);
            } else {
                return;
            }
        } else {
            if (card.canEffect(computer, player1)) {
                card.actionForOneTime(computer, player1);
            } else {
                return;
            }
        }

    }

    /**
     * 電腦出牌邏輯
     */
    private void computerPlay(int AI) {
        //聰明模式
        if (AI == 1) {
            int sump1 = 0, sump2 = 0;
            for (int i = 0; i < player1.getCardonDesk().length; i++) {      //玩家戰鬥區分數
                sump1 += player1.getCardonDesk()[i].getPoint();
            }
            for (int i = 0; i < computer.getCardonDesk().length; i++) {     //電腦戰鬥區分數
                sump2 += computer.getCardonDesk()[i].getPoint();
            }
            if (sump1 - sump2 > 11) {       //分差超過11停止出牌
                System.out.println("電腦被你的霸氣震懾,瑟瑟發抖...\n");
                p2CanPlay = false;
                return;
            }
            int count = 0;
            //tmp陣列存的是符合條件的卡牌位置int,懶得用doubleArray,直接給他20格的陣列
            int[] tmp = new int[20];
            for (int i = 0; i < computer.getHandCard().length; i++) {       //可作用的牌放到占存區
                if (computer.getHandCard()[i].canEffect(computer, player1)) {
                    tmp[count++] = i;
                }
            }
            //如果有符合發動條件的牌做以下動作
            if (count > 0) {
                //tmp陣列存的是符合條件的卡牌位置int,因此可以隨機tmp陣列的位置取得該卡牌的位置
                int index = random(0, count - 1);
                int cardToPlay = tmp[index];
                computer.setCardonDesk(addToCardSet(computer.getCardonDesk(), computer.getHandCard()[cardToPlay]));
                computer.setHandCard(removeCardFromCardSet(computer.getHandCard(), cardToPlay));
                checkBuff(computer);
                //看電腦有沒有被buff影響到歸0的牌
                checkOnDesk(computer);

                System.out.println("電腦出牌:");
                computer.setPlayerScore(0);
                if (computer.getCardonDesk().length > 0) {
                    computer.getCardonDesk()[computer.getCardonDesk().length - 1].printOutInfo();
                }
                checkType(computer);
                //看玩家有沒有被效果影響到歸0的牌
                checkOnDesk(player1);
            }
            //如果沒有符合發動條件的牌,則找數值最大的牌出
            else {
                Card result = computer.getHandCard()[0];
                int max = 0;
                //找出數值最大的牌的位置
                for (int i = 0; i < computer.getHandCard().length; i++) {
                    if (result.getPoint() < computer.getHandCard()[i].getPoint()) {
                        result = computer.getHandCard()[i];
                        max = i;
                    }
                }
                computer.setCardonDesk(addToCardSet(computer.getCardonDesk(), computer.getHandCard()[max]));
                computer.setHandCard(removeCardFromCardSet(computer.getHandCard(), max));
                checkBuff(computer);
                //看電腦有沒有被buff影響到歸0的牌
                checkOnDesk(computer);

                System.out.println("電腦出牌:");
                computer.setPlayerScore(0);
                if (computer.getCardonDesk().length > 0) {
                    computer.getCardonDesk()[computer.getCardonDesk().length - 1].printOutInfo();
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
            computer.setCardonDesk(addToCardSet(computer.getCardonDesk(), computer.getHandCard()[0]));
            computer.setHandCard(removeCardFromCardSet(computer.getHandCard(), 0));
            checkBuff(computer);
            //看電腦有沒有被buff影響到歸0的牌
            checkOnDesk(computer);
            //顯示出的那張牌
            System.out.println("電腦出牌:");
            computer.setPlayerScore(0);
            if (computer.getCardonDesk().length > 0) {
                computer.getCardonDesk()[computer.getCardonDesk().length - 1].printOutInfo();
            }

            checkType(computer);
            //看玩家有沒有被效果影響到歸0的牌
            checkOnDesk(player1);
        }
    }


    /**
     * 打亂牌組順序
     */
    private void randomCardSet(CardSet cardSet) {
//        int r, cardNum = cardSet.getCards().length;
//        Card[] shuffleCard = new Card[cardNum];
//        for (int i = 0; i < shuffleCard.length; i++) {
//            r = random(0, cardNum - 1);
//            shuffleCard[i] = cardSet.getCards()[r];
//            cardSet.removeCard(r);
//            cardNum = cardSet.getCards().length;
//        }
//        cardSet.setCards(shuffleCard);
        List<Card> cards = Arrays.asList(cardSet.getCards());
        Collections.shuffle(cards);
        Card[] shuffleCard = new Card[cards.size()];
        shuffleCard = cards.toArray(shuffleCard);
        cardSet.setCards(shuffleCard);

    }

    /**
     * 將選擇的牌從原本的牌組移除
     */
    public Card[] removeCardFromCardSet(Card[] updateCardSet, int position) {
        Card[] newCard = new Card[updateCardSet.length - 1];
        for (int i = 0; i < updateCardSet.length - 1; i++) {
            if (i < position) {
                newCard[i] = updateCardSet[i];
            } else {
                newCard[i] = updateCardSet[i + 1];
            }
        }
        return newCard;
    }


    /**
     * 將選擇的牌加進牌組
     */
    public Card[] addToCardSet(Card[] originalCardSet, Card newCard) {
        Card[] newCardSet = new Card[originalCardSet.length + 1];
        for (int i = 0; i < originalCardSet.length; i++) {
            newCardSet[i] = Card.copy(originalCardSet[i]);
        }
        newCardSet[newCardSet.length - 1] = newCard;
        return newCardSet;
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
