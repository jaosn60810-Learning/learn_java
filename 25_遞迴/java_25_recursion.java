import java.util.Scanner;

public class java_25_recursion{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(f(3));
    }
    public static int f(int x) {
        if(x==1)
            return 1;
        return f(x-1)+x;

    }
}
