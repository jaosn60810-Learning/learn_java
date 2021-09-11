package pylenovo.aoeintegration;


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
        resource.woodEfficiency = 0;//木材效率
        resource.steelEfficiency = 0;//鋼鐵效率
        
        BuildingArray buildingArray = new BuildingArray();
        
//改
        while (villagers.villagerNumber>0) {
//操作階段===========================================================================
//1.分配人數2.建房3.是否研發科技4.跳過時間
            //輸入指令
            String order = sc.nextLine();
            order = order.toLowerCase();
            String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");


            // 建造指令>>更改建築狀態>>狀態在影響是否實際建造
            // 輸入建築編號 及動作(1新增或-1移除)
            if (orderArray[0].equals("build")) {
                int buildingNumber = Integer.parseInt(orderArray[1]);
                int buildingExist = 0;
                for(int i=0; i<resource.buildingPeople.size(); i++){
                    if(resource.buildingPeople.get(i)[1]==buildingNumber){
                        buildingExist = 1;
                    }
                }
                if(buildingExist == 1){
                    System.out.println("已配置!");
                }else{
                    int opt = Integer.parseInt(orderArray[2]);
                    //(編號,動作)
                    resource.changeBuildingStatus(buildingNumber,opt);
                }
            }
    // 升級指令>>更改升級狀態
            if (orderArray[0].equals("upgrade")) {
//".........................更改升級指令狀態................................";
            }
            System.out.println(orderArray[0]);
            if(orderArray[0].equals("dist")){
                resource.distribution(Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
                if(villagers.villagerNumber >= resource.woodPeople + resource.steelPeople){
                    System.out.println(resource.getDistribution());
                }else{
                    System.out.println("超出總人數");
                }
            }
//            }

            // 時間前進指令

//


//如果指令試next開頭 更改需要跳過的時間
            if (orderArray[0].substring(0,4).equals("next")) {
                System.out.println(orderArray[0].substring(0,4));
                System.out.println(orderArray[0].substring(4));
                
                switch(orderArray[0].substring(4)){
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
            for(int h=0; h<tmp; h++){
                // 產生資源
                date.nextHour();
                resource.woodAdd();
                resource.steelAdd();
                // 產生村民和士兵
                buildingArray.buildingsGeneratePeople(date.time, villagers);
                // 判斷建築狀態決定是否建造
                for(int i=0; i<resource.buildingPeople.size(); i++){                
                    if(resource.buildingPeople.get(i)[1] == 0){
                        buildingArray.buildBuildings(date, resource.buildingPeople.get(i)[0]);
                        resource.buildingPeople.get(i)[1] -= date.addTime;
                        resource.buildingPeople.remove(i);
                    }
                }

    //......................升級是否完成.......................

    //殭屍來襲if(date.time%16==0){do it!}
                date.passTime --;
                if(date.time % 16== 0){
                    System.out.println("殭屍來襲");
                    System.out.println("是否重新配置 是>>break");
                }
                
            }//生產資源迴圈
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
            System.out.println("passTime:" + date.passTime);

        }
        System.out.println("Game Over!");
    }
}
