package scene;

import utils.CommandSolver.*;

import java.awt.*;

public abstract class Scene {

    public abstract void sceneBegin();

    public abstract void sceneEnd();

    public abstract void paint(Graphics g);

    public abstract void update();

    public abstract MouseCommandListener mouseListener();

    public abstract KeyListener keyListener();
}
