package com.company;

public class Zombie {
    //改
    public int zombieWave = 1; //
    public int zombieAttack; //


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
        //zombieWave ++ ;
        return zombieAttack;
    }

    public void showZombie(Date date,Villager villagers,Soldier soldiers,Resource resource){ //新增
        System.out.println();
        System.out.println("殭屍來襲: 第"+ zombieWave +"波");
        System.out.println("當前時間: " + date.time);
        System.out.println("市民: " + villagers.villagerNumber);
        System.out.println("士兵: " + soldiers.soliderNumber);
        System.out.println("當前木頭: " + resource.getWood());
        System.out.println("當前鐵礦: " + resource.getSteel());
        System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
        System.out.println();
    }

    public void successZombie(Soldier soldiers){ //新增
        //士兵打贏殭屍
        soldiers.soliderNumber=(soldiers.soliderLife * soldiers.soliderNumber-zombieAttack)/soldiers.soliderLife;
    }

    public void failZombie(Soldier soldiers,Villager villagers,Resource resource){ //新增
        //士兵打輸殭屍
        soldiers.soliderNumber=0;
        villagers.villagerNumber -= zombieAttack-(soldiers.soliderLife * soldiers.soliderNumber);
        //人民被攻擊，採集人數歸0，要重新分配人數
        resource.woodPeople = 0;
        resource.steelPeople= 0;
    }
}
