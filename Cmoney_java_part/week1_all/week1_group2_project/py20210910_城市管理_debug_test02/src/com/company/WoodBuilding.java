package com.company;

public class WoodBuilding extends Building {
    private final int limit = 1;

    public WoodBuilding(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("伐木場");
        super.setBuildingNumber(4);
    }



    public void techDevelop() {

    }

    @Override
    public String toString() {
        return "WoodBuilding{}";
    }
}
