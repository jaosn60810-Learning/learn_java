/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109aoe;

/**
 *
 * @author kisso
 */
public class PeopleArray {
    private int index = 0;
    public PeopleTest[] parr = new PeopleTest[1];
    
    public int getIndex() {
        return index;
    }    
    
    public void append(PeopleTest p){
        if(true){doubleArray();}
        //陣列增加人
        parr[index] = p;
        index ++ ;
    }
    
    public void doubleArray(){}
    
    public void sort(){
        //陣列排序
    }
}