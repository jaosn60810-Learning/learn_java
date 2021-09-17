package tool;

abstract class Item {
  private String name;
  private int buyIn;
  private  int sellOut;

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


    public abstract String toString();
}
