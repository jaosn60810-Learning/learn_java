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

    public void printAnimalArray() {
        for (int i = 0; i < this.animals.size(); i++) {
            System.out.println(this.animals.get(i).toString());
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
