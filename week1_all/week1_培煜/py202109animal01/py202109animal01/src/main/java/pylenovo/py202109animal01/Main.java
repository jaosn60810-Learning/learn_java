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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AnimalArray animals = new AnimalArray();
        System.out.println("新增動物在尾端");
        animals.append(new Cat("波絲貓",8));
        animals.append(new Dog("紅貴賓",3));
        animals.append(new Dog("黃金獵犬",12));
        animals.append(new Mouse("米奇",0.5));
        animals.showAnimal();
        System.out.println("\n插入動物在指定位置");
        animals.insert(new Mouse("哈姆太郎",0.4),3);
        animals.showAnimal();
        System.out.println("\n刪除指定位置的動物");
        animals.delete(2);
        animals.showAnimal();
        System.out.println("\n依名稱排序");
        animals.sortbyName();
        animals.showAnimal();
        System.out.println("\n依重量排序");
        animals.sortbyWeight();
        animals.showAnimal();
    }
}
