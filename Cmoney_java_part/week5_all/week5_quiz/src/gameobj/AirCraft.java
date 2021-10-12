package gameobj;


import controllers.SceneController;
import utils.CommandSolver;
import utils.Global;
import utils.Global.Direction;
import utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AirCraft extends GameObject {

    private Image img;
    private Direction dir;
    // 我方飛機血量
    private int bloodCount;

    public AirCraft(int x, int y) {
        super(x, y, 55, 55, x, y, 50, 50);
        // 血量預設 3 滴
        this.bloodCount = 3;
        dir = Direction.RIGHT;
        img = SceneController.instance().irc().tryGetImage(new Path().img().actors().aircraft());
    }

    /**
     * 減少飛機血量
     */
    public void hit() {
        bloodCount--;
    }

    /**
     * 取的血量
     *
     * @return int 血量
     */
    public int getBloodCount() {
        return bloodCount;
    }


    public void move() {
        if (dir == Direction.RIGHT && !touchRight()) {
            translateX(4);
        } else if (dir == Direction.LEFT && !touchLeft()) {
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
//        move();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, painter().left(), painter().top(),
                painter().width(), painter().height(), null);
    }

}
