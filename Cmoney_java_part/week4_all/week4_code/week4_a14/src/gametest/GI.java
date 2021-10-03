package gametest;

import gameobj.AirCraft;
import gameobj.CBoom;
import gameobj.CEnemy;
import utils.CommandSolver;
import utils.GameKernel;
import utils.Global;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GI implements GameKernel.GameInterface, CommandSolver.MouseCommandListener {

    private AirCraft ac;
    private ArrayList<CEnemy> arr;
    private ArrayList<CBoom> ammo;


    public GI() {
        ac = new AirCraft(10, 400);
        arr = new ArrayList<>();
        ammo = new ArrayList<>();
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
                arr.remove(i--);
            }
        }
        for (int i = 0; i < ammo.size(); i++) {
            CBoom boom = ammo.get(i);
            boom.update();
            if (boom.getState() != 0) {
                if (boom.getState() == 2) {
                    ammo.remove(i--);
                }
                continue;
            }
            for (int j = 0; j < arr.size(); j++) {
                if (boom.isCollision(arr.get(j))) {
                    boom.setState(1);
                    arr.remove(j);
                    break;
                }
            }
        }
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        ac.mouseTrig(e, state, trigTime);
        if (state == CommandSolver.MouseState.PRESSED) {
            ammo.add(new CBoom(ac.painter().left(), ac.painter().top()));
        }
    }
}
