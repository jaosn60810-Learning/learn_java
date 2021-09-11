package project;

public class Person {
    /*instance variables, what do you need to keep track of?
     * number of people, wood, iron, ammo?
     */

    public static int survivors;
    public static int wood;
    public static int iron;
    public static int ammo;

    public Person(int survivors, int wood, int iron, int ammo) {
        Person.survivors = survivors;
        Person.wood = wood;
        Person.iron = iron;
        Person.ammo = ammo;
    }

    //methods
    //getters, setters and tostring

    //sets survivors
    public void setSurvivors(int survivors) {
        Person.survivors = survivors;
    }

    //gets survivors
    public int getSurvivors() {
        return survivors;
    }

    //sets wood
    public void setWood(int wood) {
        Person.wood = wood;
    }

    //gets wood
    public int getWood() {
        return wood;
    }

    //sets iron
    public void setIron(int iron) {
        Person.iron = iron;
    }

    //gets iron
    public int getIron() {
        return iron;
    }

    //sets ammo
    public void setAmmo(int ammo) {
        Person.ammo = ammo;
    }

    //gets ammo
    public int getAmmo() {
        return ammo;
    }

    public String toString() {
        return "Day: " + Apocalypse.days + "\nSurvivors: " + Person.survivors + "\nWoods: " + Person.wood + "\nIrons: " + Person.iron + "\nAmmo: " + Person.ammo;
    }
}
