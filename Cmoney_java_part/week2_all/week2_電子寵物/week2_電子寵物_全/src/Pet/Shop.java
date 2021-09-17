
package Pet;

import java.util.Scanner;

/**
 *
 * @author mandy
 */
public class Shop {
        //Attribute
        Scanner sc = new Scanner(System.in);
        int pocket; // Paul 這個部分要從item抓 
        //商店買賣價錢列表
        String[] strSell = {"罐頭(狗/貓)","魚飼料","昆蟲飼料","擴增寵物格","擴增背包","狗","貓","魚","昆蟲","狗毛","貓毛","魚麟","木屑","紙箱","木屋","海草"};
        int[] sell = {2, 1, 1, 0, 0, 7, 3, 15, 15, 2, 1, 3, 1, 1, 2, 1};
        String[] strBuy = {"罐頭(狗/貓)","魚飼料","昆蟲飼料","擴增寵物格","擴增背包","狗","貓","魚","昆蟲","狗毛","貓毛","魚麟","木屑","紙箱","木屋","海草"};
        int[] buy = {5, 4, 3, 10, 10, 20, 15, 15, 15, 0, 0, 0, 0, 3, 4, 3};
        
        
        //從main傳入pocket引數
        public Shop(Player newPlayer){
            this.pocket = newPlayer.wallet;
        }
        
       // public void intoShop(Animal[] room , item[] position){  Paul 未加入
        public void intoShop(Player player){   
            boolean enterShop = true;
            int opt = 0;
            while(enterShop){
                System.out.println("購買商品請按1  賣出產品請按2  離開請按3");
                opt = sc.nextInt();
                if (opt == 1 || opt== 2 || opt == 3){
                    break;
                } else {
                    System.out.println("沒有這個選項喔");
                }
            }    
                switch(opt){
                    case 1:
                        buying(player.room, player.bag);
                        break;
                    case 2:
                        sell(player.room, player.bag);
                        break;
                    case 3:
                        enterShop = false;
                        break;
                    default:                       
                        break;
                }
            
        }
        
        public void isEnd(Animal[] room){  //確認賣完寵物後是否死完了
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

        public int checkIsEnoughAnimal(Animal[] room, String type){ // 確認足夠寵物數量
             int count = 0;
             for(int i = 0; i < room.length; i++){
                if(room[i] == null){
                    continue;
                }else if(room[i].type.compareTo(type) == 0) {
                    count++;
                }
             }   
             return count;   

        }
//        
        public int checkIsEnoughItem(Item[] item, String type){ // 查物品數量
             int count = 0;
             for(int i = 0; i < item.length; i++){
                if(item[i] == null){
                    continue;
                }else if(item[i].getName().compareTo(type) == 0){
                    count++;

                }
             }   
             return count;
        }
        
        public boolean checkBackpak(Item[] item, int numItem, String type){ // 查背包空位
             for(int i = 0; i < item.length; i++){
                if(item[i] == null){
                    return true;
                }else if(item[i].getName().compareTo(type) == 0 && (item[i].getCount() - 20) >= numItem ){
                    return true;
                }
             }
             return false;
        }     
        //public void buying(Animal[] room , Item[] position){ Paul 
    public void buying(Animal[] room , Bag bag){
            System.out.println("您要購買第幾項產品\n 1 罐頭(狗/貓)(價格：5) 2 魚飼料 (價格：4) 3 昆蟲飼料 (價格：3) 4 擴增寵物格(價格：10) 5 擴增背包(價格：10) 6 狗(價格：20) 7 貓(價格：15) 8 魚(價格：15) 9 昆蟲 (價格：15) 14 紙箱 (價格：15) 15 木屋 (價格：15) 16 海草 (價格：15)"); //有要從item和 player抓嗎？
            int opt1;
            //防呆
            while(true){
                opt1 = sc.nextInt();
                if (opt1 == 1 || opt1== 2 || opt1 == 3 || opt1 == 4 || opt1 == 5 || opt1 == 6 | opt1 == 7 || opt1 == 8 || opt1 == 9 || opt1 == 14 || opt1 == 15 || opt1== 16){
                    break;
                } else {
                    System.out.println("輸入有的東西啦");
                }
            }
            System.out.println("你的摳摳:" + pocket);
                int numItem;
                boolean enoughMoney;
                boolean enoughBackpack;
                boolean enoughRoom;
                switch(opt1){
                    //買罐頭
                    case 1:
                        while(true) {
                            System.out.println("請輸入你要買多少(1~10):");
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        enoughBackpack = checkBackpak(bag.getItems(), numItem, "CannedFood") ; //檢查背包
                        if (enoughMoney && enoughBackpack) {
                            bag.addItem("CannedFood" , numItem); // 背包
                            pocket -= buy[opt1-1] * numItem;
                            System.out.println("買入"+ strBuy[opt1-1] + " " + numItem);
                            System.out.println("摳摳剩下"+ pocket);
                        } else {
                            System.out.println("你的money或背包格不夠");
                        }
                        break;
                                         
                    case 2:
                        while(true) {
                            System.out.println("請輸入你要買多少(1~10):");
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        enoughBackpack = checkBackpak(bag.getItems(), numItem , "FishFood" ); //檢查背包
                        if (enoughMoney && enoughBackpack) {
                            bag.addItem("FishFood" , numItem); // 背包
                            pocket -= buy[opt1-1] * numItem;
                            System.out.println("買入"+ strBuy[opt1-1] + " " + numItem);
                            System.out.println("摳摳剩下"+ pocket);
                        } else {
                            System.out.println("你的money或背包格不夠");
                        }
                        break;
                    
                    case 3:
                        while(true) {
                            System.out.println("請輸入你要買多少(1~10):");
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        enoughBackpack = checkBackpak(bag.getItems(), numItem, "InsectFood" ); //檢查背包
                        if (enoughMoney && enoughBackpack) {
                            bag.addItem("InsectFood" , numItem); // 背包
                            pocket -= buy[opt1-1] * numItem;
                            System.out.println("買入"+ strBuy[opt1-1] + " " + numItem);
                            System.out.println("摳摳剩下"+ pocket);
                        } else {
                            System.out.println("你的money或背包格不夠");
                        }
                        break;
                    //對Animal做擴增寵物格 +amount 
                    case 4:
                        while(true) {
                            System.out.println("請輸入你要買多少(1~10):");
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        if (enoughMoney) {
                            int newRoom = room.length + numItem;
                            Animal[] temp = new Animal[newRoom];
                            for(int i = 0; i < room.length; i++) {
                                if(room[i] != null) {
                                    temp[i] = room[i];
                                }
                                
                            }
                            room = temp;
                        } else {
                            System.out.println("你的money不夠");
                        }

                        break;
                    //對背包做擴增背包 +amount
                    case 5:
                        System.out.println("請輸入你要買多少(1~10):");
                        while(true){
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        if (enoughMoney) {
                            int newItem = bag.getItems().length + numItem;
                            Item[] temp = new Item[newItem];
                            for(int i = 0; i < bag.getItems().length; i++) {
                                if(bag.getItems()[i] != null) {
                                    temp[i] = bag.getItems()[i];
                                }
                                
                            }
                            bag.setItems(temp);
                        } else {
                            System.out.println("你的money不夠");
                        }
                        break;
                    //對Animal做 new Dog() of Animal 
                    case 6:
                        while(true) {
                            System.out.println("請輸入你要買多少(1~10):");
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        enoughRoom = checkRoom(room); //檢查背包
                        if (enoughMoney && enoughRoom) {
                            newAnimal(strBuy[opt1-1], room);
                            pocket -= buy[opt1-1] * numItem;
                            System.out.println("摳摳剩下"+ pocket);
                        } else {
                            System.out.println("你的money或背包格不夠");
                        }                                                
                        break;
                    //對Animal做 new Cat() of Animal
                    case 7:
                        while(true) {
                            System.out.println("請輸入你要買多少(1~10):");
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        enoughRoom = checkRoom(room); //檢查背包
                        if (enoughMoney && enoughRoom) {
                            newAnimal(strBuy[opt1-1], room);
                            pocket -= buy[opt1-1] * numItem;
                            System.out.println("摳摳剩下"+ pocket);
                        } else {
                            System.out.println("你的money或背包格不夠");
                        }                                                
                        break;
                    //對Animal做 new Fish() of Animal
                    case 8:
                        while(true) {
                            System.out.println("請輸入你要買多少(1~10):");
                            numItem = sc.nextInt();
                            if (numItem > 0 && numItem < 11) {
                                break;
                            }
                        }
                        enoughMoney = checkMoney( buy[opt1-1], numItem, pocket); //檢查錢
                        enoughRoom = checkRoom(room); //檢查背包
                        if (enoughMoney && enoughRoom) {
                            newAnimal(strBuy[opt1-1], room);
                            pocket -= buy[opt1-1] * numItem;
                            System.out.println("摳摳剩下"+ pocket);
                        } else {
                            System.out.println("你的money或背包格不夠");
                        }                                                
                        break;           
                }        
            
    }
                
                
    //public void sell(Animal[] room , Item[] position){ Paul     
    public void sell(Animal[] room , Bag bag){
            System.out.println("您要賣第幾項產品 \n 1 罐頭(狗/貓)(價格：5) 2 魚飼料 (價格：4) 3 昆蟲飼料 (價格：3) 6 狗(價格：20) 7 貓(價格：15) 8 魚(價格：15) 9 昆蟲 (價格：15) 10 狗毛(價格：2) 11 貓毛(價格：1) 12 魚麟(價格：3) 13 木屑 (價格：1) 14 紙箱 (價格：1) 15 木屋 (價格：2) 16 海草 (價格：1) ");
            int opt2;
            while(true){
                opt2 = sc.nextInt();
                if (opt2 == 1 || opt2== 2 || opt2 == 3 ||  opt2 == 6 || opt2==7 || opt2 == 8 || opt2 == 9 || opt2 == 10 || opt2==11 || opt2 == 13 || opt2 == 14 || opt2==15 || opt2==16){
                    break;
                } else {
                    System.out.println("輸入有的東西啦");
                }
            }
           
            boolean check;
            int numItem;
            int remainItem;
            switch(opt2){
                case 1:
                    remainItem =checkIsEnoughItem(bag.getItems() , "CannedFood");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個罐頭,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "CannedFood", numItem);
                        System.out.println("你賣了" + numItem + "隻罐頭");
                        } else {
                            System.out.println("罐頭不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有罐頭");
                    }                       
                    break;
                case 2:
                    remainItem =checkIsEnoughItem(bag.getItems() , "FishFood");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個魚飼料,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "FishFood", numItem);
                        System.out.println("你賣了" + numItem + "個魚飼料");
                        } else {
                            System.out.println("魚飼料不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有魚飼料");
                    }                       
                    break;
                case 3:
                    remainItem =checkIsEnoughItem(bag.getItems() , "InsectFood");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個蟲飼料,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "InsectFood", numItem);
                        System.out.println("你賣了" + numItem + "個蟲飼料");
                        } else {
                            System.out.println("蟲飼料不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有蟲飼料");
                    }                       
                    break;
                case 6:
                    remainItem =checkIsEnoughAnimal(room , "Dog");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "隻狗仔,請輸入你要賣幾隻");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            deAnimal("Dog", room, numItem);
                        System.out.println("你賣了" + numItem + "隻狗仔");
                        System.out.println("錢包剩下"+ pocket);
                        } else {
                            System.out.println("狗仔不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有狗仔");
                    }                       
                    break;
                //對背包做  魚鱗+amount
                case 7:
                    remainItem =checkIsEnoughAnimal(room , "Cat");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "隻貓仔,請輸入你要賣幾隻");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            deAnimal("Dog", room, numItem);
                        System.out.println("你賣了" + numItem + "隻貓仔");
                        System.out.println("錢包剩下"+ pocket);
                        } else {
                            System.out.println("貓仔不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有貓仔");
                    }                       
                    break;
                case 8:
                    remainItem =checkIsEnoughAnimal(room , "Fish");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "隻魚仔,請輸入你要賣幾隻");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            deAnimal("Dog", room, numItem);
                        System.out.println("你賣了" + numItem + "隻魚仔");
                        System.out.println("錢包剩下"+ pocket);
                        } else {
                            System.out.println("魚仔不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有魚仔");
                    }                       
                    break;
                case 9:
                    remainItem =checkIsEnoughAnimal(room , "Insect");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "隻蟲仔,請輸入你要賣幾隻");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            deAnimal("Dog", room, numItem);
                        System.out.println("你賣了" + numItem + "隻蟲仔");
                        System.out.println("錢包剩下"+ pocket);
                        } else {
                            System.out.println("蟲仔不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有蟲仔");
                    }                       
                    break;
                case 10:
                    remainItem =checkIsEnoughItem(bag.getItems() , "DogHair");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個狗毛,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "DogHair", numItem);
                        System.out.println("你賣了" + numItem + "個狗毛");
                        } else {
                            System.out.println("狗毛不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有狗毛");
                    }                       
                    break;
                case 11:
                    remainItem =checkIsEnoughItem(bag.getItems() , "CatHair");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個貓毛,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "CatHair", numItem);
                        System.out.println("你賣了" + numItem + "個貓毛");
                        } else {
                            System.out.println("貓毛不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有貓毛");
                    }                       
                    break;
                case 12:
                    remainItem =checkIsEnoughItem(bag.getItems() , "FishScale");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個魚麟,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "FishScale", numItem);
                        System.out.println("你賣了" + numItem + "個魚麟");
                        } else {
                            System.out.println("魚麟不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有魚麟");
                    }                       
                    break;
                case 13:
                    remainItem =checkIsEnoughItem(bag.getItems() , "Sawdust");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個木屑,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "Sawdust", numItem);
                        System.out.println("你賣了" + numItem + "個木屑");
                        } else {
                            System.out.println("木屑不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有木屑");
                    }                       
                    break;
                case 14:
                    remainItem =checkIsEnoughItem(bag.getItems() , "Carton");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個紙箱,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "Carton", numItem);
                        System.out.println("你賣了" + numItem + "個紙箱");
                        } else {
                            System.out.println("紙箱不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有紙箱");
                    }                       
                    break;
                case 15:
                    remainItem =checkIsEnoughItem(bag.getItems() , "WoodHouse");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個木屋,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "WoodHouse", numItem);
                        System.out.println("你賣了" + numItem + "個木屋");
                        } else {
                            System.out.println("木屋不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有木屋");
                    }                       
                    break;
                case 16:
                    remainItem =checkIsEnoughItem(bag.getItems() , "Seaweed");
                    if (remainItem > 0) {
                        System.out.println("你有" + remainItem + "個海草,請輸入你要賣幾個");
                        numItem = sc.nextInt();
                        if (numItem <=  remainItem) {
                            bag.minusItem( "Seaweed", numItem);
                        System.out.println("你賣了" + numItem + "個海草");
                        } else {
                            System.out.println("海草不夠");
                        }
                    } else {
                        System.out.println("醒醒吧,你沒有海草");
                    }                       
                    break; 
            }
        isEnd(room);
        System.out.println("錢包剩下"+ pocket);
    }
        

        //當寵物格子或背包滿了強制進入購買流程，a=3為擴增寵物格，a=4為擴增背包
//    public boolean forceBuying(Animal[] allAnimals, Item[] item , int a){
//                int tmp = pocket - buy[a];            
//                while(tmp<0){
//                    System.out.println("餘額不足，請賣東西");
//                    sell(allAnimals , item);
//                    tmp = pocket - buy[a];
//                }
//                if (a == 4){
//                    int newItem = item.length + 1;
//                    Item[] temp = new Item[newItem];
//                    for(int i = 0; i < item.length; i++) {
//                        if(item[i] != null) {
//                        temp[i] = item[i];
//                        }
//                                
//                    }
//                    item = temp;
//                    pocket -= buy[a];
//                    System.out.println("買入"+ strBuy[a] + " " + "1");
//                    System.out.println("摳摳剩下"+ pocket);
//                } else if (a == 3) {
//                    int newRoom = allAnimals.length + 1;
//                    Animal[] temp = new Animal[newRoom];
//                    for(int i = 0; i < item.length; i++) {
//                        if(item[i] != null) {
//                        temp[i] = allAnimals[i];
//                        }
//                                
//                    }
//                    allAnimals = temp;
//                    pocket -= buy[a];
//                    System.out.println("買入"+ strBuy[a] + " " + "1");
//                    System.out.println("摳摳剩下"+ pocket);                    
//                }    
//
//            
//
//                return true;
//            
//    }   
        
        
        
    public boolean checkMoney (int price, int numItem, int pocket) { //檢查錢量
            return pocket > (price * numItem);
    }
        
//        public boolean checkBackpak ( Item [] item , int numItem) {
//            return true;
//        }
    public boolean checkRoom (Animal[] room) { //檢查房量
            boolean check = false;
            for (int i=0; i < room.length; i++ ) {
                if( room[i] == null) {
                    check = true;
                    break;
                }
            }
            return check;
    }
        
//    public static int gender(){//寵物性別
//        int i = (int)(Math.random()*(2-1+1))+1;//用亂數隨機選1或2，1公 2母，同人類ID開頭
//        return i;
//    }   
    
    public void deAnimal (String type , Animal[] room, int numItem) { //賣寵物 寵物死
        for (int k = 0 ; k < numItem; k++) {
            for (int i = room.length -1; i >= 0; i-- ) {
                if( room[i].type == type) {
                    room[i] = null;
                    numItem--;
                    for (int j = i ; j <  room.length -1  ; j++ ) {
                        if (room[j] == null) {
                            break;
                        }
                        room[j] = room[j+1];
                    }
                }
                if (numItem == 0) {
                    break;
                }
            }
        }    
    }
    
    
    
    public static void newAnimal(String type , Animal[] room){ //買寵物
            Scanner sc = new Scanner(System.in);
            String name;
            int gender;
            switch(type){
                case "狗":
                 Dog dog = new Dog();
                 gender = dog.sex;
                 if(gender == 1){
                        System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是男生唷！");
                 }else if(gender == 2){
                        System.out.println("恭喜你！這隻可愛的小狗狗(V●ᴥ●V) 是女生唷！");
                 }
                 System.out.println("現在，來幫牠取名吧！");
                 System.out.println("：");
                 dog.name = sc.nextLine();
                 for(int i = 0; i < room.length ; i++) {
                    if (room[i] == null) {//如果找到空房間
                        room[i] = dog;//把this dog放進房間
                        break;

                    }
                }
                break;
            case "貓":
                Cat cat = new Cat();
                 gender = cat.sex;
                 if(gender == 1){
                        System.out.println("恭喜你！這隻可愛的小貓貓(V●ᴥ●V) 是男生唷！");
                 }else if(gender == 2){
                        System.out.println("恭喜你！這隻可愛的小貓貓(V●ᴥ●V) 是女生唷！");
                 }
                 System.out.println("現在，來幫牠取名吧！");
                 System.out.println("：");
                 name = sc.nextLine();
                 cat.name = name;
                 for(int i = 0; i < room.length ; i++) {
                    if (room[i] == null) {//如果找到空房間
                        room[i] = cat;//把this dog放進房間
                        break;

                    }
                }
                break;
            case "魚":
                Fish fish = new Fish();
                 gender = fish.sex;
                 if(gender == 1){
                        System.out.println("恭喜你！這隻可愛的小魚魚(V●ᴥ●V) 是男生唷！");
                 }else if(gender == 2){
                        System.out.println("恭喜你！這隻可愛的小魚魚(V●ᴥ●V) 是女生唷！");
                 }
                 System.out.println("現在，來幫牠取名吧！");
                 System.out.println("：");
                 name = sc.nextLine();
                 fish.name = name;
                 for(int i = 0; i < room.length ; i++) {
                    if (room[i] == null) {//如果找到空房間
                        room[i] = fish;//把this dog放進房間
                        break;

                    }
                }
            case "昆蟲":
                Insect insect = new Insect();
                 gender = insect.sex;
                 if(gender == 1){
                        System.out.println("恭喜你！這隻可愛的小蟲蟲(V●ᴥ●V) 是男生唷！");
                 }else if(gender == 2){
                        System.out.println("恭喜你！這隻可愛的小蟲蟲(V●ᴥ●V) 是女生唷！");
                 }
                 System.out.println("現在，來幫牠取名吧！");
                 System.out.println("：");
                 insect.name = sc.nextLine();
                 for(int i = 0; i < room.length ; i++) {
                    if (room[i] == null) {//如果找到空房間
                        room[i] = insect;//把this dog放進房間
                        break;

                    }
                }
            default:
                break;
        }
    }
}        
//    public static Animal[] newRoom(Animal[] allAnimals){
//        Animal newArr[] = new Animal[allAnimals.length+1];
//        for(int i = 0; i < allAnimals.length; i++){
//            newArr[i] = allAnimals[i];
//        }
//        return newArr;
//    }
//        
