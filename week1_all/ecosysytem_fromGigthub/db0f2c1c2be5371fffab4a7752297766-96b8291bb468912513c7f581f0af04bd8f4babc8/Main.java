public class Main {
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem(5, 7);
        ecosystem.putSprite(new Horse(0, 0));
        ecosystem.putSprite(new Grass(0, 1));
        ecosystem.putSprite(new Grass(0, 2));

        ecosystem.putSprite(new Horse(1, 2));
        ecosystem.putSprite(new Grass(1, 5));
        ecosystem.putSprite(new Grass(1, 6));

        ecosystem.putSprite(new Horse(2, 1));

        ecosystem.putSprite(new Grass(3, 1));
        ecosystem.putSprite(new Grass(3, 2));

        ecosystem.putSprite(new Grass(4, 1));
        ecosystem.putSprite(new Horse(4, 3));
        ecosystem.putSprite(new Grass(4, 6));

        ecosystem.start();
    }
}
