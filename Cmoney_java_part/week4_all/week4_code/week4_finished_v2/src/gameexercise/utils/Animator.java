package gameexercise.utils;

import controllers.SceneController;
import static gameexercise.utils.Global.UNIT_X;
import static gameexercise.utils.Global.UNIT_Y;
import java.awt.Graphics;
import java.awt.Image;

public class Animator {

    public enum State{
        WALK(new int[]{0,1,2,1}, 40),
        RUN(new int[]{0,2}, 25);

        private int[] arr;
        private int speed;  //不能直接加入Delay 因為每個人讀到的都是同一個，會起計算

        State(int[] arr, int speed){
            this.arr = arr;
            this.speed = speed;
        }
    }

    private Image img;
    private Delay delay;
    private int count;
    private State state;
    private int type;


    public Animator(int type, State state){ // type 看角色的狀態會不會很長改變，會的話就放去paintComponent
        img = SceneController.instance().irc().tryGetImage(new Path().img().actors().actors());
        delay = new Delay(0);
        delay.loop(); // 因為State 會一直更新，所以一旦有跑道setState delay的時間就會跟著調整
        count = 0;
        this.type = type;
        setState(state);
    }

    public final void setState(State state){
        this.state = state;
        delay.setLimit(state.speed);
    }

    public void paint(Global.Direction dir,int left, int top, int right, int bottom, Graphics g) {

//        g.drawImage(img, left, top,
//                right, bottom,
//                (type % 4) * UNIT_X * 3 + UNIT_X * state.arr[count],
//                (type / 4) * UNIT_X * 4 + UNIT_Y * dir.getValue(),
//                (type % 4) * UNIT_X * 3 + UNIT_X + UNIT_X * state.arr[count],
//                (type / 4) * UNIT_X * 4 + UNIT_Y + UNIT_Y * dir.getValue(), null);
    }

    public void update() {
        if (delay.count()){
            count = ++count % state.arr.length;
        }
    }

}