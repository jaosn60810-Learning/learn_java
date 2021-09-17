package tool;

public class CatHair extends Item {

    public CatHair(String name,int buyIn,int sellOut) {
        super.setName(name);
        super.setBuyIn(buyIn);
        super.setSellOut(sellOut);
    }

    @Override
    public String toString() {
        return null;
    }
}
