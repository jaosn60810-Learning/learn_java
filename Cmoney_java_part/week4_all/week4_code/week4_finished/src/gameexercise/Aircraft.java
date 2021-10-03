package gameexercise;

import gameexercise.GameKernel.GameInterface;
import gameexercise.CommandSolver.MouseState;
import gameexercise.CommandSolver.MouseCommandListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Aircraft implements GameInterface, MouseCommandListener{

    private Image img;
    private int x;  //圖片初始的x, y 座標
    private int y;
    private int dir;   // dir == 0  飛機左移， dir == 1 飛雞右移


    public Aircraft(int x, int y){
        this.x = x;
        this.y = y;
        dir = 0;

        try {
            img = ImageIO.read(getClass().getResource("/resources/airplane1.png")); //只要有IO的部分就會特別慢，路徑是URI的格式
            /* getResource 的 / 是這個專案的相對路徑，會在/前面補上當前資料位置，src這一層，IDE會有差異，可能在src的上一層，
               如果不加的話會是絕對路徑，會從C槽開始，但很容易會報錯，因為移開之後會錯誤，
                0, 0 代表的是x,y的位置，0,0是畫面的左上角
            */
        } catch (IOException ex) {  //不會讓程式直接動不了
            ex.printStackTrace();
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void move(){
        if(dir == 1){
            x += 5;
        }else{
            x -= 5;
        }
    }// 根據方向來設定圖形新的水平位置。
    public void changeDir(int x){
        if (this.x > x){
            dir = 0;
        }else{
            dir = 1;
        }
    }// 根據滑鼠現在的水平位置（x) 來判斷圖形要向左或向右 (決定上面的move的判斷)

    @Override
    public void paint(Graphics g){
        g.drawImage(img, x, y, null);
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

    public boolean checkAttack(CEnemy e){
        // 抓出我方及敵方的位置資料，1是我方，2是敵方
        // 加的數值 是飛機的本身的寬度、長度  因為畫布是以左上角為0 0 向下延伸是+
        int left1 = x;
        int right1 = x + 77;
        int top1 = y;
        int bottom1 = y + 45; //底部
        int left2 = e.getX();
        int right2 = e.getX() + 48;
        int top2 = e.getY();
        int bottom2 = e.getY() + 44;

        //因為敵機是向下墜，所以上下左右都跟自己相反，然後判斷上下左右有其中一個吻合就代表不可能被撞到
        if(bottom1 < top2){
            return false;
        }
        if(top1 > bottom2){
            return false;
        }
        if(right1 < left2){
            return false;
        }
        if(left1 > right2){
            return false;
        }
        return true;
    }//用來判斷飛機間的碰撞， 放入要判斷的飛機，抓取它的位置


}
