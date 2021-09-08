import java.util.List;

public class Grass extends Creature {

    public Grass(int x, int y) {
        super(x, y, 'g', 0, 5, "Grass");
    }

    @Override
    protected Direction decideMovingDirection(List<Direction> availableDirections) {
        return Direction.NO_DIRECTION;  //不會移動
    }
}
