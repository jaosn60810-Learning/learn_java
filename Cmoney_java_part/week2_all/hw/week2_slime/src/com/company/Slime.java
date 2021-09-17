package com.company;

import java.util.Arrays;

public class Slime {
    private int hp;
    private int atk;
    private Skill[] skills;

    public Slime(int hp, int atk) {
        this.hp = hp;
        this.atk = atk;

        //隨機產生數字0~2 決定技能
        int random = (int) (Math.random() * (2 - 0 + 1) + 0);
        if (random == 1) {
            this.skills = new Skill[]{Skill.HEAL, Skill.NORMALATK};
        } else if (random == 2) {
            this.skills = new Skill[]{Skill.HEAL, Skill.CRITICALHIT};
        } else {
            this.skills = new Skill[]{Skill.NORMALATK, Skill.CRITICALHIT};
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Slime{" +
                "hp=" + hp +
                ", atk=" + atk +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}

