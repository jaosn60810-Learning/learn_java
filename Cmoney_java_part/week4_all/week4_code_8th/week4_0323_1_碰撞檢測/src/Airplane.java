import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Airplane implements GameKernel.UpdateInterface
        , GameKernel.PaintInterface {

    private static final int MOVE_SPEED = 16;
    private Image img;
    private int x;
    private int y;
    private int dir;

    public Airplane(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.dir = 0;
        try {
            this.img = ImageIO.read(getClass().getResource("/airplane1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isCollision(Enemy e) {
        final int left1 = this.x;
        final int left2 = e.getX();
        final int right1 = this.x + 77;
        final int right2 = e.getX() + 48;
        final int top1 = this.y;
        final int top2 = e.getY();
        final int bottom1 = this.y + 45;
        final int bottom2 = e.getY() + 44;
        if (left1 > right2) {
            return false;
        }
        if (right1 < left2) {
            return false;
        }
        if (top1 > bottom2) {
            return false;
        }
        if (bottom1 < top2) {
            return false;
        }
        return true;
    }

    @Override
    public void update() {
        if (this.dir == 0) {
            this.x += MOVE_SPEED;
        } else {
            this.x -= MOVE_SPEED;
        }
    }

    public void changeDir(final int x) {
        if (this.x > x) {
            this.dir = 1;
        } else {
            this.dir = 0;
        }
    }

    @Override
    public void paint(final Graphics g) {
        g.drawImage(this.img, this.x, this.y, null);
    }


}


