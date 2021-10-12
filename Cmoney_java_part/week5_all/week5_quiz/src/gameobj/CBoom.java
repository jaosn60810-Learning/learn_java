package gameobj;

import controllers.ImageController;
import controllers.SceneController;
import utils.Delay;
import utils.Path;

import java.awt.*;

public class CBoom extends GameObject {
    public enum State {
        NORMAL,
        BOOM,
        REMOVED;
    }

    private Image img1, img2;
    private State state;
    private Delay delay;

    public CBoom(int x, int y) {
        super(x, y, 50, 50);
        state = State.NORMAL;
        img1 =  SceneController.instance().irc().tryGetImage(new Path().img().objs().boom());
        img2 =  SceneController.instance().irc().tryGetImage(new Path().img().objs().boom2());
        delay = new Delay(30);
    }

    @Override
    public void paintComponent(Graphics g) {
        switch (state) {
            case NORMAL:
                g.drawImage(img1,
                        painter().left(),
                        painter().top(),
                        painter().width(),
                        painter().height(), null);
                break;
            case BOOM:
                g.drawImage(img2,
                        painter().left(),
                        painter().top(),
                        painter().width(),
                        painter().height(), null);
                break;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public void update() {
        if (state == State.NORMAL) {
            translateY(-8);
        } else if (state == State.BOOM) {
            delay.play();
        }

        if (delay.count()) {
            state = State.REMOVED;
        }
    }
}
