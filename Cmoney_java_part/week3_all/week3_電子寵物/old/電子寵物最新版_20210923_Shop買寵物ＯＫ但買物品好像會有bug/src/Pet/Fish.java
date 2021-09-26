package Pet;

public class Fish extends Animal{

    private int fish_Consumption = 1;
    private int fish_Feed = 5;
    private int fish_Hungry = 5;
    private int fish_Walk = 999999999; //不能散步
    private int fish_Bored = 999999999; //不會無聊
    private int fish_Sleep = 8;
    private int fish_SleepLast = 1;
    private int fish_BindingTime = 3;
    private int fish_Excretion = 2;
    private int fish_Production = 7;
    private int fish_HungryToDie = 3;
    private int fish_BoredToDie = 999999999; //不會無聊
    private int fish_Shit = 20;
    private int fish_Estrus = 8;
    private int fish_Overfull = fish_Hungry/2;

    public Fish() {
        setConsumption(fish_Consumption);
        setFeed(fish_Feed);
        setHungry(fish_Hungry);
        setWalk(fish_Walk);
        setBored(fish_Bored);
        setSleep(fish_Sleep);
        setSleepLast(fish_SleepLast);
        setBindingTime(fish_BindingTime);
        setExcretion(fish_Excretion);
        setProduction(fish_Production);
        setHungryToDie(fish_HungryToDie);
        setBoredToDie(fish_BoredToDie);
        setShit(fish_Shit);
        setType("Fish");
        setEstrus(fish_Estrus);
        setOverfull(fish_Overfull);
        setProduct("fishscale");
        setLikeDectorate("seaweed");
    }

    @Override
    public void resetSleep() {
        setSleep(fish_Sleep);
        setSleepLast(fish_SleepLast);
    }

    @Override
    public void resetFeed() {
        checkoverfull();
        setFeed(fish_Feed);
        setHungry(fish_Hungry);
    }

    @Override
    public void resetExcertion() {
        setExcretion(fish_Excretion);
    }

    @Override
    public void resetShit() {
        setShit(fish_Shit);
    }

    @Override
    public void resetProduction() {
        setProduction(fish_Production);
    }

    @Override
    public void resetBindingTime() {
        setBindingTime(fish_BindingTime);
    }

    @Override
    public Fish giveBirth() {
        Fish babyFish = new Fish();
        babyFish.setName("魚寶寶");
        return babyFish;
    }

    @Override
    public void resetEstrus() {
        setEstrus(fish_Estrus);
    }

    @Override
    public void resetOverfull() {
        setOverfull(fish_Overfull);
    }
}
