import java.util.Random;

/**
 * 空格
 */
public class Block extends Sprite {
    public Block(int x, int y, Ecosystem ecosystem) {
        super(x, y, '.');
        setEcosystem(ecosystem);
    }

    @Override
    public void move() {
        // 空格有機率變成草
        if (new Random().nextInt(100) < 4)  // 1/25機率變成草
            getEcosystem().putSprite(new Grass(getX(), getY()));
    }
}
