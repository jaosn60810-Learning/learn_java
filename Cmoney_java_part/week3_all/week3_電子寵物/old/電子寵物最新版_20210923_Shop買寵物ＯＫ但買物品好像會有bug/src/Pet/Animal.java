package Pet;

public class Animal {

    //名稱
    private String name;
    //食量
    private int consumption;
    //餵食頻率
    private int feed;
    //飢餓頻率
    private int hungry;
    //性別
    private int sex = (int) ((Math.random()*100) % 2) + 1;
    //散步頻率
    private int walk;
    //無聊頻率
    private int bored;
    //睡眠頻率
    private int sleep;
    //睡眠持續頻率
    private int sleepLast;
    //交配時間
    private int bindingTime;
    //產出物品
    private String product;
    //排泄頻率
    private int excretion;
    //產出物品頻率
    private int production;
    //餓到死頻率
    private int hungryToDie;
    //無聊到死頻率
    private int boredToDie;

    /** 這邊是額外偵測 */
    //連結對象
    private Animal binding;
    //種類
    private String type;
    //是否活著
    private boolean life = true;
    //死掉狀態(1)餓死(2)無聊死(3)髒死(4)無法連結所以死(5)撐死
    private int die;
    //排泄物數量
    private int shit;
    //不同種交配
    private int notOkaySex = 5;
    //過飽狀態
    private int overfullSituation;


    /** 本次新增狀態 */
    //好感度
    private int feeling;
    //發情狀態
    private int estrus;
    //過飽狀態
    private int overfull;
    //喜歡的裝飾物
    private String likeDectorate;
    //有的屋子
    private String decorate = "無";






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
            if(die == 5) {
                System.out.print("我是被你撐死的！！！！");
            }
        }
        System.out.println();
    }



    /** 有關睡眠＆清醒 */
    //清醒後重置睡眠相關數據
    public void resetSleep() {
        //個別更改
    }

    //請醒時要扣睡眠點數
    public void awake() {
        this.sleep -= 1;
    }

    //睡眠時要扣睡眠持續點數
    public void sleep() {
        this.sleepLast -= 1;
    }

    //清醒狀態會開始各種活動
    public void awakeToPlay() {
        this.feed -= 1;
        this.walk -= 1;
        this.production -=1;
    }


    /** 有關餵食＆飢餓＆過飽 */
    //餵食後重置餵食飢餓狀態
    public void resetFeed() {

    }

    //
    public void checkoverfull() {
        if(this.feed > 0 || this.overfullSituation > 0) {
            this.life = false;
            this.die = 5;
            return;
        }
        if(this.hungry > this.overfull) {
            setOverfullSituation();
        }
        inAGoodMood();
        System.out.println("下次想吃Lawry's，懂？(๑•́ ₃ •̀๑)");
    }

    //開始飢餓要扣飢餓點數
    public void starving() {
        this.hungry -= 1;
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

    //重置過飽狀態
    public void resetOverfull() {

    }


    /** 好感度增減 */
    public void inABadMood() {
        this.feeling -= 1;
    }

    public void inAGoodMood() {
        this.feeling += 1;
    }

    public void badMoodEffect() {
        this.walk -= 1;
        this.hungry -= 1;
    }

    public void goodMoodEffect() {
        this.walk += 2;
        this.hungry += 2;
    }


    /** 清潔相關 */
    //清潔房間
    public void resetShit() {
    }

    //重置排泄狀態
    public void resetExcertion() {

    }

    /** 有關散步＆無聊 */
    //散步
    public void resetWalk() {

    }

    //無聊狀態扣掉無聊值
    public void soBored() {
        inABadMood();
    }


    /** 有關生產物品 */
    //生產物品
    public void produceSomething() {
        resetProduction();
    }

    //產出物品後重置產出狀態
    public void resetProduction() {

    }


    /** 交配相關 */
    //確認是否有配偶
    public boolean checkBind() {
        if(this.binding == null) {
            return false;
        }
        return true;
    }

    //確認是否會交配
    public void havingSex() {
        this.bindingTime -= 1;
        this.binding.bindingTime -= 1;
    }

    //解除連結
    public void resetBinding() {
        this.binding.binding = null;
        this.binding = null;
    }

    //生小孩
    public Animal giveBirth(){
        return new Animal();
    }

    //檢查是否正常性愛
    public void havingBadSex() {
        this.notOkaySex -= 1;
        this.binding.notOkaySex -= 1;
    }

    //重置發情狀態
    public void resetEstrus() {

    }

    //連結後重置狀態
    public void resetBindingTime() {

    }

    /** -----All Getter------ */

    public String getName() {
        return name;
    }

    public int getConsumption() {
        return consumption;
    }

    public int getFeed() {
        return feed;
    }

    public int getHungry() {
        return hungry;
    }

    public int getSex() {
        return sex;
    }

    public int getWalk() {
        return walk;
    }

    public int getBored() {
        return bored;
    }

    public int getSleep() {
        return sleep;
    }

    public int getSleepLast() {
        return sleepLast;
    }

    public Animal getBinding() {
        return binding;
    }

    public int getBindingTime() {
        return bindingTime;
    }

    public int getExcretion() {
        return excretion;
    }

    public int getProduction() {
        return production;
    }

    public int getHungryToDie() {
        return hungryToDie;
    }

    public int getBoredToDie() {
        return boredToDie;
    }

    public String getType() {
        return type;
    }

    public int getShit() {
        return shit;
    }

    public int getEstrus() {
        return estrus;
    }

    public int getOverfull() {
        return overfull;
    }

    public int getNotOkaySex() {
        return notOkaySex;
    }

    public int getFeeling() {
        return feeling;
    }

    public String getProduct() {
        return product;
    }

    public String getDecorate() {
        return decorate;
    }

    public String getLikeDectorate() {
        return likeDectorate;
    }

    /** -----All Setter------ */

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void setFeed(int feed) {
        this.feed = feed;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public void setWalk(int walk) {
        this.walk = walk;
    }

    public void setBored(int bored) {
        this.bored = bored;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public void setSleepLast(int sleepLast) {
        this.sleepLast = sleepLast;
    }

    public void setBindingTime(int bindingTime) {
        this.bindingTime = bindingTime;
    }

    public void setExcretion(int excretion) {
        this.excretion = excretion;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public void setHungryToDie(int hungryToDie) {
        this.hungryToDie = hungryToDie;
    }

    public void setBoredToDie(int boredToDie) {
        this.boredToDie = boredToDie;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setShit(int shit) {
        this.shit = shit;
    }

    public void setEstrus(int estrus) {
        this.estrus = estrus;
    }

    public void setOverfull(int overfull) {
        this.overfull = overfull;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public void setDie(int die) {
        this.die = die;
    }

    public void setBinding(Animal binding) {
        this.binding = binding;
    }

    public void setOverfullSituation() {
        this.overfullSituation = this.feed;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setLikeDectorate(String likeDectorate) {
        this.likeDectorate = likeDectorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }
}
