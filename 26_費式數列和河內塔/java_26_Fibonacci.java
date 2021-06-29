import java.util.Scanner;

public class java_26_Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        use recursion
//        for(int i =0;i<n;i++)
//            System.out.println(FS(i));

//        use loop
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int tmp;
            tmp = b;
            b = a + b;
            a = tmp;
            System.out.println(a);

        }


    }

    public static int FS(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return FS(n - 1) + FS(n - 2);
    }
}
