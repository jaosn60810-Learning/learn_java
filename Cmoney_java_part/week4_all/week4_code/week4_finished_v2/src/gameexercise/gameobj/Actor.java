package gameexercise.gameobj;

import controllers.SceneController;
import gameexercise.utils.Animator;
import gameexercise.utils.Animator.State;
import gameexercise.utils.Delay;
import static gameexercise.utils.Global.*;
import gameexercise.utils.Path;
import java.awt.Graphics;
import java.awt.Image;

public class Actor extends GameObject{

    private Animator animator;
    private State state;
    private Direction dir;


    public Actor(int x, int y, int type){
        super(x , y , UNIT_X * 2, UNIT_Y *2);
        state = State.WALK;
        animator = new Animator(type, state);
        dir = Direction.RIGHT;
    }


    @Override
    public void paintComponent(Graphics g) {
        animator.paint(dir, painter().left(), painter().top(),
                painter().right(), painter().bottom(), g);
    }

    @Override
    public void update() {
        animator.update();
    }

}