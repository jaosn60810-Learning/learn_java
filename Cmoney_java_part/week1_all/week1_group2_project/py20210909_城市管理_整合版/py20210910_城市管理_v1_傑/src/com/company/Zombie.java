package com.company;

public class Zombie {
    private int zombieWave = 1;
    private int zombieAttack;


    public int getZombieAttack() {
        return zombieAttack;
    }
    public int setZombieAttack() {
        int wave = zombieWave;

        int zombieA = 5;
        int zombieB = 7;
        int zombieC = 10;
        int zombieD = 13;
        int zombieE = 17;
        int zombieF = 25;

        zombieAttack = wave * 3 * zombieA + wave / 10 * 5 * zombieB + wave / 10 * 4 * zombieC +
                wave / 10 * 3 * zombieD + wave / 10 * 2 * zombieE + wave / 10 * 1 * zombieF;
        zombieWave ++ ;
        return zombieAttack;
    }

}
