package gameexercise;

import controllers.SceneController;
import scene.MainScene;
import utils.CommandSolver.KeyListener;
import utils.CommandSolver.MouseCommandListener;
import utils.CommandSolver.MouseState;
import utils.GameKernel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class GI implements GameKernel.GameInterface, MouseCommandListener, KeyListener {

    public GI() { // 傳回最初始的主畫面
        SceneController.instance().change(new MainScene());
    }

    @Override
    public void mouseTrig(MouseEvent e, MouseState state, long trigTime) {
        MouseCommandListener m1 = SceneController.instance().mouseListener(); // 得到當前場景的滑鼠監聽
        if(m1 != null){
            m1.mouseTrig(e, state, trigTime);
        }
    }

    @Override
    public void paint(Graphics g) {  //只負責畫圖，不負責邏輯
        SceneController.instance().paint(g);   // 畫出當前場景的圖
    }

    @Override
    public void update() {
        SceneController.instance().update();  // 更新當前場景的遊戲邏輯
    }

    @Override
    public void keyPressed(int commandCode, long trigTime) {
        KeyListener k1 = SceneController.instance().keyListener(); // 得到當前場景的鍵盤按下
        if (k1 != null){
            k1.keyPressed(commandCode, trigTime);
        }
    }

    @Override
    public void keyReleased(int commandCode, long trigTime) {
        KeyListener k1 = SceneController.instance().keyListener();  // 得到當前場景的鍵盤監聽
        if (k1 != null){
            k1.keyPressed(commandCode, trigTime);
        }
    }

    @Override
    public void keyTyped(char c, long trigTime) {
        KeyListener k1 = SceneController.instance().keyListener();  // 得到當前場景的鍵盤監聽
        if (k1 != null){
            k1.keyPressed(c, trigTime);
        }
    }

}