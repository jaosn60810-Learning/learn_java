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
//將建造時間改成時間物件
//建造中村民可以被拉走，資源返回
    public  void buildBuildings(Date date, int buildingNumber) {
        int hour = date.time;
        switch (buildingNumber) {
//buildBuilding系列的功能相同可整合，給buildingNumber參數來判斷蓋哪個
//buildings.add(int hour, Resource resource,buildingNumver)
            case 1:
                //建造中物件狀態[-1,0,1] 0 1扣資源 -1還資源 0狀態不改
                buildPeopleHouse(hour, new Resource(10,0));
                break;
            case 2:
                buildUniversity(hour, new Resource(10,5));
                break;
            case 3:
                buildBarracks(hour, new Resource(20,10));
                break;
            case 4:
                buildWoodBuilding( hour, new Resource(15,0));
                break;
            case 5:
                buildIronBuilding(hour, new Resource(15,5));
                break;
            case 6:
                buildArsenal(hour, new Resource(30,10));
                break;
        }
    }
    
    //public  void buildPeopleHouse(ArrayList<Building> buildings, int hour, Resource resource) {
    public  void buildPeopleHouse(int hour, Resource resource) {
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
        public  void buildUniversity(int hour, Resource resource) {
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
    
    public  void buildBarracks(int hour, Resource resource) {
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
    public  void buildWoodBuilding(int hour, Resource resource) {
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
        } else
            System.out.println("資源不足");
    }

//    public  void buildIronBuilding(ArrayList<Building> buildings, int hour, Resource resource) {
    public  void buildIronBuilding(int hour, Resource resource) {
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
    
        public  void buildArsenal(int hour, Resource resource) {
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
        

//    public  void upgradeBuildings(ArrayList<Building> buildings, int hour, Resource resource, int buildingNumber) {
    public  void upgradeBuildings(int hour, Resource resource, int buildingNumber) {
        for(int i=0; i<buildings.size(); i++){
            if(buildings.get(i).getBuildingNumber()==buildingNumber){
//房屋自己升級
                buildings.get(i).techDevelop();
            }
        }
//        switch (buildingNumber) {
//            case 1:
//                buildPeopleHouse(hour, resource);
//                break;
//            case 4:
//                buildWoodBuilding(hour, resource);
//                break;
//            case 5:
//                buildIronBuilding(hour, resource);
//                break;
//        }
    }

    public  void buildingsGeneratePeople(int realWorldTime, Villager villagers) {
        for (Building build : buildings) {
            if (build instanceof PeopleHouse) {
                //可能報錯
                ((PeopleHouse) build).generatePeople(villagers, realWorldTime);
            }
        }
    }
}
