package com.company;

public abstract class Building {
    private int buildingTime;
    private int buildingLevel = 1;
    private String buildingName;
    private int buildingNumber;


    public Building(int buildingTime) {
        this.buildingTime = buildingTime;
    }

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

    // 升級房屋
    public void techDevelop(int realWorldTime, Resource resource) {
    }

    // 掃視所有建築是否有需要升級
    public void isTechDevelop(int realWorldTime, Resource resource) {

    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingTime=" + buildingTime +
                ", buildingLevel=" + buildingLevel +
                ", buildingName='" + buildingName + '\'' +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}
