package gameobj;

import utils.GameKernel.GameInterface;
import utils.Global;
import static utils.Global.IS_DEBUG;
import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject implements GameInterface{

    private Rect collider;  // 判斷物件碰撞的方框畫面
    private Rect painter; //畫出來的方框畫面

    public GameObject(int x, int y, int width, int height) {
        this(x, y, width, height, x, y, width, height);
    }

    public GameObject(Rect rect) {
        collider = new Rect(rect);
        painter = new Rect(rect);
    }

    public GameObject(int x, int y, int width, int height,
                      int x2, int y2, int width2, int height2) {
        collider = Rect.genWithCenter(x, y, width, height);
        painter = Rect.genWithCenter(x2, y2, width2, height2);
    }

    public GameObject(Rect rect, Rect rect2) {
        collider = new Rect(rect);
        painter = new Rect(rect2);
    }

    public boolean touchTop(){
        return collider.top() <= 0;
    }
    public boolean touchLeft() {
        return collider.left() <= 0;
    }

    public boolean touchBottom() {
        return collider.bottom() >= Global.FRAME_Y;
    }

    public boolean touchRight() {
        return collider.right() >= Global.FRAME_X;
    }

    public boolean outOfScreen(){
        if (!touchRight() || !touchLeft() || !touchTop() || !touchBottom()){
            return false;
        }
        return true;
    }

    public boolean isCollision(GameObject obj){
        return collider.overlap(obj.collider);
    }

    public final void translate(int x, int y){
        collider.translate(x, y);
        painter.translate(x, y);
    }
    public final void translateX(int x){
        collider.translateX(x);
        painter.translateX(x);
    }
    public final void translateY(int y){
        collider.translateY(y);
        painter.translateY(y);
    }

    public Rect collider(){
        return collider;
    }
    public Rect painter(){
        return painter;
    }

    @Override
    public final void paint(Graphics g) { //只是看要不要印出DEBUG的資料而已
        paintComponent(g);
        if(IS_DEBUG){
            g.setColor(Color.red); //改顏色
            collider.paint(g);   //畫物件碰撞方框
            g.setColor(Color.green); //改顏色
            painter.paint(g);   //畫物件圖畫方框
//            g.drawRect(x, y, width, height); // 如果沒有將長方形另外拉一個類別的話，就要自己畫。
            g.setColor(Color.black);
        }
    }

    public abstract void paintComponent(Graphics g); // 留給各自物件去做改寫







}