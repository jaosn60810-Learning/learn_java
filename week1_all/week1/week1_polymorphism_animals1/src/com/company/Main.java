package com.company;

import java.util.Collections;
import java.util.stream.DoubleStream;

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
        animals.printAnimalArray();
        System.out.println();
        // 指定位置插入
        animals.addAnimal(1, cat2);
        animals.printAnimalArray();
        System.out.println();
        // 指定位置刪除
        animals.removeAnimal(0);
        animals.printAnimalArray();
        System.out.println();
        // 照體重排序
        animals.getAnimals().sort(new animalsWeightSort());
        animals.printAnimalArray();
        System.out.println();
        // 照名字排序
        animals.getAnimals().sort(new animalsNameSort());
        animals.printAnimalArray();
        System.out.println();
    }
}
