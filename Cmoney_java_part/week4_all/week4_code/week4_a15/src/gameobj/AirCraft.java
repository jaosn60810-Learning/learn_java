package gameobj;

import controllers.ImageController;
import utils.CommandSolver;
import utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AirCraft extends GameObject implements CommandSolver.MouseCommandListener {

    private Image img;
    private int dir;

    public AirCraft(int x, int y) {
        super(x, y, 55, 55, x, y, 50, 50);
        dir = 0;

        img = ImageController.instance().tryGetImage(new Path().img().actors().aircraft());
    }


    public void move() {
        if (dir == 0) {
            translateX(4);
        } else {
            translateX(-4);
        }
    }

    public void changeDir(int x) {
        if (painter().left() > x) {
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
        g.drawImage(img, painter().left(), painter().top(),
                painter().width(), painter().height(), null);
    }
}
