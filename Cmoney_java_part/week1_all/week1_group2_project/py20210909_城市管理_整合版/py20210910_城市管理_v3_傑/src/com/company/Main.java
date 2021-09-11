package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 設置初始村名數量
        Villager villagers = new Villager();
        villagers.villagerLife(1);
        villagers.villagerNumber(20);
        villagers.villagerLevel = 1;

        // 設置初始士兵數量
        Soldier soldiers = new Soldier();
        soldiers.soliderLife(1);
        soldiers.soliderNumber(20);
        soldiers.soliderLevel = 1;

        // 設置初始時間
        Date date = new Date();
        date.time(0);

        // 設置初始資源和初始採集速度
        Resource resource = new Resource(1000, 1000);//新增
        resource.woodEfficiency = 3;//木材效率
        resource.steelEfficiency = 1;//鋼鐵效率

        BuildingArray buildingArray = new BuildingArray();
        while (true) {
            // 產生村民和士兵
            buildingArray.buildingsGeneratePeople(buildingArray.getBuildings(), date.time, villagers);
            buildingArray.buildingsGenerateSoldiers(buildingArray.getBuildings(), date.time, soldiers);
            // 輸入指令


            //升級
            buildingArray.isAnyBuildingsNeedUpgrade(date.time, resource);
            //殭屍來襲

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
            if (orderArray[0].equals("distribution")) {
                System.out.println("請輸入2個參數分配採集木頭與鋼鐵人數 如\n2 4");
                resource.distribution(Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
                if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople) {
                    System.out.println(resource.getDistribution());
                } else {
                    System.out.println("超出總人數");
                }
            }

            // 顯示狀態指令
            if (orderArray[0].equals("status")) {
                System.out.println("時間: " + date.time);
                System.out.println("村民: " + villagers);
                System.out.println("士兵: " + soldiers);
                System.out.println("木頭: " + resource.getWood());
                System.out.println("鐵礦: " + resource.getSteel());
                System.out.println("採集木頭效率: " + resource.woodEfficiency);
                System.out.println("採集鐵礦效率: " + resource.steelEfficiency);
                System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
                for (Building building : buildingArray.getBuildings()) {
                    System.out.println("建築: " + building);
                }
            }

            // 時間前進指令
            if (orderArray[0].equals("nexthour")) {
                date.nextHour();
                resource.resourceTime = date.addTime;//新增
                resource.woodAdd();//新增
                resource.steelAdd();//新增
            }
            if (orderArray[0].equals("nexthalfday")) {
                date.nextHalfDay();
                resource.resourceTime = date.addTime;//新增
                resource.woodAdd();//新增
                resource.steelAdd();//新增
            }
            if (orderArray[0].equals("nextday")) {
                date.nextDay();
                resource.resourceTime = date.addTime;//新增
                resource.woodAdd();//新增
                resource.steelAdd();//新增
            }
        }
    }
}
