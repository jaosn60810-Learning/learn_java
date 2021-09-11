package com.company;

public class University extends Building {
    private int civilLevel = 1;
    private int universityTechDevelopStartTime = -1;

    public University(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("研究所");
        super.setBuildingNumber(2);
    }

    // 開始研發 判斷資源是否足夠 紀錄開始開發的時間
    @Override
    public void techDevelop(int realWorldTime, Resource resource) {
        if (resource.wood >= 50 && resource.steel >= 20) {
            universityTechDevelopStartTime = realWorldTime;
        } else {
            System.out.println("資源不足");
        }
    }

    // 判斷開發時間是否到了 來增加資源採集效率
    public void isTechDevelop(int realWorldTime, Resource resource) {
        if (universityTechDevelopStartTime != -1) {
            int n = (realWorldTime - this.universityTechDevelopStartTime) / 24;
            for (int i = 0; i < n; i++) {
                civilLevel++;
                super.setBuildingLevel(super.getBuildingLevel() + 1);
            }
            if (n >= 1) {
                this.universityTechDevelopStartTime = -1;
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
                ", universityTechDevelopStartTime=" + this.universityTechDevelopStartTime +
                '}';
    }
}
