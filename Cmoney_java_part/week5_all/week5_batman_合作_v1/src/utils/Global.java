package utils;

public class Global {
    public enum Direction{  // 方向定義
        UP(3),
        DOWN(0),
        LEFT(1),
        RIGHT(2);

        private int value;
        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    //debug mode
    public static final boolean IS_DEBUG = true;

    //單位大小
    public static final int UNIX_X = 32;
    public static final int UNIX_Y = 32;

    //視窗大小
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int SCREEN_X = WINDOW_WIDTH -8 -8;  // 8 兩邊 boarder
    public static final int SCREEN_Y = WINDOW_HEIGHT -31 -8; // 31 navigation bar  和 8 boarder

    //資料刷新時間
    public static final int UPDATE_TIMES_PER_SEC = 60; //每秒更新60次遊戲邏輯
    public static final int NANOSECOND_PER_UPDATE = 1000000000 / UPDATE_TIMES_PER_SEC; // 每一次要花費的奈秒數
    //畫面更新時間
    public static final int FRAME_LIMIT = 60;
    public static final int LIMIT_DELTA_TIME = 1000000000 / FRAME_LIMIT; //每一次畫面更新要多少奈秒



    public static int random(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
