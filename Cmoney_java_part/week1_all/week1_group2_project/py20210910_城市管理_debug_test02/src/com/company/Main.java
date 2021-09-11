package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 設置初始村名數量
        Villager villagers = new Villager();
        villagers.villagerLife(1);
        villagers.villagerNumber(50); //新增  初始值須最後完成時改成20
        villagers.villagerLevel = 1;
        // 設置初始時間
        Date date = new Date();
        date.time(0);
        //設置士兵
        Soldier soldiers =new Soldier();//新增
        //設置殭屍
        Zombie zombie = new Zombie();//新增
        boolean start = true;//新增

        // 設置初始資源和初始採集速度
        Resource resource = new Resource();
        resource.woodEfficiency = 3;//木材效率
        resource.steelEfficiency = 1;//鋼鐵效率

        BuildingArray buildingArray = new BuildingArray();
        while (start) {


                // 產生村民和士兵
                buildingArray.buildingsGeneratePeople(buildingArray.getBuildings(), date.time, villagers);
                // 輸入指令


                //升級
                //殭屍來襲

                String order = sc.nextLine();
                order = order.toLowerCase();
                String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");
                // 建造指令
                if (orderArray[0].equals("build")) {
                    int buildingNumber = Integer.parseInt(orderArray[1]);
//刪掉物件參數
//buildingArray.buildBuildings(buildingArray.getBuildings(), date.time, resource, buildingNumber);
                    buildingArray.buildBuildings(date.time, buildingNumber);
                }
                // 升級指令
                if (orderArray[0].equals("upgrade")) {
                    int buildingNumber = Integer.parseInt(orderArray[1]);
//刪掉物件參數
//buildingArray.buildBuildings(buildingArray.getBuildings(), date.time, resource, buildingNumber);
                    buildingArray.buildBuildings(date.time, buildingNumber);
                }
                // 採集分配指令
//無法直接調正各資源人數
//增加不同種類資源會很複雜
//            if (orderArray[0].equals("wood")) {
//                resource.woodPeople = Integer.parseInt(orderArray[1]); //木材採集人數
//                if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople) {  //判斷人數是否超過
//                    System.out.println("採集wood:" + resource.woodPeople + "人" + " 採集steel:" + resource.steelPeople + "人");
//                } else {
//                    System.out.println("超出總人數!");
//                }
//            }
//            if (orderArray[0].equals("steel")) {
//                resource.steelPeople = Integer.parseInt(orderArray[1]);//鋼鐵採集人數
//                if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople) {  //判斷人數是否超過
//                    System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
//                } else {
//                    System.out.println("超出總人數!");
//                }
//            }
//直接分配所有資源
//distribution 5 2
                if(orderArray[0].equals("distribution")){
                    //System.out.println("請輸入2個參數分配採集木頭與鋼鐵人數 如\n2 4");
                    resource.distribution(Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
                    if(villagers.villagerNumber >= resource.woodPeople + resource.steelPeople){
                        System.out.println(resource.getDistribution());
                    }else{
                        System.out.println("超出總人數");
                    }
                }
//還沒決定building人數 目前可以直接把人拉走
//            }
                // 顯示狀態指令
                if (orderArray[0].equals("status")) {
                    System.out.println("時間: " + date.time);
                    System.out.println("市民: " + villagers);
                    System.out.println("士兵: " + soldiers);
                    System.out.println("木頭: " + resource.getWood());
                    System.out.println("鐵礦: " + resource.getSteel());
                    System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
                    for (Building building : buildingArray.getBuildings()) {
                        System.out.println("建築: " + building);
                    }

                }
                // 時間前進指令
//            int aaa = 24;
//            if(a%16!=0){
//                date.nexthour();
//                a--;
//                continue;
//            }
//---------------------------------------------------------------------//新增
                if (orderArray[0].equals("nexthour")) { //1小時
                    date.nextHour();
                    for (int i=0;i < date.addTime;i++){
                        date.time++;
                        resource.resourceTime =1;
                        resource.woodAdd();//新增
                        resource.steelAdd();//新增
                        boolean index = true;

                        if(date.time % 16 == 0){
                            start = false;
                            zombie.zombieWave = date.time/16;
                            zombie.setZombieAttack();
                            if(zombie.zombieAttack >= soldiers.soliderLife * soldiers.soliderNumber ){
                                //失敗
                                zombie.failZombie(soldiers,villagers,resource);
                                zombie.showZombie(date,villagers,soldiers,resource);
                                System.out.println("請重新分配採集木頭與鋼鐵人數 如\n2 4");

                                while (index){
                                    //序列orderArray2
                                    String order2 = sc.nextLine();
                                    order = order2.toLowerCase();
                                    String[] orderArray2 = order.replaceAll("　", " ").trim().split("\\s+");
                                    if(orderArray2[0].equals("distribution")){
                                        //System.out.println("請輸入2個參數分配採集木頭與鋼鐵人數 如\n2 4");
                                        resource.distribution(Integer.parseInt(orderArray2[1]), Integer.parseInt(orderArray2[2]));
                                        if(villagers.villagerNumber >= resource.woodPeople + resource.steelPeople){
                                            System.out.println(resource.getDistribution());
                                            index = false;
                                            start = true;
                                        }else{
                                            System.out.println("超出總人數");
                                            resource.distribution(0,0);

                                        }

                                    }
                                    if (orderArray2[0].equals("status")) {
                                        System.out.println("時間: " + date.time);
                                        System.out.println("市民: " + villagers);
                                        System.out.println("士兵: " + soldiers);
                                        System.out.println("木頭: " + resource.getWood());
                                        System.out.println("鐵礦: " + resource.getSteel());
                                        System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
                                        for (Building building : buildingArray.getBuildings()) {
                                            System.out.println("建築: " + building);
                                        }
                                        index = false;
                                        start = true;
                                    }
                                }
                            }else if(zombie.zombieAttack < soldiers.soliderLife * soldiers.soliderNumber ){
                                //成功
                                zombie.successZombie(soldiers);
                                zombie.showZombie(date,villagers,soldiers,resource);
                                start = true;
                            }

                        }

                    }

                }
                if (orderArray[0].equals("nexthalfday")) { //12小時
                    date.nextHalfDay();
                    for (int i=0;i < date.addTime;i++){
                        date.time++;
                        resource.resourceTime =1;
                        resource.woodAdd();//新增
                        resource.steelAdd();//新增
                        boolean index = true;

                        if(date.time % 16 == 0){
                            start = false;
                            zombie.zombieWave = date.time/16;
                            zombie.setZombieAttack();
                            if(zombie.zombieAttack >= soldiers.soliderLife * soldiers.soliderNumber ){
                                //失敗
                                zombie.failZombie(soldiers,villagers,resource);
                                zombie.showZombie(date,villagers,soldiers,resource);
                                System.out.println("請重新分配採集木頭與鋼鐵人數 如\n2 4");

                                while (index){
                                    //序列orderArray2
                                    String order2 = sc.nextLine();
                                    order = order2.toLowerCase();
                                    String[] orderArray2 = order.replaceAll("　", " ").trim().split("\\s+");
                                    if(orderArray2[0].equals("distribution")){
                                        //System.out.println("請輸入2個參數分配採集木頭與鋼鐵人數 如\n2 4");
                                        resource.distribution(Integer.parseInt(orderArray2[1]), Integer.parseInt(orderArray2[2]));
                                        if(villagers.villagerNumber >= resource.woodPeople + resource.steelPeople){
                                            System.out.println(resource.getDistribution());
                                            index = false;
                                            start = true;
                                        }else{
                                            System.out.println("超出總人數");
                                            resource.distribution(0,0);
                                        }

                                    }
                                    if (orderArray2[0].equals("status")) {
                                        System.out.println("時間: " + date.time);
                                        System.out.println("市民: " + villagers);
                                        System.out.println("士兵: " + soldiers);
                                        System.out.println("木頭: " + resource.getWood());
                                        System.out.println("鐵礦: " + resource.getSteel());
                                        System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
                                        for (Building building : buildingArray.getBuildings()) {
                                            System.out.println("建築: " + building);
                                        }
                                        index = false;
                                        start = true;
                                    }
                                }


                            }else if(zombie.zombieAttack < soldiers.soliderLife * soldiers.soliderNumber ){
                                //成功
                                zombie.successZombie(soldiers);
                                zombie.showZombie(date,villagers,soldiers,resource);
                                start = true;
                            }

                        }

                    }
                }

                if (orderArray[0].equals("nextday")) {//24小時
                    date.nextDay();
                    for (int i=0;i < date.addTime;i++){
                        date.time++;
                        resource.resourceTime =1;
                        resource.woodAdd();//新增
                        resource.steelAdd();//新增
                        boolean index = true;

                        if(date.time % 16 == 0){
                            start = false;
                            zombie.zombieWave = date.time/16;
                            zombie.setZombieAttack();
                            if(zombie.zombieAttack >= soldiers.soliderLife * soldiers.soliderNumber ){
                                //失敗
                                zombie.failZombie(soldiers,villagers,resource);
                                zombie.showZombie(date,villagers,soldiers,resource);
                                System.out.println("請重新分配採集木頭與鋼鐵人數 如\n2 4");

                                while (index){
                                    //序列orderArray2
                                    String order2 = sc.nextLine();
                                    order = order2.toLowerCase();
                                    String[] orderArray2 = order.replaceAll("　", " ").trim().split("\\s+");
                                    if(orderArray2[0].equals("distribution")){
                                        //System.out.println("請輸入2個參數分配採集木頭與鋼鐵人數 如\n2 4");
                                        resource.distribution(Integer.parseInt(orderArray2[1]), Integer.parseInt(orderArray2[2]));
                                        if(villagers.villagerNumber >= resource.woodPeople + resource.steelPeople){
                                            System.out.println(resource.getDistribution());
                                            index = false;
                                            start = true;
                                        }else{
                                            System.out.println("超出總人數");
                                            resource.distribution(0,0);
                                        }

                                    }
                                    if (orderArray2[0].equals("status")) {
                                        System.out.println("時間: " + date.time);
                                        System.out.println("市民: " + villagers);
                                        System.out.println("士兵: " + soldiers);
                                        System.out.println("木頭: " + resource.getWood());
                                        System.out.println("鐵礦: " + resource.getSteel());
                                        System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
                                        for (Building building : buildingArray.getBuildings()) {
                                            System.out.println("建築: " + building);
                                        }
                                        index = false;
                                        start = true;
                                    }
                                }

                            }else if(zombie.zombieAttack < soldiers.soliderLife * soldiers.soliderNumber ){
                                //成功
                                zombie.successZombie(soldiers);
                                zombie.showZombie(date,villagers,soldiers,resource);
                                start = true;
                            }

                        }

                    }
                }
//-----------------------------------------------------------------------------

        }




    }
}
