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
public class Student {

    /**
     * @param args the command line arguments
     */
    public int seatno;
    public String area;
    public String name;
    public int score;
    public Student(int seatno, String area, String name, int score){
        this.seatno = seatno;
        this.area = area;
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString(){
        return "座號:" + seatno + " 班級:" + area + " 姓名:" + name + " 成績:" + score;
    }
    
}
