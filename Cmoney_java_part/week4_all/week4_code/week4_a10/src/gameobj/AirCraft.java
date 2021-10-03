package gameobj;

import utils.CommandSolver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AirCraft extends GameObject implements CommandSolver.MouseCommandListener {


    private int dir;
    private Image img;


    public AirCraft(int x, int y) {
        super(x, y, 50, 50);
        dir = 0;

        try {
            img = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public void move() {
        if (dir == 0) {
            setX(left() + 4);
        } else {
            setX(left() - 4);
        }
    }

    public void changeDir(int x) {
        if (left() > x) {
            dir = 1;
        } else {
            dir = 0;
        }
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

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, left(), top(), width(), height(), null);
    }
}
