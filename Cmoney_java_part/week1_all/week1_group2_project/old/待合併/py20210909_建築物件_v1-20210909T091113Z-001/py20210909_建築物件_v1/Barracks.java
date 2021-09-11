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
public class Barracks extends Building{
    private int genUnit = 1;
    public Barracks(int time){
        super(time);
        super.setBuildingName("Barracks");
        super.setBuildingNumber(3);
        super.setLimit(2);
    }
    
    public void generatePeople(PeopleArray parr){
        //生士兵
    }
    
    public void techDevelop(){
        if(getBuildingLevel()<getLimit()){
            genUnit ++ ;
            super.setBuildingLevel(super.getBuildingLevel()+1);
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
        System.out.println("I'm Barracks ! Not " + str +" !");
    }
}
