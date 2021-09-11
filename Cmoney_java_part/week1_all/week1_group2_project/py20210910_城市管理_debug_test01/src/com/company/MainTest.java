package com.company;


import java.util.Scanner;

public class MainTest {

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

        // 設置初始資源和初始採集速度
        Resource resource = new Resource();//新增
        resource.woodEfficiency = 3;//木材效率
        resource.steelEfficiency = 1;//鋼鐵效率

        BuildingArray buildingArray = new BuildingArray();
        
//改
        while (villagers.villagerNumber>0) {
            // 產生村民和士兵
            buildingArray.buildingsGeneratePeople(date.time, villagers);
            // 判斷建築狀態決定是否建造
            for(int i=0; i<resource.buildingPeople.size(); i++){
                resource.buildingPeople.get(i)[1] -- ;
                
                if(resource.buildingPeople.get(i)[1] == 0){
                    resource.buildingPeople.remove(i);
                    buildingArray.buildBuildings(date, i);
                }
            }
            //升級
            //殭屍來襲
            
            String order = sc.nextLine();
            order = order.toLowerCase();
            String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");
            // 建造指令>>更改建築狀態
            // 輸入建築編號 及動作(1新增或-1移除)
            if (orderArray[0].equals("build")) {
                int buildingNumber = Integer.parseInt(orderArray[1]);
                //(編號,動作)
                resource.changeBuildingStatus(buildingNumber,1);
            }
            // 升級指令
            if (orderArray[0].equals("upgrade")) {

            }
            
            //if(date.passTime>0){continue;}
            System.out.println(orderArray[0]);
            if(orderArray[0].equals("distribution")){
                resource.distribution(Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
                if(villagers.villagerNumber >= resource.woodPeople + resource.steelPeople){
                    System.out.println(resource.getDistribution());
                }else{
                    System.out.println("超出總人數");
                }
            }
//            }

            // 時間前進指令
            System.out.println("時間: " + date.time);
            System.out.println("村民: " + villagers);
            System.out.println("木頭: " + resource.getWood());
            System.out.println("鐵礦: " + resource.getSteel());
            System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
            System.out.println("建築中人數:" + resource.buildingPeople.size());
            System.out.println("閒置村民:" + (villagers.villagerNumber - resource.woodPeople - resource.steelPeople - resource.buildingPeople.size()));
            for (Building building : buildingArray.getBuildings()) {
                System.out.println("建築: " + building);
            }
//
            if (orderArray[0].substring(0,4).equals("next")) {
                if(orderArray[0].substring(4).equals("hour")){
//改成一種指令                    date.setPassTime();
                    date.nextHour();
                    resource.resourceTime = date.addTime;//新增
                    resource.woodAdd();//新增
                    resource.steelAdd();//新增
                    
                }
//
//改
//            if (orderArray[0].equals("nexthour")) {
//                date.nextHour();
//                resource.resourceTime = date.addTime;//新增
//                resource.woodAdd();//新增
//                resource.steelAdd();//新增
//            }
//            if (orderArray[0].equals("nexthalfday")) {
//                date.nextHalfDay();
//                resource.resourceTime = date.addTime;//新增
//                resource.woodAdd();//新增
//                resource.steelAdd();//新增
//            }
//            if (orderArray[0].equals("nextday")) {
//                date.nextDay();
//                resource.resourceTime = date.addTime;//新增
//                resource.woodAdd();//新增
//                resource.steelAdd();//新增
            }
                        // 顯示狀態指令

        }
        System.out.println("Game Over!");
    }
}
