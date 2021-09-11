package com.company;

import java.util.Comparator;

public class animalsNameSort  implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getName().compareTo(a2.getName());
    }
}
