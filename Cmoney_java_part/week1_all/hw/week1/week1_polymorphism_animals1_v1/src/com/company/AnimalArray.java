package com.company;

public class AnimalArray {
    private Animal[] animals = {};

    // 新增動物至尾端
    public void addAnimal(Animal animal) {
        Animal[] newAnimals = new Animal[animals.length + 1];

        //  將陣列深拷貝
        System.arraycopy(this.animals, 0, newAnimals, 0, this.animals.length);

        newAnimals[newAnimals.length - 1] = animal;
        this.animals = newAnimals;
    }

    // 指定位置插入
    public void addAnimal(Animal animal, int index) {
        Animal[] newAnimals = new Animal[animals.length + 1];

        //  將加入物件前半段的陣列深拷貝
        if (index >= 0) System.arraycopy(this.animals, 0, newAnimals, 0, index);

        // 插入加入物件
        newAnimals[index] = animal;

        //  將加入物件後半段的陣列深拷貝
        System.arraycopy(this.animals, index, newAnimals, index + 1, this.animals.length - index);

        this.animals = newAnimals;
    }

    // 指定位置刪除
    public void removeAnimal(int index) {
        Animal[] newAnimals = new Animal[animals.length - 1];

        //  將刪除物件前半段的陣列深拷貝
        if (index >= 0) System.arraycopy(this.animals, 0, newAnimals, 0, index);

        //  將刪除物件後半段的陣列深拷貝
        System.arraycopy(this.animals, index + 1, newAnimals, index, this.animals.length - index - 1);

        this.animals = newAnimals;
    }

    // 照體重排序
    public void sortAnimalsByWeight() {
        for (int i = 0; i < this.animals.length - 1; i++) {
            for (int j = 0; j < this.animals.length - i - 1; j++) {
                if (this.animals[j].getWeight() >= this.animals[j + 1].getWeight())
                    swap(j, j + 1);
            }
        }
    }

    // 照名字排序
    public void sortAnimalsByName() {
        for (int i = 0; i < this.animals.length - 1; i++) {
            for (int j = 0; j < this.animals.length - i - 1; j++) {
                if (this.animals[j].getName().compareTo(this.animals[j + 1].getName()) > 0)
                    swap(j, j + 1);
            }
        }
    }

    public void swap(int i1, int i2) {
        Animal tmpAnimal = this.animals[i1];
        this.animals[i1] = this.animals[i2];
        this.animals[i2] = tmpAnimal;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }
}
