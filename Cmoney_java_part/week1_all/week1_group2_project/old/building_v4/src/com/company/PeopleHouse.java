package com.company;

public class PeopleHouse extends Building {
    private int genUnit = 1;
    private int peopleHouseProduceVillagerStartTime;

    public PeopleHouse(int time) {
        super(time);
        super.setLimit(2);
        super.setBuildingName("房屋");
        super.setBuildingNumber(1);
        this.peopleHouseProduceVillagerStartTime = time;
    }

    public void generatePeople(Villager villagers, int realWorldTime) {
        if (realWorldTime - this.peopleHouseProduceVillagerStartTime >= 24) {
            villagers.villagerAdd();
            this.peopleHouseProduceVillagerStartTime += 24;
        }
    }

    public void techDevelop() {
        if (super.getBuildingLevel() < super.getLimit()) {
            genUnit++;
            super.setBuildingLevel(super.getBuildingLevel() + 1);
        } else {
            System.out.println("It's the highest level!");
        }
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingTime=" + super.getBuildingTime() +
                ", buildingLevel=" + super.getBuildingLevel() +
                ", civilLevel=" + super.getCivilLevel() +
                ", limit=" + super.getLimit() +
                ", buildingName='" + super.getBuildingName() + '\'' +
                ", buildingNumber=" + super.getBuildingNumber() +
                ", peopleHouseProduceVillagerStartTime=" + this.peopleHouseProduceVillagerStartTime +
                '}';
    }
}
