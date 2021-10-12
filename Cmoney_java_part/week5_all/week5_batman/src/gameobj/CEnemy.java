package gameobj;

import controllers.SceneController;
import utils.GameKernel;
import utils.Global;
import utils.Path;
import java.awt.Graphics;
import java.awt.Image;

public class CEnemy extends GameObject implements GameKernel.GameInterface{

    private Image img;
    private int d;   //每次位移的距離
    private boolean isOutside;


    public CEnemy(int x, int y, int d){
        super(x, y, 50, 50);
        this.d = d;
        img = SceneController.instance().irc().tryGetImage(new Path().img().actors().enemy());   // 使用內部類繼承版本（需要先new 該類別的物件實體後，利用方法取得。
        isOutside = false;
    }

//    public boolean move(){
//        translateY(4);    // 每次飛機下降的距離（下降速度)
//        translateX(d);     // 每次飛機水平移動的距離
//        return painter().top() <= Global.FRAME_Y; //下面的簡寫
//    }

    public boolean outSide(){
        return isOutside;
    }


    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, painter().left(), painter().top(),
                painter().width(), painter().height(), null);
    }

    @Override
    public void update() {
        translateY(4);    // 每次飛機下降的距離（下降速度)
        translateX(d);     // 每次飛機水平移動的距離
        if (painter().top() > Global.FRAME_Y){
            isOutside = true;
        }
        //原本方法 因為要判斷飛機是否死亡，所以move在GI那邊做，改良變回外面感測boolean 讓update不是空方法
    }


}