import java.util.Scanner;

public class java_26_TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TOH(n, 'A', 'B', 'C');


    }

    public static void TOH(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println(a + " to " + c);
            return;
        } else {
            TOH(n - 1, a, c, b);
            System.out.println(a + " to " + c);
            TOH(n - 1, b, a, c);


        }

    }
}
