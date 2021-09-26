package Pet;

public class Carton extends Item {

    public Carton() {
        super.setName("紙箱");
        super.setBuyIn(3);
        super.setSellOut(1);
    }

    @Override
    public String toString() {
        return "Carton{" +
                "name='" + super.getName() + '\'' +
                ", buyIn=" + super.getBuyIn() +
                ", sellOut=" +super.getSellOut() +
                '}';
    }
}
