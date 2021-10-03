package gameobj;

import utils.GameKernel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CEnemy implements GameKernel.GameInterface {
    private int x;
    private int y;
    private int d;
    private Image img;

    public CEnemy(int x, int y, int d) {
        this.x = x;
        this.y = y;
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
        g.drawImage(img, x, y, null);
    }

    @Override
    public void update() {

    }
}
