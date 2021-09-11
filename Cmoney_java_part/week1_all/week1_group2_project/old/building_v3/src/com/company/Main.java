package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 設置初始村名數量
        Villager villagers = new Villager();
        villagers.villagerLife(1);
        villagers.villagerNumber(20);
        villagers.villagerLevel = 1;

        // 設置初始時間
        Date date = new Date();
        date.time(0);

        Resource resource = new Resource(50, 5);
        ArrayList<Building> buildings = new ArrayList<>();
        while (true) {
            // 產生村民和士兵
            buildingsGeneratePeople(buildings, date.time, villagers);
            // 輸入指令
            String order = sc.nextLine();
            order = order.toLowerCase();
            String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");
            // 建造指令
            if (orderArray[0].equals("build")) {
                int buildingNumber = Integer.parseInt(orderArray[1]);
                buildBuildings(buildings, date.time, resource, buildingNumber);
            }
            // 顯示狀態指令
            if (orderArray[0].equals("status")) {
                for (Building building : buildings) {
                    System.out.println("建築: " + building);
                }
                System.out.println("村民: " + villagers);
                System.out.println("時間: " + date.time);
                System.out.println("木頭: " + resource.getWood());
                System.out.println("鐵礦: " + resource.getIron());
            }
            // 時間前進指令
            if (orderArray[0].equals("nexthour")) {
                date.nextHour();
            }
            if (orderArray[0].equals("nexthalfday")) {
                date.nextHalfDay();
            }
            if (orderArray[0].equals("nextday")) {
                date.nextDay();
            }
        }
    }

    public static void buildBuildings(ArrayList<Building> buildings, int hour, Resource resource, int buildingNumber) {
        switch (buildingNumber) {
            case 1:
                buildPeopleHouse(buildings, hour, resource);
                break;
            case 4:
                buildWoodBuilding(buildings, hour, resource);
                break;
            case 5:
                buildIronBuilding(buildings, hour, resource);
                break;
        }
    }

    public static void buildPeopleHouse(ArrayList<Building> buildings, int hour, Resource resource) {
        if (resource.getWood() >= 10) {
            buildings.add(new PeopleHouse(hour));
            int costWood = 10;
            resource.setWood(resource.getWood() - costWood);
        } else
            System.out.println("資源不足");
    }

    public static void buildWoodBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
        if (resource.getWood() >= 15) {
            buildings.add(new WoodBuilding(hour));
            int costWood = 15;
            resource.setWood(resource.getWood() - costWood);
        } else
            System.out.println("資源不足");
    }

    public static void buildIronBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
        if (resource.getWood() >= 15 && resource.getIron() >= 5) {
            buildings.add(new IronBuilding(hour));
            int costWood = 15;
            int costIron = 5;
            resource.setWood(resource.getWood() - costWood);
            resource.setIron(resource.getIron() - costIron);
        } else
            System.out.println("資源不足");
    }

    public static void buildingsGeneratePeople(ArrayList<Building> buildings, int realWorldTime, Villager villagers) {
        for (Building build : buildings) {
            if (build instanceof PeopleHouse) {
               ((PeopleHouse) build).generatePeople(villagers,realWorldTime);
            }
        }
    }
}
