package gameobj;

import utils.GameKernel;
import utils.Global;

import java.awt.*;

import static utils.Global.IS_DEBUG;
import static utils.Global.SCREEN_Y;

public abstract class GameObject implements GameKernel.GameInterface {

    private Rect collider;
    private Rect painter;


    public GameObject(int x, int y, int width, int height) {
        collider = new Rect(x, y, width, height);
        painter = new Rect(x, y, width, height);
    }

    public GameObject(Rect rect) {
        collider = rect.clone();
        painter = rect.clone();
    }

    public GameObject(int x, int y, int width, int height,
                      int x2, int y2, int width2, int height2) {
        collider = new Rect(x, y, width, height);
        painter = new Rect(x2, y2, width2, height2);
        painter.setCenter(collider.centerX(), collider.centerY());
    }

    public GameObject(Rect rect, Rect rect2) {
        collider = rect.clone();
        painter = rect2.clone();
        painter.setCenter(rect.centerX(), rect.centerY());
    }

    public boolean touchTop() {
        return collider.top() <= 0;
    }

    public boolean touchLeft() {
        return collider.left() <= 0;
    }

    public boolean touchRight() {
        return collider.right() >= Global.SCREEN_X;
    }

    public boolean touchBottom() {
        return collider.bottom() >= Global.SCREEN_Y;
    }

    public boolean isCollision(GameObject obj) {
        return collider.overlap(obj.collider);
    }

    public final void translate(int x, int y) {
        collider.translate(x, y);
        painter.translate(x, y);
    }

    public final void translateX(int x) {
        collider.translateX(x);
        painter.translateX(x);
    }

    public final void translateY(int y) {
        collider.translateY(y);
        painter.translateY(y);
    }

    public final Rect collider() {
        return collider;
    }

    public final Rect painter() {
        return painter;
    }

    @Override
    public final void paint(Graphics g) {
        paintComponent(g);
        if (IS_DEBUG) {
            g.setColor(Color.red);
            collider.paint(g);
            g.setColor(Color.green);
            painter.paint(g);
            g.setColor(Color.black);
        }
    }

    public abstract void paintComponent(Graphics g);

}
