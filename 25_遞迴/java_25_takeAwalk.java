import java.util.Scanner;

public class java_25_takeAwalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        tAw(0, d);
    }

    public static void tAw(int i, int d) {
        if (i < d) {
            i++;
            System.out.println("you take a step : " + i);
            tAw(i, d);
        } else
            System.out.println("done" + i);


    }
}
