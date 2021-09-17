package com.company;

public class Main {

    public static void main(String[] args) {
        // 創建史萊姆A
        Slime slimeA = new Slime(random(50, 200), random(40, 80));
        System.out.println("A " + slimeA);

        // 創建史萊姆B
        Slime slimeB = new Slime(random(50, 200), random(40, 80));
        System.out.println("B " + slimeB);

        // 戰鬥到一方 HP 歸零
        System.out.println();
        System.out.println("戰鬥開始");
        while (true) {
            System.out.println("A打B");

            // 戰鬥開始
            battle(slimeA, slimeB);

            // 戰鬥結果
            battleResult(slimeA, slimeB);

            // 如果 B 生命值歸零 結束遊戲
            if (slimeB.getHp() < 1) {
                break;
            }

            System.out.println("B打A");

            // 戰鬥開始
            battle(slimeB, slimeA);

            // 戰鬥結果
            battleResult(slimeA, slimeB);

            // 如果 A 生命值歸零 結束遊戲
            if (slimeA.getHp() < 1) {
                break;
            }
        }
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void battle(Slime slimeA, Slime slimeB) {
        // 決定 A 這回合使用的技能
        Skill slimeAUseSkill = slimeA.getSkills()[random(0, 1)];
        System.out.println("使用" + slimeAUseSkill);

        // 如果是治癒 加 A 的生命值
        if (slimeAUseSkill == Skill.HEAL) {
            slimeA.setHp(slimeA.getHp() + (int) slimeAUseSkill.value);
            System.out.println("補了" + (int) slimeAUseSkill.value);
        }
        // 如果是攻擊 扣 B 的生命值
        else {
            slimeB.setHp(slimeB.getHp() - (int) (slimeAUseSkill.value * slimeA.getAtk()));
            System.out.println("打了" + (int) (slimeAUseSkill.value * slimeA.getAtk()));
        }
    }

    public static void battleResult(Slime slimeA, Slime slimeB) {
        // 印出 A 和 B 的狀態
        System.out.println("戰鬥結果");
        System.out.println("A " + slimeA);
        System.out.println("B " + slimeB);
        System.out.println();
    }
}
