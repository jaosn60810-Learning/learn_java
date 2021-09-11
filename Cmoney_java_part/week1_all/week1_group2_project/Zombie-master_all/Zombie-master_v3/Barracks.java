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
    private final int limit = 1;
    public Barracks(int time){
        super(time);
        super.setBuildingLevel(0);
        super.setBuildingName("Barracks");
        super.setBuildingNumber(3);
    }

    public void setBarracksLevel() {
        if(getBuildingLevel()<limit){setBuildingLevel(getBuildingLevel()+1);}
    }
    
//    @Override
//    public void generatePeople(PeopleArray parr){
//        for(int i=0; i<1+barracksLevel; i++){
//            parr.append(new PeopleTest());
//        }
//    }
    
    @Override
    public void techDevelop(PeopleArray parr){
        System.out.println("等待村民組parr.append");
        
    }
    @Override
    
    public void techDevelop(BuildingArray barr){
        System.out.println("Do nothing");
    }
    
    public String toString(){
        return "buildingName:" + super.getBuildingName() + 
                "\nbuildingNumber:" + super.getBuildingNumber() +
                "\nbuildingLevel:" + super.getBuildingLevel()+
                "\nBuildingTime:" + super.getBuildingTime() +"\n";
    }
    
    @Override
    public void setBuildingName(String str){
        System.out.println("I'm Barracks ! Not " + str +" !");
    }
}
