package tool;

abstract class Item {
    private int limitSize = 20;
    public int count = 0;
    abstract String getTypeName();

    boolean addItem () {
        if (this.count >= this.limitSize) {
            return  false;
        }
        this.count += 1;
        return true;
    }

    boolean getItem() {
        if (this.count <= 0) {
            return false;
        }
        this.count -= 1;
        return true;
    }

    int getItemSize() {
        return this.count;
    }

}
