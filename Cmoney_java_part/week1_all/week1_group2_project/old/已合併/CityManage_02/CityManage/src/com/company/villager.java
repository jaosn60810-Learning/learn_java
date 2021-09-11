package com.company;

public class villager  {
    public int villagerLife;//市民數值
    public int villagerNumber;//市民人數
    public int villagerProduce;//市民生產速度
    public int villagerLevel;//市民等級=房屋等級
    public int villagerTime;//市民時間=增加時間

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

        this.villagerNumber += villagerProduce * (villagerTime/24);
        //市民人數=市民人數+(生產速度*(增加的時間/24))
    }
}
