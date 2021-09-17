package Pet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player newPlayer = new Player();
        /** 一開始新增一隻動物 */
        System.out.println("請選擇你的第一隻動物～(1)狗狗 (2)貓貓 (3)魚兒 (4)昆蟲 ");
        int action = sc.nextInt();
        System.out.println("請幫他命名：");
        String animalName = sc.next();
        switch (action) {
            case 1:
                Dog newDog = new Dog();
                newDog.setName(animalName);
                newPlayer.addNewAnimal(newDog); //新增動物到陣列
                break;
            case 2:
                Cat newCat = new Cat();
                newCat.setName(animalName);
                newPlayer.addNewAnimal(newCat);
                break;
            case 3:
                Fish newFish = new Fish();
                newFish.setName(animalName);
                newPlayer.addNewAnimal(newFish);
                break;
            case 4:
                Insect newInsect = new Insect();
                newInsect.setName(animalName);
                newPlayer.addNewAnimal(newInsect);
                break;
        }

        /** 創建之後需要用到的檢查狀態 */
        Shop enterShop = new Shop(newPlayer);//創建商店

        /** 建立做動作的實體*/
        Function makeCommand = new Function();

        /** 檢查所有動物是否都活著 -> 不確定能否這樣判斷喔～ */
        while(newPlayer.room.length != 0) {

            System.out.println("\n\n請選擇：(1)對動物做動作 (2)顯示所有動物狀態 (3)顯示所有連結狀態 (4)顯示目前所有物品 (5)進入商店");
            action = sc.nextInt();
            switch (action) {
                case 1:
                    System.out.println("請輸入執行動作: (1)直接過一天 (2)餵食 (3)清潔房間 (4)散步 (5)連結 (6)解除連結 (7)回上一頁");
                    int movement = sc.nextInt();
                    while (movement>7 || movement<1) {
                        System.out.println("請輸入執行動作: (1)直接過一天 (2)餵食 (3)清潔房間 (4)散步 (5)連結 (6)解除連結 (7)回上一頁");
                        movement = sc.nextInt();
                    }
                    newPlayer = makeCommand.startCommand(newPlayer, movement);
                    break;
                case 2:
                    newPlayer.checkAnimalAmount(); //顯示所有動物陣列中的動物狀態
                    break;
                case 3:
                    newPlayer.checkAnimalBinding(); //印出所有有配對的動物
                    break;
                case 4:
                    newPlayer.printOutAllItem(); //印出所有包包
                    break;
                case 5:
                    enterShop.intoShop(newPlayer);
                    break;
            }
        }
    }
}
