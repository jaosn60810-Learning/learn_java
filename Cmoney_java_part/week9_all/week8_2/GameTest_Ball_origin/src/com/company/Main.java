package com.company;

import com.company.scene.MainScene;
import com.company.utils.GameKernel;
import com.company.utils.Global;
import static com.company.utils.Global.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author user1
 */
public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame();// 遊戲視窗本體
        jf.setTitle("Game Test 7th");// 視窗標題
        jf.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);// 視窗大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 關閉視窗時關閉程式

        GameCenter gi = new GameCenter(new MainScene());// 遊戲的本體(邏輯 + 畫面處理)

        int[][] commands = {
            {KeyEvent.VK_A, Global.Direction.LEFT.getValue()},
            {KeyEvent.VK_W, Global.Direction.UP.getValue()},
            {KeyEvent.VK_S, Global.Direction.DOWN.getValue()},
            {KeyEvent.VK_D, Global.Direction.RIGHT.getValue()},
            {KeyEvent.VK_SPACE, COMMAND_SPACE}
        };

        GameKernel gk = new GameKernel.Builder(gi, LIMIT_DELTA_TIME, NANOSECOND_PER_UPDATE)
                .initListener(commands)
                .enableKeyboardTrack(gi)
                .keyCleanMode()
                .enableMouseTrack(gi)
                .gen();

        jf.add(gk);

        jf.setVisible(true);
        gk.run(IS_DEBUG);
    }

}
