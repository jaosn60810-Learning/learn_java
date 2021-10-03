package gameobj;

import utils.GameKernel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CEnemy implements GameKernel.GameInterface {
    private int x;
    private int y;
    private int d;
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

    public CEnemy(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.d = d;

        try {
            img = ImageIO.read(getClass().getResource("/resources/enemy1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean move() {
        y += 4;
        x += d;
        return y <= 600;
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    @Override
    public void update() {

    }
}
