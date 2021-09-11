package com.company;

public class University extends Building {
    private int civilLevel = 1;
    //
    private int peopleHouseProduceVillagerStartTime;

    public University(int time) {
        super(time);
//不設限建築等級
//        super.setLimit(2);
        super.setBuildingName("研究所");
        super.setBuildingNumber(2);
        this.peopleHouseProduceVillagerStartTime = time;
    }

    public void upgradeBuilding(BuildingArray buildings, int realWorldTime, Resource resource, int buildingNumber) {
        buildings.upgradeBuildings(realWorldTime,resource,buildingNumber);
    }

    public void techDevelop() {
//by PY        
//        if (super.getBuildingLevel() < super.getLimit()) {
            civilLevel++;
            super.setBuildingLevel(super.getBuildingLevel() + 1);
//        } else {
//            System.out.println("It's the highest level!");
//        }
//revised
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingTime=" + super.getBuildingTime() +
                ", buildingLevel=" + super.getBuildingLevel() +
//                ", civilLevel=" + super.getCivilLevel() +
//不設限建築等級
//                ", limit=" + super.getLimit() +
                ", buildingName='" + super.getBuildingName() + '\'' +
                ", buildingNumber=" + super.getBuildingNumber() +
                ", peopleHouseProduceVillagerStartTime=" + this.peopleHouseProduceVillagerStartTime +
                '}';
    }
}
