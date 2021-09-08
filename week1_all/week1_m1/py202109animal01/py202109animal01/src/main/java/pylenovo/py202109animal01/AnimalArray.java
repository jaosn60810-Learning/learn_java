/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109animal01;
/**
 *
 * @author kisso
 */

//可以依照動物的姓名排序動物(String compare)
//可以依照動物的體重排序動物
//可以按當前array中的順序印出所有動物
public class AnimalArray {
    private int index = 0;
    Animal[] arr = new Animal[1];
    private void doubleArray(Animal[] arr){
        Animal[] arr2 = new Animal[arr.length*2];
        for(int i=0; i<arr.length; i++){
            arr2[i] = arr[i];
        }
        this.arr = arr2;
    }
    
    public void append(Animal animal){
        if(arr.length == index){
            doubleArray(arr);
        }
        arr[index] = animal;
        index ++ ;
    }
    
    public void insert(Animal animal,int n){
        if(arr.length == index){
            doubleArray(arr);
        }
        for(int i=n; i<index; i++){
            arr[i+1] = arr[i];
        }
        arr[n] = animal;
        index ++ ;
    }
    
    public void delete(int n){
        for(int i=n; i<index-1; i++){
            arr[i] = arr[i+1];
        }
        index -- ;
    }
    
    public void sortbyName(){
        for(int i=0; i<index-1; i++){
            for(int j=0; j<index-1-i; j++){
                if(arr[j].name.compareTo(arr[j+1].name) < 0){
                    Animal tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    
    public void sortbyWeight(){
        for(int i=0; i<index-1; i++){
            for(int j=0; j<index-1-i; j++){
                if(arr[j].weight < arr[j+1].weight){
                    Animal tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    
    public void showAnimal(){
        for(int i=0; i<index; i++){
            System.out.println(arr[i].toString());
        }
    }
}
