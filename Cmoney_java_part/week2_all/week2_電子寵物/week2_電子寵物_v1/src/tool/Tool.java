package tool;

import java.util.Scanner;

public class Tool {

    static Scanner sc = new Scanner(System.in);

    public static int gender(){//寵物性別
        int i = (int)(Math.random()*(2-1+1))+1;//用亂數隨機選1或2，1公 2母，同人類ID開頭
        return i;
    }

    public static Animal[] newRoom(Animal[] room){
        Animal newArr[] = new Animal[room.length+1];
        for(int i = 0; i < room.length; i++){
            newArr[i] = room[i];
        }
        return newArr;
    }
    
//    public static Animal[] sellAnimal(Animal[] room, int animalNum){
//        int count = 0;
//        for(int i = 0; i < room.length; i++){
//            if(room[i] == null){
//                count++;
//                continue;
//            }else if(room[i].type == animalNum){
//                room[i] = null;
//                count++;
//                break;
//            }
//        }
//        return room;
//    }

    public static void newAnimal(int i,Animal[]room){
        int gender = Tool.gender();
        Scanner sc = new Scanner(System.in);
        switch(i){
            case 1:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.println("：");
                String name = sc.nextLine();
                Dog dog = new Dog(name);
                for(i = 0; i < room.length ; i++) {
                    if (room[i] == null) {//如果找到空房間
                        room[i] = dog;//把this dog放進房間
                        break;
//                    } else {//沒有空房間
//                        System.out.println("寵物房已不足，是否購買寵物房？ (Y)進入商店、(N)不進入商店(新生的寵物將直接被遺棄)");
//                        while (true) {
//                            System.out.println("請輸入 Y 或 N :");
//                            System.out.print(":");
//                            String opt1 = sc.nextLine();
//                            if (opt1.equals("Y")) {
//                                //強制進入商店，最終商店會回傳boolean
//                                if (Shop.forceBuying(1) = true) {//如果購買房子成功，就再跑一次“將寵物放入房間”流程
//                                    for (i = 0; i < room.length; i++) {
//                                        if (room[i] == null) {//如果找到空房間
//                                            room[i] = dog;//把this dog放進房間
//                                            break;
//                                        } else if (Shop.forceBuying(1) = false) {//如果選擇進入商店，但購買房子失敗
//                                            System.out.println("沒地方住啦ＱＱ 要跟主人說掰掰ㄌ ><");
//                                            break;//等於新生寵物直接死亡
//                                        }
//                                    }
//                                }
//                            }
//                            if (opt1.equals("N")) {//新生寵物直接死亡
//                                System.out.println("嗚嗚>< 主人你好狠心ＱＱ");
//                                break;
//                            }
//                        }
                    }
                }
                break;
            case 2:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小貓貓(Ф∀Ф) 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小貓貓(Ф∀Ф) 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.println("：");
                String name2 = sc.nextLine();
                Cat cat = new Cat(name2);
                for(i = 0; i < room.length ; i++) {
                    if (room[i] == null) {//如果找到空房間
                        room[i] = cat;//把this cat放進房間
                        break;
//                    } else {//沒有空房間
//                        System.out.println("寵物房已不足，是否購買寵物房？ (Y)進入商店、(N)不進入商店(新生的寵物將直接被遺棄)");
//                        while (true) {
//                            System.out.println("請輸入 Y 或 N :");
//                            System.out.print(":");
//                            String opt2 = sc.nextLine();
//                            if (opt2.equals("Y")) {
//                                //強制進入商店，最終商店會回傳boolean
//                                if (Shop.forceBuying(1) = true) {//如果購買房子成功，就再跑一次“將寵物放入房間”流程
//                                    for (i = 0; i < room.length; i++) {
//                                        if (room[i] == null) {//如果找到空房間
//                                            room[i] = cat;//把this cat放進房間
//                                            break;
//                                        } else if (Shop.forceBuying(1) = false) {//如果選擇進入商店，但購買房子失敗
//                                            System.out.println("沒地方住啦ＱＱ 要跟主人說掰掰ㄌ ><");
//                                            break;//等於新生寵物直接死亡
//                                        }
//                                    }
//                                }
//                            }
//                            if (opt2.equals("N")) {//新生寵物直接死亡
//                                System.out.println("嗚嗚>< 主人你好狠心ＱＱ");
//                                break;
//                            }
//                        }
                    }
                }
                break;
            case 3:
                if(gender == 1){
                    System.out.println("恭喜你！這隻可愛的小魚魚ʚ(•”̮•)ɞ 是男生唷！");
                }else if(gender == 2){
                    System.out.println("恭喜你！這隻可愛的小魚魚ʚ(•”̮•)ɞ 是女生唷！");
                }
                System.out.println("現在，來幫牠取名吧！");
                System.out.println("：");
                String name3 = sc.nextLine();
                Fish fish = new Fish(name3);
                for(i = 0; i < room.length ; i++) {
                    if (room[i] == null) {//如果找到空房間
                        room[i] = fish;//把this fish放進房間
                        break;
//                    } else {//沒有空房間
//                        System.out.println("寵物房已不足，是否購買寵物房？ (Y)進入商店、(N)不進入商店(新生的寵物將直接被遺棄)");
//                        while (true) {
//                            System.out.println("請輸入 Y 或 N :");
//                            System.out.print(":");
//                            String opt3 = sc.nextLine();
//                            if (opt3.equals("Y")) {
//                                //強制進入商店，最終商店會回傳boolean
//                                if (Shop.forceBuying(1) = true) {//如果購買房子成功，就再跑一次“將寵物放入房間”流程
//                                    for (i = 0; i < room.length; i++) {
//                                        if (room[i] == null) {//如果找到空房間
//                                            room[i] = fish;//把this fish放進房間
//                                            break;
//                                        } else if (Shop.forceBuying(1) = false) {//如果選擇進入商店，但購買房子失敗
//                                            System.out.println("沒地方住啦ＱＱ 要跟主人說掰掰ㄌ ><");
//                                            break;//等於新生寵物直接死亡
//                                        }
//                                    }
//                                }
//                            }
//                            if (opt3.equals("N")) {//新生寵物直接死亡
//                                System.out.println("嗚嗚>< 主人你好狠心ＱＱ");
//                                break;
//                            }
//                        }
                    }
                }
                break;
        }
    }
}