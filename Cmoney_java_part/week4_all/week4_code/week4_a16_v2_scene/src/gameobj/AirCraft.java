package gameobj;

import controllers.ImageController;
import utils.CommandSolver;
import utils.Global.Direction;
import utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AirCraft extends GameObject implements CommandSolver.MouseCommandListener {

    private Image img;
    private Direction dir;

    public AirCraft(int x, int y) {
        super(x, y, 55, 55, x, y, 50, 50);
        dir = Direction.RIGHT;
        img = ImageController.instance().tryGetImage(new Path().img().actors().aircraft());
    }


    public void move() {
        if (dir == Direction.RIGHT && !touchRight()) {
            translateX(4);
        } else if(dir == Direction.LEFT && !touchLeft()) {
            translateX(-4);
        }
    }

    public void changeDir(int x) {
        if (painter().left() > x) {
            dir = Direction.LEFT;
        } else {
            dir = Direction.RIGHT;
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
