package tool;

import java.util.Arrays;

public class Item {
    private String name;
    private int buyIn;
    private int sellOut;
    private Item[][] items;


    /**
     * 加入物品到 Item 的 items 屬性裡
     *
     * @param item
     */
    public void addItem(Item item) {
        // 如果有一樣的物品且物品疊加數量(howManyItemsInThisGrid)小於包包格的最大疊加數量(this.items[0].length)，則疊加再一起
        for (int i = 0; i < this.items.length; i++) {
            // 如果此包包格的第一個物品不是 null，則判斷使否能疊加
            if (this.items[i][0] != null) {
                // 判斷此包包格的第一個物品是不是一樣的物件
                boolean AreThereSameItems = this.items[i][0].getName().equals(item.getName());
                // 判斷此包包格的疊加數量
                int howManyItemsInThisGrid = this.howManyItemsInThisGrid()[i];
                // 如果 AreThereSameItems  &&  howManyItemsInThisGrid 小於包包格的最大疊加數量，將 item 放到 this.items[i][howManyItemsInThisGrid] 裡
                if (howManyItemsInThisGrid < this.items[0].length && AreThereSameItems) {
                    this.items[i][howManyItemsInThisGrid] = item;
                    return;
                }

            } else {
                // 判斷此包包格的疊加數量
                int howManyItemsInThisGrid = this.howManyItemsInThisGrid()[i];
                // 將 item 放到 this.items[i][howManyItemsInThisGrid] 裡
                this.items[i][howManyItemsInThisGrid] = item;
                return;
            }
        }
    }

    public int[] howManyItemsInThisGrid() {
        int[] bagSpace = new int[this.items.length];
        int count = 0;
        for (int i = 0; i < this.items.length; i++) {
            for (int j = 0; j < this.items[i].length; j++) {
                if (this.items[i][j] != null) {
                    count++;
                }
            }
            bagSpace[i] = count;
            count = 0;
        }
        return bagSpace;
    }

    public Item() {
        this.items = new Item[2][2];
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

    public Item[][] getItems() {
        return items;
    }

    public void setItems(Item[][] items) {
        this.items = items;
    }
}
