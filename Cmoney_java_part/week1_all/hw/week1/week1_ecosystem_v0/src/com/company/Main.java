package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ecosystem ecosystem = new Ecosystem(5, 7);
        ecosystem.putSprite(new Horse(0, 0));
        ecosystem.putSprite(new Horse(1, 2));

        while (true) {

            ecosystem.start();
        }
    }
}
