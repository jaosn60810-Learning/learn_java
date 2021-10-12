package scene;

import utils.CommandSolver.KeyListener;
import utils.CommandSolver.MouseCommandListener;
import java.awt.Graphics;

public abstract class Scene {

    public abstract void sceneBegin();

    public abstract void scenceEnd();

    public abstract void paint(Graphics g);

    public abstract void update();
    //監聽滑鼠及鍵盤會設成抽象方法是提醒使用者繼承時，可以跑出來還沒被設訂，
//避免使用者不知道有這個功能，如果使用者不要使用，就return null 即可。
    public abstract MouseCommandListener mouseListener();
    public abstract KeyListener keyListener();

    /*  假設要讓場景可以暫停的話，可參考以下作法
    private boolean isPause;
    
    public Scene(){
        isPause = false;
    }
    
    public void paint(Graphics g){
        if (isPause){
            paintPause(g);
        }else{
            paintPlay(g);
        }
    }
    public abstract void paintPlay(Graphics g);
    public abstract void paintPause(Graphics g);
    
    public void pause(){
        isPause = true;
    }
    public void play(){
        isPause = false;
    }
     */
}