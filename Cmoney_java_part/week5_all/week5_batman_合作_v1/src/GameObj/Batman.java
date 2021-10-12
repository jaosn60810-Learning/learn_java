package GameObj;

import controllers.SceneController;
import utils.CommandSolver;
import utils.Global;
import utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Batman extends  GameObject implements  CommandSolver.KeyCommandListener {
    private Image img;
    private Global.Direction dir;


    public Batman (int x, int y) {
        super(x, y, 50, 50,x, y, 50, 50);
        dir = Global.Direction.RIGHT;
        //img = ImageResourceController.instance().tryGetImage(new Path().img().actors().airCraft());
        img = SceneController.instance().irc().tryGetImage(new Path().img().actors().batman());
    }




    public void move(){
        if(dir == Global.Direction.RIGHT && !touchRight()) {
            translateX(4);
        } else if ( dir == Global.Direction.LEFT && !touchLeft()){
            translateX(-4);
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
    }

    @Override
    public void update() {
        //每秒跑UPDATE_TIMES_PER_SEC次
        move();
    }

//    @Override
//    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {  // 抓滑鼠在動的時候鼠標的位置
//        if (state == CommandSolver.MouseState.MOVED) {
//            changeDir(e.getX());
//        }
//    }

    @Override
    public void keyPressed(int commandCode, long trigTime) {
        if (commandCode == 3) {
            changeDir(800);
        } else if (commandCode == 2) {
            changeDir(0);
        }
    }

    @Override
    public void keyReleased(int commandCode, long trigTime) {

    }
}
