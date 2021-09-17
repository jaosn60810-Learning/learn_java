package tool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bag b = new Bag();
        b.addItem("Cannedfood",3);
        b.addItem("cathair",2);
        b.addItem("Cannedfood",18);
        b.addItem("cathair",19);
        b.addItem("Cannedfood",18);

        for (int i = 0; i <b.getItems().size(); i++) {
            System.out.println(b.getItems().get(i));
        }

    }
}
