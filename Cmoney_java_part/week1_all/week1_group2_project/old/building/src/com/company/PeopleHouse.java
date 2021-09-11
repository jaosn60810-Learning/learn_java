package com.company;

public class PeopleHouse extends Building {
    public PeopleHouse(int buildingTime, Resource buildingNeedResource, int buildingLevel, String buildingName, int buildingNumber) {
        super(buildingTime, buildingNeedResource, 1, "房屋", 1);
    }

    @Override
    public void generatePeople(int[] people, int hour) {
        people[0]++;
    }


    @Override
    public void techDevelop() {

    }

    @Override
    public String toString() {
        return "PeopleHouse{}";
    }
}
