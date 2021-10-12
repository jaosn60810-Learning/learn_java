package gameobj;

import controllers.SceneController;
import utils.GameKernel.GameInterface;
import utils.CommandSolver.MouseState;
import utils.CommandSolver.MouseCommandListener;
import utils.Global.Direction;
import utils.Path;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

public class Batman extends GameObject implements GameInterface, MouseCommandListener{

    private Image img;
    private Direction dir;   // dir == 0  飛機左移， dir == 1 飛雞右移

    public Batman(int x, int y){
        super(x, y, 50, 50);
        dir = Direction.RIGHT;
//        img = SceneController.instance().irc().tryGetImage(PathClass.Resources.Imgs.Actors.AIR_CRAFT);   // 使用內部類別，全設為常數版本。
//  原本img = IRC.instance().tryGetImage(new Path().img().actors().aircraft()); 但為了實現換場景的功能，無法指使用IRC控制
        img = SceneController.instance().irc().tryGetImage(new Path().img().actors().aircraft());   // 使用內部類繼承版本（需要先new 該類別的物件實體後，利用方法取得。
        //

        /* getResource 的 / 是這個專案的相對路徑，會在/前面補上當前資料位置，src這一層，IDE會有差異，可能在src的上一層，
           如果不加的話會是絕對路徑，會從C槽開始，但很容易會報錯，因為移開之後會錯誤，
            0, 0 代表的是x,y的位置，0,0是畫面的左上角
        */
        //正常來說要利用path來控管路徑，以確保使用者不會輸錯路徑。


    }

    public void move(){
        switch (dir){
            case RIGHT:
                if (!touchRight()){
                    translateX(4);
                }
                break;
            case LEFT:
                if (!touchLeft()){
                    translateX(-4);
                }
                break;
            case UP:
                if (!touchTop()){
                    translateY(-4);
                }
                break;
            case DOWN:
                if (!touchBottom()){
                    translateY(4);
                }
                break;
        }
    }// 根據方向來設定圖形新的水平位置。

    public void changeDir(int x){
        if (painter().left() > x){
            dir = Direction.LEFT;
        }else{
            dir = Direction.RIGHT;
        }
    }// 根據滑鼠現在的水平位置（x) 來判斷圖形要向左或向右 (決定上面的move的判斷)

    @Override
    public void paintComponent(Graphics g){ // 改寫GameObject 的 paintComponent
        g.drawImage(img, painter().left(),painter().top(),
                painter().width(), painter().height(), null);
    }//在JFrame視窗上繪圖（把飛機放進去）

    @Override
    public void update() {
        move();
    }

    @Override
    public void mouseTrig(MouseEvent e, MouseState state, long trigTime) {
        if (state == MouseState.MOVED){
            changeDir(e.getX());
        }
    }







}