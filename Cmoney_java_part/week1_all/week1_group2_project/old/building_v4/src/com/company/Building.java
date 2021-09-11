package com.company;



public abstract class Building {
    private int buildingTime;
    private int buildingLevel = 1;
    private int civilLevel = 1;
    private int limit ;
    private String buildingName;
    private int buildingNumber;


    public Building(int buildingTime) {
        this.buildingTime = buildingTime;
    }

    public int getCivilLevel() {
        return civilLevel;
    }

    public void setCivilLevel(int civilLevel) {
        this.civilLevel = civilLevel;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    @Override
    public String toString() {
        return "Building{" +
                "buildingTime=" + buildingTime +
                ", buildingLevel=" + buildingLevel +
                ", civilLevel=" + civilLevel +
                ", limit=" + limit +
                ", buildingName='" + buildingName + '\'' +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}
