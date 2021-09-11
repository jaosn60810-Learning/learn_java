package com.company;

public abstract class Building {
    private int buildingTime;
    private int buildingLevel = 1;
//University無法改父類別參數 
//    private int civilLevel = 1;
    
//不設限建築等級
//    private int limit ;
    private String buildingName;
    private int buildingNumber;


    public Building(int buildingTime) {
        this.buildingTime = buildingTime;
    }

//    public int getCivilLevel() {
//        return civilLevel;
//    }
//
//    public void setCivilLevel(int civilLevel) {
//        this.civilLevel = civilLevel;
//    }
    
//不設限建築等級
//    public int getLimit() {
//        return limit;
//    }
//
//    public void setLimit(int limit) {
//        this.limit = limit;
//    }

    public int getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(int buildingTime) {
        this.buildingTime = buildingTime;
    }

    public int getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
    
    // 使所有房屋都有升級的功能
    public void techDevelop(int realWorldTime,Resource resource){
        
    }

    // 掃視所有建築是否有需要升級
    public void isTechDevelop(int realWorldTime,Resource resource){

    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingTime=" + buildingTime +
                ", buildingLevel=" + buildingLevel +
//                ", civilLevel=" + civilLevel +
//不設限建築等級
//                ", limit=" + limit +
                ", buildingName='" + buildingName + '\'' +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}
