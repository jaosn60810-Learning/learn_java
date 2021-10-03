package gameexercise.scene;

import controllers.SceneController;
import gameexercise.gameobj.Actor;
import gameexercise.utils.CommandSolver;
import static gameexercise.utils.Global.*;
import gameexercise.utils.Path;
import java.awt.Graphics;
import java.awt.Image;

public class ActorTestScene extends Scene{

    private Actor actor;

    @Override
    public void sceneBegin() {
        actor = new Actor(400 , 300, 6);
    }

    @Override
    public void scenceEnd() {
    }

    @Override
    public void paint(Graphics g) {
        actor.paint(g);
    }
    /*
    一個角色基本上是 32 * 32 （看圖片的裁切 ， Golbal UNIT_ X . Y 去調整每個的大小;
    取出的圖，放到對應的位置上
    dx 1   代表要印出的地點x , y  左上角
    dx 2   代表要印到的目標點 x, y 右下角  （跟原本大小不同時會做resize）
    sx 1   代表要抓取的地點 x, y  左上角
    sx 2   代表要抓到的目標點 x, y 右下角  原本的圖 0~96 、 0~128 抓出來。
    來源範圍的兩個點
    */

    @Override
    public void update() {
        actor.update();
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return null;
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return null;
    }

}