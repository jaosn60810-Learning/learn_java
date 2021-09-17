package tool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Item[] i = new Item[4];
        i[0] = new CatHair();
        i[1] = new CannedFood();
        System.out.println(Arrays.toString(i));
    }
}
