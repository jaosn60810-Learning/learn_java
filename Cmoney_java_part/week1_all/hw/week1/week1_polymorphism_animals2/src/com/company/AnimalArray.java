package com.company;

import java.util.ArrayList;

public class AnimalArray {
    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void addAnimal(int index, Animal animal) {
        this.animals.add(index, animal);
    }

    public void removeAnimal(int index) {
        this.animals.remove(index);
    }

    public void printAnimal(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : this.animals) {
            if (animal.getName().compareTo(name) == 0)
                return animal;
        }
        return null;
    }

    public ArrayList<Animal> findAnimalByFirstLetter(char firstLetter) {
        ArrayList<Animal> sameFirstLetterAnimals = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getName().charAt(0) == firstLetter)
                sameFirstLetterAnimals.add(animal);
        }
        return sameFirstLetterAnimals;
    }

    public ArrayList<Animal> findAnimalByMinToMaxWeight(int min, int max) {
        ArrayList<Animal> minToMaxWeightAnimals = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getWeight() >= min && animal.getWeight() <= max)
                minToMaxWeightAnimals.add(animal);
        }
        return minToMaxWeightAnimals;
    }

    public ArrayList<Animal> findAnimalBySpecies(Animal species) {
        ArrayList<Animal> sameSpeciesAnimals = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getClass().equals(species.getClass()))
                sameSpeciesAnimals.add(animal);
        }
        return sameSpeciesAnimals;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
