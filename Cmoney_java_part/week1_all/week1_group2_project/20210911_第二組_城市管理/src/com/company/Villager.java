package com.company;

public class Villager {
    public int villagerLife;//村民數值
    public int villagerNumber;//村民人數
    public int villagerProduce = 0 ;//村民生產速度
    public int villagerLevel=0;//村民等級=房屋等級

    public void villagerLife(int life) {
        this.villagerLife = life;

    }

    public void villagerNumber(int villagerNumber) {
        this.villagerNumber = villagerNumber;

    }
//更改Level參數
    public void villagerAdd() {
        this.villagerProduce = 1+villagerLevel*2;
        this.villagerNumber += villagerProduce;
        //村民人數= 村民人數+生產速度
    }
    
    public void build(int civilLevel){
        
    }

    @Override
    public String toString() {
        return "市民生命值=" + villagerLife +
                "\t市民總數=" + villagerNumber +
                "\t生民效率=" + villagerProduce +
                "\t市民等級=" + villagerLevel ;
    }
}
