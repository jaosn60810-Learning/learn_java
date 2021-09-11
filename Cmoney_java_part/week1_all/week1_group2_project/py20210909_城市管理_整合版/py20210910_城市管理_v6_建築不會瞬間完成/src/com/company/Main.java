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

        while (start) {
            // 產生村民和士兵
            buildingArray.buildingsGeneratePeople(buildingArray.getBuildings(), date.time, villagers);
            buildingArray.buildingsGenerateSoldiers(buildingArray.getBuildings(), date.time, soldiers);

            // 輸入指令

            //升級
            buildingArray.isAnyBuildingsNeedUpgrade(date.time, resource);

            String order = sc.nextLine();
            order = order.toLowerCase();
            String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");

            // 建造指令
//            if (orderArray[0].equals("build")) {
//                int buildingNumber = Integer.parseInt(orderArray[1]);
//                buildingArray.buildBuildings(date.time, resource, buildingNumber);
//            }
            if (orderArray[0].equals("build")) {
                int buildingNumber = Integer.parseInt(orderArray[1]);
                int buildingExist = 0;
                for (int i = 0; i < resource.buildingPeople.size(); i++) {
                    if (resource.buildingPeople.get(i)[1] == buildingNumber) {
                        buildingExist = 1;
                    }
                }
                if (buildingExist == 1) {
                    System.out.println("已配置!");
                } else {
                    int opt = Integer.parseInt(orderArray[2]);
                    //(編號,動作)
                    resource.changeBuildingStatus(buildingNumber, opt);
                }
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
            if (orderArray[0].equals("woodsteel")) {
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

            //如果指令試next開頭 更改需要跳過的時間
            if (orderArray[0].substring(0, 4).equals("next")) {
                System.out.println(orderArray[0].substring(0, 4));
                System.out.println(orderArray[0].substring(4));

                switch (orderArray[0].substring(4)) {
                    case "hour":
                        date.passTime = 1;
                        break;
                    case "halfday":
                        date.passTime = 12;
                        break;
                    case "day":
                        date.passTime = 24;
                        break;
                }
            }

            int tmp = date.passTime;
            for (int h = 0; h < tmp; h++) {
                // 產生資源
                date.nextHour();
                resource.woodAdd();
                resource.steelAdd();

                // 判斷建築狀態決定是否建造
                for (int i = 0; i < resource.buildingPeople.size(); i++) {
                    if (resource.buildingPeople.get(i)[1] == 0) {
                        buildingArray.buildBuildings(date.time, resource, resource.buildingPeople.get(i)[0]);
                        resource.buildingPeople.get(i)[1] -= date.addTime;
                        resource.buildingPeople.remove(i);
                    }
                }

                // 時間前進指令
//---------------------------------------------------------------------//新增
                if (orderArray[0].equals("nexthour")) { //1小時
                    date.nextHour();
                    for (int i = 0; i < date.addTime; i++) {
                        date.time++;
                        resource.resourceTime = 1;
                        resource.woodAdd();//新增
                        resource.steelAdd();//新增
                        boolean index = true;

                        if (date.time % 16 == 0) {
                            start = false;
                            zombie.zombieWave = date.time / 16;
                            zombie.setZombieAttack();
                            if (zombie.zombieAttack >= soldiers.soliderLife * soldiers.soliderNumber) {
                                //失敗
                                zombie.failZombie(soldiers, villagers, resource);
                                zombie.showZombie(date, villagers, soldiers, resource);
                                System.out.println("請重新分配採集木頭與鋼鐵人數 如:woodsteel 2 4");
                                System.out.println("如果不想分配採集人數，請輸入:end");
                                while (index) {
                                    //序列orderArray2
                                    String order2 = sc.nextLine();
                                    order = order2.toLowerCase();
                                    String[] orderArray2 = order.replaceAll("　", " ").trim().split("\\s+");
                                    if (orderArray2[0].equals("woodsteel")) {
                                        resource.distribution(Integer.parseInt(orderArray2[1]), Integer.parseInt(orderArray2[2]));
                                        if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople) {
                                            System.out.println(resource.getDistribution());
                                            index = false;
                                            start = true;
                                        } else {
                                            System.out.println("超出總人數");
                                            resource.distribution(0, 0);
                                        }

                                    }
                                    if (orderArray2[0].equals("end")) {
                                        index = false;
                                        start = true;
                                    }
                                }


                            } else if (zombie.zombieAttack < soldiers.soliderLife * soldiers.soliderNumber) {
                                //成功
                                zombie.successZombie(soldiers);
                                zombie.showZombie(date, villagers, soldiers, resource);
                                start = true;
                            }

                        }
                        if (i == date.addTime - 1) { //最後執行次數顯示狀態
                            status.showStatus(date, villagers, soldiers, resource, buildingArray);//秀出資訊
                        }

                    }

                }
                if (orderArray[0].equals("nexthalfday")) { //12小時
                    date.nextHalfDay();
                    for (int i = 0; i < date.addTime; i++) {
                        date.time++;
                        resource.resourceTime = 1;
                        resource.woodAdd();//新增
                        resource.steelAdd();//新增
                        boolean index = true;

                        if (date.time % 16 == 0) {
                            start = false;
                            zombie.zombieWave = date.time / 16;
                            zombie.setZombieAttack();
                            if (zombie.zombieAttack >= soldiers.soliderLife * soldiers.soliderNumber) {
                                //失敗
                                zombie.failZombie(soldiers, villagers, resource);
                                zombie.showZombie(date, villagers, soldiers, resource);
                                System.out.println("請重新分配採集木頭與鋼鐵人數 如:woodsteel 2 4");
                                System.out.println("如果不想分配採集人數，請輸入:end");
                                while (index) {
                                    //序列orderArray2
                                    String order2 = sc.nextLine();
                                    order = order2.toLowerCase();
                                    String[] orderArray2 = order.replaceAll("　", " ").trim().split("\\s+");
                                    if (orderArray2[0].equals("woodsteel")) {
                                        resource.distribution(Integer.parseInt(orderArray2[1]), Integer.parseInt(orderArray2[2]));
                                        if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople) {
                                            System.out.println(resource.getDistribution());
                                            index = false;
                                            start = true;
                                        } else {
                                            System.out.println("超出總人數");
                                            resource.distribution(0, 0);
                                        }

                                    }
                                    if (orderArray2[0].equals("end")) {
                                        index = false;
                                        start = true;
                                    }
                                }


                            } else if (zombie.zombieAttack < soldiers.soliderLife * soldiers.soliderNumber) {
                                //成功
                                zombie.successZombie(soldiers);
                                zombie.showZombie(date, villagers, soldiers, resource);
                                start = true;
                            }

                        }
                        if (i == date.addTime - 1) { //最後執行次數顯示狀態
                            status.showStatus(date, villagers, soldiers, resource, buildingArray);//秀出資訊
                        }

                    }
                }

                if (orderArray[0].equals("nextday")) {//24小時
                    date.nextDay();
                    for (int i = 0; i < date.addTime; i++) {
                        date.time++;
                        resource.resourceTime = 1;
                        resource.woodAdd();//新增
                        resource.steelAdd();//新增
                        boolean index = true;

                        if (date.time % 16 == 0) {
                            start = false;
                            zombie.zombieWave = date.time / 16;
                            zombie.setZombieAttack();
                            if (zombie.zombieAttack >= soldiers.soliderLife * soldiers.soliderNumber) {
                                //失敗
                                zombie.failZombie(soldiers, villagers, resource);
                                zombie.showZombie(date, villagers, soldiers, resource);
                                System.out.println("請重新分配採集木頭與鋼鐵人數 如:woodsteel 2 4");
                                System.out.println("如果不想分配採集人數，請輸入:end");
                                while (index) {
                                    //序列orderArray2
                                    String order2 = sc.nextLine();
                                    order = order2.toLowerCase();
                                    String[] orderArray2 = order.replaceAll("　", " ").trim().split("\\s+");
                                    if (orderArray2[0].equals("woodsteel")) {
                                        resource.distribution(Integer.parseInt(orderArray2[1]), Integer.parseInt(orderArray2[2]));
                                        if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople) {
                                            System.out.println(resource.getDistribution());
                                            index = false;
                                            start = true;
                                        } else {
                                            System.out.println("超出總人數");
                                            resource.distribution(0, 0);
                                        }

                                    }
                                    if (orderArray2[0].equals("end")) {
                                        index = false;
                                        start = true;
                                    }
                                }


                            } else if (zombie.zombieAttack < soldiers.soliderLife * soldiers.soliderNumber) {
                                //成功
                                zombie.successZombie(soldiers);
                                zombie.showZombie(date, villagers, soldiers, resource);

                                start = true;
                            }

                        }
                        if (i == date.addTime - 1) { //最後執行次數顯示狀態
                            status.showStatus(date, villagers, soldiers, resource, buildingArray);//秀出資訊
                        }

                    }
                }
//-----------------------------------------------------------------------------
            }
        }
    }
}
