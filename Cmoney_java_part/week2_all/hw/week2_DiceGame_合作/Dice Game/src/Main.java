import java.util.Scanner;

/**
 * 1. 撰寫一個程式實現以下功能
 * A. 請撰寫一個類別DiceGame(80%)
 * i. 創建DiceGame時可以指定要使用的骰子數量、獲勝的規則、進行回合數(30%)
 * ii. 骰子數量必須為 3~6(10%)
 * iii. 進行回合數必須大於0且為奇數(10%)
 * iv. 獲勝規則有 點數大者勝、點數小者勝、相同點數多者勝(30%)
 * B. 請撰寫一個主程式依照以下流程執行(20%)
 * i. 讓使用者指定骰子數量(3~6)
 * ii. 讓使用者選擇獲勝規則(1~3)
 * iii. 讓使用者選擇進行回合數
 * iv. 進行遊戲並顯示最終勝利者
 * v. 重新回到B-i步驟
 *
 *
 * 備註:
 * 1. 骰子數量、獲勝規則、進行回合數皆必須為DiceGame的屬性
 * 2. 玩家數量永遠為2，請寫死於DiceGame中
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("請輸入要使用的骰子數量：");
            int diceAmount = sc.nextInt();
            System.out.println("請輸入要獲勝的規則：");
            int diceRule = sc.nextInt();
            System.out.println("請輸入進行回合數：");
            int round = sc.nextInt();

            DiceGame newGame = new DiceGame(round, diceAmount, diceRule);
            newGame.startGame();
        }
    }
}
