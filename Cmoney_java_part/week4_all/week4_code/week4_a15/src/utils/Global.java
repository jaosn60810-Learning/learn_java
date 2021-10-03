package utils;

public class Global {
    public static final boolean IS_DEBUG = true;

    // 視窗大小
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int SCREEN_X = WINDOW_WIDTH - 8 - 8; //內層視窗   8是左右的邊況（基本是固定的）
    public static final int SCREEN_Y = WINDOW_HEIGHT - 31 -8; //內層視窗   8是上下的邊況（基本是固定的），但是上面的標題站的大小長度是23 所以上面等於是- (23+8) = -31;


    // 資料刷新時間
    public static final int UPDATE_TIMES_PER_SEC = 60; // 每秒更新60次遊戲邏輯
    public static final int NANOSECOND_PER_UPDATE = 1000000000 / UPDATE_TIMES_PER_SEC;// 每一次要花費的奈秒數

    // 畫面更新時間
    public static final int FRAME_LIMIT = 60;
    public static final int LIMIT_DELTA_TIME = 1000000000 / FRAME_LIMIT;


    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
