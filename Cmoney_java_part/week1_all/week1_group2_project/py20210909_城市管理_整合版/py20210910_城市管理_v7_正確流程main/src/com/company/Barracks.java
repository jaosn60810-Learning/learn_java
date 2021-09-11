package com.company;

public class Barracks extends Building {
    private int genUnit = 1;
    private int barracksProduceSoldierStartTime;
    private int barracksTechDevelopStartTime = -1;

    public Barracks(int time) {
        super(time);
        super.setBuildingName("軍營");
        super.setBuildingNumber(3);
        this.barracksProduceSoldierStartTime = time;
    }

    // 判斷生產士兵時間是否到了 來增加士兵數量
    public void generateSoldier(Soldier soldier, int realWorldTime) {
        int n = (realWorldTime - this.barracksProduceSoldierStartTime) / 3;
        // n 波 * genUnit 個士兵
        for (int i = 0; i < n * genUnit; i++) {
            soldier.soliderAdd();
        }
        this.barracksProduceSoldierStartTime += 3 * n;
    }

    // 開始研發 判斷資源是否足夠 紀錄開始開發的時間
    @Override
    public void techDevelop(int realWorldTime, Resource resource) {
        if (resource.wood >= 30 && resource.steel >= 15) {
            barracksTechDevelopStartTime = realWorldTime;
        } else {
            System.out.println("資源不足");
        }
    }

    // 判斷開發時間是否到了 來增加士兵血量
    public void isTechDevelop(int realWorldTime, Resource resource) {
        if (barracksTechDevelopStartTime != -1) {
            int n = (realWorldTime - this.barracksTechDevelopStartTime) / 30;
            for (int i = 0; i < n; i++) {
                genUnit++;
                super.setBuildingLevel(super.getBuildingLevel() + 1);
            }
            if (n >= 1) {
                this.barracksTechDevelopStartTime = -1;
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
                ", barracksProduceSoldierStartTime=" + this.barracksProduceSoldierStartTime +
                ", genUnit=" + this.genUnit +
                ", barracksTechDevelopStartTime=" + this.barracksTechDevelopStartTime +
                '}';
    }
}
