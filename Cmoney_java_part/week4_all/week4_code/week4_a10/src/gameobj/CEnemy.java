package gameobj;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CEnemy extends GameObject {

    private Image img;
    private int d;

    public CEnemy(int x, int y, int d) {
        super(x, y, 50, 50);
        this.d = d;

        try {
            img = ImageIO.read(getClass().getResource("/resources/enemy1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean move() {
        setY(top() + 4);
        setX(left() + d);
        return top() <= 600;
    }


    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, left(), top(), width(), height(), null);
    }

    @Override
    public void update() {

    }
}
