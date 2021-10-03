package scene;

import controllers.SceneController;
import gameobj.AirCraft;
import gameobj.CBoom;
import gameobj.CEnemy;
import utils.CommandSolver;
import utils.Global;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainScene extends Scene {
    private AirCraft ac;
    private ArrayList<CEnemy> arr;
    private ArrayList<CBoom> ammo;

    @Override
    public void sceneBegin() {
        ac = new AirCraft(10, 400);
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
    public void paint(Graphics g) {
        // 每秒跑 FRAME_LIMIT 次
        ac.paint(g);
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).paint(g);
        }
        for (int i = 0; i < ammo.size(); i++) {
            ammo.get(i).paint(g);
        }
    }

    @Override
    public void update() {
        // 隨機產生
        if (Global.random(0, 14) == 0 && arr.size() < 15) {
            arr.add(new CEnemy(Global.random(0, 600), 0, Global.random(-5, 5)));
        }
        ac.update();
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).move()) {
                arr.remove(i--);
                continue;
            }
            if (ac.isCollision(arr.get(i))) {
                SceneController.instance().change(new GameOverScene());
                continue;
            }
            arr.get(i).update();
        }
        for (int i = 0; i < ammo.size(); i++) {
            CBoom boom = ammo.get(i);
            boom.update();
            if (boom.getState() != CBoom.State.NORMAL) {
                if (boom.getState() == CBoom.State.REMOVED) {
                    ammo.remove(i--);
                }
                continue;
            }
            if (boom.outOfScreen()) {
                ammo.remove(i--);
                continue;
            }
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
    public CommandSolver.MouseCommandListener mouseListener() {
        return (MouseEvent e, CommandSolver.MouseState state, long trigTime) -> {
            ac.mouseTrig(e, state, trigTime);
            if (state == CommandSolver.MouseState.PRESSED) {
                ammo.add(new CBoom(ac.painter().left(), ac.painter().top()));
            }
        };
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return null;
    }
}
