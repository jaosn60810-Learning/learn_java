package gameexercise;

public class Global {
    // Debug Mode
    public static final boolean IS_DEBUG = true;
    public static void log(String str){
        if(IS_DEBUG){
            System.out.println(str);
        }
    }
    // 視窗大小
    public static final int FRAME_X = 800;  //外層視窗
    public static final int FRAME_Y = 600;  //外層視窗
    public static final int SCREEN_X = FRAME_X - 8 - 8; //內層視窗
    public static final int SCREEN_Y = FRAME_Y - 31 -8; //內層視窗
    // 資料刷新時間
    public static final int UPDATE_TIMES_PER_SEC = 60; // 每秒更新60次遊戲邏輯
    public static final int NANOSECOND_PER_UPDATE = 1000000000 / UPDATE_TIMES_PER_SEC; //每次更新的時間
    // 畫面更新時間
    public static final int FRAME_LIMIT = 60; //每秒更新60次畫面
    public static final int LIMIT_DELTA_TIME = 1000000000 / FRAME_LIMIT; // 每次更新畫面的時間
    // 遊戲單位大小
    public static final int UNIT_X = 32;
    public static final int UNIT_Y = 32;
    // 方向
    public static final int DOWN = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;

    public static boolean random(int rate){
        return random(1, 100) <= rate;
    }

    public static int random(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }

}