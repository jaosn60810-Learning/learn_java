package gametest;


import controllers.SceneController;
import scene.MainScene;
import scene.Scene;
import utils.CommandSolver.*;
import utils.GameKernel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GI implements GameKernel.GameInterface, MouseCommandListener, KeyListener {


    public GI() {
        SceneController.instance().change(new MainScene());
    }


    @Override
    public void paint(Graphics g) {
        SceneController.instance().paint(g);
    }

    @Override
    public void update() {
        SceneController.instance().update();
    }

    @Override
    public void mouseTrig(MouseEvent e, MouseState state, long trigTime) {
        MouseCommandListener m1 = SceneController.instance().mouseListener();
        if (m1 != null) {
            m1.mouseTrig(e, state, trigTime);
        }
    }

    @Override
    public void keyPressed(int commandCode, long trigTime) {
        KeyListener k1 = SceneController.instance().keyListener();
        if (k1 != null) {
            k1.keyPressed(commandCode, trigTime);
        }
    }

    @Override
    public void keyReleased(int commandCode, long trigTime) {
        KeyListener k1 = SceneController.instance().keyListener();
        if (k1 != null) {
            k1.keyReleased(commandCode, trigTime);
        }
    }

    @Override
    public void keyTyped(char c, long trigTime) {
        KeyListener k1 = SceneController.instance().keyListener();
        if (k1 != null) {
            k1. keyTyped(c, trigTime);
        }
    }
}
