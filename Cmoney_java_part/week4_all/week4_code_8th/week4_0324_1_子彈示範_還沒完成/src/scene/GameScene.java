package scene;

import gameobj.Airplane;
import gameobj.Boom;
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
    private ArrayList<Boom> ammo;

    public GameScene() {
    }


    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < this.ammo.size(); i++) {
            this.ammo.get(i).paint(g);
        }

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

        // update objects
        this.airplane.update();

        for (int i = 0; i < this.ammo.size(); i++) {
            this.ammo.get(i).update();
        }

        for (int i = 0; i < this.enemies.size(); i++) {
            this.enemies.get(i).update();
        }

        //other
        for (int i = 0; i < this.ammo.size(); i++) {
            if (this.ammo.get(i).isOutOfBound()) {
                this.ammo.remove(i);
                i--;
                continue;
            }
            for (int j = 0; j < this.enemies.size(); j++) {
                if (this.ammo.get(i).isCollision(this.enemies.get(j))) {
                    this.enemies.remove(j);
                    break;
                }
            }
        }

        for (int i = 0; i < this.enemies.size(); i++) {
            if (this.enemies.get(i).isOutOfBound()) {
                this.enemies.remove(i);
                i--;
                continue;
            }
            if (this.airplane.isCollision((this.enemies.get(i)))) {
                this.enemies.remove(i);
                i--;
            }
        }
    }

    @Override
    public void sceneBegin() {
        this.airplane = new Airplane(30, 500);
        this.enemies = new ArrayList<>();
        this.ammo = new ArrayList<>();
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
            if (state != null) {
                switch (state) {
                    case MOVED:
                        this.airplane.changeDir(e.getX());
                        break;
                    case RELEASED:
                        this.ammo.add(new Boom(this.airplane.x(), this.airplane.y()));
                        break;
                }
            }
        };
    }
}
