package scene;

import controllers.SceneController;
import gameobj.Aircraft;
import gameobj.CBoom;
import gameobj.CEnemy;
import utils.CommandSolver;
import utils.Global;
import static utils.Global.*;
import utils.Path;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainScene extends Scene{
    /*由於滑鼠、按鍵的感測，應該在各物件各自的邏輯判斷 實現（但是最好是讓飛機自己去判斷，
    但是如果直接放給飛機製作，要留個接口讓外面可以決定要使用鍵盤或滑鼠操作，
    並且在GI這邊還是要導入飛機的判斷系統（以e代替），而非main function做，所以
   讓GI去實現滑鼠及鍵盤的感測Overried 並讓外部直接讀取GI 得到GI內的MouseCommandListener
    這裡可以直接得到是因為 MouseCommandListener介面只有一個方法，所以可以直接抓取。
     */
    private Aircraft ac;
    private ArrayList<CEnemy> enmys;
    private ArrayList<CBoom> booms;
    private Image bgimg;
    private AudioClip boomMusic;
    private AudioClip bgMusic;

    @Override
    public void sceneBegin() {  //利用sceneBegin()的方法替代創毽子，這樣可以讓場景被重複利用，而不用重新new一個
        ac = new Aircraft(20, 400); // 也可以加入arr
        enmys = new ArrayList<>();
        booms = new ArrayList<>();
        bgimg = SceneController.instance().irc().tryGetImage(new Path().img().backgrounds().sea());
        try {
            boomMusic = Applet.newAudioClip(getClass().getResource("/resources/sounds/bomb.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bgMusic = Applet.newAudioClip(getClass().getResource("/resources/sounds/Alarm01.wav"));
        } catch (Exception e) {

        }
        bgMusic.loop(); // 重複播放， 如果只要撥放一次就是 bgMusic.play();  //自己加的 
    }

    @Override
    public void scenceEnd() {
        bgMusic.stop();
        ac = null;
        enmys = null;
        booms = null;
        bgMusic = null;
    }


    @Override
    public void paint(Graphics g) {  //只負責畫圖，不負責邏輯
        // 每秒跑 FRAME_LIMIT 次
        g.drawImage(bgimg, 0, 0, FRAME_X, FRAME_Y, null);
        ac.paint(g);
        for (int i = 0; i < enmys.size(); i++) {
            enmys.get(i).paint(g);
        }
        for (int i = 0; i < booms.size(); i++) {
            booms.get(i).paint(g);
        }
    }
    @Override
    public void update() {
        //每秒跑 UPDATE_TIMES_PER_SEC 次
        //1.執行各物件的移動
        if (Global.random(1, 15) == 15 && enmys.size() < 15) {   // 隨機製造敵機飛機
            enmys.add(new CEnemy(Global.random(0, 580), Global.random(0, 50), Global.random(-3, 3)));
        }
        ac.update();   // 原始飛機
        // 2.移動敵機，並判斷各飛機之間的關係（飛機碰撞）
        for (int i = 0; i < enmys.size(); i++) {
            //  如果移動失敗，代表超出了畫面範圍，會回傳false，所以讓飛機移出清單
            if (enmys.get(i).outSide()) {
                enmys.remove(i--);
                continue;// 要i-- 是因為如果刪除了以後， 原本1的位置變成2，但i從2開始，也就是會有一個沒判斷到
            }
            if (ac.isCollision(enmys.get(i))) {  //判斷有無跟敵機發生碰撞
                SceneController.instance().change(new GameOverScene());
                continue;
            }
            enmys.get(i).update();
        }
        // 3. 判斷子彈移動與各物件之間的碰撞關係
        for (int i = 0; i < booms.size(); i++) {
            CBoom boom = booms.get(i);
            boom.update();
            if (boom.getState() != CBoom.State.NORMAL){
                if (boom.getState() == CBoom.State.REMOVED){
                    booms.remove(i);  // 如果子彈的狀態是要被消除，就將他移除
                }
                continue;
            }
            if (boom.touchTop()){
                booms.remove(i);
                continue;
            }
            if (boom.getState() == CBoom.State.NORMAL) {
                for (int j = 0; j < enmys.size(); j++) {
                    if (boom.isCollision(enmys.get(j))){
                        boom.setState(CBoom.State.BOOM);
                        enmys.remove(j);
                        boomMusic.play();
                        break;
                    }
                }
            }
        }

    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return (MouseEvent e, CommandSolver.MouseState state, long trigTime) -> {
            ac.mouseTrig(e, state, trigTime);
            if (state == CommandSolver.MouseState.CLICKED || state == CommandSolver.MouseState.PRESSED) {
                booms.add(new CBoom(ac.painter().left(), ac.painter().top(), 30, 30));
            }
        }; //匿名內部類，可轉為lambda

    }

    @Override
    public CommandSolver.KeyListener keyListener() {  //沒使用到就回傳null
        return new CommandSolver.KeyListener(){
            @Override
            public void keyPressed(int commandCode, long trigTime) {
                //對應按鍵按下時
            }

            @Override
            public void keyReleased(int commandCode, long trigTime) {
                //對應按鍵沒按時
            }

            @Override
            public void keyTyped(char c, long trigTime) {
                //讀取到按鍵的字元
            }
        };

    }


}