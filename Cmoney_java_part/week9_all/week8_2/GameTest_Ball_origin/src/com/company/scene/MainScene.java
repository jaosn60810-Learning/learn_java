/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.scene;

import com.company.gameobj.*;
import com.company.utils.CommandSolver;
import com.company.utils.Global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author user1
 */
public class MainScene extends Scene {

    ArrayList<Ball> ballList;

    @Override
    public void sceneBegin() {
        ballList = new ArrayList<>();
        ballList.add(new Ball(50, 250, 30, Color.CYAN));
        ballList.add(new Ball(500, 250, 30, Color.CYAN));
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < ballList.size(); i++) {
            ballList.get(i).paint(g);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < ballList.size(); i++) {
            ballList.get(i).update();
        }
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return (MouseEvent e, CommandSolver.MouseState state, long trigTime) -> {
            if (state == null) {
                return;
            }
            switch (state) {
            }
        };
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return new CommandSolver.KeyListener() {
            @Override
            public void keyPressed(int commandCode, long trigTime) {
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
