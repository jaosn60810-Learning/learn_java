package controller;

import scene.Scene;
import utils.CommandSolver;
import utils.GameKernel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SceneController implements GameKernel.PaintInterface, GameKernel.UpdateInterface
        , CommandSolver.KeyListener, CommandSolver.MouseListener {

    private Scene currentScene;

    public SceneController(Scene currentScene) {
        changes(currentScene);
    }

    public void changes(Scene scene) {
        if (this.currentScene != null) {
            this.currentScene.sceneEnd();
        }
        if (scene != null) {
            scene.sceneBegin();
        }
        this.currentScene = scene;
    }

    @Override
    public void paint(Graphics g) {
        if (this.currentScene != null) {
            this.currentScene.paint(g);
        }
    }

    @Override
    public void update() {
        if (this.currentScene != null) {
            this.currentScene.update();
        }
    }

    @Override
    public void keyPressed(final int commandCode, final long trigTime) {
        if (this.currentScene != null && this.currentScene.keyListener() != null) {
            this.currentScene.keyListener().keyPressed(commandCode, trigTime);
        }
    }

    @Override
    public void keyReleased(final int commandCode, final long trigTime) {
        if (this.currentScene != null && this.currentScene.keyListener() != null) {
            this.currentScene.keyListener().keyReleased(commandCode, trigTime);
        }
    }

    @Override
    public void keyTyped(final char c, final long trigTime) {
        if (this.currentScene != null && this.currentScene.keyListener() != null) {
            this.currentScene.keyListener().keyTyped(c, trigTime);
        }
    }

    @Override
    public void mouseTrig(final MouseEvent e, final CommandSolver.MouseState state, final long trigTime) {
        if (this.currentScene != null && this.currentScene.mouseListener() != null) {
            this.currentScene.mouseListener().mouseTrig(e, state, trigTime);
        }
    }

}
