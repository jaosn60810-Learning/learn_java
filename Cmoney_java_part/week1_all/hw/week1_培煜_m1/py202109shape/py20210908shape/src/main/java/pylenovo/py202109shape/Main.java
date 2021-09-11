/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109shape;
import java.util.Scanner;
/**
 *
 * @author kisso
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    //
    public static void main(String[] args) {
        // TODO code application logic here
        
        ShapeArray arr = new ShapeArray();
        //可選擇新增的形狀
        //1 5       //1 1 
        //2 5 15    //2 2
        //2 2 38    //4 4
        arr.append();
        arr.append(); 
        arr.append();
        System.out.println("印出指定位置形狀");
        System.out.println(arr.getShape(0));
        System.out.println(arr.getShape(1));
        arr.sortbyArea();//由大到小
        arr.showAll();
        arr.sortbyPerimeter();//由大到小
        arr.showAll();
        System.out.println(arr.arrDistance(1, 2));
        Point p1 = new Point(0,3);
        Point p2 = new Point(3,0);
        arr.showRange(p1,p2);
    }
}
