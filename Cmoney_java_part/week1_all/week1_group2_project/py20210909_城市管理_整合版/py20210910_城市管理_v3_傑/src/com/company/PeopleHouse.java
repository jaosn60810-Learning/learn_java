package com.company;

public class PeopleHouse extends Building {
    private int genUnit = 1;
    private int peopleHouseProduceVillagerStartTime;
    private int peopleHouseTechDevelopStartTime = -1;

    public PeopleHouse(int time) {
        super(time);
        super.setBuildingName("房屋");
        super.setBuildingNumber(1);
        this.peopleHouseProduceVillagerStartTime = time;
    }

    // 判斷生產村民時間是否到了 來增加村民數量
    public void generatePeople(Villager villagers, int realWorldTime) {
        int n = (realWorldTime - this.peopleHouseProduceVillagerStartTime) / 24;
        // n 波 * genUnit 個村民
        for (int i = 0; i < n * genUnit; i++) {
            villagers.villagerAdd();
        }
        this.peopleHouseProduceVillagerStartTime += 24 * n;
    }

    // 開始研發 判斷資源是否足夠 紀錄開始開發的時間
    @Override
    public void techDevelop(int realWorldTime, Resource resource) {
        if (resource.wood >= 30 && resource.steel >= 15) {
            peopleHouseTechDevelopStartTime = realWorldTime;
        } else {
            System.out.println("資源不足");
        }
    }

    // 判斷開發時間是否到了 來增加村民生產數量
    public void isTechDevelop(int realWorldTime, Resource resource) {
        if (peopleHouseTechDevelopStartTime != -1) {
            int n = (realWorldTime - this.peopleHouseTechDevelopStartTime) / 30;
            for (int i = 0; i < n; i++) {
                genUnit++;
                super.setBuildingLevel(super.getBuildingLevel() + 1);
            }
            if (n >= 1) {
                this.peopleHouseTechDevelopStartTime = -1;
            }
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
                ", genUnit=" + this.genUnit +
                ", peopleHouseTechDevelopStartTime=" + this.peopleHouseTechDevelopStartTime +
                '}';
    }
}
