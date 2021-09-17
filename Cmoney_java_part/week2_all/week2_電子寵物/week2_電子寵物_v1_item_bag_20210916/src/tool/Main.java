package tool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        item.addItem(new CannedFood());
        item.addItem(new CannedFood());
        item.addItem(new CannedFood());
        for (int i = 0; i < item.getItems().length; i++) {
            System.out.println(Arrays.toString(item.getItems()[i]));
        }
        System.out.println(Arrays.toString(item.howManyItemsInThisGrid()));

    }
}
