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
                // 將加入的數量(itemNum)加到原本的是數量中(items[i].getCount())
                items[i].setCount(items[i].getCount() + itemNum);
                return;
            }
        }

        // 如果包包裡沒有相同的物品名稱就會執行到這裡，根據加入的物品名稱決定要新增哪個物品
        switch (itemName) {
            // 如果物品名稱是"cannedfood"
            case "cannedfood":
                // 在 bagCount 的位置創造一個 CannedFood 物件
                items[bagCount] = new CannedFood();
                // 將這個 CannedFood 物件的數量 ++
                items[bagCount].setCount(itemNum);
                // 增加 bagCount 的數量
                bagCount++;
                break;
            case "carton":
                items[bagCount] = new Carton();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "cathair":
                items[bagCount] = new CatHair();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "doghair":
                items[bagCount] = new DogHair();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "fishfood":
                items[bagCount] = new FishFood();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "fishscale":
                items[bagCount] = new FishScale();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "insectfood":
                items[bagCount] = new InsectFood();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "sawdust":
                items[bagCount] = new Sawdust();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "seaweed":
                items[bagCount] = new Seaweed();
                items[bagCount].setCount(itemNum);
                bagCount++;
                break;
            case "woodhouse":
                items[bagCount] = new WoodHouse();
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
        for (int i = 0; i < items.length; i++) {
            // 如果這個物品名稱(items[i].getName().toLowerCase())和傳入的物品名稱(itemName)相同
            if (items[i].getName().toLowerCase().equals(itemName)) {
                // 如果這個物品數量夠減 則減掉
                if (items[i].getCount() - itemNum > 0) {
                    items[i].setCount(items[i].getCount() - itemNum);
                }
                // 如果這個物品數量剛好扣完 則將物品從陣列中移除 並將 bagCount--
                else if (items[i].getCount() - itemNum == 0) {
                    items[i] = null;
                    bagCount--;
                }
                // 如果這個物品數量不扣減 則顯示"你沒有這麼多"
                else {
                    System.out.println("你沒有這麼多");
                }
                return;
            }
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
