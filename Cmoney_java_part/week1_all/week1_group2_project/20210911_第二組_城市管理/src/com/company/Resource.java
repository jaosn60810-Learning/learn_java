package com.company;

import java.util.ArrayList;


public class Resource {
    public int wood; //木材總數
    public int steel; //鋼鐵總數
    public int woodPeople;//採集木材人數
    public int steelPeople;//採集鋼鐵人數
    public int woodEfficiency;//採集木材效率
//
    public ArrayList<int[]> buildingStatus = new ArrayList<>();

    public int steelEfficiency;//採集鋼鐵效率
    public int resourceTime;
     
    public Resource(){}
    public Resource(int wood, int steel){
        this.wood = wood;
        this.steel = steel;
    }
    
//
    public void distribution(int wood, int steel){
        woodPeople = wood;
        steelPeople = steel;
    }
    
    public String getDistribution(){
        return "採集wood:" + woodPeople + " 採集steel:" + steelPeople;        
    }
    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getSteel() {
        return steel;
    }

    public void setSteel(int steel) {
        this.steel = steel;
    }

    public int getWoodEfficiency() {
        return woodEfficiency;
    }

    public void setWoodEfficiency(int woodEfficiency) {
        this.woodEfficiency = woodEfficiency;
    }

    public int getSteelEfficiency() {
        return steelEfficiency;
    }

    public void setSteelEfficiency(int steelEfficiency) {
        this.steelEfficiency = steelEfficiency;
    }

    public int getResourceTime() {
        return resourceTime;
    }

    public void setResourceTime(int resourceTime) {
        this.resourceTime = resourceTime;
    }

    public void woodAdd(){
        wood += woodPeople * woodEfficiency *resourceTime;

    }
    public void steelAdd(){
        steel += steelPeople * steelEfficiency *resourceTime;
    }

    public void changeBuildingStatus(int buildingNumber, int opt, int civilLevel){
        //可能報錯
        if(opt == 1){
            switch(buildingNumber){
                case 1://房屋
                    buildingStatus.add(new int[]{1,1,10,0});
                    break;
                case 2://研究所
                    buildingStatus.add(new int[]{2,3,10,5});
                    break;
                case 3://軍營
                    buildingStatus.add(new int[]{3,2,20,10});
                    break;
                case 4://伐木場
                    buildingStatus.add(new int[]{4,1,15,0});
                    break;
                case 5://煉鋼廠
                    buildingStatus.add(new int[]{5,1,15,5});
                    break;
                case 6://兵工廠
                    if(civilLevel>=2){
                        buildingStatus.add(new int[]{6,3,30,10});
                    }
                    System.out.println("文明等級不足!");
                    break;
            }
        }else if(opt == -1){
            for(int i=0; i<buildingStatus.size(); i++){
                int[] tmp = buildingStatus.get(i);
                if(tmp[0]==buildingNumber){
                    wood -= tmp[2];
                    steel -= tmp[3];
                    buildingStatus.remove(i);
                }
            }
            //根據不同的建築物返還
        }else{
            System.out.println("請輸入正確的指令");
        }
    }
}
