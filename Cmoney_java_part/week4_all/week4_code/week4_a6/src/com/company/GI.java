package com.company;

import gameobj.AirCraft;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GI implements GameKernel.GameInterface, CommandSolver.MouseCommandListener {

    private AirCraft ac;
    private ArrayList<AirCraft> arr;

    public GI() {
        ac = new AirCraft(10,400);
        arr = new ArrayList<>();
        arr.add(new AirCraft(10,200));
        arr.add(new AirCraft(10,300));
    }


    @Override
    public void paint(Graphics g) {
        // 每秒跑 FRAME_LIMIT 次
        ac.paint(g);
    }

    @Override
    public void update() {
        // 每秒跑 UPDATE_TIMES_PER_SEC 次
        ac.update();
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        ac.mouseTrig(e,state,trigTime);
    }
}
