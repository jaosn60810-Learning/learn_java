package tool;

public class Bag {
    private Item[] items = {new CannedFood(), new Carton(), new CatHair(),
            new DogHair(), new FishFood(), new FishScale(),
            new InsectFood(), new Sawdust(), new Seaweed(), new WoodHouse()};


    public void addItem(String itemName, int itemNum) {
        itemName = itemName.toLowerCase();
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().toLowerCase().equals(itemName)) {
                items[i].setCount(items[i].getCount() + itemNum);
                return;
            }
        }
    }

    public void minusItem(String itemName, int itemNum) {
        itemName = itemName.toLowerCase();
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().toLowerCase().equals(itemName)) {
                if (items[i].getCount() - itemNum >= 0) {
                    items[i].setCount(items[i].getCount() - itemNum);
                } else {
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
}
