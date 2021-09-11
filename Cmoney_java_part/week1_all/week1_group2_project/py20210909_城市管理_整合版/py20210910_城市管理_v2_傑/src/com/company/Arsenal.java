package com.company;

public class Arsenal extends Building {
    private int arsenalTechDevelopStartTime = -1;

    public Arsenal(int time) {
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("兵工廠");
        super.setBuildingNumber(6);
    }

    // 開始研發 判斷資源是否足夠 紀錄開始開發的時間
    @Override
    public void techDevelop(int realWorldTime, Resource resource) {
        if (resource.wood >= 70 && resource.steel >= 40) {
            arsenalTechDevelopStartTime = realWorldTime;
        } else {
            System.out.println("資源不足");
        }
    }

    // 判斷開發時間是否到了 來增加士兵數值
    public void isTechDevelop(int realWorldTime, Soldier soldier) {
        if (arsenalTechDevelopStartTime != -1) {
            int n = (realWorldTime - this.arsenalTechDevelopStartTime) / 48;
            for (int i = 0; i < n; i++) {
                soldier.soliderLife += 1;
                super.setBuildingLevel(super.getBuildingLevel() + 1);
            }
            if (n >= 1) {
                this.arsenalTechDevelopStartTime = -1;
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
                ", arsenalTechDevelopStartTime=" + this.arsenalTechDevelopStartTime +
                '}';
    }
}
