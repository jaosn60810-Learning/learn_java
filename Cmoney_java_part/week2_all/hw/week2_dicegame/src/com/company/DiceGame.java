package com.company;


public class DiceGame {

    //回合數
    int round;
    //骰子數
    int[][] playerDice = new int[2][];
    //規則
    int rule;
    //playerWin
    int[] player = new int[2];

    /** 設定骰子數 */
    public void setPlayerDice(int amount) {
        this.playerDice = new int[2][amount];
    }

    /** 設定回合 */
    public void setRound(int round) {
        this.round = round;
    }

    /** 設定規則 */
    public void setRule(int rule) {
        this.rule = rule;
    }

    
    /** 排序用途 */
    public interface Comparator{
        public boolean compare(int[][] compareUse);
    }

    /** 印出骰出的骰子 */
    public void print(int number){
        for(int i = 0; i<playerDice[number].length; i++){
            System.out.print(playerDice[number][i]+"  ");
        }
    }

    /** 確認該回合贏家 */
    public int[] checkWin(Comparator toCheck){
        int[][] compareUse = new int[2][6];
        for(int i = 0; i<playerDice[0].length; i++){
            compareUse[0][playerDice[0][i]-1]++;
            compareUse[1][playerDice[1][i]-1]++;
        }
        if(toCheck.compare(compareUse)){
            System.out.println("\n----------\n本局你獲勝！！！");
            player[0]++;
        } else {
            System.out.println("\n----------\n本局對方獲勝！！！");
            player[1]++;
        }
        return player;
    }


    /** 開始遊戲 */
    public void startGame(){
        player[0] = 0;
        player[1] = 0;
        for(int i = 0; i<round; i++){
            for(int k = 0; k<playerDice[0].length; k++){
                int randomNumber = (int) (Math.random() * 6) + 1;
                playerDice[0][k] = randomNumber;
                randomNumber = (int) (Math.random() * 6) + 1;
                playerDice[1][k] = randomNumber;
            }
            System.out.println("\n\n【第"+(i+1)+"回合】\n你骰到：");
            print(0);
            System.out.println("\n對方骰到：");
            print(1);
            switch (rule){
                case 1:
                    player = checkWin(new Comparator() {
                        @Override
                        public boolean compare(int[][] compareUse) {
                            int player1 = 0;
                            int player2 = 0;
                            for(int i = 0; i<6;i++){
                                if(compareUse[0][i]>=1){
                                    player1+=i+1;
                                }
                                if(compareUse[1][i]>=1){
                                    player2+=i+1;
                                }
                            }
                            return player1 > player2;
                        }
                    });
                    break;
                case 2:
                    player = checkWin(new Comparator() {
                        @Override
                        public boolean compare(int[][] compareUse) {
                            int player1 = 0;
                            int player2 = 0;
                            for(int i = 0; i<6;i++){
                                if(compareUse[0][i]>=1){
                                    player1+=i+1;
                                }
                                if(compareUse[1][i]>=1){
                                    player2+=i+1;
                                }
                            }
                            return player1 < player2;
                        }
                    });
                    break;
                case 3:
                    player = checkWin(new Comparator() {
                        @Override
                        public boolean compare(int[][] compareUse) {
                            int player1 = 0;
                            int player2 = 0;
                            for(int i = 0; i<6;i++){
                                if(compareUse[0][i]>=2){
                                    player1++;
                                }
                                if(compareUse[1][i]>=2){
                                    player2++;
                                }
                            }
                            return player1 > player2;
                        }
                    });
                    break;
            }
        }
        if(player[0]>player[1]){
//            System.out.println(player[1]);
            System.out.println("\n\n恭喜獲勝！"+round+"場比賽中，您贏了："+player[0]+"場\n");
        } else {
//            System.out.println(player[1]);
            System.out.println("\n\n可惜輸了！"+round+"場比賽中，您贏了："+player[0]+"場\n");
        }
    }

}
