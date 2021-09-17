package com.company;

public class Input {

    public static String randomInputString(String hint, int min, int max) {
        System.out.print(hint + ": ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Input.random(min, max); i++) {
            str.append((char) Input.random(97, 122));
        }
        System.out.println(str);
        return str.toString();
    }

    public static int randomInputNum(String hint,int min, int max) {
        System.out.print(hint + ": ");
        int randomNum = random(min,max);
        System.out.println(randomNum);
        return randomNum;
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
