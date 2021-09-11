package com.company;

public class IronBuilding extends Building{
    public IronBuilding(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("煉鋼場");
        super.setBuildingNumber(5);
    }




    public void techDevelop() {

    }

    @Override
    public String toString() {
        return "IronBuilding{}";
    }
}
