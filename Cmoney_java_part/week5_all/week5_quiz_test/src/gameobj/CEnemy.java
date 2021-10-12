package gameobj;


import controllers.ImageController;
import controllers.SceneController;
import utils.Global;
import utils.Path;

import java.awt.*;

public class CEnemy extends GameObject {

    private Image img;
    private int d;
    // 敵方飛機血量
    private int bloodCount;
    private int minBloodCount;
    private int maxBloodCount;

    public CEnemy(int x, int y, int d, int minBloodCount, int maxBloodCount) {
        super(x, y, 50, 50);

        // 血量預設
        this.minBloodCount = minBloodCount;
        this.maxBloodCount = maxBloodCount;
        this.bloodCount = Global.random(minBloodCount, maxBloodCount);

        this.d = d;

        img = SceneController.instance().irc().tryGetImage(new Path().img().actors().enemy());
    }

    /**
     * 減少飛機血量
     */
    public void hit() {
        bloodCount--;
    }

    /**
     * 取的血量
     *
     * @return int 血量
     */
    public int getBloodCount() {
        return bloodCount;
    }

    public boolean move() {
        if (Global.IS_DEBUG) {
            translateY(1);
        }
        translateY(4);
        translateX(d);
        return painter().top() <= 600;
    }


    public void paintComponent(Graphics g) {
        g.drawImage(img, painter().left(), painter().top(),
                painter().width(), painter().height(), null);
    }

    @Override
    public void update() {

    }
}
