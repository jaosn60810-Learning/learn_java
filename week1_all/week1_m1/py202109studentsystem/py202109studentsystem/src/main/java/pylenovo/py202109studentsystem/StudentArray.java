/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109studentsystem;

/**
 *
 * @author kisso
 */
import java.util.Scanner;
public class StudentArray {
    private int index = 0;
    private Student arr[];
    public StudentArray(){
        arr = new Student[1];
    }
    
    private void doubleArray(Student[] arr){
        Student[] arr2 = new Student[arr.length*2];
        for(int i=0; i<index; i++){
            arr2[i] = arr[i];
        }
        this.arr = arr2;
    }
    
    public void append(Student student){
        if(this.arr.length == index){
            doubleArray(arr);
        }
        arr[index] = student;
        index ++ ;
    }
    
    //指定座號成績
    public void getScore(int n){
        for(int i=0; i<index; i++){
            if(arr[i].seatno == n){System.out.println(arr[i].score);}            
        }
    }
    
    //sortbyscore依照成績由大到小排序學生
    public void sortByScore(){
        for(int i=0; i<index-1;i++){
            for(int j=0; j<index-1-i; j++){
                if(arr[j].score<arr[j+1].score){
                    Student tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    //sortbyseatno依照座號由小到大排序學生
    public void sortBySeatno(){        
        for(int i=0; i<index-1;i++){
            for(int j=0; j<index-1-i; j++){
                if(arr[j].seatno>arr[j+1].seatno){
                    Student tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    
    //修改成績
    public void reviseScore(int n){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<index; i++){
            if(arr[i].seatno == n){
                System.out.println("成績將修改為:(int)");
                arr[i].score = sc.nextInt();
            }
        }
    }
    
    public void showAll(){
        for(int i=0; i<index; i++){
            System.out.println(arr[i].toString());
        }
    }
    
    
}
