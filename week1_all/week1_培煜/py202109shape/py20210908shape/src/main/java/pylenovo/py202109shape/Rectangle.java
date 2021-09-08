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
public class Rectangle extends Shape{
    public double w;
    public double h;
    public Rectangle(double w, double h){
        this.w = w;
        this.h = h;
    }
    
    @Override
    public double area(){
        return w*h;
    }
    @Override
    public double perimeter(){
        return 2*(w+h);
    }
    
    

}
