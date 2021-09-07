package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("dog", (float) 12.1);
        Dog dog2 = new Dog("dog2", (float) 1.1);
        Cat cat = new Cat("cat", (float) 33.2);
        Cat cat2 = new Cat("cat2", (float) 3.2);
        Mouse mouse = new Mouse("mouse", (float) 23.2);
        Mouse mouse2 = new Mouse("mouse2", (float) 2.2);
        AnimalArray animals = new AnimalArray();
        // 新增動物
        animals.addAnimal(dog);
        animals.addAnimal(dog2);
        animals.addAnimal(cat);
        animals.addAnimal(mouse);
        animals.addAnimal(mouse2);
        // 印出所有動物
        animals.printAnimal(animals.getAnimals());
        System.out.println();
        // 指定位置插入
        animals.addAnimal(1, cat2);
        animals.printAnimal(animals.getAnimals());
        System.out.println();
        // 指定位置刪除
        animals.removeAnimal(0);
        animals.printAnimal(animals.getAnimals());
        System.out.println();
        // 照體重排序
        animals.getAnimals().sort(new animalsWeightSort());
        animals.printAnimal(animals.getAnimals());
        System.out.println();
        // 照名字排序
        animals.getAnimals().sort(new animalsNameSort());
        animals.printAnimal(animals.getAnimals());
        System.out.println();
        // 用名字找動物
        System.out.println(animals.findAnimalByName("mouse").toString());
        System.out.println();
        // 用字首找動物
        ArrayList<Animal> sameFirstLetterAnimals = animals.findAnimalByFirstLetter('c');
        animals.printAnimal(sameFirstLetterAnimals);
        System.out.println();
        // 可以依照體重的大小(min~max)篩選動物
        ArrayList<Animal> minToMaxWeightAnimals = animals.findAnimalByMinToMaxWeight(0, 5);
        animals.printAnimal(minToMaxWeightAnimals);
        System.out.println();
        // 可以依照動物的種類篩選動物
        ArrayList<Animal> sameSpeciesAnimals = animals.findAnimalBySpecies(cat);
        animals.printAnimal(sameSpeciesAnimals);
        System.out.println();

    }
}
