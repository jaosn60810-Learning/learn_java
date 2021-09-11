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

    //本身就有buildingArray的屬性，不需要重新給參數，直接用就可
//    public  void buildBuildings(ArrayList<Building> buildings, int hour, Resource resource, int buildingNumber) {
    public void buildBuildings(int hour, Resource resource, int buildingNumber) {
        switch (buildingNumber) {
//buildBuilding系列的功能相同可整合，給buildingNumber參數來判斷蓋哪個
//buildings.add(int hour, Resource resource,buildingNumver)
            case 1:
                buildPeopleHouse(hour, resource);
                break;
            case 2:
                buildUniversity(hour, resource);
                break;
            case 3:
                buildBarracks(hour, resource);
                break;
            case 4:
                buildWoodBuilding(hour, resource);
                break;
            case 5:
                buildIronBuilding(hour, resource);
                break;
            case 6:
                buildArsenal(hour, resource);
                break;
        }
    }

    //public  void buildPeopleHouse(ArrayList<Building> buildings, int hour, Resource resource) {
    public void buildPeopleHouse(int hour, Resource resource) {
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

    public void buildUniversity(int hour, Resource resource) {
        // 判斷是否已經有此建築
        for (Building build : buildings) {
            if (build instanceof University) {
                System.out.println("已經有此建築");
                return;
            }
        }
        // 判斷資源是否足夠
        if (resource.getWood() >= 10 && resource.getSteel() >= 5) {
            buildings.add(new University(hour));
            resource.setWood(resource.getWood() - 10);
            resource.setSteel(resource.getSteel() - 5);
        } else
            System.out.println("資源不足");
    }

    public void buildBarracks(int hour, Resource resource) {
        // 判斷是否已經有此建築
        for (Building build : buildings) {
            if (build instanceof University) {
                System.out.println("已經有此建築");
                return;
            }
        }
        // 判斷資源是否足夠
        if (resource.getWood() >= 10 && resource.getSteel() >= 5) {
            buildings.add(new PeopleHouse(hour));
            resource.setWood(resource.getWood() - 10);
            resource.setSteel(resource.getSteel() - 5);
        } else
            System.out.println("資源不足");
    }


    //    public  void buildWoodBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
    public void buildWoodBuilding(int hour, Resource resource) {
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
//            int costWood = 15;
            resource.setWood(resource.getWood() - 15);
            // 升級木頭採集效率
            resource.woodEfficiency = 4;
        } else
            System.out.println("資源不足");
    }

    //    public  void buildIronBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
    public void buildIronBuilding(int hour, Resource resource) {
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

    public void buildArsenal(int hour, Resource resource) {
        // 判斷是否已經有此建築
        for (Building build : buildings) {
            if (build instanceof University) {
                System.out.println("已經有此建築");
                return;
            }
        }
        // 判斷資源是否足夠
        if (resource.getWood() >= 30 && resource.getSteel() >= 10) {
            buildings.add(new PeopleHouse(hour));
            resource.setWood(resource.getWood() - 30);
            resource.setSteel(resource.getSteel() - 10);
        } else
            System.out.println("資源不足");
    }

    public void upgradeBuildings(int hour, Resource resource, int buildingNumber) {
        for (Building building : buildings) {
            if (building.getBuildingNumber() == buildingNumber) {
                building.techDevelop(hour, resource);
            }
        }
    }

    public void isAnyBuildingsNeedUpgrade(int realWorldTime, Resource resource) {
        for (Building build : buildings) {
            build.isTechDevelop(realWorldTime, resource);
        }
    }

    public void buildingsGeneratePeople(ArrayList<Building> buildings, int realWorldTime, Villager villagers) {
        for (Building build : buildings) {
            if (build instanceof PeopleHouse) {
                ((PeopleHouse) build).generatePeople(villagers, realWorldTime);
            }
        }
    }

    public boolean isUniversityExisting() {
        for (Building build : buildings) {
            if (build instanceof University) {
                return true;
            }
        }
        return false;
    }
}
