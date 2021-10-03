package gameexercise;

import gameexercise.CommandSolver.*;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 *
 * @author user1
 */
public class GameKernel extends Canvas {  
    /* 簡單來說 GameJPanel 就是在控制物件動畫的main function（寫在Timer裡）
    而各自物件操控的細節再各class裡面
    main function JFrame 視窗就是整個控制整個畫面視窗，也就是圖畫版，
    JPanel就是畫筆，各class就是顏料
    而在這裡，利用GameKernel(老師自定義的，並非內建）取代原先JPanel的功能，更加強大可怕
     */

    public static class Builder {

        private final GameInterface gi;
        private final GameKernel gk;
        private CommandSolver.Builder builder;

        public Builder(GameInterface gi, long limitDeltaTimePerNano, long nanosecPerUpdate) {
            this.gi = gi;
            this.gk = new GameKernel(gi, limitDeltaTimePerNano, nanosecPerUpdate);
        }
        //處裡CommandSolver的接口，主要是在放入鍵盤的對應指令，只加入一個
        public Builder initListener(){
            builder = new CommandSolver.Builder(this.gk, this.gk.nanosecPerUpdate);
            return this;
        }
        /*處裡CommandSolver的接口，主要是在放入鍵盤的對應指令，可以放入一個二維陣列
        KeyEvent e 是 java 原本的讀取鍵盤類別。 只可以讀取到案了哪個按鍵，跟讀取到該字元，
        就沒有用了，所以老師這邊改寫為傳入int commandCode (指令的code EX:按下w 傳回3 ) , long trigTime (觸發的時間))
        */
        public Builder initListener(int[][] array) {
            builder = new CommandSolver.Builder(this.gk, this.gk.nanosecPerUpdate, array);
            return this;
        }
        //處裡CommandSolver的接口，主要是在放入鍵盤的對應指令，可以放入一個ArrayList清單
        public Builder initListener(ArrayList<int[]> cmArray) {
            builder = new CommandSolver.Builder(this.gk, this.gk.nanosecPerUpdate, cmArray);
            return this;
        }

        public Builder add(int key, int command) {  // 加入一顆按鍵的功能
            builder.add(key, command);
            return this;
        }

        public Builder enableMouseTrack(MouseCommandListener ml) {  //按下去之後要幹嘛
            builder.enableMouseTrack(ml);
            return this;
        }

        public Builder enableKeyboardTrack(KeyListener kl) {    //按下去之後要幹嘛
            builder.enableKeyboardTrack(kl);
            return this;
        }
        //因為滑鼠感測問題，有時候在滑鼠按下時，因為長短
        public Builder mouseForceRelease() {
            builder.mouseForceRelease();
            return this;
        }
        /* 讓按鈕敏感度降低，不至於按一下就觸發好幾個，java預設也是這樣
        但一旦按鍵一直被按住時，就會頓一下，然後才一直輸入。
        */
        public Builder keyTypedMode() {
            builder.keyTypedMode();
            return this;
        }
        //用於讓按鈕敏感度提高，也就是按一下，就會一直觸發不會停頓，依照遊戲自行選怎要哪個模式。
        public Builder keyCleanMode() {
            builder.keyCleanMode();
            return this;
        }
        //追蹤鍵盤的輸入，可以讀取到字元，可搭配enableKeyboardTrack 內實現keyTyped 幫字元做額外的判斷
        public Builder trackChar() {
            builder.trackChar();
            return this;
        }

        public GameKernel gen(){
            gk.cs = builder.gen();
            return gk;
        }

        Object enableMouseTrack() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public interface GameInterface {  // GI

        public void paint(Graphics g); //畫的時候在做什麼

        public void update();
    }// 也就是原本的input（已封死在CommandSolver裡面，所以這裡看不到) -> update -> paint的地方

    private CommandSolver cs;
    private final long limitDeltaTimePerNano;
    private final long nanosecPerUpdate;
    private final GameInterface gi;


    private GameKernel(GameInterface gi, long limitDeltaTimePerNano, long nanosecPerUpdate) {
        this.gi = gi;
        this.limitDeltaTimePerNano = limitDeltaTimePerNano;
        this.nanosecPerUpdate = nanosecPerUpdate;
    }

    public void paint() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
//        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (gi != null) {
            gi.paint(g);
        }
        g.dispose();
        bs.show();
    }  //取代原先jPanel 的paintComponent 的功能 - 新增了畫面失真的處裡

    public void run(boolean isDebug) {
        cs.start();
        long startTime = System.nanoTime();  //取得目前系統時間的奈秒
        long passedUpdated = 0;  //  實際應該更新的次數 (當畫面延遲時 補上資料運算的次數)
        long lastRepaintTime = System.nanoTime(); //最後一次畫面更新的時間
        int painTimes = 0;  // 用來算這一秒畫了幾次 -> 也就是FPS 
        long timer = System.nanoTime(); // 取得目前系統時間的奈秒，以計算FPS
        while (true) {   //不要在此印出資料，會用生命在印，這個while(true) 迴圈就是在實現原本Timer的功能

            long currentTime = System.nanoTime();// 系統當前時間
            long totalTime = currentTime - startTime;// 從開始到現在經過的時間
            long targetTotalUpdated = totalTime / (nanosecPerUpdate);// 開始到現在應該更新的次數
            // input
            // input end
            while (passedUpdated < targetTotalUpdated) {// 如果當前經過的次數小於實際應該要更新的次數
                //update 更新追上當前次數
                if (cs != null) {
                    cs.update();
                }
                gi.update();   // 更新邏輯
                passedUpdated++;  // 增加更新次數
            }
            //計算真實FPS 數 系統當前的時間- 系統建立的時間/每秒過後的時間 超過1秒後計算
            if (currentTime - timer >= 1000000000) {
                if (isDebug) {
                    System.out.println("FPS: " + painTimes);
                }
                painTimes = 0;
                timer = currentTime;
            }
            if (limitDeltaTimePerNano <= currentTime - lastRepaintTime) {
                //畫出畫面
                lastRepaintTime = currentTime;  //最後一次畫的時間變成當前時間
                paint();  //觸發繪圖 重繪 Graphics 畫面
                painTimes++;  // 如果要補畫面的畫就要在這邊加入，讓有少的都會印出來，所以就會產生瞬間加入。
            }
        }
    } // 原先 main function 的 while(true)迴圈 (Timer的功能) 改成在這裡實現


}
