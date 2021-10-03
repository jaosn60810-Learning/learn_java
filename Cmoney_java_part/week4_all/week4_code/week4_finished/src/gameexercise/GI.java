package gameexercise;

import gameexercise.CommandSolver.MouseCommandListener;
import gameexercise.CommandSolver.MouseState;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class GI implements GameKernel.GameInterface, MouseCommandListener {

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

    public GI() {
        ac = new Aircraft(20, 400); // 也可以加入arr
        enmys = new ArrayList<>();
//        for (int i = 0; i < Global.random(5, 10); i++) {
//            enmys.add(new CEnemy(Global.random(0, 560), Global.random(0, 50), Global.random(-5, 5)));
//        }
        booms = new ArrayList<>();
        try {
            bgimg = ImageIO.read(getClass().getResource("/resources/sea.png"));
        } catch (IOException ex) {
            Logger.getLogger(GI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            boomMusic = Applet.newAudioClip(getClass().getResource("/resources/bomb.wav"));
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            bgMusic = Applet.newAudioClip(getClass().getResource("/resources/Alarm01.wav"));
        }catch (Exception e){

        }
        bgMusic.loop(); // 重複播放， 如果只要撥放一次就是 bgMusic.play();  //自己加的 

    }

    @Override
    public void mouseTrig(MouseEvent e, MouseState state, long trigTime) {
        ac.mouseTrig(e, state, trigTime);
        if (state == MouseState.CLICKED || state == MouseState.PRESSED) {
            booms.add(new CBoom(ac.getX(), ac.getY()));
        }
    }

    @Override
    public void paint(Graphics g) {
        // 每秒跑 FRAME_LIMIT 次
        g.drawImage(bgimg, 0, 0, 800, 650, null);
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
        ac.update();   // 原始飛機
        if (Global.random(1, 10) > 9 && enmys.size() < 11) {   // 隨機製造敵機飛機
            enmys.add(new CEnemy(Global.random(0, 580), Global.random(0, 50), Global.random(-3, 3)));
        }
        for (int i = 0; i < enmys.size(); i++) {
            enmys.get(i).update();
        }
        for (int i = 0; i < booms.size(); i++) {
            booms.get(i).update();
        }
        // 2.判斷各物件之間的關係（飛機碰撞）
        for (int i = 0; i < enmys.size(); i++) {
            //  如果移動失敗，代表超出了畫面範圍，會回傳false，所以讓飛機移出清單
            if (enmys.get(i).move() == false) {
                enmys.remove(i);
            } else {
                if (ac.checkAttack(enmys.get(i))) {  //判斷有無跟敵機發生碰撞
                    System.exit(0);  // 程式結束
                }
            }
        }
        // 3. 判斷各物件之間的關係（子彈碰撞）
        for (int i = 0; i < booms.size(); i++) {
            if (booms.get(i).move() == false) {
                booms.remove(i);
            } else {
                if (booms.get(i).getState() == 0) {
                    for (int j = 0; j < enmys.size(); j++) { // j 是敵方飛機的判斷
                        if (booms.get(i).checkAttack(enmys.get(j))) {
                            enmys.remove(j);
                            boomMusic.play();
                            break;
                        }
                    }
                }
            }
        }


    }

}
