package gametest;

import utils.GameKernel;
import utils.Global;

import javax.swing.*;

import java.awt.event.KeyEvent;

import static utils.Global.*;

public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame(); // 遊戲視窗本體
        jf.setTitle("Game Test"); // 視窗標題
        jf.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // 視窗大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //關閉視窗時關閉程式

        // 關聯鍵盤按鍵與指令集
        int[][] commands = {
                {KeyEvent.VK_LEFT, Global.LEFT},
                {KeyEvent.VK_RIGHT, Global.RIGHT},
                {KeyEvent.VK_UP, Global.UP},
                {KeyEvent.VK_DOWN, Global.DOWN},
                {KeyEvent.VK_SPACE, Global.SPACE}
        };

        GI gi = new GI(); // 遊戲的本體(邏輯 + 畫面處理)

        GameKernel gk = new GameKernel.Builder(gi, LIMIT_DELTA_TIME, NANOSECOND_PER_UPDATE)
                .initListener(commands)
                .enableMouseTrack(gi)
                .enableKeyboardTrack(gi)
                .keyTypedMode()
                .gen();

        jf.add(gk);

        jf.setVisible(true);
        gk.run(IS_DEBUG);
    }
}
