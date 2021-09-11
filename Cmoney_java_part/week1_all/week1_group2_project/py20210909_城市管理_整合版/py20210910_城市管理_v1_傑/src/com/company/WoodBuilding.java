package com.company;

public class WoodBuilding extends Building {
    private int woodBuildingTechDevelopStartTime = -1;

    public WoodBuilding(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("伐木場");
        super.setBuildingNumber(4);
    }

    // 開始研發 判斷資源是否足夠 紀錄開始開發的時間
    @Override
    public void techDevelop(int realWorldTime, Resource resource) {
        if (resource.wood >= 30 && resource.steel >= 15) {
            woodBuildingTechDevelopStartTime = realWorldTime;
        } else {
            System.out.println("資源不足");
        }
    }

    // 判斷開發時間是否到了 來增加資源採集效率
    public void isTechDevelop(int realWorldTime, Resource resource) {
        if (woodBuildingTechDevelopStartTime != -1) {
            int n = (realWorldTime - this.woodBuildingTechDevelopStartTime) / 30;
            for (int i = 0; i < n; i++) {
                resource.woodEfficiency += 2;
            }
            this.woodBuildingTechDevelopStartTime += 30 * n;
        }
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingTime=" + super.getBuildingTime() +
                ", buildingLevel=" + super.getBuildingLevel() +
                ", buildingName='" + super.getBuildingName() + '\'' +
                ", buildingNumber=" + super.getBuildingNumber() +
                ", woodBuildingTechDevelopStartTime=" + this.woodBuildingTechDevelopStartTime +
                '}';
    }
}
