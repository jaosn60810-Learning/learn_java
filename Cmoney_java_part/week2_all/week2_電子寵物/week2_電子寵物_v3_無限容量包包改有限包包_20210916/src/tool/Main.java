package tool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bag b = new Bag();
        b.addItem("Cannedfood",2);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("fishfood",5);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("Cannedfood",5);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("fishfood",4);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.minusItem("Cannedfood",1000);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.minusItem("Fishfood",1000);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("fishfood",3);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();

        b.addItem("cannedfood",3);
        System.out.println(Arrays.toString(b.getItems()));
        System.out.println(b.getBagCount());
        System.out.println();
    }
}
