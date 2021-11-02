/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.scene;

import com.company.gameobj.*;
import com.company.utils.CommandSolver;
import com.company.utils.Delay;
import com.company.utils.Global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author user1
 */
public class MainScene extends Scene {

    ArrayList<Ball> ballList;
    ArrayList<Ammo> ammo;
    Delay delayShootAmmo;

    @Override
    public void sceneBegin() {
        ballList = new ArrayList<>();
        ballList.add(new Ball(50, 250, 30, Color.CYAN));
        ballList.add(new Ball(500, 250, 30, Color.CYAN));
        ballList.get(0).setId(1);
        ballList.get(0).setCanMove(true);
        ballList.get(0).setCanShoot(true);
        ballList.get(1).setId(2);

        ammo = new ArrayList<>();
        delayShootAmmo = new Delay(20);
        delayShootAmmo.loop();
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < ballList.size(); i++) {
            ballList.get(i).paint(g);
        }
        for (int i = 0; i < ammo.size(); i++) {
            ammo.get(i).paint(g);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < ballList.size(); i++) {
            ballList.get(i).update();
        }
        for (int i = 0; i < ammo.size(); i++) {
            ammo.get(i).update();
            if (ammo.get(i).painter().centerX() >= ammo.get(i).ox() + 110) {
                ammo.remove(i--);
            }
        }
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return (MouseEvent e, CommandSolver.MouseState state, long trigTime) -> {
            if (state == null) {
                return;
            }
            if (state == CommandSolver.MouseState.PRESSED) {
                if (e.getX() >= ballList.get(0).painter().left()
                        && e.getX() <= ballList.get(0).painter().right()
                        && e.getY() >= ballList.get(0).painter().top()
                        && e.getY() <= ballList.get(0).painter().bottom()
                ) {
                    ballList.get(0).setCanMove(true);
                    ballList.get(0).setCanShoot(true);
                    ballList.get(1).setCanMove(false);
                    ballList.get(1).setCanShoot(false);
                }
                if (e.getX() >= ballList.get(1).painter().left()
                        && e.getX() <= ballList.get(1).painter().right()
                        && e.getY() >= ballList.get(1).painter().top()
                        && e.getY() <= ballList.get(1).painter().bottom()
                ) {
                    ballList.get(1).setCanMove(true);
                    ballList.get(1).setCanShoot(true);
                    ballList.get(0).setCanMove(false);
                    ballList.get(0).setCanShoot(false);

                }
            }
        };
    }


    @Override
    public CommandSolver.KeyListener keyListener() {
        return new CommandSolver.KeyListener() {
            @Override
            public void keyPressed(int commandCode, long trigTime) {
                Vector vector = new Vector(2, 2);
                for (Ball ball : ballList) {
                    if (ball.isCanMove()) {
                        //按下A球向左移動
                        if (commandCode == Global.Direction.LEFT.getValue()) {
                            ball.translateX(-vector.vx());
                        }
                        //按下D球向右移動
                        if (commandCode == Global.Direction.RIGHT.getValue()) {
                            ball.translateX(vector.vx());
                        }
                        //按下W球向上移動
                        if (commandCode == Global.Direction.UP.getValue()) {
                            ball.translateY(-vector.vy());
                        }
                        //按下D球向下移動
                        if (commandCode == Global.Direction.DOWN.getValue()) {
                            ball.translateY(vector.vy());
                        }

                    }
                    // 發射子彈
                    if (ball.isCanShoot()) {
                        if (delayShootAmmo.count()) {
                            if (commandCode == Global.COMMAND_SPACE) {
                                ammo.add(new Ammo(ball.painter().centerX(), ball.painter().centerY(), 10, Color.RED, new Vector(10, 0)));
                            }
                        }
                    }
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
