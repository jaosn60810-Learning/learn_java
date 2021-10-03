package gameobj;

import utils.Animator;
import utils.Animator.State;

import static utils.Global.*;

import java.awt.Graphics;

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