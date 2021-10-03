import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Airplane implements GameKernel.UpdateInterface, GameKernel.PaintInterface {

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

    }

    public void changeDir(int x) {
        if (this.x > x) {
            dir = 1;
        } else {
            dir = 0;
        }
    }

    @Override
    public void paint(Graphics g) {

    }
}


