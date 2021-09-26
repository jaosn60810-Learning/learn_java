package Pet;

public class Cat extends Animal{

    private int cat_Consumption = 1;
    private int cat_Feed = 3;
    private int cat_Hungry = 4;
    private int cat_Walk = 10;
    private int cat_Bored = 10;
    private int cat_Sleep = 8;
    private int cat_SleepLast = 4;
    private int cat_BindingTime = 3;
    private int cat_Excretion = 5;
    private int cat_Production = 6;
    private int cat_HungryToDie = 3;
    private int cat_BoredToDie = 9;
    private int cat_Shit = 3;
    private int cat_Estrus = 5;
    private int cat_Overfull = cat_Hungry/2;


    public Cat() {
        setConsumption(cat_Consumption);
        setFeed(cat_Feed);
        setHungry(cat_Hungry);
        setWalk(cat_Walk);
        setBored(cat_Bored);
        setSleep(cat_Sleep);
        setSleepLast(cat_SleepLast);
        setBindingTime(cat_BindingTime);
        setExcretion(cat_Excretion);
        setProduction(cat_Production);
        setHungryToDie(cat_HungryToDie);
        setBoredToDie(cat_BoredToDie);
        setShit(cat_Shit);
        setType("Cat");
        setEstrus(cat_Estrus);
        setOverfull(cat_Overfull);
        setProduct("cathair");
        setLikeDectorate("carton");
    }

    @Override
    public void resetSleep() {
        setSleep(cat_Sleep);
        setSleepLast(cat_SleepLast);
    }

    @Override
    public void resetFeed() {
        checkoverfull();
        setFeed(cat_Feed);
        setHungry(cat_Hungry);
        checkExerction();
    }

    @Override
    public void resetExcertion() {
        setExcretion(cat_Excretion);
    }

    @Override
    public void resetShit() {
        setShit(cat_Shit);
    }

    @Override
    public void resetWalk() {

        setWalk(cat_Walk);
    }

    @Override
    public void resetProduction() {
        setProduction(cat_Production);
    }

    @Override
    public void resetBindingTime() {
        setBindingTime(cat_BindingTime);
    }

    @Override
    public Cat giveBirth() {
        Cat babyCat = new Cat();
        babyCat.setName("貓寶寶");
        return babyCat;
    }

    @Override
    public void resetEstrus() {
        setEstrus(cat_Estrus);
    }

    @Override
    public void resetOverfull() {
        setOverfull(cat_Overfull);
    }

}
