package com.company;

public class Input {

    public String randomInputString(String hint, int min, int max) {
        System.out.println(hint + ":");
        String str = "";
        for (int i = 0; i < randomInputNum(min, max); i++) {
            str += (char) this.randomInputNum(97, 122);
        }
        System.out.println("自動產生 " + str);
        return str;
    }


    public int[] randomInputDate(String hint) {
        System.out.println(hint + ":");
        int[] date = {this.randomInputNum(2000, 2002), this.randomInputNum(1, 3), this.randomInputNum(1, 3)};
        return date;
    }

    public int randomInputNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
