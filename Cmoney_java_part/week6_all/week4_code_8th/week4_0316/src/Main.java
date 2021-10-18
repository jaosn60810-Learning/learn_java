import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        GameJPanel gameJPanel = new GameJPanel();
        jFrame.setTitle("Game 9th");
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(gameJPanel);

        jFrame.setVisible(true);
    }
}
