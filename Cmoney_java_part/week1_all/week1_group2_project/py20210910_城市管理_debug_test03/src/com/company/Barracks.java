package pylenovo.aoeintegration;

public class Barracks extends Building {
    private int genUnit = 1;
    private int BarracksProduceSoldierStartTime;

    public Barracks(int time) {
        super(time);
//不設限建築等級
//        super.setLimit(2);
        super.setBuildingName("軍營");
        super.setBuildingNumber(3);
        this.BarracksProduceSoldierStartTime = time;
    }

//待改    public void generatePeople(Villager villagers, int realWorldTime) {
    public void generateSoldier(Soldier soldier, int realWorldTime) {
//by PY
//        if (realWorldTime - this.peopleHouseProduceVillagerStartTime >= 24) {
//            villagers.villagerAdd();
//            this.peopleHouseProduceVillagerStartTime += 24;
//        }
//
        int n = (realWorldTime - this.BarracksProduceSoldierStartTime)/3 ;
//n波*genUnit個士兵
        for(int i=0; i<n*genUnit; i++){
//待改            villagers.villagerAdd();
            soldier.soliderAdd();
        }
        this.BarracksProduceSoldierStartTime += 24*n;
//revised
    }
    
    @Override
    public void techDevelop() {
//by PY        
//        if (super.getBuildingLevel() < super.getLimit()) {
            genUnit++;
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
                ", peopleHouseProduceVillagerStartTime=" + this.BarracksProduceSoldierStartTime +
                '}';
    }
}
