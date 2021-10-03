package controllers;

import scene.Scene;
import utils.CommandSolver.*;

import java.awt.*;

public class SceneController {

    private static SceneController sceneController;

    private SceneController() {
    }

    public static SceneController instance() {
        if (sceneController == null) {
            sceneController = new SceneController();
        }
        return sceneController;
    }

    private Scene lastScene;
    private Scene currentScene;

    public void change(Scene scene) {
        lastScene = currentScene;
        scene.sceneBegin();
        currentScene = scene;
    }

    public void paint(Graphics g) {
        if (currentScene != null) {
            currentScene.paint(g);
        }
    }


    public void update() {
        if (lastScene != null) {
           lastScene.sceneEnd();
           lastScene = null;
        }
        if (currentScene != null) {
            currentScene.update();
        }
    }


    public MouseCommandListener mouseListener() {
        return currentScene.mouseListener();
    }

    public KeyListener keyListener() {
        return currentScene.keyListener();
    }
}
