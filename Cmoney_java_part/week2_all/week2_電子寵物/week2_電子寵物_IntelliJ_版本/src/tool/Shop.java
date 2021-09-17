/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.Scanner;

/**
 *
 * @author mandy
 */
public class Shop {
        //Attribute
        Scanner sc = new Scanner(System.in);
        int pocket;
        String[] strSell = {"食物", "狗", "狗毛", "貓", "貓毛", "魚", "魚鱗"};
        int[] sell = {2, 10, 2, 7, 1, 7, 3};
        String[] strBuy = {"食物", "擴增寵物格", "擴增背包", "狗", "貓", "魚"};
        int[] buy = {5, 10, 10, 20, 15, 15};
        
        
        //從main傳入pocket引數
        public Shop(int pocket){
            this.pocket = pocket;
        }
        
        public void intoShop(Animal[] room){
            boolean tf = true;
            while(tf){
                System.out.println("購買商品請按1  賣出產品請按2  離開請按3  看背包請按0");
                int opt = sc.nextInt();
                switch(opt){
                    case 1:
                        buying(room);
                        break;
                    case 2:
                        sell(room);
                        break;
                    case 3:
                        tf = false;
                        break;
                    case 4:
                        //看背包數值
                }
            }
        }
        
        public void isEnd(Animal[] room){
            int overLine =0;
            for (Animal room1 : room) {
                if (room1 != null) {
                    // != 有人 ==沒人
                    overLine++;
                    break;
                }
            }
            if (overLine == 0) {//如果程式進行到這邊依然沒有人=所有房間都是空的>Gameover
                System.out.println("你的寶貝全都死撩撩了啦！！！！！");
                System.exit(0);
            }
        }

        public boolean checkIsEnoughAnimal(Animal[] room, int animalNum){
        int count = 0;
        for(int i = 0; i < room.length; i++){
            if(room[i] == null){
                count++;
            }else if(room[i].type == animalNum){
                room[i] = null;
                return true;
            }else if(room[i].type != animalNum){
                count++;
            }
        }
        if(count==room.length){
                return false;
        }else{
            return true;
        }
}
    
        public void buying(Animal[] room){
            System.out.println("您要購買第幾項產品(輸入1~6)\n1 食物(價格：５) 2 擴增寵物格(價格：10) 3 擴增背包(價格：10) 4 狗(價格：20) 5 貓(價格：1５) 6 魚(價格：1５) ");
            int opt1;
            //防呆
            while(true){
                opt1 = sc.nextInt();
                if (opt1 == 1 || opt1== 2 || opt1 == 3 || opt1 == 4 || opt1 == 5 || opt1 == 6){
                    break;
                } else {
                    System.out.println("輸入錯誤");
                }
            }
            //檢查錢夠不夠
            if(pocket - buy[opt1-1] < 0){
                System.out.print("錢不夠 ");
            }else{
                pocket -= buy[opt1-1];
                //對買的物品進行背包增減
                switch(opt1){
                    //對背包做食物+amount
                    case 1:
                        break;
                    //對Animal做擴增寵物格 +amount                      
                    case 2:
                        Tool.newRoom(room);
                        break;
                    //對背包做擴增背包 +amount
                    case 3:
                        break;
                    //對Animal做 new Dog() of Animal                        
                    case 4:
                        Tool.newAnimal(1, room);
                        break;
                    //對Animal做 new Cat() of Animal
                    case 5:
                        Tool.newAnimal(2, room);
                        break;
                    //對Animal做 new Fish() of Animal
                    case 6:
                        Tool.newAnimal(3, room);
                        break;
                }
            }
            System.out.println("錢包剩下"+ pocket);
    }
        
    public void sell(Animal[] room){
            System.out.println("您要賣第幾項產品(請輸入1~7)\n1 食物(價格：2) 2 狗(價格：10) 3 狗毛(價格：2) 4 貓(價格：7) 5 貓毛(價格：1) 6 魚(價格：7) 7 魚鱗(價格：3) ");
            int opt2;
            while(true){
                opt2 = sc.nextInt();
                if (opt2 == 1 || opt2== 2 || opt2 == 3 || opt2 == 4 || opt2 == 5 || opt2 == 6 || opt2==7){
                    break;
                } else {
                    System.out.println("輸入1~7拉");
                }
            }
            //檢查數量夠不夠!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            boolean tf;
            switch(opt2){
                //對背包做食物+amount
                case 1:
                    break;
                //對Animal做 減Dog()
                case 2:
                    tf = checkIsEnoughAnimal(room, 1);
                    if(tf==true){
                        pocket += sell[opt2-1];
                    }else{
                        System.out.println("數量不夠耶><");
                    }
                    break;
                //對背包做 狗毛+amount
                case 3:
                    break;
                //對Animal做 new Cat() of Animal 
                case 4:
                    tf = checkIsEnoughAnimal(room,  2);
                    if(tf==true){
                        pocket += sell[opt2-1];
                    }else{
                        System.out.println("數量不夠耶><");
                    }
                    break;
                //對背包做 貓毛+amount 
                case 5:
                    break;
                //對Animal做 new Fish() of Animal
                case 6:
                    tf = checkIsEnoughAnimal(room,  3);
                    if(tf==true){
                        pocket += sell[opt2-1];
                    }else{
                        System.out.println("數量不夠耶><");
                    }
                    break;
                //對背包做  魚鱗+amount
                case 7:
                    break;

            }
        isEnd(room);
        System.out.println("錢包剩下"+ pocket);
    }
        

        //當寵物格子或背包滿了強制進入購買流程，a=1為擴增寵物格，a=2為擴增背包
        public boolean forceBuying(Animal[] room, int a){
            int tmp = pocket - buy[a];
            //判斷餘額是否足夠
            if(tmp<0){
                //不足進入是否要賣東西
                while(true){
                    System.out.println("餘額不足，是否要賣東西，是按 1，否按 2，看背包請按 0");
                    int ans = sc.nextInt();
                    if(ans==0){
                        //call 背包數值
                    }
                    if(ans==1){
                        sell(room);
                        int tmp2 = pocket - buy[a];
                        if(tmp2>0){
                            pocket -= buy[a];
                            System.out.println("已自動擴增");
                            return true;
                        }
                    }else if(ans==2){
                        return false;                    
                    }else{
                        System.out.println("輸入0~2拉~");
                    }
                }
            }else{
                pocket -= buy[a];
                if(a==1){
                    //擴增寵物格 +1
                }else if(a==2){
                    //擴增背包 +1
                }
                return true;
            }
        }   
}