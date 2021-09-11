package com.company;

import java.util.ArrayList;

public class BuildingArray {
    private ArrayList<Building> buildings = new ArrayList<>();

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public  void buildBuildings(ArrayList<Building> buildings, int hour, Resource resource, int buildingNumber) {
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

    public  void buildPeopleHouse(ArrayList<Building> buildings, int hour, Resource resource) {
        // 判斷是否已經有此建築
        for (Building build : buildings) {
            if (build instanceof PeopleHouse) {
                System.out.println("已經有此建築");
                return;
            }
        }
        // 判斷資源是否足夠
        if (resource.getWood() >= 10) {
            buildings.add(new PeopleHouse(hour));
            int costWood = 10;
            resource.setWood(resource.getWood() - costWood);
        } else
            System.out.println("資源不足");
    }

    public  void buildWoodBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
        // 判斷是否已經有此建築
        for (Building build : buildings) {
            if (build instanceof WoodBuilding) {
                System.out.println("已經有此建築");
                return;
            }
        }
        // 判斷資源是否足夠
        if (resource.getWood() >= 15) {
            buildings.add(new WoodBuilding(hour));
            int costWood = 15;
            resource.setWood(resource.getWood() - costWood);
        } else
            System.out.println("資源不足");
    }

    public  void buildIronBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
        // 判斷是否已經有此建築
        for (Building build : buildings) {
            if (build instanceof IronBuilding) {
                System.out.println("已經有此建築");
                return;
            }
        }
        // 判斷資源是否足夠
        if (resource.getWood() >= 15 && resource.getSteel() >= 5) {
            buildings.add(new IronBuilding(hour));
            int costWood = 15;
            int costIron = 5;
            resource.setWood(resource.getWood() - costWood);
            resource.setSteel(resource.getSteel() - costIron);
        } else
            System.out.println("資源不足");
    }

    public  void upgradeBuildings(ArrayList<Building> buildings, int hour, Resource resource, int buildingNumber) {
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

    public  void buildingsGeneratePeople(ArrayList<Building> buildings, int realWorldTime, Villager villagers) {
        for (Building build : buildings) {
            if (build instanceof PeopleHouse) {
                ((PeopleHouse) build).generatePeople(villagers, realWorldTime);
            }
        }
    }
}
