package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GI implements GameKernel.GameInterface, CommandSolver.MouseCommandListener {

    private Image img;
    private int x;
    private int y;
    private int dir;

    public GI() {
        x = 30;
        y = 250;
        dir = 0;

        try {
            img = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void move() {
        if (dir == 0) {
            x += 4;
        } else {
            x -= 4;
        }
    }

    public void changeDir(int x) {
        if (this.x > x) {
            dir = 1;
        } else {
            dir = 0;
        }
    }

    @Override
    public void paint(Graphics g) {
        // 每秒跑 FRAME_LIMIT 次
        g.drawImage(img, x, y, null);
    }

    @Override
    public void update() {
        // 每秒跑 UPDATE_TIMES_PER_SEC 次
        move();
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        if (state == CommandSolver.MouseState.MOVED) {
            changeDir(e.getX());
        }
    }
}
