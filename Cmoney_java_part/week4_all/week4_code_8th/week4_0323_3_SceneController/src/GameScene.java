import gameobj.Airplane;
import gameobj.Enemy;
import scene.Scene;
import utils.CommandSolver;
import utils.GameKernel;
import utils.Global;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameScene extends Scene {

    private Airplane airplane;
    private ArrayList<Enemy> enemies;

    public GameScene() {
    }


    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < this.enemies.size(); i++) {
            this.enemies.get(i).paint(g);
        }
        this.airplane.paint(g);
    }

    @Override
    public void update() {
        // 隨機產生飛機
        if (Global.random(1, 100) <= 8) {
            this.enemies.add(new Enemy(Global.random(0, 600), 0,
                    Global.random(-5, 5)));
        }
        this.airplane.update();
        for (int i = 0; i < this.enemies.size(); i++) {
            this.enemies.get(i).update();
            if (this.airplane.isCollision((this.enemies.get(i))) || this.enemies.get(i).isOutOfBound()) {
                this.enemies.remove(i);
                i--;
            }
        }
    }

    @Override
    public void sceneBegin() {
        this.airplane = new Airplane(30, 500);
        this.enemies = new ArrayList<>();
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return null;
    }

    @Override
    public CommandSolver.MouseListener mouseListener() {
        return (e, state, trigTime) -> {
            if (state == CommandSolver.MouseState.MOVED) {
                this.airplane.changeDir(e.getX());
            }
        };
    }
}
