/**
 * 八個方向之列舉並帶有位移資訊
 */
public enum Direction {
    LEFT_UP(-1, -1), UP(0, -1), RIGHT_UP(1, -1),
    LEFT(-1, 0), NO_DIRECTION(0, 0), RIGHT(1, 0),
    LEFT_DOWN(-1, 1), DOWN(0, 1), RIGHT_DOWN(1, 1);

    private int dx;  //位移x
    private int dy;  //位移y

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    /**
     * @return 有移動性的方向 i.e. NO_DIRECTION 以外的方向
     */
    public static Direction[] getMovingDirections() {
        return new Direction[] {LEFT_UP, UP, RIGHT_UP, LEFT, RIGHT, LEFT_DOWN, DOWN, RIGHT_DOWN};
    }
}
