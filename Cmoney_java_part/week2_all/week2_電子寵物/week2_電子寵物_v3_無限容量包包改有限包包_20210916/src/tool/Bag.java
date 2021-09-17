package tool;

public class Bag {
    // 放置物品的陣列
    private Item[] items = new Item[10];
    // 包包的格子數
    private int bagCount = 0;


    /**
     * 將物品放到背包裡
     *
     * @param itemName String 傳入物品的名稱
     * @param itemNum  int 傳入物品的數量
     */
    public void addItem(String itemName, int itemNum) {
        // 將輸入的名稱統一轉換成小寫
        itemName = itemName.toLowerCase();


        // 掃過整個包包的物品陣列
        for (int i = 0; i < bagCount; i++) {
            // 如果這個物品名稱(items[i].getName().toLowerCase())和傳入的物品名稱(itemName)相同
            if (items[i].getName().toLowerCase().equals(itemName)) {
               // 如果此物品的數量加上要加的物品數量 <= 這個包包格可以儲存的最大空間
                if (items[i].getCount() + itemNum <= items[i].getItemsLimit()) {
                    // 將加入的數量(itemNum)加到原本的是數量中(items[i].getCount())
                    items[i].setCount(items[i].getCount() + itemNum);
                    //  並跳出此 Function
                    return;
                }
                // 如果不是(代表有一樣的名字 但包包格滿了)
                else {
                    // 將可以加進去的數量(包包格的上限 - 包包格中的物品數量)從要加的數量中( itemNum )扣除
                    itemNum -= items[i].getItemsLimit() - items[i].getCount();
                    // 將包包格補滿
                    items[i].setCount(items[i].getItemsLimit());
                }
            }
        }

        // 如果包包裡沒有相同的物品名稱
        // 或前面裝一樣物品的包包格已經滿了 就會執行到這裡
        // 根據加入的物品名稱決定要新增哪個物品
        switch (itemName) {
            // 如果物品名稱是"cannedfood"
            case "cannedfood":
                // 在 index 是 bagCount 的地方創建一個 CannedFood 物件
                items[bagCount] = new CannedFood();
                // 如果要加入的物品數量 > 這個包包格的上限
                while (itemNum > items[bagCount].getItemsLimit()) {
                    // 將可以加進去的數量(包包格的上限 - 包包格中的物品數量)從要加的數量中( itemNum )扣除
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    // 將包包格補滿
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    // 將包包物品數量 + 1
                    bagCount++;
                    // 在 index 是 bagCount 的地方創建一個 CannedFood 物件
                    items[bagCount] = new CannedFood();
                }
                // 迴圈結束後可以確認要加的物品 <= 這個包包格的上限
                items[bagCount].setCount(itemNum);
                // 將包包物品數量 + 1
                bagCount++;
                break;
            case "carton":
                items[bagCount] = new Carton();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new Carton();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "cathair":
                items[bagCount] = new CatHair();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new CatHair();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "doghair":
                items[bagCount] = new DogHair();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new DogHair();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "fishfood":
                items[bagCount] = new FishFood();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new FishFood();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "fishscale":
                items[bagCount] = new FishScale();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new FishScale();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "insectfood":
                items[bagCount] = new InsectFood();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new InsectFood();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "sawdust":
                items[bagCount] = new Sawdust();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new Sawdust();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "seaweed":
                items[bagCount] = new Seaweed();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new Seaweed();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "woodhouse":
                items[bagCount] = new WoodHouse();
                while (itemNum > items[bagCount].getItemsLimit()) {
                    itemNum -= items[bagCount].getItemsLimit() - items[bagCount].getCount();
                    items[bagCount].setCount(items[bagCount].getItemsLimit());
                    bagCount++;
                    items[bagCount] = new WoodHouse();
                }
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
        }
    }

    /**
     * 將從背包裡移除
     *
     * @param itemName String 移除物品的名稱
     * @param itemNum  int 移除物品的數量
     */
    public void minusItem(String itemName, int itemNum) {
        // 將輸入的名稱統一轉換成小寫
        itemName = itemName.toLowerCase();

        // 掃過整個包包的物品陣列
        for (int i = items.length - 1; i > -1; i--) {
            // 如果是空值跳過
            if (items[i] == null) {
                continue;
            }
            // 如果這個物品名稱(items[i].getName().toLowerCase())和傳入的物品名稱(itemName)相同
            if (items[i].getName().toLowerCase().equals(itemName)) {
                // 如果這個物品數量夠減
                if (items[i].getCount() - itemNum > 0) {
                    // 則扣除包包裡此物品的數量
                    items[i].setCount(items[i].getCount() - itemNum);
                    //  並跳出此 Function
                    return;
                }
                // 如果這個物品數量減完為零
                else if (items[i].getCount() - itemNum == 0) {
                    // 則將包包裡此物品變成 null
                    items[i] = null;
                    // 將包包物品數量-1
                    bagCount--;
                    //  並跳出此 Function
                    return;
                }
                // 如果這個物品數量不夠減
                else {
                    // 將夠減的物品從 itemNum 裡扣掉
                    itemNum -= items[i].getCount();
                    // 則將包包裡此物品變成 null
                    items[i] = null;
                    // 將包包物品數量-1
                    bagCount--;
                }
            }
        }
        // 如果要扣除的物品還有剩
        if (itemNum > 0) {
            // 印出缺少的數量和物品名稱
            System.out.println("你還缺 " + itemNum + " 個 " + itemName);
        }
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }
}
