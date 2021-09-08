import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ecosystem {
    private final int width;
    private final int height;
    private Sprite[][] board;

    public Ecosystem(int width, int height) {
        this.width = width;
        this.height = height;
        board = new Sprite[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void putSprite(Sprite sprite) {
        sprite.setEcosystem(this);
        sprite.setX(sprite.getX());
        sprite.setY(sprite.getY());
        board[sprite.getY()][sprite.getX()] = sprite;
    }

    public Sprite getSpriteAt(int x, int y) {
        return board[y][x];
    }

    public void updateSpriteLocation(Sprite sprite, int newX, int newY) {
        //如果原先的位置並非新生兒則為被吃掉的生物→成為空格
        Sprite spriteAtPlace = board[sprite.getY()][sprite.getX()];
        board[sprite.getY()][sprite.getX()] = spriteAtPlace instanceof NewbornCreature ?
                spriteAtPlace : new Block(sprite.getX(), sprite.getY(), this);

        sprite.setX(newX);
        sprite.setY(newY);
        board[sprite.getY()][sprite.getX()] = sprite; //放置更新之後的位置
    }

    public void start() {
        complementBlocks();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(this);
            scanner.nextLine();
            moveAllSprites();
        }
    }

    private void complementBlocks() {
        // 將空位全部填滿成Block
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                if (board[y][x] == null) {
                    board[y][x] = new Block(x, y, this);
                }
        }
    }

    private void moveAllSprites() {
        Set<Sprite> movedSprites = new HashSet<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                if (!movedSprites.contains(board[y][x])) {
                    movedSprites.add(board[y][x]);
                    board[y][x].move();
                }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                stringBuilder.append(board[y][x]).append(" ");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
