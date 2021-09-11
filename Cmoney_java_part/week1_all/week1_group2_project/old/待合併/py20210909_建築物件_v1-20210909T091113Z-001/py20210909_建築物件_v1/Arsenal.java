/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109aoe;

/**
 *
 * @author kisso
 */
public class Arsenal extends Building{
    public Arsenal(int time){
        super(time);
        super.setBuildingName("Arsenal");
        super.setBuildingNumber(6);
        super.setLimit(3);
    }


    
    public void generatePeople(PeopleArray parr){
        System.out.println("I just wanna fight for extinction!");
    }
    
    public void techDevelop(){
       if(getBuildingLevel()<getLimit()){
            super.setBuildingLevel(super.getBuildingLevel()+1);

           //升級士兵
        }else{
            System.out.println("It's the highest level!");            
        }        
    }
    
    public String toString(){
        return "buildingName:" + super.getBuildingName() + 
                "\nbuildingNumber:" + super.getBuildingNumber() +
                "\nbuildingLevel:" + super.getBuildingLevel()+
                "\nBuildingTime:" + super.getBuildingTime() +
                "\nCivilLevel:" + super.getCivilLevel() +"\n";
    }
    
    @Override
    public void setBuildingName(String str){
        System.out.println("I'm Arsenal ! Not " + str +" !");
    }
}
