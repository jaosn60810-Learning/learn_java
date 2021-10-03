import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        final JFrame jFrame = new JFrame();
        final GameJPanel gameJPanel = new GameJPanel();
        jFrame.setTitle("Game 9th");
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(gameJPanel);

        jFrame.setVisible(true);

        //一個程式可以有多個執行續(平行處理)

        Timer timer = new Timer(100, e -> {
            gameJPanel.move();
            jFrame.repaint();
        });
        timer.start();
    }
}
