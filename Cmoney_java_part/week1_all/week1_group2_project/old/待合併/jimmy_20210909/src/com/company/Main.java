package com.company;

public class Main {

    public static void main(String[] args) {
        Zombie zombie = new Zombie();
        for (int i = 9; i <= 20 ; i++) {
            zombie.setZombieAttack(i);
            System.out.println(zombie.zombieAttack);
        }
    }
}
