package com.company;

public class IronBuilding extends Building{
    public IronBuilding(int buildingTime, Resource buildingNeedResource, int buildingLevel, String buildingName, int buildingNumber) {
        super(buildingTime, buildingNeedResource, 1, "煉鋼廠", 5);
    }

    @Override
    public void generatePeople(int[] people, int hour) {

    }

    @Override
    public void techDevelop() {

    }

    @Override
    public String toString() {
        return "IronBuilding{}";
    }
}
