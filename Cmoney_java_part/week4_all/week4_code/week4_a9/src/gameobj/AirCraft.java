package gameobj;

import utils.CommandSolver;
import utils.GameKernel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AirCraft implements GameKernel.GameInterface, CommandSolver.MouseCommandListener {

    private int x;
    private int y;
    private int dir;
    private int width;
    private int height;
    private Image img;

    public int left() {
        return x;
    }

    public int right() {
        return x + width;
    }

    public int top() {
        return y;
    }

    public int bottom() {
        return y + height;
    }

    public AirCraft(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        dir = 0;

        try {
            img = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isCollision(CEnemy e) {
        if (right() < e.left()) {
            return false;
        }
        if (left() > e.right()) {
            return false;
        }
        if (top() > e.bottom()) {
            return false;
        }
        if (bottom() < e.top()) {
            return false;
        }
        return true;
    }

    public void move() {
        if (dir == 0) {
            x += 4;
        } else {
            x -= 4;
        }
    }

    public void changeDir(int x) {
        if (this.x > x) {
            dir = 1;
        } else {
            dir = 0;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        if (state == CommandSolver.MouseState.MOVED) {
            changeDir(e.getX());
        }
    }
}
