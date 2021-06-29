import java.util.Arrays;
import java.util.Scanner;

public class java_hw_24 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strs = new String[2];
        int[] strsn = new int[2];
        int count = 0;

        while (true) {
            String str = sc.nextLine();
            if (str.equals("-1"))
                break;
            if (strs.length == count) {
                strs = DA(strs);
                strsn = DAint(strsn);
            }
            int index = FIWK(strs,str,count);
            if(index == -1){
                strs[count] = str;
                index = count++;
            }
            strsn[index]++;
        }
        System.out.println(Arrays.toString(strs));
        System.out.println(Arrays.toString(strsn));
    }


    public static int FIWK(String[] arr, String key, int count) {
        for (int i = 0; i < count; i++) {
            if (arr[i].equals(key))
                return i;
        }
        return -1;
    }

    public static String[] DA(String[] strs) {
        String[] newstrs = new String[strs.length * 2];
        for (int i = 0; i < strs.length; i++)
            newstrs[i] = strs[i];
        return newstrs;
    }

    public static int[] DAint(int[] strs) {
        int[] newstrs = new int[strs.length * 2];
        for (int i = 0; i < strs.length; i++)
            newstrs[i] = strs[i];
        return newstrs;
    }

}