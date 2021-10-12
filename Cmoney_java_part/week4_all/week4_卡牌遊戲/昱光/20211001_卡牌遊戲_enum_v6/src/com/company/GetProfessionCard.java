package com.company;

public class GetProfessionCard {


    public static Card[] getProfessionAllCard(int fate){
        switch (fate){
            case 1:
               return WarriorCard.CARD1.getAllCard();
            case 2:
                return MageCard
        }
    }

    public static Card getProfessionOneCard(int fate, int cardNum){
        switch (fate){
            case 1:
                for (WarriorCard w:WarriorCard.values()){
                    if(w.getNumber() == cardNum){
                        return w.getThisCard();
                    }
                }
            case 2:
                return MageCard
        }
    }
}
