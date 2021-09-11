package com.company;

public class Status {
    public void showStatus(Date date,Villager villagers,Soldier soldiers,Resource resource,BuildingArray buildingArray){
        System.out.println("時間: " + date.time);
        System.out.println("市民: " + villagers);
        System.out.println("士兵: " + soldiers);
        System.out.println("木頭: " + resource.getWood());
        System.out.println("鐵礦: " + resource.getSteel());
        System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
        for (Building building : buildingArray.getBuildings()) {
            System.out.println("建築: " + building);
        }
        System.out.println();
        System.out.println("《遊戲指令手冊》");
        System.out.println("建築物編號: (1.房屋) (2.研究所) (3.軍營) (4.筏木場) (5.煉鋼場) (6.兵工廠)");
        System.out.println("指令:(顯示狀態:status)、(採集人數分配:woodsteel 木材人數 鋼鐵人數)、(建立建築物:build 建築物編號)");
        System.out.println("指令:(時間進行1小時:nexthour)、(時間進行12小時:nexthalfday)、(時間進行24小時:nextday)");
    }
}
