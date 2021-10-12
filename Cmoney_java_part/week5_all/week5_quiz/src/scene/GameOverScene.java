package scene;

import utils.CommandSolver;
import utils.Global;

import java.awt.*;

public class GameOverScene extends Scene {
    private long gameTime;
    private int killEnemyCount;

//    public GameOverScene() {
//        this.gameTime = 0;
//        this.killEnemyCount = 0;
//    }

    public void setGameTime(long gameTime) {
        this.gameTime = gameTime;
    }

    public void setKillEnemyCount(int killEnemyCount) {
        this.killEnemyCount = killEnemyCount;
    }

    @Override
    public void sceneBegin() {

    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawString("Game Over", Global.SCREEN_X / 2, Global.SCREEN_Y / 2);
        g.drawString("Survive: " + this.gameTime + " sec", Global.SCREEN_X / 2, Global.SCREEN_Y / 2 + 25);
        g.drawString("Kill: " + this.killEnemyCount, Global.SCREEN_X / 2, Global.SCREEN_Y / 2 + 50);
    }

    @Override
    public void update() {

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
