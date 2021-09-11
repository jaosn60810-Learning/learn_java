package com.company;



public abstract class Building {
    private int buildingTime;
    private Resource buildingNeedResource;
    private int buildingLevel;
    private String buildingName;
    private int buildingNumber;

    public Building(int buildingTime, Resource buildingNeedResource, int buildingLevel, String buildingName, int buildingNumber) {
        this.buildingTime = buildingTime;
        this.buildingNeedResource = buildingNeedResource;
        this.buildingLevel = buildingLevel;
        this.buildingName = buildingName;
        this.buildingNumber = buildingNumber;
    }

    public int getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(int buildingTime) {
        this.buildingTime = buildingTime;
    }

    public Resource getBuildingNeedResource() {
        return buildingNeedResource;
    }

    public void setBuildingNeedResource(Resource buildingNeedResource) {
        this.buildingNeedResource = buildingNeedResource;
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

    public abstract void generatePeople(int[] people,int hour);
    public abstract void techDevelop();



}
