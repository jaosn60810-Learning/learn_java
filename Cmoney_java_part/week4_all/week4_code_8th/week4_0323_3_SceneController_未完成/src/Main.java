import utils.CommandSolver;
import utils.GameKernel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final JFrame jFrame = new JFrame();

        Scene scene = new Scene();

        final GameKernel gameKernel = new GameKernel.Builder()
                .input(new CommandSolver.BuildStream()
                        .mouseTrack().subscribe(scene)
                )
                .paint(scene)
                .update(scene)
                .gen();

        jFrame.setTitle("Game 9th");
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(gameKernel);

        jFrame.setVisible(true);

        gameKernel.run();

    }
}
