package com.company;

/** 產生隨機資料用
 *
 */
public class Input {
    /** 隨機產生從 min~max 長度的字串，字串由隨機的 26個英文小寫字母組成
     * @param hint 跑出的提示
     * @param min  隨機字串最小長度
     * @param max  隨機字串最大長度
     * @return String 回傳隨機字串
     */
    public static String randomInputString(String hint, int min, int max) {
        System.out.print(hint + ": ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Input.random(min, max); i++) {
            str.append((char) Input.random(97, 122));
        }
        System.out.println(str);
        return str.toString();
    }

    /** 隨機產生從 min~max 範圍的數字
     * @param hint 跑出的提示
     * @param min 隨機數字最小值
     * @param max 隨機數字最大值
     * @return int 隨機數字
     */
    public static int randomInputNum(String hint,int min, int max) {
        System.out.print(hint + ": ");
        int randomNum = random(min,max);
        System.out.println(randomNum);
        return randomNum;
    }

    /** 隨機產生從 min~max 範圍的數字
     * @param min 隨機數字最小值
     * @param max 隨機數字最大值
     * @return int 隨機數字
     */
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
