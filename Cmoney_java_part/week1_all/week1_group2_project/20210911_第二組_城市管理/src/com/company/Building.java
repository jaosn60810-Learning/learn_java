package com.company;

import java.util.ArrayList;
public class Building {
    public ArrayList<int[]> buildingObj = new ArrayList<>();
    Building(){
        //       編號,等級,建木,建鋼,升判,升木,升鋼,升時,建判,建時,realTime
        int[] b1 = {1,  0,  10, 0,  0,  30, 15, 30, 0,  1,  -1};
        int[] b2 = {2,  0,  10, 5,  0,  50, 20, 24, 0,  3,  -1};
        int[] b3 = {3,  0,  20, 10,  0,  30, 15, 30, 0,  2,  -1};
        int[] b4 = {4,  0,  15, 0,  0,  30, 15, 30, 0,  1,  -1};
        int[] b5 = {5,  0,  15, 5,  0,  30, 15, 30, 0,  1,  -1};
        int[] b6 = {6,  0,  30, 10,  0,  70, 40, 48, 0,  3,  -1};
        buildingObj.add(b1);
        buildingObj.add(b2);
        buildingObj.add(b3);
        buildingObj.add(b4);
        buildingObj.add(b5);
        buildingObj.add(b6);
    }
    
    public void buildCheck(int buildingNumber,Resource resource){
        if(buildingObj.get(buildingNumber)[8]==0 ){
                    if(resource.getWood() >= buildingObj.get(buildingNumber)[2] &&
                            resource.getWood() > buildingObj.get(buildingNumber)[3] ){
                        buildingObj.get(buildingNumber)[8]=1;
                        resource.setWood(resource.getWood() - buildingObj.get(buildingNumber)[2]);
                        resource.setSteel(resource.getSteel() - buildingObj.get(buildingNumber)[3]);                        
                    }
                }else if((buildingObj.get(buildingNumber)[8]==1)){
                    System.out.println("已配置村民建造");
                }else if((buildingObj.get(buildingNumber)[8]==2)){
                    System.out.println("已存在該建築");
                }
    }
@Override
    public String toString(){
        int tmp = 0;
        for(int i=0; i<buildingObj.size(); i++){
            if(buildingObj.get(i)[8] == 1){
                tmp ++;
            }
        }
        return Integer.toString(tmp);
    }
    
    
}
