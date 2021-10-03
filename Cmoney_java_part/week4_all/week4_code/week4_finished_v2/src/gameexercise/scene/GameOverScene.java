
package gameexercise.scene;

import controllers.SceneController;
import gameexercise.utils.CommandSolver;
import gameexercise.utils.Delay;
import gameexercise.utils.Global;

import java.awt.Color;
import java.awt.Graphics;

public class GameOverScene extends Scene {

    private Delay delay;

    @Override
    public void sceneBegin() {
        delay = new Delay(180);
        delay.play();
    }

    @Override
    public void scenceEnd() {
        delay.stop();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawString("Game Over!", Global.SCREEN_X / 2, Global.SCREEN_Y / 2);
    }

    @Override
    public void update() {
        if (delay.count()) {
            SceneController.instance().change(new MainScene());
        }
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