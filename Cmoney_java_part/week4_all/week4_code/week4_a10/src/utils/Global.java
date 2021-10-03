package utils;

public class Global {
    public static final boolean IS_DEBUG = false;

    // 視窗大小
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

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
