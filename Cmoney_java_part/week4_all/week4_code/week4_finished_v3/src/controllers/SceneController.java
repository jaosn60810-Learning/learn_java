package controllers;

import scene.Scene;
import utils.CommandSolver;
import utils.CommandSolver.KeyListener;
import utils.CommandSolver.MouseCommandListener;
import java.awt.Graphics;

public class SceneController{ // 切換場景的控制器

    private static SceneController sceneController;

    private SceneController(){
        lastIrc = new IRC();
        currentIrc = new IRC();
    }

    public static SceneController instance(){
        if (sceneController == null){
            sceneController = new SceneController();
        }
        return sceneController;
    }

    private Scene lastScene; // 暫存上一個場景
    private Scene currentScene;
    private IRC lastIrc;
    private IRC currentIrc;
    //如果讓SceneController 擁有滑鼠、鍵盤的指令，好處是只會new一次，在交換時處裡一次而已
//但如果今天想要讓同一個場景不同時期有不同的指令功能，
//那就要把監聽系統的屬性放在該屬性類別，但壞處就是每個都要用一次
    private MouseCommandListener m1;
    private KeyListener k1;

    public void change(Scene scene){
        lastScene = currentScene;   // 如果不先關掉的話，有可能會讓記憶體耗能提高，因為會同時存在圖片

        IRC tmp = currentIrc;
        currentIrc = lastIrc;
        lastIrc = tmp;

        if (scene != null){
            scene.sceneBegin();
            m1 = scene.mouseListener();  // 拿到該場景的滑鼠、鍵盤監聽系統，並儲存起來
            k1 = scene.keyListener();
        }
        currentScene = scene;
    }

    public void paint(Graphics g) {
        if (currentScene != null){
            currentScene.paint(g);
        }

    }

    public void update() {
        if (lastScene != null){
            lastScene.scenceEnd();
            lastIrc.clear();
            lastScene = null;
        }
        if (currentScene != null){
            currentScene.update();
        }
    }

    public CommandSolver.MouseCommandListener mouseListener() {
        return m1;
    }

    public CommandSolver.KeyListener keyListener() {
        return k1;
    }

    public IRC irc(){ // 傳回當前的影像
        return currentIrc;
    }



}