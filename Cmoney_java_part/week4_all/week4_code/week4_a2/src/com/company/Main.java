package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    // 資料刷新時間
    public static final int UPDATE_TIMES_PER_SEC = 60; // 每秒更新60次遊戲邏輯
    public static final int NANOSECOND_PER_UPDATE = 1000000000 / UPDATE_TIMES_PER_SEC;// 每一次要花費的奈秒數
    // 畫面更新時間
    public static final int FRAME_LIMIT = 60;
    public static final int LIMIT_DELTA_TIME = 1000000000 / FRAME_LIMIT;

    public static void main(String[] args) {
//        System.out.println((int)(Math.random()*28));
        JFrame jf = new JFrame();
        jf.setTitle("Game test");
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameJPanel jp = new GameJPanel();
        jf.add(jp);

        jf.setVisible(true);

        long startTime = System.nanoTime(); // 取得目前系統時間的奈秒
        long passedUpdated = 0;// 實際應該該新的次數
        long lastRepaintTime = System.nanoTime();// 最後一次畫面更新的時間
        int paintTimes = 0;
        long timer = System.nanoTime();

        while (true) {
            long currentTime = System.nanoTime(); // 系統當前時間
            long totalTime = currentTime - startTime; // 從開始到現在經過的時間
            long targetTotalUpdated = totalTime / (NANOSECOND_PER_UPDATE); // 開始到現在應該更新的次數
            // input
            // input end
            while (passedUpdated < targetTotalUpdated) { // 如果當前經過的次數小於實際應該要更新的次數
                //  update 更新追上當前次數
//                if(cs != null){
//                    cs.update();
//                }
                jp.move(); // 更新邏輯
                passedUpdated++; // 增加更新次數
            }
            if (currentTime - timer >= 1000000000) {
                System.out.println("FPS: " + paintTimes);
                paintTimes = 0;
                timer = currentTime;
            }
            if (LIMIT_DELTA_TIME <= currentTime - lastRepaintTime) {
                // 畫出畫面
                lastRepaintTime = currentTime; // 最後一次畫的時間變成當前時間
                jf.repaint(); // 觸發繪圖
                paintTimes++;
            }
        }
    }
}
