package com.company;

import gameobj.AirCraft;
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

    public GI() {
        ac = new AirCraft(10, 400);
        arr = new ArrayList<>();
        arr.add(new CEnemy(Global.random(0, 600), 0, Global.random(-5, 5)));
        arr.add(new CEnemy(Global.random(0, 600), 0, Global.random(-5, 5)));
    }


    @Override
    public void paint(Graphics g) {
        // 每秒跑 FRAME_LIMIT 次
        ac.paint(g);
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).paint(g);
        }
    }

    @Override
    public void update() {
        // 隨機產生
        if(Global.random(0,14) == 0 && arr.size()<15){
            arr.add(new CEnemy(Global.random(0, 600), 0, Global.random(-5, 5)));
        }
        ac.update();
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).move()) {
                arr.remove(i--);
            }
        }
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        ac.mouseTrig(e, state, trigTime);
    }
}
