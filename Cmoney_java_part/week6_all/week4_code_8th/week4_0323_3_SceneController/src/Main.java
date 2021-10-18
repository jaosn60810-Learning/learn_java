import controller.SceneController;
import utils.CommandSolver;
import utils.GameKernel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final JFrame jFrame = new JFrame();

        final SceneController sceneController = new SceneController(new GameScene());

        final GameKernel gameKernel = new GameKernel.Builder()
                .input(new CommandSolver.BuildStream()
                        .mouseTrack().subscribe(sceneController)
                        .keyboardTrack()
                        .next().keyCleanMode().subscribe(sceneController)
                )
                .paint(sceneController)
                .update(sceneController)
                .gen();

        jFrame.setTitle("Game 9th");
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(gameKernel);

        jFrame.setVisible(true);

        gameKernel.run();

    }
}
