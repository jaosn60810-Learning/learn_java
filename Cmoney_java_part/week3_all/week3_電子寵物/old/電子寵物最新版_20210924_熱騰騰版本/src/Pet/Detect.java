package Pet;

public class Detect {

    Animal[] allAnimals;

    /** 將動物陣列傳入修改 */
    public Detect(Animal[] allAnimals){
        this.allAnimals = allAnimals;
    }

    /** 檢查完狀態後回傳更新的動物狀態 */
    public Animal[] checkStatus(Player thePlayer){
        for(int i = 0; i < allAnimals.length; i++) {
            if(allAnimals[i]!=null){
                Animal thePet = allAnimals[i];

                //檢查是否活著
                boolean alive = checkAlive(thePet);
                if(alive) {

                    //檢查是否要睡覺
                    boolean awake = checkSleep(thePet);
                    if(awake) {

                        //檢查好感度
                        checkFeeling(thePet);

                        //清醒狀態會先扣基本數值
                        ordinaryLife(thePet);

                        //檢查是否需要餵食
                        checkHungry(thePet);

                        //檢查是否要散步
                        checkBored(thePet);

                        //檢查是否有交配對象
                        boolean bound = checkBound(thePet);
                        if(bound) {
                            //檢查是否同種，不同種依據搭配不同步動物有不同結果
                            checkBindSituation(thePet);
                        }

                        //檢查是否產出物品
                        checkProduction(thePet, thePlayer);

                    } else {
                        //檢查是否要清醒
                        checkAwake(thePet);
                    }
                }
            }
        }
        return allAnimals;
    }

    /** 檢查是否活著 */
    private boolean checkAlive(Animal thePet) {
        //檢查是否餓死
        if(thePet.getHungry() <= 0) {
            thePet.setLife(false);
            thePet.setDie(1);
            return false;
        }
        //檢查是否無聊死
        if(thePet.getBored() <= 0) {
            thePet.setLife(false);
            thePet.setDie(2);
            return false;
        }
        //檢查是否髒死
        if(thePet.getShit() <= 0) {
            thePet.setLife(false);
            thePet.setDie(3);
            return false;
        }
        //檢查是否性愛致死
        if(thePet.getNotOkaySex() <= 0) {
            thePet.setLife(false);
            thePet.setDie(4);
            thePet.getBinding().setLife(false);
            thePet.getBinding().setDie(4);
            return false;
        }
        return true;
    }

    /** 活著，檢查是否要休眠 */
    private boolean checkSleep(Animal thePet) {
        if(thePet.getSleep() <= 0) {
            return false;
        }
        thePet.awake(); //減少睡眠值
        return true;
    }

    /** 活著，但睡眠狀態，檢查是否要清醒 */
    private void checkAwake(Animal thePet) {
        if(thePet.getSleepLast() <= 0) {
            thePet.resetSleep();
            return;
        }
        thePet.sleep(); //減少睡眠值
    }

    /** 活著，清醒狀態，好感度影響飢餓跟散步 */
    private void checkFeeling(Animal thePet) {
        if(thePet.getFeeling() > 10) {
            for(int i = 0; i< 2; i++) {
                thePet.inAGoodMood();
            }
        }
        if(thePet.getFeeling() < 0) {
            thePet.inABadMood();
        }
    }

    /** 活著，清醒狀態，餵食＆散步＆生產先扣一點 */
    private void ordinaryLife(Animal thePet) {
        thePet.awakeToPlay();
    }

    /** 活著，清醒狀態，檢查飢餓值影響好感度 */
    private void checkHungry(Animal thePet) {
        if(thePet.getFeed() <= 0) {
            System.out.println("警告："+thePet.getName()+"需要餵食！");
            thePet.inABadMood();
            thePet.starving();
            thePet.resetOverfull();
        }

        //過飽會扣好感度
        if(thePet.getOverfull() >= 0) {
            for(int i = 0; i<2; i++) {
                thePet.inABadMood();
            }
        }
    }

    /** 活著，清醒狀態，檢查無聊值影響好感度 */
    private void checkBored(Animal thePet) {
        if(thePet.getWalk() <= 0) {
            System.out.println("警告："+thePet.getName()+"需要散步！");
            thePet.inABadMood();
            thePet.soBored();
        }
    }

    /** 活著，清醒狀態，檢查有無配偶 */
    private boolean checkBound(Animal thePet) {
        return thePet.checkBind();
    }

    /** 活著，清醒狀態，檢查配偶是否同種及相關 */
    private void checkBindSituation(Animal thePet) {
        if(thePet.getType() == thePet.getBinding().getType()) {
            if(thePet.getSex() != thePet.getBinding().getSex()) {
                thePet.havingSex();
                if(thePet.getBindingTime() == 0) {
                    havingABaby(thePet);
                    thePet.resetBindingTime();
                    thePet.getBinding().resetBindingTime();
                }
            }
        } else {
            thePet.havingBadSex();
            switch (thePet.getType()) {
                case "Dog":
                    dogBadSex(thePet);
                    break;
                case "Cat":
                    catBadSex(thePet);
                    break;
                case "Fish":
                    fishBadSex(thePet);
                    break;
                case "Insect":
                    insectBadSex(thePet);
                    break;
            }
        }
    }

    /** 狗狗的不正常性愛 */
    public void dogBadSex(Animal thePet) {

        //不同情境A：狗＆昆蟲
        if(thePet.getBinding().getType() == "Insect"){
            if(thePet.getBored() <= 0) {
                //狗在無聊，昆蟲會死
                thePet.getBinding().setLife(false);
                System.out.println("你的"+thePet.getName()+"把"+thePet.getBinding().getName()+"玩死啦!!");
            }
        }

        //不同情境B：狗＆貓
        if(thePet.getBinding().getType() == "Cat"){
            if(thePet.getBored()  <= 0 || thePet.getBinding().getBored() <= 0) {
                //狗在無聊，貓在無聊 好感度都-1
                thePet.inABadMood();
                thePet.getBinding().inABadMood();
                System.out.println(thePet.getName()+"跟"+thePet.getBinding().getName()+"無聊中...!!");
            }
        }
    }

    /** 貓咪的不正常性愛 */
    public void catBadSex(Animal thePet) {

        //不同情境A：貓＆魚
        if(thePet.getBinding().getType() == "Fish"){
            if(thePet.getFeed() <= 0) {
                //貓在餓，魚會死
                thePet.getBinding().setLife(false);
                //要餵貓
                thePet.resetFeed();
                System.out.println("你的"+thePet.getName()+"把"+thePet.getBinding().getName()+"吃掉ㄌ!瓜張!");
            }
        }

        //不同情境B：貓＆昆蟲
        if(thePet.getBinding().getType() == "Insect"){
            if(thePet.getBored() <= 0) {
                //貓在無聊，昆蟲會死
                thePet.getBinding().setLife(false);
                //要帶貓散步
                thePet.resetWalk();
                System.out.println("你的"+thePet.getName()+"把"+thePet.getBinding().getName()+"玩死啦!!");
            }
        }

        //不同情境C：貓＆狗
        if(thePet.getBinding().getType() == "Dog"){
            if(thePet.getBored() <= 0 || thePet.getBinding().getBored() <= 0) {
                //貓在無聊，狗在無聊 好感度都-1
                thePet.inABadMood();
                thePet.getBinding().inABadMood();
                System.out.println(thePet.getName()+"跟"+thePet.getBinding().getName()+"無聊中...!!");
            }
        }
    }

    /** 魚兒的不正常性愛 */
    public void fishBadSex(Animal thePet) {

        //不同情境A：魚&貓
        if(thePet.getBinding().getType() == "Cat"){
            if(thePet.getBinding().getFeed() <= 0) {
                //貓在餓，魚會死
                thePet.setLife(false);
                //要餵貓
                thePet.getBinding().resetFeed();
                System.out.println("你的"+thePet.getName()+"被"+thePet.getBinding().getName()+"吃掉ㄌ？!");
            }
        }
    }

    /** 昆蟲的不正常性愛 */
    public void insectBadSex(Animal thePet) {

            //不同情境A：昆蟲＆狗
            if(thePet.getBinding().getType() == "Dog"){
                if(thePet.getBinding().getBored() <= 0) {
                    //狗在無聊，昆蟲會死
                    thePet.setLife(false);
                    System.out.println("你的"+thePet.getName()+"被"+thePet.getBinding().getName()+"玩死啦!!");
                }
            }

            //不同情境B：昆蟲＆貓
            if(thePet.getBinding().getType() == "Cat"){
                if(thePet.getBinding().getBored() <= 0) {
                    //狗在無聊，昆蟲會死
                    thePet.setLife(false);
                    //貓被散步一次
                    thePet.getBinding().resetWalk();
                    System.out.println("你的"+thePet.getName()+"被"+thePet.getBinding().getName()+"玩死啦!!");
                }
            }
    }

    /** 活著，清醒狀態，生出一個小Baby */
    private void havingABaby(Animal thePet) {
        for(int i = 0; i < allAnimals.length; i++) {
            if(allAnimals[i]==null) {
                allAnimals[i] = thePet.giveBirth();
                return;
            }
        }
        System.out.println("孩子的爹/娘，你沒有地方生啦！趕快買房吧！");
    }

    /** 檢查是否產出東西*/
    private void checkProduction(Animal thePet, Player thePlayer) {
        if(thePet.getProduction() <= 0) {
            thePet.produceSomething();
            thePlayer.bag.addItem(thePet.getProduct(), 1);
            String temp = "";
            switch (thePet.getProduct()){
                case "doghair":
                    temp = "狗毛";
                    break;
                case "cathair":
                    temp = "貓毛";
                    break;
                case "fishscale":
                    temp = "魚鱗";
                    break;
                case "sawdust":
                    temp = "木屑";
            }
            System.out.println(thePet.getName() + "產出了" + temp + "!");
        }
    }

    private Animal[] doubleArray(Animal[] originalArray){
        Animal[] newArray = new Animal[feList(originalArray.length)];
        for(int i = 0; i < originalArray.length; i++){
            newArray[i] = originalArray[i];
        }
        return newArray;
    }

    private int feList(int originalArray) {
        if(originalArray == 0) {
            return 1;
        }
        if(originalArray == 1) {
            return 2;
        }
        return (originalArray-1) + (originalArray-2);
    }
}
