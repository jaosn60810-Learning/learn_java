package gameobj;

import java.awt.*;

public class Rect {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public final Rect translate(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public final Rect translateX(int x) {
        this.x += x;
        return this;
    }

    public final Rect translateY(int y) {
        this.y += y;
        return this;
    }

    public final Rect scale(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public final Rect scaleX(int width) {
        this.width = width;
        return this;
    }

    public final Rect scaleY(int height) {
        this.height = height;
        return this;
    }

    public final int centerX() {
        return x + width / 2;
    }

    public final int centerY() {
        return y + height / 2;
    }

    public final void setCenter(int x, int y) {
        this.x = x - width / 2;
        this.y = y - height / 2;
    }

    public final int width() {
        return width;
    }

    public final int height() {
        return height;
    }

    public final int left() {
        return x;
    }

    public final int right() {
        return x + width;
    }

    public final int top() {
        return y;
    }

    public final int bottom() {
        return y + height;
    }

    public final boolean overlap(Rect obj) {
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

    public final Rect clone() {
        return new Rect(left(), top(), width(), height());
    }

    public final void paint(Graphics g) {
        g.drawRect(x, y, width, height);
    }
}
