package pylenovo.aoeintegration;

public class PeopleHouse extends Building {
    private int genUnit = 1;
    private int peopleHouseProduceVillagerStartTime;

    public PeopleHouse(int time) {
        super(time);
//不設限建築等級
//        super.setLimit(2);
        super.setBuildingName("房屋");
        super.setBuildingNumber(1);
        this.peopleHouseProduceVillagerStartTime = time;
    }

    public void generatePeople(Villager villagers, int realWorldTime) {
//by PY
//        if (realWorldTime - this.peopleHouseProduceVillagerStartTime >= 24) {
//            villagers.villagerAdd();
//            this.peopleHouseProduceVillagerStartTime += 24;
//        }
//
        int n = (realWorldTime - this.peopleHouseProduceVillagerStartTime)/24 ;
        for(int i=0; i<n; i++){
            villagers.villagerAdd();
        }
        this.peopleHouseProduceVillagerStartTime += 24*n;
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
                ", peopleHouseProduceVillagerStartTime=" + this.peopleHouseProduceVillagerStartTime +
                '}';
    }
}
