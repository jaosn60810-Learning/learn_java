package com.company;

public class Status {
    public void showStatus(Date date,Villager villagers,Soldier soldiers,Resource resource,Building building){
        System.out.println("時間: " + date.time);
        System.out.println("市民狀態: " + villagers);
        System.out.println("士兵狀態: " + soldiers);
        System.out.println("現有木頭: " + resource.getWood());
        System.out.println("現有鐵礦: " + resource.getSteel());
        System.out.println("採集木頭人數: " + resource.woodPeople + "人" + 
                            "\t採集鋼鐵人數: " + resource.steelPeople + "人" + 
                            "\t建築人數:" + building + "人");
        System.out.println("採集木頭效率: " + resource.woodEfficiency);
        System.out.println("採集鋼鐵效率: " + resource.steelEfficiency);
        System.out.println();
        for(int i=0; i<building.buildingObj.size(); i++){
            System.out.println("房屋編號:" + building.buildingObj.get(i)[0]);
            System.out.print("房屋等級:" + building.buildingObj.get(i)[1]);
            System.out.print("  升級判定:" + building.buildingObj.get(i)[4]);
            System.out.print("  升級時間:" + building.buildingObj.get(i)[7]);
            System.out.print("  建築判定:" + building.buildingObj.get(i)[8]);
            System.out.print("  建築所需時間:" + building.buildingObj.get(i)[9]);
            System.out.println("  建築完成時間:" + building.buildingObj.get(i)[10]);
//            for(int j=0; j<building.buildingObj.get(0).length; j++){
//                System.out.print(building.buildingObj.get(i)[j]);
//            }
        }
        System.out.println();
System.out.println();
System.out.println("《遊戲指令手冊》");
System.out.println("建築物編號和功能介紹:");
System.out.println("(1.房屋:\t\t可產生市民，升級後效率提升\t\t建造成本: 10 木材)");
System.out.println("(2.研究所:\t可升級建築和提升文明等級\t\t\t建造成本: 10 木材， 5 鋼鐵)");
System.out.println("(3.軍營:\t\t可產生士兵，升級後效率提升\t\t建造成本: 20 木材， 10 鋼鐵)");
System.out.println("(4.筏木場:\t可提高採集木材效率，升級後效率提升\t建造成本: 15 木材)");
System.out.println("(5.煉鋼場:\t可提高採集鋼鐵效率，升級後效率提升\t建造成本: 15 木材， 5 鋼鐵)");
System.out.println("(6.兵工廠:\t可升級士兵，提升攻擊力\t\t\t建造成本: 30 木材， 5 鋼鐵，文明等級需達: 2)");
System.out.println("輸入指令: (顯示狀態: status)、(採集人數分配: dist 指派採集木材人數 指派採集鋼鐵人數)、(建立建築物: build 建築物編號)");
System.out.println("輸入指令: (時間進行 1 小時: nexthour)、(時間進行 12 小時: nexthalfday)、(時間進行 24 小時: nextday)");    }
}
