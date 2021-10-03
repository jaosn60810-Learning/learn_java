package gameexercise;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class CEnemy implements GameKernel.GameInterface{

    private Image img;
    private int x;  //圖片初始的x, y 座標
    private int y;
    private int d;   //每次位移的距離


    public CEnemy(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
        try {
            img = ImageIO.read(getClass().getResource("/resources/enemy1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void print(Graphics g){
        g.drawImage(img, x, y, null);
    }
    public boolean move(){
        y += Global.random(1, 4);    // 每次飛機下降的距離（下降速度)
        x += d;     // 每次飛機水平移動的距離

        if (y > 610){
            return false;  //false 代表敵機已離開畫面
        }
        return true;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    @Override
    public void update() {
        move();
    }


}
