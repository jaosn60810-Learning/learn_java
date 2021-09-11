package com.company;

public class PeopleHouse extends Building {
    public PeopleHouse(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("房屋");
        super.setBuildingNumber(1);
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
