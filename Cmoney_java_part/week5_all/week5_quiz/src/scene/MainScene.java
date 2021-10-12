package scene;

import controllers.SceneController;
import gameobj.AirCraft;
import gameobj.CBoom;
import gameobj.CEnemy;
import utils.CommandSolver;
import utils.Global;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainScene extends Scene {
    private AirCraft ac;
    private ArrayList<CEnemy> arr;
    private ArrayList<CBoom> ammo;
    //遊戲開始時間
    private long gameStartTime;
    //遊戲現在時間
    private long gameCurrentTime;
    //飛機擊落數量
    private int killEnemyCount;
    // 敵人最小血量
    private int minBloodCount;
    // 敵人最大血量
    private int maxBloodCount;
    // 敵人血量控制器
    private boolean isAddBloodCount;
    // 敵人數量機率
    private int enemyChance;
    // 敵人數量控制器
    private boolean isAddEnemy;

    @Override
    public void sceneBegin() {
        ac = new AirCraft(10, 500);
        arr = new ArrayList<>();
        ammo = new ArrayList<>();
        // 畫面開始時 把系統時間抓下來
        gameStartTime = gameCurrentTime = System.nanoTime();
        // 敵人最小血量
        minBloodCount = 1;
        // 敵人最大血量
        maxBloodCount = 3;
        // 敵人血量控制器
        isAddBloodCount = true;
        // 敵人數量機率
        enemyChance = 1;
        // 敵人數量控制器
        isAddEnemy = true;


    }

    @Override
    public void sceneEnd() {
        ac = null;
        arr = null;
        ammo = null;
        SceneController.instance().irc().clear();
    }

    @Override
    public void paint(Graphics g) {
        // 時間顯示
        // 紅色字
        g.setColor(Color.red);
        // 計算經過時間
        float gameTime = (this.gameCurrentTime - this.gameStartTime) / 1000000000;
        // 畫出經過時間
        g.drawString(String.format("Time: %.2f", gameTime), 700, 15);

        // 擊毀飛機顯示
        // 紅色字
        g.setColor(Color.red);
        // 畫出擊毀飛機數量
        g.drawString("kill: " + this.killEnemyCount, 700, 550);

        // 每秒跑 FRAME_LIMIT 次
        ac.paint(g);
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).paint(g);
        }
        for (int i = 0; i < ammo.size(); i++) {
            ammo.get(i).paint(g);
        }
    }

    @Override
    public void update() {
        // 獲取現在系統時間
        gameCurrentTime = System.nanoTime();

        // 避免敵人血量狂加
        if ((killEnemyCount + 1) % 5 == 0 && killEnemyCount > 0) {
            isAddBloodCount = true;
        }
        // 當玩家每擊墜5架敵人飛機 則增加隨機範圍 最小值+1最大值+2
        if (killEnemyCount % 5 == 0 && killEnemyCount > 0 && isAddBloodCount) {
            this.maxBloodCount += 2;
            this.minBloodCount++;
            if (Global.IS_DEBUG) {
                System.out.println("敵人最低血量 " + minBloodCount);
                System.out.println("敵人最大血量 " + maxBloodCount);
            }
            isAddBloodCount = false;
        }


        // 計算生存時間
        long gameTime = (this.gameCurrentTime - this.gameStartTime) / 1000000000;
        // 避免敵人機率狂加
        if ((gameTime + 1) % 5 == 0 && gameTime > 0) {
            isAddEnemy = true;
        }
        //每經過5秒 則增加上限5台並增加產生機率5%
        if (gameTime % 5 == 0 && gameTime > 0 && isAddEnemy) {
            enemyChance++;
            if (Global.IS_DEBUG) {
                System.out.println("出現機率 " + enemyChance + "/20");
            }
            isAddEnemy = false;
        }

        // 隨機產生
        if (Global.random(1, 20) <= enemyChance && arr.size() < 11) {
            arr.add(new CEnemy(Global.random(0, 600), 0, Global.random(-5, 5), minBloodCount, maxBloodCount));
        }
        ac.update();
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).move()) {
                arr.remove(i--);
                continue;
            }
            if (ac.isCollision(arr.get(i))) {
                // 撞到敵機扣寫
                ac.hit();
                // 撞到敵機移除敵機 避免秒扣三滴結束遊戲
                arr.remove(i);
                // 增加擊毀飛機數量
                this.killEnemyCount++;
                // 如果血量低於 0 則叫出結束畫面
                if (ac.getBloodCount() <= 0) {
                    GameOverScene gameOverScene = new GameOverScene();
                    // 計算生存時間
                    gameTime = (this.gameCurrentTime - this.gameStartTime) / 1000000000;
                    // 將生存時間傳到 gameOverScene
                    gameOverScene.setGameTime(gameTime);
                    // 將擊毀數量傳到 gameOverScene
                    gameOverScene.setKillEnemyCount(this.killEnemyCount);
                    // 切換結束場景
                    SceneController.instance().change(gameOverScene);
                    continue;
                }
            }
            arr.get(i).update();
        }
        for (int i = 0; i < ammo.size(); i++) {
            CBoom boom = ammo.get(i);
            boom.update();
            if (boom.getState() != CBoom.State.NORMAL) {
                if (boom.getState() == CBoom.State.REMOVED) {
                    ammo.remove(i--);
                }
                continue;
            }
            if (boom.outOfScreen()) {
                ammo.remove(i--);
                continue;
            }
            for (int j = 0; j < arr.size(); j++) {
                CEnemy enemy = arr.get(j);
                if (boom.isCollision(enemy)) {
                    boom.setState(CBoom.State.BOOM);
                    // 飛彈打到扣寫
                    enemy.hit();
                    //如果生命低於 0 移除飛機
                    if (enemy.getBloodCount() <= 0) {
                        // 增加擊毀飛機數量
                        this.killEnemyCount++;
                        // 移除飛機
                        arr.remove(j);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return null;
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return new CommandSolver.KeyListener() {
            @Override
            public void keyPressed(int commandCode, long trigTime) {
                //按下左鍵飛機向左移動
                if (commandCode == Global.LEFT) {
                    ac.translateX(16 * -1);
                }
                //按下右鍵飛機向右移動
                if (commandCode == Global.RIGHT) {
                    ac.translateX(16);
                }
            }

            @Override
            public void keyReleased(int commandCode, long trigTime) {
                //按下並放開空白鍵飛機發射飛彈
                if (commandCode == Global.SPACE) {
                    ammo.add(new CBoom(ac.painter().left(), ac.painter().top()));
                }
            }

            @Override
            public void keyTyped(char c, long trigTime) {

            }
        };
    }
}
