package gameobj;

import utils.GameKernel;

import java.awt.*;

import static utils.Global.IS_DEBUG;

public abstract class GameObject implements GameKernel.GameInterface {

    private int x;
    private int y;
    private int width;
    private int height;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int width(){
        return width;
    }

    public int height() {
        return height;
    }

    public int left() {
        return x;
    }

    public int right() {
        return x + width;
    }

    public int top() {
        return y;
    }

    public int bottom() {
        return y + height;
    }

    public boolean isCollision(GameObject obj) {
        if (right() < obj.left()) {
            return false;
        }
        if (left() > obj.right()) {
            return false;
        }
        if (top() > obj.bottom()) {
            return false;
        }
        if (bottom() < obj.top()) {
            return false;
        }
        return true;
    }

    @Override
    public void paint(Graphics g) {
        paintComponent(g);
        if (IS_DEBUG) {
            g.setColor(Color.red);
            g.drawRect(x, y, width, height);
            g.setColor(Color.black);
        }
    }

    public abstract void paintComponent(Graphics g);

}
