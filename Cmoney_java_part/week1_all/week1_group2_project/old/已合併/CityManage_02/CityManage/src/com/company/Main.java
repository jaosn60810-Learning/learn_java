package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        villager vill = new villager();
        vill.villagerLife(1);
        vill.villagerNumber(20);

        resource res = new resource();//新增
        res.woodEfficiency = 3;//木材效率
        res.steelEfficiency = 1;//鋼鐵效率

        Date date = new Date();
        date.time(0);


        while (true) {
            System.out.println("Date:" + date.time + " hr");
            System.out.println("villagerLife:" + vill.villagerLife);
            System.out.println("villagerNumber:" + vill.villagerNumber);

            System.out.println("wood:" + res.wood);  //顯示木材
            System.out.println("steel:" + res.steel); //顯示鋼鐵

            //新增指令
            while (true) {
                System.out.println("請輸入指令分配村民採集:wood+市民人數");
                String collection1 = sc.next();
                System.out.println("請輸入指令分配村民採集:steel+市民人數");
                String collection2 = sc.next();

                String[] coll1 = collection1.split("\\+");
                String[] coll2 = collection2.split("\\+");

                res.woodPeople = Integer.decode(coll1[1]); //木材採集人數
                res.steelPeople = Integer.decode(coll2[1]);//鋼鐵採集人數

                if (vill.villagerNumber >= res.woodPeople + res.steelPeople) {  //判斷人數是否超過
                    System.out.println("採集wood:" + res.woodPeople + "人" + " 採集steel:" + res.steelPeople + "人");
                    break;
                } else {
                    System.out.println("人數輸入錯誤!");
                }
            }

            System.out.println("請輸入時間指令:nextHour、nextHalfDay、nextDay");
            String next = sc.next();

            switch (next) {
                case "nextHour": {  //時間增加1
                    date.nextHour();
                    vill.villagerTime = date.addTime;
                    vill.villagerLevel = date.houseLevel;
                    vill.villagerAdd();

                    res.resourceTime = date.addTime;//新增
                    res.woodAdd();//新增
                    res.steelAdd();//新增
                    break;
                }
                case "nextHalfDay": {   //時間增加12
                    date.nextHalfDay();
                    vill.villagerTime = date.addTime;
                    vill.villagerLevel = date.houseLevel;
                    vill.villagerAdd();

                    res.resourceTime = date.addTime;//新增
                    res.woodAdd();//新增
                    res.steelAdd();//新增
                    break;
                }
                case "nextDay": {  //時間增加24
                    date.nextDay();
                    vill.villagerTime = date.addTime;
                    vill.villagerLevel = date.houseLevel;
                    vill.villagerAdd();

                    res.resourceTime = date.addTime;//新增
                    res.woodAdd();//新增
                    res.steelAdd();//新增
                    break;
                }
            }

        }

    }
}

