package com.company;

public class Resource {
    public int wood; //木材總數
    public int steel; //鋼鐵總數
    public int woodPeople;//採集木材人數
    public int steelPeople;//採集鋼鐵人數
    public int woodEfficiency;//採集木材效率
    public int steelEfficiency;//採集鋼鐵效率
    public int resourceTime;

//預設資源為0
    public Resource(){}
//設定有參數的Resource建構子
    public Resource(int wood, int steel){
        this.wood = wood;
        this.steel = steel;
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

    public int getWoodPeople() {
        return woodPeople;
    }

    public void setWoodPeople(int woodPeople) {
        this.woodPeople = woodPeople;
    }

    public int getSteelPeople() {
        return steelPeople;
    }

    public void setSteelPeople(int steelPeople) {
        this.steelPeople = steelPeople;
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

}
