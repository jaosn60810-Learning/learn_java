package gameobj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Boom extends GameObject {
    private static final int MOVE_SPEED = 3;
    private Image img1;
    private Image img2;
    private int state;

    public Boom(int x, int y) {
        super(x, y, 34, 40);
        this.state = 0;
        try {
            this.img1 = ImageIO.read(getClass().getResource("/boom.png"));
            this.img2 = ImageIO.read(getClass().getResource("/boom2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        if (this.state == 0) {
            g.drawImage(this.img1, x(), y(), null);
            return;
        }
        g.drawImage(this.img2, x(), y(), null);

    }

    public void changeState() {
        this.state = 1;
    }

    public boolean isDead() {
        return this.state >= 30;
    }

    public boolean isAlive() {
        return this.state == 0;
    }

    @Override
    public void update() {
        if (this.state == 0) {
            offsetY(-MOVE_SPEED);
            return;
        }

        this.state++;

    }
}
