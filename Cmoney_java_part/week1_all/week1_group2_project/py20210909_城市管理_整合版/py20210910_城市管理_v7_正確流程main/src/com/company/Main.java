package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 設置初始村名數量
        Villager villagers = new Villager();
        villagers.villagerLife(1);
        villagers.villagerNumber(35);
        villagers.villagerLevel = 1;
        int passTime = 0;
        // 設置初始時間
        Date date = new Date();
        date.time(0);

        // 設置初始士兵數量
        Soldier soldiers = new Soldier();
        soldiers.soliderLife(2);
        soldiers.soliderNumber(10);
        soldiers.soliderLevel = 1;

        //設置殭屍
        Zombie zombie = new Zombie();//新增
        boolean start = true;//新增

        // 設置初始資源和初始採集速度
        Resource resource = new Resource(0, 0);//新增
        resource.woodEfficiency = 3;//木材效率
        resource.steelEfficiency = 1;//鋼鐵效率

        // 設置狀態顯示
        Status status = new Status(); //新增

        // 設置建築物
        BuildingArray buildingArray = new BuildingArray();

        while (villagers.villagerNumber>0) {
            //==========================================資源增加

            // 輸入指令
            String order = sc.nextLine();
            order = order.toLowerCase();
            String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");

            // 建造指令
            if (orderArray[0].equals("build")) {
                int buildingNumber = Integer.parseInt(orderArray[1]);
                buildingArray.buildBuildings(date.time, resource, buildingNumber);
            }

            // 升級指令
            if (orderArray[0].equals("upgrade")) {
                if (buildingArray.isUniversityExisting()) {
                    int buildingNumber = Integer.parseInt(orderArray[1]);
                    buildingArray.upgradeBuildings(date.time, resource, buildingNumber);
                } else {
                    System.out.println("請先建造研究所");
                }

            }

            // 採集分配指令
            if (orderArray[0].equals("dist")) {
                //System.out.println("請輸入2個參數分配採集木頭與鋼鐵人數 如\n2 4");
                resource.distribution(Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
                if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople) {
                    System.out.println(resource.getDistribution());
                } else {
                    System.out.println("超出總人數");
                    resource.distribution(0, 0);
                }
            }

            // 顯示狀態指令
            if (orderArray[0].equals("status")) {
                status.showStatus(date, villagers, soldiers, resource, buildingArray);//秀出資訊
            }

            // 時間前進指令
//---------------------------------------------------------------------//新增
            
            
            if (orderArray[0].substring(0,4).equals("next")) { //1小時
                switch(orderArray[0].substring(4)){
                    case "hour":
                        passTime = 1;
                        break;
                    case "halfday":
                        passTime = 12;
                        break;
                    case "day":
                        passTime = 24;
                        break;
                }
            //=================================================================for
                int tmp = passTime;
                for (int i = 0; i < tmp; i++) {
                    date.nextHour();
                    date.time++;
                    resource.resourceTime = 1;
                    resource.woodAdd();//新增
                    resource.steelAdd();//新增
                // 產生村民和士兵
                    buildingArray.buildingsGeneratePeople(buildingArray.getBuildings(), date.time, villagers);
                    buildingArray.buildingsGenerateSoldiers(buildingArray.getBuildings(), date.time, soldiers);
                //升級
                    buildingArray.isAnyBuildingsNeedUpgrade(date.time, resource);

                    if (date.time % 16 == 0) {
                        zombie.zombieWave = date.time / 16;
                        zombie.setZombieAttack();
                        if (zombie.zombieAttack >= soldiers.soliderLife * soldiers.soliderNumber) {
                            //失敗
                            zombie.failZombie(soldiers, villagers, resource);
                            zombie.showZombie(date, villagers, soldiers, resource);
                            resource.distribution(0, 0);
                            System.out.println("請重新分配採集木頭與鋼鐵人數 如:woodsteel 2 4");
                        } else if (zombie.zombieAttack < soldiers.soliderLife * soldiers.soliderNumber) {
                            //成功
                            zombie.successZombie(soldiers);
                            zombie.showZombie(date, villagers, soldiers, resource);
                        }
                    }
                    if (i == tmp-1) { //最後執行次數顯示狀態
                        status.showStatus(date, villagers, soldiers, resource, buildingArray);//秀出資訊
                    }

                }

            }
//-----------------------------------------------------------------------------
        }
    }
}
