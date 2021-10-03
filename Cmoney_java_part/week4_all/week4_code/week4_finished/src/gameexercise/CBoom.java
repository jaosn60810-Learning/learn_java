package gameexercise;

import gameexercise.CommandSolver.MouseState;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class CBoom implements GameKernel.GameInterface{
    private Image img, imgB;
    private int x;
    private int y;  // 子彈的座標
    private int state = 0;  // state 0 代表子彈未爆， 1代表炸毀敵機

    public CBoom(int sx, int sy){
        x = sx;
        y = sy;
        try {
            img = ImageIO.read(getClass().getResource("/resources/boom.png"));
            imgB = ImageIO.read(getClass().getResource("/resources/boom2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        if (state == 0){
            g.drawImage(img, x, y, null);
        }else{
            g.drawImage(imgB, x, y, null);
        }
    }

    public boolean move(){
        if(state == 0){  // 子彈如果還沒爆炸
            y -= 18;     //子彈持續上移
            if (y < 0){  // 如果y<0 代表子彈超出視窗範圍
                return false;
            }
        }else{
            state++;
            if(state > 12){
                return false;
            }
        }
        return true;
    }

    public int getState(){
        return state;
    }

    public boolean checkAttack(CEnemy e){
        int left1 = x;
        int right1 = x + 34;
        int top1 = y;
        int bottom1 = y + 40;
        int left2 = e.getX();
        int right2 = e.getX() + 48;
        int top2 = e.getY();
        int bottom2 = e.getY() + 44;

        if (bottom1 < top2){
            return false;
        }
        if (top1 > bottom2){
            return false;
        }
        if (right1 < left2){
            return false;
        }
        if (left1 > right2){
            return false;
        }
        state = 1;  // state = 1 代表炸毀敵機
        return true;  // 回傳true代表子彈打中敵機
    }

    @Override
    public void update() {
        move();
    }


}
