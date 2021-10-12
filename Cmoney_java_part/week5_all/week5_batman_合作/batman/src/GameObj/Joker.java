package GameObj;

import controllers.SceneController;
import gametest9th.utils.CommandSolver;
import gametest9th.utils.Delay;
import gametest9th.utils.Global;
import gametest9th.utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Joker extends  GameObject {
    private Image img;
    private Global.Direction dir;
    private int d;
    private Delay delay, delay2, delay3;

    public Joker (int x, int y,int d) {
        super(x, y, 60, 60,x, y, 50, 50);
        dir = Global.Direction.RIGHT;
        //img = ImageResourceController.instance().tryGetImage(new Path().img().actors().airCraft());
        img = SceneController.instance().irc().tryGetImage(new Path().img().actors().joker());
        this.d = d;
        delay = new Delay(60); //delay 30楨 ==0.5秒
        delay2 = new Delay(600);
        delay3 = new Delay(120);
        state = State.NORMAL;
    }

    public enum State {
        NORMAL,
        STAR
    }

    public State getState() {
        return state;
    }

    private Joker.State state;




    public void move(){
        if(dir == Global.Direction.RIGHT && !touchRight()) {
            translateX(d);
        } else if ( dir == Global.Direction.LEFT && !touchLeft()){
            translateX(-d);
        }
    }

    public void changeDir( int x){
        if (painter().left() > x) {
            dir = Global.Direction.LEFT;
        } else {
            dir = Global.Direction.RIGHT ;
        }
    }



    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, painter().left(), painter().top(), painter().width(), painter().height(),null); // 給左上角座標 和 寬高
        if (state == State.STAR) {
            g.setColor(Color.yellow);
            super.collider().paint(g);
        }
    }

    @Override
    public void update() {
        //每秒跑UPDATE_TIMES_PER_SEC次
        move();
        delay.loop();
        delay2.play();
        if (delay.countToLimit()) { // 如果數到 count的limit的時候
            changeDir(Global.random(1,800));
            d = Global.random(1,5);
        }
        if (delay2.countToLimit()) {
            state = State.STAR;
            delay3.play();
        }
        if (delay3.countToLimit()) {
            state = State.NORMAL;
            delay2.play();
        }



    }

}