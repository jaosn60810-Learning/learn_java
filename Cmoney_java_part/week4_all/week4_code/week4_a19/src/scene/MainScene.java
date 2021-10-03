package scene;


import gameobj.Actor;
import utils.CommandSolver;
import utils.Global;

import java.awt.*;

public class MainScene extends Scene {

    private Actor actor;

    @Override
    public void sceneBegin() {
        actor = new Actor(Global.SCREEN_X / 2, Global.SCREEN_Y / 2, 6);
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        actor.paint(g);
    }

    @Override
    public void update() {
        actor.update();
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return null;
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return null;
    }
}
