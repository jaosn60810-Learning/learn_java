package gameexercise;

import gameexercise.utils.GameKernel;
import gameexercise.utils.GameKernel.Builder;
import gameexercise.utils.Global;
import static gameexercise.utils.Global.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class GameExercise {



    public static void main(String[] args) {

        JFrame jf = new JFrame();  // JFrame (視窗)為畫布，整個視窗內部範圍都是繪圖區的範圍，遊戲視窗本體
        jf.setTitle("飛機射擊遊戲");  //設置視窗的名稱
        jf.setSize(FRAME_X, FRAME_Y);  //設置JFrame的寬度和高度 - 引用Golbal的常數
        jf.setLocationRelativeTo(null);  // 將視窗固定在螢幕中央，如果要指定位置，可以放入兩個int x, y
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //使用 System exit 方法退出應用程式。僅在應用程式中使用（限JFrame使用)，指定右上角的X的功能。

        // 關聯鍵盤按鍵與指令集
        int[][] commands ={
                // 正常來說是要寫成 {KeyEvent.VK_W, Global.UP}, 由Global這個類別去定義UP...個按鍵 = 數字幾
                // 會需要這樣是為了讓使用者可以自定義鍵盤 ，可以多對一。
                // 也可以寫成 { KeyEvent.VK_W, 3}
                // commands 是用來綁定指令用的
                {KeyEvent.VK_W, Global.UP},
                {KeyEvent.VK_UP, Global.UP},
                {KeyEvent.VK_A, Global.LEFT},
                {KeyEvent.VK_S, Global.DOWN},
                {KeyEvent.VK_D, Global.RIGHT}
        };

        GI gi = new GI(); // 遊戲的本體（邏輯 + 畫面處理）

        GameKernel gk = new Builder(gi, LIMIT_DELTA_TIME, NANOSECOND_PER_UPDATE) //GI(遊戲邏輯及畫面處理)、畫面、遊戲邏輯的更新時間 (後兩個可以達成製作降低偵數或無現
                // 1.加入鍵盤的監聽、原本是用 add(KeyEvent.W, 3)，但因為要寫一堆add 因此有可以直接丟2維陣列的方法
                .initListener(commands)  //宣告每顆按鈕按下後代表什麼，沒用到可以不放，但目前有點小bug所以一定要放
                .enableMouseTrack(gi)  //這裡放gi 是因為GI 有實現了 MouseCommandListener介面的方法，所以是使用裡面的function
                .enableKeyboardTrack(gi)  //這裡放gi 是因為GI 有實現了 KeyListener介面的方法，所以是使用裡面的function
                .keyTypedMode() // 讓滑鼠、按鈕敏感度降低，不至於按一下就觸發好幾個
                .trackChar() // 開啟才可追蹤字元
                .gen();

        jf.add(gk);  // 因為GameKernel有先繼承了Canvas(畫布) 所以可以將gk 放入視窗中

        jf.setVisible(true);  //顯示 JFrame
        gk.run(IS_DEBUG); // boolean 是決定要不要開起Debug模式，產生FPS
        /*
        JFrame 被叫出來後會先做 paint  此時會觸發所有的 paintComponent <- 畫出我裡面的元件長什麼樣子 和 所有的 paint <- 畫自己本身都觸發一次
        JFrame 會觸發paint 這個paint 會在觸發所有的paintComponent <- 會在觸發所有元件的paint
        */

    }

}