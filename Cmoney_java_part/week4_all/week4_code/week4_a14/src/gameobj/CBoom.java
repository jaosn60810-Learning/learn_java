package gameobj;

import controllers.ImageController;
import utils.Delay;
import utils.Path;

import java.awt.*;

public class CBoom extends GameObject {
    private Image img1, img2;
    private int state;
    private Delay delay;

    public CBoom(int x, int y) {
        super(x, y, 50, 50);
        state = 0;
        img1 = ImageController.instance().tryGetImage(new Path().img().objs().boom());
        img2 = ImageController.instance().tryGetImage(new Path().img().objs().boom2());
        delay = new Delay(30);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (state == 0) {
            g.drawImage(img1,
                    painter().left(),
                    painter().top(),
                    painter().width(),
                    painter().height(), null);
        } else {
            g.drawImage(img2,
                    painter().left(),
                    painter().top(),
                    painter().width(),
                    painter().height(), null);
        }
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    @Override
    public void update() {
        if (state == 0) {
            translateY(-8);
        } else if (state == 1) {
            delay.play();
        }

        if (delay.count()) {
            state = 2;
        }
    }
}
