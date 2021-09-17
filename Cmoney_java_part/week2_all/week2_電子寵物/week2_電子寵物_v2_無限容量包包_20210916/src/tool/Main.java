package tool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bag b = new Bag();
        b.addItem("Cannedfood",3);
        System.out.println(Arrays.toString(b.getItems()));
        b.minusItem("Cannedfood",2);
        System.out.println(Arrays.toString(b.getItems()));
        b.minusItem("Cannedfood",2);
        System.out.println(Arrays.toString(b.getItems()));
    }
}
