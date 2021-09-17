package Pet;

public class Animal {

    //名稱
    String name;
    //食量
    int consumption;
    //餵食頻率
    int feed;
    //飢餓頻率
    int hungry;
    //性別
    int sex;
    //散步頻率
    int walk;
    //無聊頻率
    int bored;
    //睡眠頻率
    int sleep;
    //睡眠持續頻率
    int sleepLast;
    //交配時間
    int bindingTime;
    //產出物品
    int product;
    //排泄頻率
    int excretion;
    //產出物品頻率
    int production;
    //餓到死頻率
    int hungryToDie;
    //無聊到死頻率
    int boredToDie;

    /** 這邊是額外偵測 */
    //連結對象
    Animal binding;
    //種類
    String type;
    //是否活著
    boolean life;
    //死掉狀態(1)餓死(2)無聊死(3)髒死(4)無法連結所以死
    int die;
    //排泄物數量
    int shit;
    //不同種交配
    int notOkaySex = 5;


    /** 本次新增狀態 */
    //好感度
    int feeling;
    //發情狀態
    int estrus;
    //過飽狀態
    int overfull;

    //設定動物名字
    public void setName(String name) {
        this.name = name;
    }

    //印出動物狀態
    public void printOutStatus() {
        System.out.print(name+"，目前狀態：");
        if(life == true) {
            if(sleep <= 0) {
                System.out.print("睡覺中勿擾～");
            } else {

                System.out.print("  【飽食度】");
                if(feed <= 0) {
                    System.out.print("我肚子餓了！");
                } else {
                    System.out.print("ＯＫ還不餓！");
                }

                System.out.print("\t【無聊度】");
                if(walk <= 0) {
                    System.out.print("該找我玩ㄌ！");
                } else {
                    System.out.print("沒事不要煩！");
                }

                System.out.print("\t【好感度】");
                if(feeling <= 0) {
                    System.out.print("-> " + feeling + "  我ㄅ喜歡你！");
                } else {
                    System.out.print("-> " + feeling + "  主人偶愛你！！");
                }

                System.out.print("\t【感情狀況】");
                if(binding == null) {
                    System.out.print("我單身... (PД`q。)·。'゜");
                } else {
                    System.out.print("-> " + binding.name + "是我ㄉ寶貝 <3 <3 <3！！");
                }

                if(excretion == 0) {
                    System.out.print("\t驚！剛剛大便ㄌ～(╬☉д⊙)");
                }
            }
        } else {
            System.out.print("ㄏㄏ我已死亡 -> ");
            if(die == 1) {
                System.out.print("我是餓死ㄉ(✘Д✘๑ )");
            }
            if(die == 2) {
                System.out.print("我是無聊死ㄉ(|||ﾟдﾟ)");
            }
            if(die == 3) {
                System.out.print("我是髒死ㄉΣ(*ﾟдﾟﾉ)ﾉ");
            }
            if(die == 4) {
                System.out.print("我是不正常性愛死ㄉ(／‵Д′)／~ ╧╧");
            }
        }
        System.out.println();
    }

    //清醒後重置睡眠相關數據
    public void resetSleep() {

    }

    //餵食後重置餵食飢餓狀態
    public void resetFeed() {

    }

    //餵食後更新排泄狀態
    public void checkExerction() {
        this.excretion--;
        //確認要不要大便
        if(this.excretion == 0) {
            this.shit--;
            resetExcertion();
        }
    }

    //重置排泄狀態
    public void resetExcertion() {

    }

    //清潔房間
    public void resetShit() {

    }

    //散步
    public void resetWalk() {

    }

    //產出物品後重置產出狀態
    public void resetProduction() {

    }

    //連結後重置狀態
    public void resetBindingTime() {

    }

    //生小孩
    public Animal giveBirth(){
        return new Animal();
    }

    //重置發情狀態
    public void resetEstrus() {

    }

    //重置過飽狀態
    public void resetOverfull() {

    }

    //解除連結
    public void resetBinding() {
        this.binding.binding = null;
        this.binding = null;
    }
}
