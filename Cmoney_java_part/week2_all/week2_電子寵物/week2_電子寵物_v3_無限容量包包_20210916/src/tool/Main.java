package tool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bag b = new Bag();
        b.addItem("Cannedfood",3);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("fishfood",2);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("Cannedfood",2);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.minusItem("Fishfood",1);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("Cannedfood",6);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.minusItem("Fishfood",1);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("Sawdust",2);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();
    }
}
