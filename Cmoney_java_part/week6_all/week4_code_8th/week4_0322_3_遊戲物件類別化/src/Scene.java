import java.awt.*;
import java.awt.event.MouseEvent;

public class Scene implements GameKernel.PaintInterface, GameKernel.UpdateInterface
        , CommandSolver.MouseListener {

    private Airplane airplane;

    public Scene() {
        this.airplane = new Airplane(30,500);
    }

    @Override
    public void mouseTrig(final MouseEvent e, final CommandSolver.MouseState state, final long trigTime) {
        if (state == CommandSolver.MouseState.MOVED) {
            this.airplane.changeDir(e.getX());
        }
    }

    @Override
    public void paint(Graphics g) {
        this.airplane.paint(g);
    }

    @Override
    public void update() {
        this.airplane.update();
    }

}
