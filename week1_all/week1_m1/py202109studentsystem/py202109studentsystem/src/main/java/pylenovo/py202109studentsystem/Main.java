package pylenovo.py202109studentsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisso
 */
import java.util.ArrayList;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentArray arr = new StudentArray();
        arr.append(new Student(1,"601","Allen",80));
        arr.append(new Student(3,"601","Apple",60));
        arr.append(new Student(2,"601","Alina",30));
        arr.append(new Student(4,"601","Alice",90));
        //指定座號的成績
        arr.getScore(2);
        arr.showAll();

        //修改成績
        System.out.println();
        arr.reviseScore(3);
        arr.showAll();

        //成績排序
        System.out.println();
        arr.sortByScore();
        arr.showAll();
        System.out.println();

        //座號排序
        System.out.println();
        arr.sortBySeatno();
        arr.showAll();
        

    }
    
}
