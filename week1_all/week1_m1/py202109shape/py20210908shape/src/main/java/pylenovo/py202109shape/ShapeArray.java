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

public class ShapeArray {
    private int index = 0;
    Shape[] arr = new Shape[1];
    Input input = new Input();
    private void doubleArray(Shape[] arr){
        Shape[] arr2 = new Shape[arr.length*2];
        for(int i=0; i<arr.length; i++){
            arr2[i] = arr[i];
        }
        this.arr = arr2;
    }

    public void append(){
        int opt = input.number("請選擇形狀 1是圓形 2是長方形:",1,2);
        //空間不夠就doubleArray
        if(arr.length == index){
            doubleArray(arr);
        }
        //新增可選擇形狀
        switch(opt){
            case 1:
                arr[index] = new Circle(input.number("請輸入半徑",1,10));
                break;
            case 2:
                arr[index] = new Rectangle(
                        input.number("請輸入長",1,10),
                        input.number("請輸入寬",1,10));
                break;
        }
        index ++ ;        
    }
    
    public String getShape(int n){
        return arr[n].toString();
    }
    
    public void showAll(){
        for(int i=0; i<index; i++){
            System.out.println(arr[i].toString());
        }
    }
    
    public void showRange(Point p1,Point p2){
        if(p1.x>p2.x){
            double tmp = p1.x;
            p1.x = p2.x;
            p2.x = tmp;
        }
        if(p1.y>p2.y){
            double tmp = p1.y;
            p1.y = p2.y;
            p2.y = tmp;
        }
        for(int i=0; i<index; i++){
            if(arr[i].point.x>=p1.x &&
                arr[i].point.x<=p2.x &&
                arr[i].point.y>=p1.y &&
                arr[i].point.y<=p2.y){
                System.out.println(getShape(i));            
            }
        }
    }
    
    public void sortbyArea(){
        for(int i=0; i<index-1; i++){
            for(int j=0; j<index-1-j; j++){
                if(arr[i].area()<arr[i+1].area()){
                    Shape tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
    }
    
    public void sortbyPerimeter(){
        for(int i=0; i<index-1; i++){
            for(int j=0; j<index-1-j; j++){
                if(arr[i].perimeter()<arr[i+1].perimeter()){
                    Shape tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
    }
    
    public double arrDistance(int a, int b){
        return arr[a].distance(arr[b]);
    }
    
}
