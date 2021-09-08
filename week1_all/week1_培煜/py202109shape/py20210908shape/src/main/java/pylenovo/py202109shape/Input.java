/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109shape;
import java.util.*;
/**
 *
 * @author kisso
 */
public class Input {
    Scanner sc = new Scanner(System.in);
    public Input(){
        System.out.println("輸入值");
    }
    public int number(String str,int start,int end){
        System.out.println(str);
        //範圍尚未設定
        return sc.nextInt();
    }
    
}
