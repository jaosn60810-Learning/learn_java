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
public class Circle extends Shape{
    public static final double PI = 3.14;
    public double r;
    public Circle(double r){
        this.r = r;
    }

    @Override
    public double area(){
        return Math.round(r*r*PI*100)/100d;
    }
    
    @Override
    public double perimeter(){
        return Math.round(2*r*PI*100)/100d;
    }
}
