import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    // 資料刷新時間
    public  static final int UPDATE_TIMES_PER_SEC = 60;// 每秒更新60次遊戲邏輯
    public  static final int NANOSECOND_PER_UPDATE = 1000000000 /UPDATE_TIMES_PER_SEC;// 每一次要花費的奈秒數

    // 畫面更新時間
    public static final int FRAME_LIMIT = 60;
    public static final int LIMIT_DELTA_TIME = 1000000000 / FRAME_LIMIT;

    public static void main(String[] args) {
        final JFrame jFrame = new JFrame();
        final GameJPanel gameJPanel = new GameJPanel();
        jFrame.setTitle("Game 9th");
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(gameJPanel);

        jFrame.setVisible(true);

        final long startTime = System.nanoTime(); // 程式開始時間
        long lastRepaintTime = System.nanoTime(); // 上一次重新畫圖的時間
        int paintTimes = 0;
        int passedUpdated = 0;
        long timer = System.nanoTime();
        while (true) {
            final long currentTime = System.nanoTime(); // 這一圈迴圈開始時的系統時間
            final long totalTime = currentTime - startTime; // 程式開始到現在經過的時間
            final long targetTotalUpdated = totalTime / (NANOSECOND_PER_UPDATE); // 開始到現在應該更新的次數

            while (passedUpdated < targetTotalUpdated) { // 如果當前經過的次數小於實際應該要更新的次數
                // update 更新追上當前次數
                gameJPanel.move();
                passedUpdated++;
            }

            if (currentTime - timer >= 1000000000) {
                System.out.println("FPS: " + paintTimes);
                paintTimes = 0;
                timer = currentTime;
            }

            // 現在時間 - 上一次畫的時間 大於等於 每一次繪圖要等待的時間間隔
            if (currentTime - lastRepaintTime >= LIMIT_DELTA_TIME) {
                lastRepaintTime = currentTime;
                jFrame.repaint();
                paintTimes++;
            }
        }
    }
}
