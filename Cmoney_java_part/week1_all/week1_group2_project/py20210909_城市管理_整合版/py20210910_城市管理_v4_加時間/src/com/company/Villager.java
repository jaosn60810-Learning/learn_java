package com.company;

public class Villager {
    public int villagerLife;//村民數值
    public int villagerNumber;//村民人數
    public int villagerProduce = 1;//村民生產速度
    public int villagerLevel;//村民等級=房屋等級
    public int villagerTime;//村民時間=增加時間

    public void villagerLife(int life) {
        this.villagerLife = life;

    }

    public void villagerNumber(int villagerNumber) {
        this.villagerNumber = villagerNumber;

    }
//更改Level參數
    public void villagerAdd() {
        this.villagerProduce = villagerLevel;
        this.villagerNumber += villagerProduce;
        //村民人數= 村民人數+生產速度
    }
    
    public void build(int civilLevel){
        
    }

    @Override
    public String toString() {
        return "Villager{" +
                "villagerLife=" + villagerLife +
                ", villagerNumber=" + villagerNumber +
                ", villagerProduce=" + villagerProduce +
                ", villagerLevel=" + villagerLevel +
                ", villagerTime=" + villagerTime +
                '}';
    }
}
