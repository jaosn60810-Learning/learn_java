package tool;

import java.util.Scanner;


public class Animal {

//    public Animal[] getRoom(Animal[]room){
//        Animal[] arr = room;
//        return arr;
//    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    int type;


    public int getThing() {
        return thing;
    }

    public void setThing(int thing) {
        this.thing = thing;
    }

    int thing;

    int thingLine = 5;
    int feedConsume = 2;

    public int getThingLine() {
        return thingLine;
    }

    public void setThingLine(int thingLine) {
        this.thingLine = thingLine;
    }

    public int getFeedConsume() {
        return feedConsume;
    }

    public void setFeedConsume(int feedConsume) {
        this.feedConsume = feedConsume;
    }

    public int getFeedMax() {
        return feedMax;
    }

    public void setFeedMax(int feedMax) {
        this.feedMax = feedMax;
    }

    public int getFeedLine() {
        return feedLine;
    }

    public void setFeedLine(int feedLine) {
        this.feedLine = feedLine;
    }

    public int getFeedNumberMax() {
        return feedNumberMax;
    }

    public void setFeedNumberMax(int feedNumberMax) {
        this.feedNumberMax = feedNumberMax;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public void setCleanMax(int cleanMax) {
        this.cleanMax = cleanMax;
    }

    public int getCleanLine() {
        return cleanLine;
    }

    public void setCleanLine(int cleanLine) {
        this.cleanLine = cleanLine;
    }

    public int getWalkMax() {
        return walkMax;
    }

    public void setWalkMax(int walkMax) {
        this.walkMax = walkMax;
    }

    public int getWalkLine() {
        return walkLine;
    }

    public void setWalkLine(int walkLine) {
        this.walkLine = walkLine;
    }

    public int getConnectLine() {
        return connectLine;
    }

    public void setConnectLine(int connectLine) {
        this.connectLine = connectLine;
    }

    public int getConnectMax() {
        return connectMax;
    }

    public void setConnectMax(int connectMax) {
        this.connectMax = connectMax;
    }

    public int getSleepLine() {
        return sleepLine;
    }

    public void setSleepLine(int sleepLine) {
        this.sleepLine = sleepLine;
    }

    public int getSleepMax() {
        return sleepMax;
    }

    public void setSleepMax(int sleepMax) {
        this.sleepMax = sleepMax;
    }

    public int getWakeLine() {
        return wakeLine;
    }

    public void setWakeLine(int wakeLine) {
        this.wakeLine = wakeLine;
    }

    public int getWakeMax() {
        return wakeMax;
    }

    public void setWakeMax(int wakeMax) {
        this.wakeMax = wakeMax;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public int getFeedNumber() {
        return feedNumber;
    }

    public void setFeedNumber(int feedNumber) {
        this.feedNumber = feedNumber;
    }

    public Animal[] getRoom() {
        return room;
    }

    public void setRoom(Animal[] room) {
        this.room = room;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getConnectNum() {
        return connectNum;
    }

    public void setConnectNum(String connectNum) {
        this.connectNum = connectNum;
    }

    public boolean isBorn() {
        return born;
    }

    public void setBorn(boolean born) {
        this.born = born;
    }

    public int getBornNumber() {
        return bornNumber;
    }

    public void setBornNumber(int bornNumber) {
        this.bornNumber = bornNumber;
    }

    public boolean isxConnect() {
        return xConnect;
    }

    public void setxConnect(boolean xConnect) {
        this.xConnect = xConnect;
    }

    public int getxConnectNumber() {
        return xConnectNumber;
    }

    public void setxConnectNumber(int xConnectNumber) {
        this.xConnectNumber = xConnectNumber;
    }

    int feedMax = 4 + 4;
    int feedLine = feedMax;//餵食血條 餵食頻率+飢餓頻率   餓死
    int feedNumberMax = 3;//排泄頻率的餵食後第N個動作
    int cleanMax = 5;
    int cleanLine = cleanMax;//清潔血條  排泄頻率+便便數量(餵食次數/便便累積量)   髒死
    int walkMax = 3 + 6;
    int walkLine = walkMax;//散步血條   散步頻率+無聊頻率   無聊死
    int connectLine = 2;//交配血條
    int connectMax = 2;//
    int sleepLine = 2;
    int sleepMax = 2;
    int wakeLine = 7;
    int wakeMax = 7;
    int cleanTime;
    int connectTime;
    boolean full = false;//是否餵食過
    int feedNumber = feedNumberMax;//餵食的計數器
    Animal room[];
    int roomNumber;//寵物房編號(已+1)=寵物編號
    int gender;

    Scanner sc = new Scanner(System.in);
    String connectNum;//每當連結產生時，自動給一個連結編號

    boolean born = false;//是否可以生
    int bornNumber = connectMax;

    boolean xConnect = false;//不同種的連結
    int xConnectNumber = 5;//若是不同種類的寵物放在一起，超過5個動作，則兩個寵物都會死亡

    String name;

    public Animal(String name) {
        this.name = name;
    }

    public static void feed(Animal[] room, int x) {//x為誰被feed
        if (room[x - 1].wakeLine != 0) {
//            if(bag.food >= room[x].feedConsume){//先檢查背包共有多少食物<食量 回傳：食物不夠
            room[x - 1].feedLine = room[x - 1].feedMax;//夠的話：進行一次餵食，餵飽該動物
            room[x - 1].full = true;//該動物顯示為剛被餵食過
            //最後回傳 (種類：食物  數量：食量  加減：減)給背包
//            }
            System.out.println(room[x - 1].name + "說：哇家爸啊啦");
        } else {
            System.out.println(room[x - 1].name + "說：麥吵啦！！哇咧睏ZZZzzz");
        }
    }

    public static void poopoo(Animal[] room) {
        for (int i = 0; i < room.length; i++) {
            if (room[i] != null) {
                if (room[i].feedNumber == 0) {//被餵食過後且過了n個動作
                    room[i].cleanLine--;
                    room[i].full = false;
                    System.out.println(room[i].name + "説: 我棒賽了");
                }
            }
        }
    }

    public static int clean(Animal[] room, int x) {
        room[x - 1].cleanLine = room[x - 1].cleanMax;
        System.out.println(room[x - 1].name + "説: 感謝鏟屎官");
        return -1;//回傳給next“我做了基本動作”
    }

    public static int walk(int[] arr, Animal[] room) {//從Main裡導入int陣列，陣列裡存的是寵物編號
        for (int i = 0; i < arr.length; i++) {//從寵物編號陣列，提取寵物"房"編號，並叫出寵物們
            int x = arr[i] - 1;//因為New的時候，寵物"房"編號+1才等於寵物編號，所以回頭時要-1
            if (room[x] != null) {
                if (room[x].wakeLine != 0) {
                    room[x].walkLine = room[x].walkMax;//被抓出來的寵物，將無聊量的血條填滿
                    System.out.println(room[x].name + "說：外面空氣真清新");
                } else {
                    System.out.println(room[x].name + "說：麥吵啦！！哇咧睏ZZZzzz");
                }
            }
        }
        return -2;
    }

    public String name() {//寵物名稱
        //System.out.println("您選擇了寵物"); > 寫在每一種動物的建構子
        Scanner sc = new Scanner(System.in);
        System.out.print("現在，請替牠取名：");
        String name = sc.nextLine();//應該寫在操作裡，有個setter name & getter name
        return name;
    }

    public boolean checkIsEnoughAnimal(Animal[] room, int animalNum) {
        int count = 0;
        for (int i = 0; i < room.length; i++) {
            if (room[i] == null) {
                count++;
                continue;
            } else if (room[i].type == animalNum) {
                room[i] = null;
                return true;
            }
        }
        if (count == room.length) {
            return false;
        }
        return true;
    }

    public static int connect(int x, int y, Animal[] room) {//連結(交配)   產生一個連結編號字串，屬於屬性(狀態)例如"1,3"、"2,4"(是+1過的) 但1跟3都會是1,3而沒有3,1
        room[x - 1].connectNum = x + "," + y;
        room[y - 1].connectNum = x + "," + y;
        // 沒有連結編號
        //進行"產生連結編號"流程
        if (room[x - 1].type == room[y - 1].type && room[x - 1].gender != room[y - 1].gender) {
            //過room[x - 1].connectLine的時間後
            room[x - 1].born = true;
            room[y - 1].born = true;
        } else if (room[x - 1].type != room[y - 1].type) {
            room[x - 1].xConnect = true;
            room[y - 1].xConnect = true;
        }
        System.out.println("現在" + room[x - 1].name + "跟" + room[y - 1].name + "在一起囉 <3 ");
        System.out.println("連結編號: " + room[x - 1].connectNum);
        return -3;
    }

    public static void borned(Animal[] room) {//生產
        for (int i = 1; i < room.length; i++) {//掃描每一個寵物房，裡面是否有可以生的寵物
            if (room[i] != null) {
                if (room[i].born == true) {
                    System.out.println("恭喜老爺賀喜夫人!!!!!!!!!!!!!!!!!!");
                    Tool.newAnimal(room[i].type, room);
                }
            }
        }

    }

    public static void dead(Animal[] room) {//動物死亡
        for (int i = 0; i < room.length; i++) {
            if (room[i] != null) {
                if (room[i].feedLine == 0 || room[i].cleanLine == 0 || room[i].walkLine == 0 || room[i].xConnectNumber == 0) {//分別為餓死、髒死、無聊死、錯誤配種死
                    System.out.println("Ooops！" + room[i].name + "已經去世了QQ 請節哀(ఠ్ఠ ˓̭ ఠ్ఠ)");
                    room[i] = null;
                }
            }
        }
        int overLine = 0;
        for (int i = 0; i < room.length; i++) {
            if (room[i] != null) {// != 有人 ==沒人
                overLine++;
                break;
            }
        }
        if (overLine == 0) {//如果程式進行到這邊依然沒有人=所有房間都是空的>Gameover
            System.out.println("你的寶貝全都死撩撩了啦！！！！！ ( ಠ ಠ )");
            System.exit(0);
        }
    }


    public static void disconnect(int x, int y, Animal[] room) {//解除連結時，被餵食兩個int>我用房間編號叫出那兩個，將“連結狀態String”變為null
        if (y != x && room[y - 1] != null) {
            room[x - 1].connectNum = null;
            room[y - 1].connectNum = null;
            room[x - 1].connectLine = room[x - 1].connectMax;
            room[y - 1].connectLine = room[x - 1].connectMax;
            room[x - 1].born = false;
            room[y - 1].born = false;
            room[x - 1].bornNumber = room[x - 1].connectMax;
            room[y - 1].bornNumber = room[x - 1].connectMax;
            room[x - 1].xConnect = false;
            room[y - 1].xConnect = false;
            room[x - 1].xConnectNumber = 5;
            room[y - 1].xConnectNumber = 5;
            System.out.println(room[x - 1].name + "和" + room[y - 1].name + "解除情慾流動");
        } else {
            System.out.println("編號有錯");
        }
    }


//    public void thing(int time){//動物會產出的東西  1.狗毛dogHair/t2.貓毛catHair/t3.魚鱗fishScale
//        int i = 0;
//        if(time == 5){//產出物品頻率，每種動物不一樣
//            for(i = 0; i < bag.length ; i++) {//等待bag導入bag的第一行陣列
//                if (bag[i] == null) {//如果找到空背包格
//                    bag[i] = thing;//把this thing放進背包格
//                    bagCounter[i]++;//等待bag導入的第二行陣列
//                    break;
//                } else {//沒有空背包格
//                    System.out.println("背包格已不足，是否購買背包格？ (Y)進入商店、(N)不進入商店(寵物產生的物品將直接消失)");
//                    String opt = sc.nextLine();
//                    while (true) {
//                        System.out.print("請輸入 Y 或 N :");
//                        if (opt.equals("Y")) {
//                            //Shop.forceBuying(2);//強制進入商店，最終商店會回傳boolean
//                            //if(boolean i = true){//如果購買背包格成功，就再跑一次"將物品放入背包格"流程
//                            //  if (bag[i] == null) {//如果找到空背包格
//                            //  bag[i] = thing;//把this thing放進背包格
//                            //  bagCounter[i]++;//等待bag導入的第二行陣列
//                            //  break;
//                            //  }else if(boolean i = false){//如果選擇進入商店，但購買背包格失敗
//                            //      break;//等於寵物產生的物品直接消失
//                            //  }
//                        }
//                        if (opt.equals("N")) {//寵物產生的物品直接消失
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//    }
}


