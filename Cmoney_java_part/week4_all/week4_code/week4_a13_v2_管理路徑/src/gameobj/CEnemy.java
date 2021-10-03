package gameobj;


import controllers.ImageResourceController;
import utils.Path;

import java.awt.*;

public class CEnemy extends GameObject {

    private Image img;
    private int d;

    public CEnemy(int x, int y, int d) {
        super(x, y, 50, 50);
        this.d = d;

        img = ImageResourceController.instance().tryGetImage(Path.Resources.Actors.ENEMY);
    }

    public boolean move() {
        translateY(4);
        translateX(d);
        return painter().top() <= 600;
    }


    public void paintComponent(Graphics g) {
        g.drawImage(img, painter().left(), painter().top(),
                painter().width(), painter().height(), null);
    }

    @Override
    public void update() {

    }
}
