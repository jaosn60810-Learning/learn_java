import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameJPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        try {
            Image image = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
            g.drawImage(image, 50, 50, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
