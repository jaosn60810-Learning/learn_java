package Pet;

public class Dog extends Animal{

    private int dog_Consumption = 2;
    private int dog_Feed = 4;
    private int dog_Hungry = 4;
    private int dog_Walk = 3;
    private int dog_Bored = 6;
    private int dog_Sleep = 7;
    private int dog_SleepLast = 2;
    private int dog_BindingTime = 2;
    private int dog_Excretion = 3;
    private int dog_Production = 5;
    private int dog_HungryToDie = 4;
    private int dog_BoredToDie = 6;
    private int dog_Shit = 5;
    private int dog_Estrus = 3;
    private int dog_Overfull = dog_Hungry/2;

    public Dog() {
        setConsumption(dog_Consumption);
        setFeed(dog_Feed);
        setHungry(dog_Hungry);
        setWalk(dog_Walk);
        setBored(dog_Bored);
        setSleep(dog_Sleep);
        setSleepLast(dog_SleepLast);
        setBindingTime(dog_BindingTime);
        setExcretion(dog_Excretion);
        setProduction(dog_Production);
        setHungryToDie(dog_HungryToDie);
        setBoredToDie(dog_BoredToDie);
        setShit(dog_Shit);
        setType("Dog");
        setEstrus(dog_Estrus);
        setOverfull(dog_Overfull);
        setProduct("doghair");
        setLikeDectorate("woodhouse");
    }

    @Override
    public void resetSleep() {
        setSleep(dog_Sleep);
        setSleepLast(dog_SleepLast);
    }

    @Override
    public void resetFeed() {
        checkoverfull();
        setFeed(dog_Feed);
        setHungry(dog_Hungry);
    }

    @Override
    public void resetExcertion() {
        setExcretion(dog_Excretion);
    }

    @Override
    public void resetShit() {
        setShit(dog_Shit);
    }

    @Override
    public void resetWalk() {
        setWalk(dog_Walk);
    }

    @Override
    public void resetProduction() {
        setProduction(dog_Production);
    }

    @Override
    public void resetBindingTime() {
        setBindingTime(dog_BindingTime);
    }

    @Override
    public Dog giveBirth() {
        Dog babyDog = new Dog();
        babyDog.setName("狗寶寶");
        return babyDog;
    }

    @Override
    public void resetEstrus() {
        setEstrus(dog_Estrus);
    }

    @Override
    public void resetOverfull() {
        setOverfull(dog_Overfull);
    }
}
