package gameobj;

import controllers.SceneController;
import utils.Animator;
import utils.Animator.*;
import utils.Delay;
import utils.Global.*;
import utils.Path;

import java.awt.*;

public class Actor extends GameObject {

    private Animator animator;
    private State state;
    private Direction dir;

    public Actor(int x, int y, int type) {
        super(x, y, 64, 64);
        state = State.WALK;
        animator = new Animator(type,state);
        dir = Direction.RIGHT;
    }

    @Override
    public void paintComponent(Graphics g) {
        animator.paint(dir,
                painter().left(), painter().top(), painter().right(), painter().bottom(), g);
    }

    @Override
    public void update() {
        animator.update();
    }
}
