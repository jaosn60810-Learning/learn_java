package com.company;
//兵工廠改已new出的Barracks物件的參數
//該Barracks根據新的參數addSoldier
public class Arsenal extends Building {
//    private int genUnit = 1;
//    private int peopleHouseProduceVillagerStartTime;

    public Arsenal(int time) {
        super(time);
//不設限建築等級
//        super.setLimit(2);
        super.setBuildingName("兵工廠");
        super.setBuildingNumber(6);
//        this.peopleHouseProduceVillagerStartTime = time;
    }

    @Override
    public void techDevelop(int realWorldTime,Resource resource) {
//by PY        
//        if (super.getBuildingLevel() < super.getLimit()) {
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
//                ", peopleHouseProduceVillagerStartTime=" + this.peopleHouseProduceVillagerStartTime +
                '}';
    }
}
