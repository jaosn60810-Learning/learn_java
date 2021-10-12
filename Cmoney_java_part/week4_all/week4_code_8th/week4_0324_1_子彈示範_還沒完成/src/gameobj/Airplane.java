package gameobj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Airplane extends GameObject {

    private static final int MOVE_SPEED = 4;
    private Image img;
    private int dir;

    public Airplane(final int x, final int y) {
        super(x, y, 77, 45);
        this.dir = 0;
        try {
            this.img = ImageIO.read(getClass().getResource("/airplane1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update() {
        if (this.dir == 0) {
            offsetX(MOVE_SPEED);
        } else {
            offsetX(-MOVE_SPEED);
        }
    }

    public void changeDir(final int x) {
        if (x() > x) {
            this.dir = 1;
        } else {
            this.dir = 0;
        }
    }

    @Override
    public void paint(final Graphics g) {
        g.drawImage(this.img, x(), y(), null);
    }


}


