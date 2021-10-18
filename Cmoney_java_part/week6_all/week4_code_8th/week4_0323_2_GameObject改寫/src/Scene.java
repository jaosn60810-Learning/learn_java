import gameobj.Airplane;
import gameobj.Enemy;
import utils.CommandSolver;
import utils.GameKernel;
import utils.Global;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Scene implements GameKernel.PaintInterface, GameKernel.UpdateInterface
        , CommandSolver.MouseListener {

    private Airplane airplane;
    private ArrayList<Enemy> enemies;

    public Scene() {
        this.airplane = new Airplane(30, 500);
        this.enemies = new ArrayList<>();
    }

    @Override
    public void mouseTrig(final MouseEvent e, final CommandSolver.MouseState state, final long trigTime) {
        if (state == CommandSolver.MouseState.MOVED) {
            this.airplane.changeDir(e.getX());
        }
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
            if (this.airplane.isCollision((this.enemies.get(i)))|| this.enemies.get(i).isOutOfBound()) {
                this.enemies.remove(i);
                i--;
            }
        }
    }
}
