import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Airplane implements GameKernel.UpdateInterface
        , GameKernel.PaintInterface, CommandSolver.MouseListener {

    private static final int MOVE_SPEED = 16;
    private Image img;
    private int x;
    private int y;
    private int dir;

    public Airplane() {
        x = 30;
        y = 500;
        dir = 0;
        try {
            img = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
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
            dir = 1;
        } else {
            dir = 0;
        }
    }

    @Override
    public void paint(final Graphics g) {
        g.drawImage(this.img, this.x, this.y, null);
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        if(state == CommandSolver.MouseState.MOVED){
            this.changeDir(e.getX());
        }
    }
}


