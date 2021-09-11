package com.company;

public class Date {
    public int time; //時間
    public int addTime; //增加時間
    public int houseLevel=1; //先暫放房屋等級

    public void time(int time){
        this.time = time;
    }

    public void nextHour(){
        addTime = 1;
        time+=addTime;
    }

    public void nextHalfDay(){
        addTime = 12;
        time+=addTime;
    }

    public void nextDay(){
        addTime = 24;
        time+=addTime;
    }

//    public void Zombie(){
//        int n = 0 ;
//        int a,b,c,d,e,f = 0;
//        int ZombieAttack = 0;
//        if (time % 16 == 0) {
//            n++;
//            a = (n * 3) * 5;
//            b = (int) (n / 10 * 5) * 7;
//            c = (int) (n / 10 * 4) * 10;
//            d = (int) (n / 10 * 3) * 13;
//            e = (int) (n / 10 * 2) * 17;
//            f = (int) (n / 10 * 1) * 25;
//            ZombieAttack = (a + b + c + d + e + f);
//        }
//    }

}
