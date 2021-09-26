package Pet;

public class Insect extends Animal {

    private int insect_Consumption = 1;
    private int insect_Feed = 4;
    private int insect_Hungry = 5;
    private int insect_Walk = 999999999; //不能散步
    private int insect_Bored = 999999999; //不會無聊
    private int insect_Sleep = 999999999; //不用睡覺
    private int insect_SleepLast = 999999999; //不用睡覺
    private int insect_BindingTime = 2;
    private int insect_Excretion = 1;
    private int insect_Production = 4;
    private int insect_HungryToDie = 10;
    private int insect_BoredToDie = 999999999; //不會無聊
    private int insect_Shit = 30;
    private int insect_Estrus = 13;
    private int insect_Overfull = insect_Hungry/2;

    public Insect() {
        setConsumption(insect_Consumption);
        setFeed(insect_Feed);
        setHungry(insect_Hungry);
        setWalk(insect_Walk);//不能散步
        setBored(insect_Bored);//不會無聊
        setSleep(insect_Sleep);//不用睡覺
        setSleepLast(insect_SleepLast);
        setBindingTime(insect_BindingTime);
        setExcretion(insect_Excretion);
        setProduction(insect_Production);
        setHungryToDie(insect_HungryToDie);
        setBoredToDie(insect_BoredToDie);//不會無聊
        setShit(insect_Shit);
        setType("Insect");
        setEstrus(insect_Estrus);
        setOverfull(insect_Overfull);
        setProduct("sawdust");
    }

    @Override
    public void resetSleep() {
        //不用睡覺
    }

    @Override
    public void resetFeed() {
        checkoverfull();
        setFeed(insect_Feed);
        setHungry(insect_Hungry);
    }

    @Override
    public void resetExcertion() {
        setExcretion(insect_Excretion);
    }

    @Override
    public void resetShit() {
        setShit(insect_Shit);
    }

    @Override
    public void resetProduction() {
        setProduction(insect_Production);
    }

    @Override
    public void resetBindingTime() {
        setBindingTime(insect_BindingTime);
    }

    @Override
    public Insect giveBirth() {
        Insect babyInsect = new Insect();
        babyInsect.setName("昆蟲寶寶");
        return babyInsect;
    }

    @Override
    public void resetEstrus() {
        setEstrus(insect_Estrus);
    }

    @Override
    public void resetOverfull() {
        setOverfull(insect_Overfull);
    }

}
