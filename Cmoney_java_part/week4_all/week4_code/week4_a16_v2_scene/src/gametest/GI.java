package gametest;


import scene.MainScene;
import scene.Scene;
import utils.CommandSolver.*;
import utils.GameKernel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GI implements GameKernel.GameInterface, MouseCommandListener, KeyListener {


    private Scene scene;

    public GI() {
        scene = new MainScene();
        scene.sceneBegin();
    }


    @Override
    public void paint(Graphics g) {
        scene.paint(g);
    }

    @Override
    public void update() {
        scene.update();
    }

    @Override
    public void mouseTrig(MouseEvent e, MouseState state, long trigTime) {
        if (scene.mouseListener() != null) {
            scene.mouseListener().mouseTrig(e, state, trigTime);
        }
    }

    @Override
    public void keyPressed(int commandCode, long trigTime) {

    }

    @Override
    public void keyReleased(int commandCode, long trigTime) {

    }

    @Override
    public void keyTyped(char c, long trigTime) {

    }
}
