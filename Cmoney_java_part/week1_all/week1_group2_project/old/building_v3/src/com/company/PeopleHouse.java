package com.company;

public class PeopleHouse extends Building {
    private int peopleHouseProduceVillagerStartTime;
    public PeopleHouse(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("房屋");
        super.setBuildingNumber(1);
        this.peopleHouseProduceVillagerStartTime = time;
    }

    public void generatePeople(Villager villagers, int realWorldTime) {
        if(realWorldTime - this.peopleHouseProduceVillagerStartTime >= 24){
            villagers.villagerAdd();
            this.peopleHouseProduceVillagerStartTime = realWorldTime;
        }

    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingTime=" + super.getBuildingTime() +
                ", buildingLevel=" + super.getBuildingLevel() +
                ", buildingName='" + super.getBuildingName() + '\'' +
                ", buildingNumber=" + super.getBuildingNumber() +
                ", peopleHouseProduceVillagerStartTime=" + this.peopleHouseProduceVillagerStartTime +
                '}';
    }
}
