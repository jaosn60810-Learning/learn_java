package com.company;

public class WoodBuilding extends Building{
    public WoodBuilding(int buildingTime, Resource buildingNeedResource, int buildingLevel, String buildingName, int buildingNumber) {
        super(buildingTime, buildingNeedResource, 1, "伐木場", 4);
    }

    @Override
    public void generatePeople(int[] people, int hour) {

    }

    @Override
    public void techDevelop() {

    }

    @Override
    public String toString() {
        return "WoodBuilding{}";
    }
}
