package tool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bag b = new Bag();
        b.addItem(new CannedFood());
        System.out.println(Arrays.toString(b.getContainer()));
        System.out.println(Arrays.toString(b.getContainer2()));
    }
}
