import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Airplane implements GameKernel.UpdateInterface
        , GameKernel.PaintInterface {

    private static final int MOVE_SPEED = 16;
    private Image img;
    private int x;
    private int y;
    private int dir;

    public Airplane(final int x,final  int y) {
        this.x = x;
        this.y = y;
        this.dir = 0;
        try {
            this. img = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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


