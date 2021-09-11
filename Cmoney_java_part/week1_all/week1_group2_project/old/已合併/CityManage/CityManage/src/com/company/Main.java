package com.company;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        villager vill = new villager();
        vill.villagerLife(1);
        vill.villagerNumber(20);

        Date date = new Date();
        date.time(0);


    while (true){
        System.out.println("Date:"+date.time+" hr");
        System.out.println("villagerLife:"+vill.villagerLife);
        System.out.println("villagerNumber:"+vill.villagerNumber);

        System.out.println("請輸入時間指令:nextHour、nextHalfDay、nextDay");
        String next = sc.next();

        switch (next){
            case "nextHour":{  //時間增加1
                date.nextHour();
                vill.villagerTime = date.time;
                vill.villagerLevel= date.houseLevel;
                vill.villagerAdd();
                break;
            }
            case "nextHalfDay":{   //時間增加12
                date.nextHalfDay();
                vill.villagerTime = date.time;
                vill.villagerLevel= date.houseLevel;
                vill.villagerAdd();
                break;
            }
            case "nextDay":{  //時間增加24
                date.nextDay();
                vill.villagerTime = date.time;
                vill.villagerLevel= date.houseLevel;
                vill.villagerAdd();
                break;
            }
        }

    }


    }
}
