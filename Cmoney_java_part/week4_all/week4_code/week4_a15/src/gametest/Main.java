package gametest;

import utils.GameKernel;

import javax.swing.*;

import static utils.Global.*;

public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame(); // 遊戲視窗本體
        jf.setTitle("Game Test"); // 視窗標題
        jf.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // 視窗大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //關閉視窗時關閉程式

        // 關聯鍵盤按鍵與指令集
//        int[][] commands = {
//                // 正常來說是要寫成 {KeyEvent.VK_W, Global.UP}, 由Global這個類別去定義UP...個按鍵 = 數字幾
//                // 會需要這樣是為了讓使用者可以自定義鍵盤 ，可以多對一。
//                // commands 是用來綁定指令用的
//                {KeyEvent.VK_W, 3},
//                {KeyEvent.VK_UP, 3},
//                {KeyEvent.VK_A, 1},
//                {KeyEvent.VK_S, 2},
//                {KeyEvent.VK_D, 0}
//        };

        GI gi = new GI(); // 遊戲的本體(邏輯 + 畫面處理)

        GameKernel gk = new GameKernel.Builder(gi, LIMIT_DELTA_TIME, NANOSECOND_PER_UPDATE)
                .initListener()
                .enableMouseTrack(gi)
                .gen();

        jf.add(gk);

        jf.setVisible(true);
        gk.run(IS_DEBUG);
    }
}
