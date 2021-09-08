package com.company;

import java.util.Comparator;

public class animalsWeightSort implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return Math.round(a1.getWeight() - a2.getWeight());
    }
}
