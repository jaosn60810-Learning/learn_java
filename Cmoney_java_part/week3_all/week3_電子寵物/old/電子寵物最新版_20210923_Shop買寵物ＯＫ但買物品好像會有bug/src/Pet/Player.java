package Pet;

public class Player {

    private static final int DOG = 0;
    private static final int CAT = 1;
    private static final int FISH = 2;
    private static final int INSECT = 3;
    String name;
    int wallet = 10000;
    Bag bag = new Bag();
    int index = 0;
    int type;
    Animal[] room = new Animal[10];


    /** 新增一隻動物 */
    public void addNewAnimal(Animal animal) {
        room[index] = animal;
        //先不管動物刪減？？？？
    }

    /** 印出目前所有的動物 */
    public void checkAnimalAmount() {
        System.out.print("\n" + "主人，你的寵物有：\n");
        for (int i = 0;i<room.length ;i++) {
            if (room[i] != null) {
                System.out.print("〔"+(i+1)+"〕");
                room[i].printOutStatus();
            }
        }
    }

    /** 印出正在交配的動物 */
    public void checkAnimalBinding() {
        System.out.print("\n" + "主人，目前有：\n");
        for (int i = 0;i<room.length ;i++) {
            if(room[i] == null) {
                continue;
            } else {
                if (room[i].getBinding() != null) {
                    System.out.print("〔"+(i+1)+"〕");
                    room[i].printOutStatus();
                }
            }
        }
    }

    /** 印出包包所有東西 */
    public void printOutAllItem() {
        for(int i = 0; i < bag.getItems().length; i++) {
            if(bag.getItems()[i] != null) {
                System.out.println(bag.getItems()[i].getName()+"  -  "+bag.getItems()[i].getCount());
            }
        }
    }
    public static void checkBackpack(Animal[] room, Bag[] backpack) {  // 背包
        int len = room.length;
        for (int i = 0; i < len; i++) {
            if (room[i] != null) {
                System.out.println("Pet");
                System.out.println("編號: " + (i + 1) + ", " + "種類: " + room[i].getType() + ", " + "姓名: " + room[i].getName());
            }
        }

        int len2 = backpack.length;
        for (int i = 0; i < len2; i++) {
            if (backpack[i] != null) {
                System.out.println("Backpack");
                System.out.println("編號: " + (i + 1) + ", " + "種類: " + room[i].getType() + ", " + "數量: " + room[i].getName());
            }
        }
    }
}



