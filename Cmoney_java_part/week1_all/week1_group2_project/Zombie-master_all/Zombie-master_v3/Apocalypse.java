package project;

import java.security.SecureRandom;
import java.util.Scanner;

public class Apocalypse {
    // instance data here. what do you need to keep track of?
    // number of days left?
    public static int days;
    private int scavengers, zombies;
    int woodFound, ironFound, ammoFound, peopleFound;
    Person group1;
    SecureRandom rng;

    // constructor
    // what will we initialize through constructor?
    public Apocalypse() {
        group1 = new Person(Util.SURVIVORS, Util.WOOD, Util.IRON, Util.AMMO);
        days = 1;
        rng = new SecureRandom();

    }

    // public boolean runSimulation() will go here
    // return true if there are survivors and wood and iron
    // return false if no survivors and wood amd iron
    public boolean runSimulation() {
        while (Person.survivors > 0) {
            combat();
            // if there are no survivors left after combat, returns false
            if (Person.survivors == 0) {
                System.out.println("\nEveryone was eaten by zombies.");
                return false;
            }
            System.out.println(group1.toString());
//            combat();
//            // if there are no survivors left after combat, returns false
//            if (Person.survivors == 0) {
//                System.out.println("\nEveryone was eaten by zombies.");
//                return false;
//            }
            System.out.println();
            scavenge();
            days++;
        }
        return false;
    }

    // method for scavenging supplies
    private void scavenge() {
        // prompts user for a yes/no input
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to scavenge for supplies? (Y/N) ");
        String response = input.next();

        // if user enters an invalid input, keep asking until user inputs y/n
        while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            System.out.println("Invalid input");
            System.out.print("Do you want to scavenge for supplies? (Y/N) ");
            response = input.next();
        }

        // if user accepts to scavenge for supplies by pressing "y", prompt user
        // for amount of survivors they want to send out
        if (response.equalsIgnoreCase("y")) {

            System.out.print("How many people do you want to send on the supply run? ");
            scavengers = input.nextInt();
            // makes it so that user cannot input more survivors than they
            // already have or a negative amount
            while (scavengers > Person.survivors || scavengers < 0) {
                System.out.println("Invalid input");
                System.out.print("How many people do you want to send out on the supply run? ");
                scavengers = input.nextInt();
            }

            // if scavengers survive supply run, they have a chance of finding
            // wood, iron, ammo, grenades, or other people to join


            // methods for finding supplies, more scavengers = potentially
            findWood();
            findIron();
            findAmmo();
            // method for finding more people to join the group
            findSurvivors();
            System.out.printf(
                    "The scavengers returned safely with: %d wood, %d iron, %d ammo, %d new members\n\n",
                    woodFound, ironFound, ammoFound, peopleFound);
            // reset values to 0 to avoid these values getting stuck on a
            // number
            woodFound = 0;
            ironFound = 0;
            ammoFound = 0;
            peopleFound = 0;

        }
        // if user enters "n", nothing is scavenged and the day continues on
        else if (response.equalsIgnoreCase("n")) {
            System.out.println();
            return;
        }
    }

    private void findWood() {
        // scavengers have a 100% chance of finding wood
        // randomly generates amount of wood and multiplies that by amount of
        // scavengers
        woodFound = (3) * scavengers;
        Person.wood += woodFound;
    }

    private void findIron() {
        // scavengers have a 100% chance of finding iron
        // randomly generates amount of iron and multiplies that by amount of
        // scavengers
        ironFound = (3) * scavengers;
        Person.iron += ironFound;
    }

    private void findAmmo() {
        ammoFound = scavengers;
        Person.ammo += ammoFound;
    }

    private void findSurvivors() {
        peopleFound = scavengers;
        Person.survivors += peopleFound;
    }

    // method to fight zombies
    private void combat() {
        // generates a random amount of zombies each day, survivors will use
        // grenades first and then firearms after they cannot throw anymore
        // grenades.
        // they will use melee weapons if they run out of ammo
        zombies = this.zombiesAttackAbility();
        System.out.println("Zombies at beginning of combat: " + zombies);
        gunBattle();
        System.out.println("Survivors after combat: " + Person.survivors);
    }

    private int zombiesAttackAbility() {
        int zombiesAttackAbilityTotal = 0;
        // 殭屍
        zombiesAttackAbilityTotal += days * 3;
        return zombiesAttackAbilityTotal;
    }

    private void gunBattle() {
        while (zombies > 0 && Person.survivors > 0 && Person.ammo > 0) {
            Person.ammo--;
            zombies--;
        }
        if (Person.ammo < 1 && zombies > 0) {
            Person.survivors -= zombies;
        }
        if (Person.survivors < 1) {
            Person.survivors = 0;
        }
    }
}
