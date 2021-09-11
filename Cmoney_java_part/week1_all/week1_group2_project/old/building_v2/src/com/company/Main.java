package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] village = {0, 0};
        int[] army = {0, 0};
        int hour = 0;
        Resource resource = new Resource(15, 5);
        ArrayList<Building> buildings = new ArrayList<>();
        while (true) {
            // 產生村民和士兵
            buildingsGeneratePeople(buildings, hour, village);
            // 輸入指令
            String order = sc.nextLine();
            order = order.toLowerCase();
            String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");
            // 建造指令
            if (orderArray[0].equals("build")) {
                int buildingNumber = Integer.parseInt(orderArray[1]);
                buildBuildings(buildings, hour, resource, buildingNumber);

            }
            // 顯示狀態指令
            if (orderArray[0].equals("status")) {
                for (Building building : buildings) {
                    System.out.println("建築: " + building);
                }
                System.out.println("村民[數目,血量]: " + Arrays.toString(village));
                System.out.println("時間: " + hour);
                System.out.println("木頭: " + resource.getWood());
                System.out.println("鐵礦: " + resource.getIron());

            }
            // 時間前進指令
            if (orderArray[0].equals("nexthour")) {
                hour++;
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

    public static void buildingsGeneratePeople(ArrayList<Building> buildings, int hour, int[] village) {
        for (Building build : buildings) {
            if (build instanceof PeopleHouse) {
                village[0] += hour - build.getBuildingTime();
                build.setBuildingTime(hour);
            }
        }
    }
}
