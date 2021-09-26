
package Pet;

import java.util.Scanner;

/**
 * @author charisma
 */

public class Function {

    Scanner sc = new Scanner(System.in);

    /** 傳入玩家所有資料 */
    public Player startCommand(Player player, int movement) {
        //延遲輸出
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie)
        {
            System.out.println("生產寵物中...");
        }

        Detect detectStatus = new Detect(player.room);

        switch (movement) {

            /** 直接過一天 */
            case 1:
                player.room = detectStatus.checkStatus(player);
                System.out.println("主人，你就這樣浪費時間？OK？很閒？┐(´д`)┌");
                break;

            /** 餵食 */
            case 2:
                System.out.println("選擇要餵食的寵物!");
                player.checkAnimalAmount();
                int pickAnimal = sc.nextInt();
                player.room[pickAnimal-1].resetFeed();
                break;

            /** 清潔房間 */
            case 3:
                System.out.println("選擇要清潔的寵物!");
                player.checkAnimalAmount();
                int pickAnimal2 = sc.nextInt();
                player.room[pickAnimal2-1].resetShit();
                System.out.println("桑幾勒～有吿送✧*｡٩(ˊᗜˋ*)و✧*｡");
                player.room = detectStatus.checkStatus(player);
                break;

            /** 散步 */
            case 4:
                System.out.println("選擇要散步的寵物!");
                player.checkAnimalAmount();
                int pickAnimal3 = sc.nextInt();
                player.room[pickAnimal3-1].resetWalk();
                for(int i = 0; i < 2; i++) {
                    player.room[pickAnimal3-1].inAGoodMood();
                }
                System.out.println("帶我走～到遙遠的以後～～～(๑ơ ₃ ơ)♥");
                player.room = detectStatus.checkStatus(player);
                break;

            /** 連結 */
            case 5:
                System.out.println("請輸入要連結的寵物編號：(用空白分開，i.g： 1,3)");
                player.checkAnimalAmount();
                int pickAnimalA = sc.nextInt();
                int pickAnimalB = sc.nextInt();
                player.room[pickAnimalA-1].setBinding(player.room[pickAnimalB-1]);
                player.room[pickAnimalB-1].setBinding(player.room[pickAnimalA-1]);
                System.out.println("部長：不排除有 "+player.room[pickAnimalA-1].getName()+" 與 "+ player.room[pickAnimalB-1].getName()+" 的連結");
                break;

            /** 解除連結 */
            case 6:
                System.out.println("請輸入要解除連結的寵物編號:");
                player.checkAnimalBinding();
                int pickAnimal4 = sc.nextInt();
                System.out.println("拿勝利寶劍，斬斷 " + player.room[pickAnimal4-1].getName() + " 和 "
                        + player.room[pickAnimal4-1].getBinding().getName() + " 的連結!");
                player.room[pickAnimal4-1].resetBinding();
                break;

            /** 裝飾寵物房 */
            case 7:
                System.out.println("請選擇要裝飾的寵物房!");
                player.checkAnimalAmount();
                int pickAnimal5 = sc.nextInt();
                System.out.println("要用甚麼裝飾呢?\t1.紙箱\t2.木屋\t3.海草");
                int chooseDecorate = sc.nextInt();
                String chineseDecorate = "", decorate = "";
                switch (chooseDecorate) {
                    case 1:
                        chineseDecorate = "紙箱";
                        decorate = "carton";
                        break;
                    case 2:
                        chineseDecorate = "木屋";
                        decorate = "woodhouse";
                        break;
                    case 3:
                        chineseDecorate = "海草";
                        decorate = "seaweed";
                }
                //判斷背包是否有這個裝飾物
                if (player.bag.DetectItem(decorate)) {
                    //判斷寵物房是否已經有裝飾物
                    if (player.room[pickAnimal5].getDecorate().equals("無")) {
                        player.room[pickAnimal5].setDecorate(decorate);
                        player.bag.minusItem(decorate, 1);
                        //判斷該裝飾物是否是寵物喜歡的
                        if (player.room[pickAnimal5].getDecorate().equals(player.room[pickAnimal5].getLikeDectorate())) {
                            System.out.println(player.room[pickAnimal5].getName() + "很喜歡這個裝物品! 好感度+2!");
                            for(int i = 0; i < 2; i++) {
                                player.room[pickAnimal5].inAGoodMood();
                            }
                        } else {
                            System.out.println("在" + player.room[pickAnimal5].getName() + "的房間裝飾了" + chineseDecorate + "!");
                        }
                    } else {
                        System.out.println("每間寵物房只能有一個裝飾，要換掉現在的裝飾嗎?\t1.是\t2.否");
                        int choose = sc.nextInt();
                        if (choose == 1) {
                            String temp = player.room[pickAnimal5].getDecorate();
                            player.room[pickAnimal5].setDecorate(decorate);
                            player.bag.minusItem(decorate, 1);
                            player.bag.addItem(temp, 1);
                            if (player.room[pickAnimal5].getDecorate().equals(player.room[pickAnimal5].getLikeDectorate())) {
                                System.out.println(player.room[pickAnimal5].getName() + "很喜歡這個裝飾物! 好感度+2!");
                                for(int i = 0; i < 2; i++) {
                                    player.room[pickAnimal5].inAGoodMood();
                                }
                            } else {
                                System.out.println("在" + player.room[pickAnimal5].getName() + "的房間裝飾了" + chineseDecorate + "!");
                            }
                        }
                    }
                } else {
                    System.out.println("沒有這個裝飾物，快去商店買!");
                }
                break;
        }
        //延遲輸出
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie)
        {
            System.out.println("生產寵物中...");
        }
        return player;
    }

}


