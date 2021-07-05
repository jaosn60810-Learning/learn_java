public class Rectangle {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setWidth(int width) {
        if (width <= 0)
            this.width = 1;
        this.width = width;
    }

    public void setHeight(int height) {
        if (height <= 0)
            this.height = 1;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getArea() {
        return this.getWidth() * this.getHeight();
    }

    public int getParameter() {
        return (this.getWidth() + this.getHeight()) * 2;
    }

    public int compare(Rectangle rect2) {
        return this.getArea() - rect2.getArea();
    }

}
