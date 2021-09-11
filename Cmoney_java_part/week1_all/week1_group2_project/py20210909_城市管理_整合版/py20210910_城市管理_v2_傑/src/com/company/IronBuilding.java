package com.company;

public class IronBuilding extends Building {
    private int ironBuildingTechDevelopStartTime = -1;

    public IronBuilding(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("煉鋼場");
        super.setBuildingNumber(5);
    }

    // 開始研發 判斷資源是否足夠 紀錄開始開發的時間
    @Override
    public void techDevelop(int realWorldTime, Resource resource) {
        if (resource.wood >= 30 && resource.steel >= 15) {
            ironBuildingTechDevelopStartTime = realWorldTime;
        } else {
            System.out.println("資源不足");
        }
    }

    // 判斷開發時間是否到了 來增加資源採集效率
    public void isTechDevelop(int realWorldTime, Resource resource) {
        if (ironBuildingTechDevelopStartTime != -1) {
            int n = (realWorldTime - this.ironBuildingTechDevelopStartTime) / 30;
            for (int i = 0; i < n; i++) {
                resource.steelEfficiency += 1;
                super.setBuildingLevel(super.getBuildingLevel() + 1);
            }
            if (n >= 1) {
                this.ironBuildingTechDevelopStartTime = -1;
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
                ", ironBuildingTechDevelopStartTime=" + this.ironBuildingTechDevelopStartTime +
                '}';
    }
}
