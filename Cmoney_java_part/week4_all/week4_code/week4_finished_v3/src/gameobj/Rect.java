package gameobj;
// 物件碰撞判斷的長方形～  同理可改成圓形等等....

import java.awt.Graphics;

public class Rect {
    //長方形改為的上下左右的點位
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rect(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public Rect(Rect rect){
        this.left = rect.left;
        this.top = rect.top;
        this.right = rect.right;
        this.bottom = rect.bottom;
    }

    public static Rect genWithCenter(int x, int y, int width, int height){
        int left = x - width / 2;
        int right = left + width;
        int top = y - height / 2;
        int bottom = top + height;
        return new Rect(left, top, right, bottom);
    }

    public final int width(){  //右-左 = 寬
        return this.right - this.left;
    }
    public final int height(){ // 下-上 = 長
        return this.bottom - this.top;
    }
    public int left() {
        return left;
    }
    public void setLeft(int left) {
        this.left = left;
    }
    public int top() {
        return top;
    }
    public void setTop(int top) {
        this.top = top;
    }
    public int right() {
        return right;
    }
    public void setRight(int right) {
        this.right = right;
    }
    public int bottom() {
        return bottom;
    }
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int centerX(){
        return (left + right) / 2;
    }
    public int centerY(){
        return (top + bottom) / 2;
    }
    public float exactCenterX(){
        return (left + right) / 2f;
    }
    public float exactCenterY(){
        return (top + bottom) / 2f;
    }

    public final Rect translate(int dx, int dy){
        this.left += dx;
        this.right += dx;
        this.top += dy;
        this.bottom += dy;
        return this;
    }
    public final Rect translateX(int dx){
        this.left += dx;
        this.right += dx;
        return this;
    }
    public final Rect translateY(int dy){
        this.top += dy;
        this.bottom += dy;
        return this;
    }

    public final boolean overlap(int left, int top, int right, int bottom){
        // 判斷有無碰撞，也就是兩個物件相比
        //因為敵機是向下墜，所以上下左右都跟自己相反，然後判斷上下左右有其中一個吻合就代表不可能被撞到
        if(bottom() < top){
            return false;
        }
        if(top() > bottom){
            return false;
        }
        if(right() < left){
            return false;
        }
        if(left() > right){
            return false;
        }
        return true;
    }//用來判斷物件間的碰撞， 放入要判斷的物件長方形，抓取它的位置

    public final boolean overlap(Rect b){
        return overlap(b.left, b.top, b.right, b.bottom);
    }

    public final Rect clone(){
        return new Rect(left(), right(), width(), height());
    } // 複製一個長方形

    public final void paint(Graphics g){
        g.drawRect(left(), top(), width(), height());
    }

}