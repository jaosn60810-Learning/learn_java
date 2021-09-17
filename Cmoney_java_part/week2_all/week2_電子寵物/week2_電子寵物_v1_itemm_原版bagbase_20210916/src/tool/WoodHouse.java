package tool;

public class WoodHouse extends Item {

    public WoodHouse() {
        super.setName("木屋");
        super.setBuyIn(4);
        super.setSellOut(2);
    }

    @Override
    public String toString() {
        return "WoodHouse{" +
                "name='" + super.getName() + '\'' +
                ", buyIn=" + super.getBuyIn() +
                ", sellOut=" +super.getSellOut() +
                '}';
    }
}
