public class DiceGame {
    int round;
    int diceAmount;
    int rule;
    int[] player1;
    int[] player2;
    int[] score = new int[2];


    public void checkWin(ruleChoose r) {
        int[] player1Dice = new int[6];
        int[] player2Dice = new int[6];
        for (int i = 0; i < diceAmount; i++) {
            player1Dice[player1[i] - 1]++;
            player2Dice[player2[i] - 1]++;
        }
        if (r.judge(player1Dice, player2Dice)) {
            System.out.println("玩家1贏");
        } else {
            System.out.println("玩家2贏");
        }
    }


    public interface ruleChoose {
        public boolean judge(int[] player1Dice, int[] player2Dice);
    }


    public void startGame() {
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < diceAmount; j++) {
                player1[j] = getDiceAmount();
                player2[j] = getDiceAmount();
            }
            switch (rule) {
                case 1:
                    checkWin(new ruleChoose() {

                        @Override
                        public boolean judge(int[] player1, int[] player2) {
                            int player1Dice = 0;
                            int player2Dice = 0;
                            for (int j = 0; j < 6; j++) {
                                player1Dice += player1[j] * (j + 1);
                                player2Dice += player2[j] * (j + 1);
                            }
                            if (player1Dice > player2Dice) {
                                score[0]++;
                            } else {
                                score[1]++;
                            }
                            return player1Dice > player2Dice;
                        }
                    });
                    break;
                case 2:
                    checkWin(new ruleChoose() {

                        @Override
                        public boolean judge(int[] player1, int[] player2) {
                            int player1Dice = 0;
                            int player2Dice = 0;
                            for (int j = 0; j < 6; j++) {
                                player1Dice += player1[j] * (j + 1);
                                player2Dice += player2[j] * (j + 1);
                            }
                            if (player1Dice < player2Dice) {
                                score[0]++;
                            } else {
                                score[1]++;
                            }
                            return player1Dice < player2Dice;
                        }
                    });

                    break;
                case 3:
                    checkWin(new ruleChoose() {

                        @Override
                        public boolean judge(int[] player1, int[] player2) {
                            int player1Dice = 0;
                            int player2Dice = 0;
                            for (int j = 0; j < 6; j++) {
                                if (player1[j] >= 2) {
                                    player1Dice++;
                                }
                                if (player2[j] >= 2) {
                                    player2Dice++;
                                }
                            }
                            if (player1Dice > player2Dice) {
                                score[0]++;
                            } else {
                                score[1]++;
                            }
                            return player1Dice > player2Dice;
                        }
                    });
                    break;
            }
        }
    }

    public DiceGame(int round, int diceAmount, int diceRule) {
        this.round = round;
        this.diceAmount = diceAmount;
        this.rule = diceRule;
        player1 = new int[this.diceAmount];
        player2 = new int[this.diceAmount];
    }

    public int getDiceAmount() {
        int dice = (int) (Math.random() * 6 + 1);
        return dice;
    }
}
