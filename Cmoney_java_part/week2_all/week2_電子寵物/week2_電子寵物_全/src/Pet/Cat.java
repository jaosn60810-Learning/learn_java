package Pet;

public class Cat extends Animal{

    public int cat_Consumption = 1;
    public int cat_Feed = 3;
    public int cat_Hungry = 4;
    public int cat_Sex = (int) ((Math.random()*100) % 2);
    public int cat_Walk = 10;
    public int cat_Bored = 10;
    public int cat_Sleep = 8;
    public int cat_SleepLast = 4;
    public int cat_BindingTime = 3;
    public int cat_Excretion = 5;
    public int cat_Production = 6;
    public int cat_HungryToDie = 3;
    public int cat_BoredToDie = 9;
    public int cat_Shit = 3;
    public int cat_Estrus = 5;
    public int cat_Overfull = cat_Hungry/2;


    public Cat() {
        this.consumption = cat_Consumption;
        this.feed = cat_Feed;
        this.hungry = cat_Hungry;
        this.sex = cat_Sex;
        this.walk = cat_Walk;
        this.bored = cat_Bored;
        this.sleep = cat_Sleep;
        this.sleepLast = cat_SleepLast;
        this.bindingTime = cat_BindingTime;
        this.excretion = cat_Excretion;
        this.production = cat_Production;
        this.hungryToDie = cat_HungryToDie;
        this.boredToDie = cat_BoredToDie;
        this.life = true;
        this.shit = cat_Shit;
        this.type = "Cat";
        this.estrus = cat_Estrus;
        this.overfull = cat_Overfull;
    }

    @Override
    public void resetSleep() {
        this.sleep = cat_Sleep;
        this.sleepLast = cat_SleepLast;
    }

    @Override
    public void resetFeed() {
        this.feed = cat_Feed;
        this.hungry = cat_Hungry;
        checkExerction();
    }

    @Override
    public void resetExcertion() {
        this.excretion = cat_Excretion;
    }

    @Override
    public void resetShit() {
        this.shit = cat_Shit;
    }

    @Override
    public void resetWalk() {
        this.walk = cat_Walk;
    }

    @Override
    public void resetProduction() {
        this.production = cat_Production;
    }

    @Override
    public void resetBindingTime() {
        this.bindingTime = cat_BindingTime;
    }

    @Override
    public Animal giveBirth() {
        Cat babyCat = new Cat();
        babyCat.name = "貓寶寶";
        return babyCat;
    }

    @Override
    public void resetEstrus() {
        this.estrus = cat_Estrus;
    }

    @Override
    public void resetOverfull() {
        this.overfull = cat_Overfull;
    }
}
