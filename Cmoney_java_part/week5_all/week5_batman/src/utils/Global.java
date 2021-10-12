package utils;

public class Global {  // 將一些常用的屬性，用Global 做一個包裝，當成一個工具包
    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    // Debug Mode
    public static final boolean IS_DEBUG = true;  // 用來設定要不要印FPS、相關除錯模式 EX:物件長方形邊框
    public static void log(String str){
        if(IS_DEBUG){
            System.out.println(str);
        }
    }
    // 視窗大小
    public static final int FRAME_X = 800;  //外層視窗
    public static final int FRAME_Y = 600;  //外層視窗
    public static final int SCREEN_X = FRAME_X - 8 - 8; //內層視窗   8是左右的邊況（基本是固定的）
    public static final int SCREEN_Y = FRAME_Y - 31 -8; //內層視窗   8是上下的邊況（基本是固定的），但是上面的標題站的大小長度是23 所以上面等於是- (23+8) = -31;
    //資料刷新時間
    public static final int UPDATE_TIMES_PER_SEC = 60; // 每秒更新60次遊戲邏輯（次數）
    public static final int NANOSECOND_PER_UPDATE = 1000000000 / UPDATE_TIMES_PER_SEC; //每次遊戲邏輯更新要花費的奈秒數（時間）
    //1000毫秒就是1秒 毫秒三個0   10的9次方分之1秒就是奈秒 也就是十億分之一秒，簡單來講奈秒就九個0 
    // 這裡也可以用long
    //畫面更新時間  跟資料刷新分開是因為要避免因為設備問題產生遊戲邏輯次數不同的狀況
    public static final int FRAME_LIMIT = 60;   //每秒畫面要print的次數 也就是FPS正常應有的值（次數）
    public static final int LIMIT_DELTA_TIME = 1000000000 / FRAME_LIMIT; //每次畫面更新要花的毫秒數（時間）
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