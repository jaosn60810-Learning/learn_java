package com.company;

public class Zombie {
    int zombieWave;
    int zombieAttack;

    public int getZombieWave() {
        return zombieWave;
    }
    public void setZombieWave(int wave) {
        this.zombieWave = wave;
    }

    public int getZombieAttack() {
        return zombieAttack;
    }
    public void setZombieAttack(int wave) {
        int zombieAttack;
        int zombieWave = wave;

        int zombieA = 5;
        int zombieB = 7;
        int zombieC = 10;
        int zombieD = 13;
        int zombieE = 17;
        int zombieF = 25;

        zombieAttack = zombieWave * 3 * zombieA + zombieWave / 10 * 5 * zombieB + zombieWave / 10 * 4 * zombieC +
                zombieWave / 10 * 3 * zombieD + zombieWave / 10 * 2 * zombieE + zombieWave / 10 * 1 * zombieF;

        this.zombieAttack = zombieAttack;
    }

//    int zombieLife;
//
//    int zombieA = 5;
//    int zombieB = 7;
//    int zombieC = 10;
//    int zombieD = 13;
//    int zombieE = 17;
//    int zombieF = 25;
//
//    zombieAttack = zombieWave * 3 * zombieA + zombieWave / 10 * 5 * zombieB + zombieWave / 10 * 4 * zombieC +
//    zombieWave / 10 * 3 * zombieD + zombieWave / 10 * 2 * zombieE + zombieWave / 10 * 1 * zombieF;

//    public int zombieAttack() {
//        return zombieLife;
//    }
}
