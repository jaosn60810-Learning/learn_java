/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109shape;

/**
 *
 * @author kisso
 */
import java.util.Scanner;
public abstract class Shape {
    //Circle不想要有w h 屬性
    public Point point;
    public Shape(){
        Scanner sc = new Scanner(System.in);
        System.out.println("請設定座標");
        point = new Point(sc.nextDouble(),sc.nextDouble());
    }
    public abstract double area();
    
    public abstract double perimeter();
    //坐標軸
    
    public double distance(Shape shape){
        double dx = this.point.x - shape.point.x;
        double dy = this.point.y - shape.point.y;
        double ret = Math.pow(Math.pow(dx,2)+Math.pow(dy,2),0.5);
        ret = Math.round(ret*100)/100d;
        return ret;
    }

    
    @Override
    public String toString(){
        return  "面積:" + area() + 
                "周長:" + perimeter() + 
                "座標:" + point.x + "," + point.y;
    }
}
