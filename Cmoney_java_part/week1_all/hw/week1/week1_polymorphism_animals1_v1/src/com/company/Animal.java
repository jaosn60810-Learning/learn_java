package com.company;

public class Animal {
    private String name;
    private float weight;

    public Animal(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.name + " " + this.weight;
    }
}
