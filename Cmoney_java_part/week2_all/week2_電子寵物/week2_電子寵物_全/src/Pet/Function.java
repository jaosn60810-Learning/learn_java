
package Pet;

import java.util.Scanner;

/**
 * @author charisma
 */

public class Function {

    Scanner sc = new Scanner(System.in);

    /** 傳入玩家所有資料 */
    public Player startCommand(Player player, int movement) {

        Detect detectStatus = new Detect(player.room);

        switch (movement) {

            /** 直接過一天 */
            case 1:
                player.room = detectStatus.checkStatus();
                System.out.println("主人，你就這樣浪費時間？OK？很閒？┐(´д`)┌");
                break;

            /** 餵食 */
            case 2:
                System.out.println("選擇要餵食的寵物!");
                player.checkAnimalAmount();
                int pickAnimal = sc.nextInt();
                System.out.println("下次想吃Lawry's，懂？(๑•́ ₃ •̀๑)");
                player.room[pickAnimal-1].resetFeed();
                player.room[pickAnimal-1].feeling++;
                break;

            /** 清潔房間 */
            case 3:
                System.out.println("選擇要清潔的寵物!");
                player.checkAnimalAmount();
                int pickAnimal2 = sc.nextInt();
                player.room[pickAnimal2-1].resetShit();
                System.out.println("桑幾勒～有吿送✧*｡٩(ˊᗜˋ*)و✧*｡");
                player.room = detectStatus.checkStatus();
                break;

            /** 散步 */
            case 4:
                System.out.println("選擇要散步的寵物!");
                player.checkAnimalAmount();
                int pickAnimal3 = sc.nextInt();
                player.room[pickAnimal3-1].resetWalk();
                System.out.println("帶我走～到遙遠的以後～～～(๑ơ ₃ ơ)♥");
                player.room[pickAnimal3-1].feeling += 2;
                player.room = detectStatus.checkStatus();
                break;

            /** 連結 */
            case 5:
                System.out.println("請輸入要連結的寵物編號：(用空白分開，i.g： 1,3)");
                player.checkAnimalAmount();
                int pickAnimalA = sc.nextInt();
                int pickAnimalB = sc.nextInt();
                player.room[pickAnimalA-1].binding = player.room[pickAnimalB-1];
                player.room[pickAnimalB-1].binding = player.room[pickAnimalA-1];
                System.out.println("部長：不排除有 "+player.room[pickAnimalA-1].type+" 與 "+ player.room[pickAnimalB-1]+" 的連結");
                break;

            /** 解除連結 */
            case 6:
                System.out.println("請輸入要解除連結的寵物編號:");
                player.checkAnimalBinding();
                int pickAnimal4 = sc.nextInt();
                System.out.println("拿勝利寶劍，斬斷 " + player.room[pickAnimal4-1].name + " 和 " + player.room[pickAnimal4-1].binding.name + " 的連結!");
                player.room[pickAnimal4-1].resetBinding();
                break;
            case 7:
                break;
        }
        return player;
    }

}


