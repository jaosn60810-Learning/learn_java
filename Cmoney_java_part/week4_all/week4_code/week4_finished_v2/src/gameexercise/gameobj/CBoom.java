package gameexercise.gameobj;

import controllers.SceneController;
import gameexercise.utils.GameKernel;
import gameexercise.utils.Delay;
import gameexercise.utils.Path;
import java.awt.Graphics;
import java.awt.Image;

public class CBoom extends GameObject implements GameKernel.GameInterface{
    public enum State{
        NORMAL,
        BOOM,
        REMOVED
    }

    private Image img1, img2;
    private State state;  // state 0 代表子彈未爆， 1代表炸毀敵機
    private Delay delay;

    public CBoom(int x, int y, int width, int height){
        super(x, y, width, height);
        state = State.NORMAL;
        try {
            img1 = SceneController.instance().irc().tryGetImage(new Path().img().objs().boom());
            img2 = SceneController.instance().irc().tryGetImage(new Path().img().objs().boom2());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        delay = new Delay(30); // 這個30代表的是30楨，一秒有60楨， 30楨 = 0.5秒
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    @Override
    public void update() {
        if (state == State.NORMAL){
            translateY(-8);
        }else if (state == State.BOOM){
            delay.play();   // 正常來說只要讓play被觸發一次，也就是讓他想調成別的狀態避免重複觸發
        }
        if (delay.count()){
            state = State.REMOVED;
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        switch (state){
            case NORMAL:
                g.drawImage(img1,
                        painter().left(),
                        painter().top(),
                        painter().width(),
                        painter().height(), null);
                break;
            case BOOM:
                g.drawImage(img2,
                        painter().left(),
                        painter().top(),
                        painter().width(),
                        painter().height(), null);
                break;
        }
    }


}