/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;
import java.util.HashSet;
import pet.*;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author charisma
 */

public class Function {
    

    

  
    
    public static void mainList (Animal[] room , Shop shop)  { // 主選單
        Scanner sc = new Scanner(System.in);
        int command;
        while(true){        
            System.out.println("請輸入執行動作: 1 (對寵物進行動作), 2 (顯示連結狀態), 3 (顯示目前所有寵物及其狀態), 4 (顯示目前所有物品以及寵物), 5 (進入商店)");
            command = sc.nextInt();
            if (command == 1 || command == 2 || command == 3 || command == 4 || command == 5 ){
                break;
            } else {
                System.out.println("輸入錯誤");
            }
                
        }
            
            
        switch(command) { 
            case 1:
                groupList(room);
                break;
            case 2: 
                checkConnect(room); 
                break; 
            case 3: 
                checkPet(room);
                break; 
            case 4: 
                break; 
            case 5: 
                shop.intoShop(room); 
                break; 
        }
            
            
        
    }
    
    
    public static void groupList (Animal[] room) { // 寵物動作選單: 選寵物 ＋ walk + connect 主選單
        Scanner sc = new Scanner(System.in);
        int command;
        while(true){        
            System.out.println("請輸入執行動作: 1 (選寵物), 2 (交配), 3 (散步), 99 (離開)" );
            command = sc.nextInt();
            if (command == 1 || command == 2 || command == 3 || command == 99){
                break;
            }else {
                System.out.println("輸入錯誤");
            }
                
        }
        while (command != 99) {
            groupListCommand (room, command);
            while(true){        
                System.out.println("請輸入執行動作: 1 (選寵物), 2 (交配), 3 (散步), 99 (離開)" );
                command = sc.nextInt();
                if (command == 1 || command == 2 || command == 3  || command == 99){
                  break;
                }else {
                    System.out.println("輸入錯誤");
                }
                
            }
        }

    }

    public static void groupListCommand (Animal[] room, int command) { //選寵物 散步 連結 指令執行
        Scanner sc = new Scanner(System.in);    
        switch(command) { 
            case 1:
                int n = animalPick(room , command);
                animalList(room,n);
                break;
            case 2:
                int a;
                int b;    
                while(true){    
                    System.out.println("請輸入寵物編號(用逗號分隔 e.g: 1,2)");
                    String s = sc.nextLine() ;
                    String[] nums = s.split(",") ;
                    a = Integer.parseInt(nums[0]);
                    b = Integer.parseInt(nums[1]);
                    if (room[a-1] != null && room[b-1] != null){
                        break;
                    }
                    
                }
                //Animal.connect(a,b,room);
                Animal.connect( a , b , room);
                allNext(room );
                Animal.poopoo(room);
                Animal.borned(room);
                Animal.dead(room);
                break; 
            case 3:
                int[] arr;
                while(true){    
                    System.out.println("請輸入寵物編號(用逗號分隔 e.g: 1,2,3 可多個寵物)");
                    String s = sc.nextLine() ;
                    String[] nums = s.split(",") ;
                    int len = nums.length;
                    arr = new int[len];
                    int c = 0;
                    for ( int i = 0; i < len; i++ ) {
                        int f = Integer.parseInt(nums[i]);
                        arr[i] = f;
                        if (room[f-1] == null) {
                            c++;
                        }
                    }
                    if (c == 0){
                        break;
                    }
                }
                allNext(room);
                Animal.walk(arr , room);
                Animal.poopoo(room);
                Animal.borned(room);
                Animal.dead(room);
                break; 
            case 99:
                break;
                
        }
            
            
        
    }
    
    
    
    
    public static int animalPick (Animal[] room , int command) { //選寵物
        Scanner sc = new Scanner(System.in);
        int num = room.length;
        
        //for (int i = 0; i < num; i++) {
        //    if (animal[i] != null) {
        //        System.out.println("No. " + animal[i].roomNumber + "," + "Name: " + animal[i].name  + "," + "Type: " + animal[i].type + "," + "Gender: " + animal[i].gender);
        //    }    
        //}
        int n;
        while(true){    
            System.out.println("請輸入寵物編號");
            n = sc.nextInt();
            if (room[n-1] != null){
                break;
            }
            System.out.println("編號有錯"); 
        }
        
        return n;
        
     }
    

    

     public static void animalList (Animal[] room  , int n) { // 選寵物後動作選單
        Scanner sc = new Scanner(System.in);
        int command;
        while(true){        
            System.out.println("請輸入執行動作: 1 (直接過一天), 2 (餵食), 3 (清潔房間), 4 (解除連結), 99 (離開)");
            command = sc.nextInt();
            if (command == 1 || command == 2  || command == 3  || command == 4  || command == 99){
                break;
            }else {
                System.out.println("輸入錯誤");
            }
                
        }
        
        while (command != 99) {
            animalListCommand (room, command, n);
            while(true){        
                System.out.println("請輸入執行動作: 1 (直接過一天), 2 (餵食), 3 (清潔房間), 4 (解除連結), 99 (離開)");
                command = sc.nextInt();
                if (command == 1  || command == 2  || command == 3  || command == 4  || command == 99  ){
                  break;
                } else {
                    System.out.println("輸入錯誤");
                }
                
            }
        }
        
     }
     
     public static void animalListCommand (Animal[] room , int command , int n) {       // 選寵物後動作執行
        switch(command) { 
            case 1:
                int method = 0;
                allNext(room);
                Animal.poopoo(room);
                Animal.borned(room);
                Animal.dead(room);
                break;
            case 2: 
                Animal.feed(room, n); 
                break;
            case 3:
                allNext(room);
                Animal.clean(room , n);
                Animal.poopoo(room);
                Animal.borned(room);
                Animal.dead(room);
                break;
            case 4:
                int d = animalPick(room , command);
                Animal.disconnect(n ,d , room); 
                break;                
            case 99:  
                break;             
        
     }   
    
    
    
    
    
    }
     
     


     public static void allNext (Animal[] room) {       
          int len = room.length;
          for (int i = 0; i < len; i++) {
              if (room[i] != null) {
                  if (room[i].full && room[i].sleepLine != 0) {
                      room[i].feedNumber -= 1;
                  }
                  if (room[i].sleepLine != 0) {
                        room[i].thingLine -= 1;
                  }     
                  if (room[i].connectNum != null && room[i].sleepLine != 0) {
                        room[i].connectTime -= 1;
                  }
                  room[i].feedLine -= 1;
                  //System.out.println("room[i].feedLine: " + room[i].feedLine);
                  room[i].walkLine -= 1; 
                  if (room[i].wakeLine > 1 ) {
                      room[i].wakeLine -= 1;
                  } else if (room[i].wakeLine  == 1 && room[i].sleepLine == 0) {
                      room[i].wakeLine -= 1;
                      room[i].sleepLine = room[i].sleepMax;
                  } else if (room[i].sleepLine > 1 ) {
                      room[i].sleepLine -= 1;
                  } else if (room[i].sleepLine  == 1 && room[i].wakeLine == 0) {
                      room[i].sleepLine -= 1;
                      room[i].wakeLine = room[i].wakeMax;
                  }
                  //System.out.println("wakeLine:" + room[i].wakeLine + "," + "sleepLine:" + room[i].sleepLine);

                  if (room[i].xConnect) {
                      room[i].xConnectNumber -= 1;
                  }
              }
          }
        
     }
     
     
     public static void checkConnect (Animal[] room) {       //連結狀態
          int len = room.length;
          int real = 0;
          int count = 0;
          for (int i = 0; i < len; i++) {
              if (room[i] != null) {
                  real++;
              }
          }
          String[] duplicateArray = new String[real];
          for (int i = 0; i < len; i++) {
              if (room[i] != null) {
                  duplicateArray[count++] = room[i].connectNum;
              }
          }

     
         Set<String> intSet = new HashSet<String>();
         for (String element : duplicateArray) {
             intSet.add(element);
         }
        
         String nonDuplicateArray[] = new String[intSet.size()];
 
         Object[] tempArray = intSet.toArray();
         for (int i = 0; i < tempArray.length; i++) {
             nonDuplicateArray[i] = (String) tempArray[i];
         }     
         for (int e =0; e < intSet.size() -1 ; e++) {
            for (int j = 0; j < intSet.size() -e -1; j++) {
                if (nonDuplicateArray[j].compareTo(nonDuplicateArray[j+1]) > 0) {
                    String temp = nonDuplicateArray[j+1];
                    nonDuplicateArray[j+1] = nonDuplicateArray[j];
                    nonDuplicateArray[j] = temp;
                }
            }
        }     
         System.out.println("connected status:");
         for (String element : nonDuplicateArray) {
             if (element != "")
             System.out.println(element);
         }               
     }     
     
     public static void checkPet (Animal[] room ) {       //寵物狀態
        int len = room.length;
        System.out.println("Current Pet Status");
        for (int i = 0; i < len; i++) {
            if (room[i] != null) {
              String hunger = "飽足";
              String boring = "有趣";
              String wakeUp = "睡著";
              String makeLove = "未交配";
              String clean = "乾淨";
              if (room[i] != null) {
                  if (room[i].type == 1){
                        String typeString = "狗";
                        if(room[i].feedLine < 5) {
                             hunger = "飢餓";
                        }
                        if(room[i].walkLine < 7) {
                             boring = "無聊";
                        }
                        if(room[i].cleanLine < 4) {
                             clean = "髒亂";
                        }
                        if(room[i].wakeLine > 0) {
                             wakeUp = "清醒";
                        }
                        if(room[i].connectNum != null) {
                            makeLove = "交配中";
                        }
                        String wc;
                        if(room[i].gender == 1) {
                            wc = "雄霸";
                        } else {
                            wc = "女豪";
                        }
                        System.out.println("編號: " + (i+1) + ", " + "種類: " + typeString + ", " + "姓名: " + room[i].name + ", " + "性別: " + wc + ", " + "飢餓狀態: " + hunger + ", " + "心情狀態: " + boring + ", " + "清醒狀態: " + wakeUp + ", " + "交配狀態: " + makeLove + ", " + "整潔狀態: " + clean + ", " + "產出物品剩餘回合: " + room[i].thingLine );                      
                  } else if ( room[i].type == 2 ) {
                        String typeString = "貓";
                        if(room[i].feedLine < 5) {
                             hunger = "飢餓";
                        }
                        if(room[i].walkLine < 11) {
                             boring = "無聊";
                        }
                        if(room[i].cleanLine < 3) {
                             clean = "髒亂";
                        } 
                        if(room[i].wakeLine > 0) {
                             wakeUp = "清醒";
                        }
                        if(room[i].connectNum != "") {
                             makeLove = "交配中";
                        }
                        String wc;
                        if(room[i].gender == 1) {
                            wc = "雄霸";
                        } else {
                            wc = "女豪";
                        }
                        System.out.println("編號: " + (i+1) + ", " + "種類: " + typeString + ", " + "姓名: " + room[i].name + ", " + "性別: " + room[i].gender + ", " + "飢餓狀態: " + hunger + ", " + "心情狀態: " + boring + ", " + "清醒狀態: " + wakeUp + ", " + "交配狀態: " + makeLove + ", " + "整潔狀態: " + clean + ", " + "產出物品剩餘回合: " + room[i].thingLine );                                                
                  } else {
                        String typeString = "魚";
                        if(room[i].feedLine < 6) {
                             hunger = "飢餓";
                        }
                        if(room[i].wakeLine > 0) {
                             wakeUp = "清醒";
                        }
                        if(room[i].cleanLine < 5) {
                             clean = "髒亂";
                        } 
                        if(room[i].connectNum != "") {
                             makeLove = "交配中";
                        }
                        String wc;
                        if(room[i].gender == 1) {
                            wc = "雄霸";
                        } else {
                            wc = "女豪";
                        }                        
                        System.out.println("編號: " + (i+1) + ", " + "種類: " + typeString + ", " + "姓名: " + room[i].name + ", " + "性別: " + room[i].gender + ", " + "飢餓狀態: " + hunger + ", " + "心情狀態: " + boring + ", " + "清醒狀態: " + wakeUp + ", " + "交配狀態: " + makeLove + ", " + "整潔狀態: " + clean + ", " + "產出物品剩餘回合: " + room[i].thingLine );                                                                          
                  }

              }
            }  
        }
        
     }     
    
    public static void checkPetBackpack (Animal[] room,Bag[] backpack ){  // 寵物背包
          int len = room.length;
          for (int i = 0; i < len; i++) {
              if (room[i] != null) {
                  System.out.println("Pet");
                  System.out.println("編號: " + (i+1) + ", " + "種類: " + room[i].type + ", " + "姓名: " + room[i].name );                  
              }
          }
          int len2 = backpack.length;
          for (int i = 0; i < len2; i++) {
              if (backpack[i] != null) {
                  System.out.println("Backpack");
                  System.out.println("編號: " + (i+1) + ", " + "種類: " + room[i].type + ", " + "數量: " + room[i].name);                                    
              }
          }
        
     } 
    
    
    
    
    
    
     


     
     
     
     
     
     
     
     
     
     
     
     
}


