package com.company;

public class resource {
    public int wood; //木材總數
    public int steel; //鋼鐵總數
    public int woodPeople;//採集木材人數
    public int steelPeople;//採集鋼鐵人數
    public int woodEfficiency;//採集木材效率
    public int steelEfficiency;//採集鋼鐵效率
    public int resourceTime;


    public void woodAdd(){
        wood += woodPeople * woodEfficiency *resourceTime;

    }
    public void steelAdd(){
        steel += steelPeople * steelEfficiency *resourceTime;
    }

}

