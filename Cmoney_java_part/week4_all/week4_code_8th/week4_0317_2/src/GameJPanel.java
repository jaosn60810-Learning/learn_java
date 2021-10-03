import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameJPanel extends JPanel {

    private static final int MOVE_SPEED = 16;
    private Image img;
    private int x;
    private int y;
    private int dir;

    public GameJPanel() {
        x = 30;
        y = 500;
        dir = 0;
        try {
            img = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomMouseListener cm = new CustomMouseListener();
        addMouseListener(cm);
        addMouseMotionListener(cm);
    }

    public void move() {
        if (dir == 0) {
            x += MOVE_SPEED;
        } else {
            x -= MOVE_SPEED;
        }
    }

    public void changeDir(int x) {
        if (this.x > x) {
            dir = 1;
        } else {
            dir = 0;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    private class CustomMouseListener extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            changeDir(e.getX());
        }
    }
}
