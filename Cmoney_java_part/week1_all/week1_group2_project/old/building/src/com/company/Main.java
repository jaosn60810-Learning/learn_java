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
            String order = sc.nextLine();
            order = order.toLowerCase();
            if (order.contains("build")) {
                char c = order.charAt(order.length() - 1);
                int buildingNumber = c - '0';
                buildBuildings(buildings, hour, resource, buildingNumber);

            }
            if (order.contains("status")) {
                for (Building building : buildings) {
                    System.out.println("建築: " + building);
                }
                System.out.println("村民[數目,血量]: " + Arrays.toString(village));
                System.out.println("時間: " + hour);
                System.out.println("木頭: " + resource.getWood());
                System.out.println("鐵礦: " + resource.getIron());

            }
            if (order.contains("nexthour")) {
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
            buildings.add(new PeopleHouse(hour, new Resource(10, 0), 1, "房屋", 1));
            int costWood = buildings.get(buildings.size() - 1).getBuildingNeedResource().getWood();
            resource.setWood(resource.getWood() - costWood);
        } else
            System.out.println("資源不足");
    }

    public static void buildWoodBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
        if (resource.getWood() >= 15) {
            buildings.add(new WoodBuilding(hour, new Resource(15, 0), 1, "伐木場", 4));
            int costWood = buildings.get(buildings.size() - 1).getBuildingNeedResource().getWood();
            resource.setWood(resource.getWood() - costWood);
        } else
            System.out.println("資源不足");
    }

    public static void buildIronBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
        if (resource.getWood() >= 15 && resource.getIron() >= 5) {
            buildings.add(new IronBuilding(hour, new Resource(15, 5), 1, "煉鋼廠", 5));
            int costWood = buildings.get(buildings.size() - 1).getBuildingNeedResource().getWood();
            int costIron = buildings.get(buildings.size() - 1).getBuildingNeedResource().getIron();
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
