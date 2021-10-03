package gameobj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Enemy extends GameObject {
    private Image img;
    private int d;

    public Enemy(final int x, final int y, final int d) {
        super(x, y, 48, 44);
        this.d = d;
        try {
            this.img = ImageIO.read(getClass().getResource("/enemy1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isOutOfBound() {
        if (y() >= 650) {
            return false;
        }
        return true;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, x(), y(), null);
    }

    @Override
    public void update() {
        offsetY(5);
        offsetX(this.d);
    }
}
