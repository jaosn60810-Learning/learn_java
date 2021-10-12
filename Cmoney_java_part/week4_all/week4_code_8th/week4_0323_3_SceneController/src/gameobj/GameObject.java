package gameobj;

import utils.GameKernel;

public abstract class GameObject implements GameKernel.UpdateInterface, GameKernel.PaintInterface {
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

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public void offsetX(final int x) {
        this.x += x;
    }

    public void offsetY(final int y) {
        this.y += y;
    }

    public void offset(final int x, final int y) {
        offsetX(x);
        offsetY(y);
    }

    public int left() {
        return this.x;
    }

    public int right() {
        return this.x + this.width;
    }

    public int top() {
        return this.y;
    }

    public int bottom() {
        return this.y + this.height;
    }

    public boolean isCollision(final GameObject obj) {
        if (left() > obj.right()) {
            return false;
        }
        if (right() < obj.left()) {
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
}
