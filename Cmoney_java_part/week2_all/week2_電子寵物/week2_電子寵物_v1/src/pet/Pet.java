/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pet;

/**
 *
 * @author charisma
 */
import tool.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Animal[] arr = {new Cat(),new Dog()};
        
        //Animal mouse = new Mouse();
        //arr = AnimalArray.insertAnimal(arr , mouse, 1);

        Scanner sc = new Scanner(System.in);
        //int foodVol = 5; //食物
        //int petRoom = 10; //寵物房
        //int backpackVol = 10; //背包格
        //int money = 0; // 錢
        //Animal[] animal = new Animal[10];
        
        //Animal[] room = new Animal[10];
        //Cat cat = new Cat2();
        //Dog dog = new Dog("ww");
        //Fish2 fish = new Fish2();
        //cat.setType("cat");
        //dog.setType("dog");
        //fish.setType("fish");
        //cat.setWeight(76);
        //dog.setWeight(55);
        //fish.setWeight(32);
        //cat.setName("Ban");
        //dog.setName("Daniel");
        //fish.setName("Danny");        
        
        //room[1] = cat;
        //room[2] = fish;
        Animal[] room = new Animal[10];
        System.out.println("嗨咿～～～歡迎來到電子寵物ʕ◉ᴥ◉ʔ  請輸入數字選擇你的第一隻動物 \t1.狗 \t2.貓\t3.魚");
        System.out.print("：");
        int opt = sc.nextInt();
        int gender = Tool.gender();
        String name = sc.nextLine();
        switch(opt){
            case 1:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.print("：");
                String name1 = sc.nextLine();
                Dog dog = new Dog(name1);
                dog.setGender(gender);
                room[0] = dog;
                
                break;
            case 2:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小貓貓(Ф∀Ф) 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小貓貓(Ф∀Ф) 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.print("：");
                String name2 = sc.nextLine();
                Cat cat = new Cat(name2);
                cat.setGender(gender);
                room[0] = cat;
                break;
            case 3:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小魚魚ʚ(•”̮•)ɞ 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小魚魚ʚ(•”̮•)ɞ 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.print("：");
                String name3 = sc.nextLine();
                Fish fish = new Fish(name3);
                fish.setGender(gender);
                room[0] = fish;
                break;
        }
        //Animal2[] room = new Animal2[10];
                System.out.println("嗨咿～～～歡迎來到電子寵物ʕ◉ᴥ◉ʔ  請輸入數字選擇你的第一隻動物 \t1.狗 \t2.貓\t3.魚");
                System.out.print("：");
                opt = sc.nextInt();
                gender = Tool.gender();
                name = sc.nextLine();
        switch(opt){
            case 1:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.print("：");
                String name1 = sc.nextLine();
                Dog dog = new Dog(name1);
                dog.setGender(gender);
                room[1] = dog;
                
                break;
            case 2:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小貓貓(Ф∀Ф) 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小貓貓(Ф∀Ф) 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.print("：");
                String name2 = sc.nextLine();
                Cat cat = new Cat(name2);
                cat.setGender(gender);
                room[1] = cat;
                break;
            case 3:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小魚魚ʚ(•”̮•)ɞ 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小魚魚ʚ(•”̮•)ɞ 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.print("：");
                String name3 = sc.nextLine();
                Fish fish = new Fish(name3);
                fish.setGender(gender);
                room[1] = fish;
                break;
        }
        
        
        
        int pocket = 0; // 錢
        Shop shop = new Shop(pocket);
        

        //Animal2[] room = new Animal2[10];
        //room[0] = new Animal2(0,0,0,0,0,0,0,0,0);
        //room[0] = dog;


        
        boolean check = true;
        System.out.println("開始與寵物們相遇吧!!!");
        //new Animal  //創建新寵物 （寵物）
        while(check) {
            Function.mainList(room , shop); // 主選單
        }
        
        
        
        
        
    
        
        
 }
    
    
    
    
}










