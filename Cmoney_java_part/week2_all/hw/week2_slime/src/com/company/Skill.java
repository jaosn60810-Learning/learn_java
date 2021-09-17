package com.company;

public enum Skill {
    HEAL(10),
    NORMALATK(1),
    CRITICALHIT(1.5);

    double value;

    Skill(double value) {
        this.value = value;
    }
}
