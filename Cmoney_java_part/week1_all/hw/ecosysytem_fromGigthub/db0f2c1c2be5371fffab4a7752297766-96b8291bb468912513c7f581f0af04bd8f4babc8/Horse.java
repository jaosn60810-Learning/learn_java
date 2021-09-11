import java.util.List;
import java.util.Random;

public class Horse extends Creature {
    public Horse(int x, int y) {
        super(x, y, 'h', 10, 8, "Horse");
    }

    @Override
    protected Direction decideMovingDirection(List<Direction> availableDirections) {
        return availableDirections.get(new Random().nextInt(availableDirections.size()));
    }
}
