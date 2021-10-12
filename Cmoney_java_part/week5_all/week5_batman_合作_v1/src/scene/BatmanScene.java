package scene;

import GameObj.*;
import controllers.SceneController;
import utils.CommandSolver;
import utils.Global;
import utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static utils.Global.SCREEN_X;
import static utils.Global.SCREEN_Y;

public class BatmanScene extends Scene{
    private Batman bm;
    private ArrayList<BatmanDart> bd;
    private Joker jk;
    private int count = 0;


    @Override
    public void sceneBegin() {
        bm = new Batman(SCREEN_X/2 , 550);
        bd = new ArrayList<>();
        jk = new Joker(SCREEN_X/2 ,100, Global.random(1,5));

    }

    @Override
    public void sceneEnd() {
        bm = null;
        bd = null;
        jk = null;

    }

    @Override
    public void update() {

        bm.update();
        jk.update();

        //判斷子彈狀態
        for (int i = 0; i < bd.size(); i++) {
            BatmanDart boom = bd.get(i);
            boom.update();
            if (boom.isCollision(jk)) {
                bd.remove(i--);
                if (jk.getState() == Joker.State.NORMAL) {
                    count++;
                }
                if(count == 2) {
                    SceneController.instance().change(new GameOverScene());
                    break;
                }
                    continue;
                }

            //判斷子彈飛出畫面沒
            if (boom.touchTop()) {
                bd.remove(i--);

                continue;
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        //每秒跑FRAME_LIMIT次
        bm.paint(g);
        jk.paint(g);
//        //畫全部還在的敵機
//        for (int i = 0 ; i < arr.size(); i++) {
//            arr.get(i).paint(g);
//        }
        //畫全部還在的子彈
        for (int i = 0; i < bd.size(); i++) {
            bd.get(i).paint(g);
        }
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
//        return (MouseEvent e, CommandSolver.MouseState state, long trigTime) -> {
//            bm.keyPressed(,state,trigTime);
//            if (state == CommandSolver.MouseState.PRESSED) {
//                bd.add(new BatmanDart(bm.painter().left(), bm.painter().top()));//子彈準備要畫在飛機所在位置的地方
//            }
//        };
        return null;
   }

    @Override
    public CommandSolver.KeyListener keyListener() {
    return new CommandSolver.KeyListener() {
        @Override
        public void keyPressed(int commandCode, long trigTime) {
            bm.keyPressed(commandCode, trigTime);
            if (commandCode == 1) {
                bd.add(new BatmanDart(bm.painter().left(), bm.painter().top()));//子彈準備要畫在飛機所在位置的地方
            }
        }

        @Override
        public void keyReleased(int commandCode, long trigTime) {

        }

        @Override
        public void keyTyped(char c, long trigTime) {

        }
    };
    }
}
