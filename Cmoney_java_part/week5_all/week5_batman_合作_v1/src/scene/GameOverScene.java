package scene;

import controllers.SceneController;
import utils.CommandSolver;
import utils.Global;
import utils.Path;

import java.awt.*;

import static utils.Global.SCREEN_X;
import static utils.Global.SCREEN_Y;

public class GameOverScene extends Scene {
    private Image bg = SceneController.instance().irc().tryGetImage(new Path().img().backgrounds().cloud());

    @Override
    public void sceneBegin() {

    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void update() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, SCREEN_X, SCREEN_Y,null);
        g.setColor(Color.red);
        g.drawString("Game Over", Global.SCREEN_X /2, Global.SCREEN_Y /2);
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
