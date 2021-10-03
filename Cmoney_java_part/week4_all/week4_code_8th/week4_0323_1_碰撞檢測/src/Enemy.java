import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Enemy implements GameKernel.UpdateInterface, GameKernel.PaintInterface {
    private Image img;
    private int x;
    private int y;
    private int d;

    public Enemy(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        try {
            this.img = ImageIO.read(getClass().getResource("/enemy1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean move() {
        this.y += 5;
        this.x += this.d;
        if (this.y >= 650) {
            return false;
        }
        return true;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, this.x, this.y, null);
    }

    @Override
    public void update() {

    }
}
