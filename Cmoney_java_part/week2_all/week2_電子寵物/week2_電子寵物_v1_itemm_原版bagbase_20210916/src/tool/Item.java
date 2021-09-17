package tool;

abstract class Item {
    private int limitSize = 20;
    public int count = 0;
    private String name;
    private int buyIn;
    private int sellOut;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuyIn() {
        return buyIn;
    }

    public void setBuyIn(int buyIn) {
        this.buyIn = buyIn;
    }

    public int getSellOut() {
        return sellOut;
    }

    public void setSellOut(int sellOut) {
        this.sellOut = sellOut;
    }
}
