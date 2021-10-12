package scene;

import GameObj.AirCraft;
import GameObj.CBoom;
import GameObj.CEnemy;
import controllers.SceneController;
import utils.CommandSolver.*;
import utils.Global;
import utils.Path;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static utils.Global.SCREEN_X;
import static utils.Global.SCREEN_Y;

public class MainScene extends Scene{

    private AirCraft ac;
    private ArrayList<CEnemy> arr;
    private ArrayList<CBoom> ammo;
    private Image bg = SceneController.instance().irc().tryGetImage(new Path().img().backgrounds().sea());

    @Override
    public void sceneBegin() {
        ac = new AirCraft(10 , 400);
        arr = new ArrayList<>();
        ammo = new ArrayList<>();

    }

    @Override
    public void sceneEnd() {
        ac = null;
        arr = null;
        ammo = null;
    }

    @Override
    public void update() {
        //隨機產生enemy
        if(Global.random(0,14) == 0 && arr.size() < 15){
            arr.add(new CEnemy(Global.random(0,600),0 , Global.random(-5,5)));
        }

        ac.update();
        //判斷敵機飛離畫面沒
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).move()) {  //這樣結構沒有很好 判斷true false 不要這樣寫比較好 , 這裡是把敵機的update包成move的boolean函式
                arr.remove(i--); // i 不減的話 remove後 array會向前 會少跑到一圈
                continue;
            }
            if (ac.isCollision(arr.get(i))) {
                SceneController.instance().change(new GameOverScene());
            }
        }
        //判斷子彈狀態
        for (int i = 0; i < ammo.size(); i++) {
            CBoom boom = ammo.get(i);
            boom.update();
            if (boom.getState() != CBoom.State.NORMAL) {
                if (boom.getState() == CBoom.State.REMOVED) {
                    ammo.remove(i--);
                }
                continue;
            }
            //判斷子彈飛出畫面沒
            if (boom.touchTop()) {
                ammo.remove(i--);
                continue;
            }
            //判斷子彈打中飛機沒
            for (int j = 0; j < arr.size(); j++) {
                if (boom.isCollision(arr.get(j))) {
                    boom.setState(CBoom.State.BOOM);
                    arr.remove(j);
                    break;
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //每秒跑FRAME_LIMIT次
        g.drawImage(bg, 0, 0, SCREEN_X, SCREEN_Y,null);
        ac.paint(g);
        //畫全部還在的敵機
        for (int i = 0 ; i < arr.size(); i++) {
            arr.get(i).paint(g);
        }
        //畫全部還在的子彈
        for (int i = 0; i < ammo.size(); i++) {
            ammo.get(i).paint(g);
        }
    }

    @Override
    public MouseCommandListener mouseListener() {
        return (MouseEvent e, MouseState state, long trigTime) -> {
                ac.mouseTrig(e,state,trigTime);
                if (state == MouseState.PRESSED) {
                    ammo.add(new CBoom(ac.painter().left(), ac.painter().top()));//子彈準備要畫在飛機所在位置的地方
                }
        };
    }

    @Override
    public KeyListener keyListener() {
        return null;
    }
}
