package com.company;

public class villager  {
    public int villagerLife;//村民數值
    public int villagerNumber;//村民人數
    public int villagerProduce;//村民生產速度
    public int villagerLevel;//村民等級=房屋等級
    public int villagerTime;//村民時間=增加時間

   public void villagerLife(int life){
       this.villagerLife = life;

   }
    public void villagerNumber(int villagerNumber){
        this.villagerNumber = villagerNumber;

    }

    public void villagerAdd(){
        if (villagerLevel == 1){
            villagerProduce = 1;
        }else if(villagerLevel == 2){
            villagerProduce =2; }

        this.villagerNumber += villagerProduce * villagerTime;
        //村民人數=村民人數+(生產速度*增加的時間)
    }
}
