package tool;

import java.sql.SQLOutput;

public class Bag {
    private Base[] container = new Base[10];
    private Item[] container2 = new Item[10];
    private int currentBaseIndex = 0; // 現在加到背包第幾格
    private boolean isEmptyBag = true; // 確認是不是空背包

    public Bag() {
        Food food = new Food();
    }

    boolean addItem(Item item) {
        if (this.container2.length == 0) {
            container2[0].addItem();
        }
        return true;
    }

    void addItem(String typeName) {
        //如果是空背包就直接new一個Base出來
        if (isEmptyBag) {
            Base newBase = new Base(typeName);
            newBase.addItem();
            container[currentBaseIndex] = newBase;
            this.isEmptyBag = false;
        } else {
            for (int i = 0; i <= currentBaseIndex; i++) {
                Base currentBase = container[i];
                if (currentBase.checkIsSameItemAndNotFull(typeName)) {
                    // 放入物品
                    currentBase.addItem();
                    break;
                } else {
                    // 加一個新的Base，還有位置才加
                    if (currentBaseIndex < container.length - 1) {
                        currentBaseIndex += 1;
                        Base newBase = new Base(typeName);
                        newBase.addItem();
                        container[currentBaseIndex] = newBase;
                    }else{
                        System.out.println("背包滿了唷！可以去商店買背包格哦！");
                    }
                }
            }
        }
    }
    // 搜尋背包物品種類，取該物品第一個位置的一個單位
    boolean getItem(String typeName) {
        if (isEmptyBag) {
            return false;
        }
        boolean hasItem = false;
        for (int i = 0; i <= currentBaseIndex; i++) {
            if (container[i].checkIsSameItemAndNotEmpty(typeName)) {
                container[i].minusItem();
                hasItem = true;
                break;
            }
        }
        return hasItem; // 你已經拿成功
    }
    //背包目前用了幾格
    int getItemSize(String typeName) {
        int itemSize = 0;
        for (int i = 0; i <= this.currentBaseIndex; i++) {
            if (container[i].getTypeName() == typeName) {
                itemSize += container[i].getItemSize();
            }
        }
        return itemSize;
    }
//    String getItems(String typeName,int num) {
//        if (isEmptyBag) {
//            return null;
//        }
////        boolean hasItem = false;
//        for (int i = 0; i <= currentBaseIndex; i++) {
//            if (container[i].checkIsSameItemAndNotEmpty(typeName)) {
//                Base temp = container[i];
//                if (temp.getItemSize() < num) {
//                    return "數量不足";
//                }
//                container[i].minusItems(num);
//                return typeName;
////                hasItem = true;
//            }
//        }
//        return null;
//    }
}
