package gameobj;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CEnemy extends GameObject {

    private static Image img;
    private int d;

    public CEnemy(int x, int y, int d) {
        super(x, y, 50, 50);
        this.d = d;
        if (img == null) {
            try {
                img = ImageIO.read(getClass().getResource("/resources/enemy1.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
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
