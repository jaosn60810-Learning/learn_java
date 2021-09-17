package tool;

public class CatHair extends Item {

    public CatHair() {
        super.setName("貓毛");
        super.setBuyIn(0);
        super.setSellOut(1);
    }

    @Override
    public String toString() {
        return "CatHair{" +
                "name='" + super.getName() + '\'' +
                ", buyIn=" + super.getBuyIn() +
                ", sellOut=" +super.getSellOut() +
                '}';
    }
}
