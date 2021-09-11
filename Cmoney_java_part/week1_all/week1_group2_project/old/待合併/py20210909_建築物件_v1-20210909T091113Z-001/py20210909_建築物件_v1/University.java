/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pylenovo.py202109aoe;
import java.util.Scanner;
/**
 *
 * @author kisso
 */
public class University extends Building{
    private final int limit = 2;
    public University(int time){
        super(time);
        super.setBuildingName("University");
        super.setBuildingNumber(2);
    }
    
//    @Override
//    public void generatePeople(PeopleArray parr){
//        for(int i=0; i<1+barracksLevel; i++){
//            parr.append(new PeopleTest());
//        }
//    }
//    
//    public void generatePeople(PeopleArray parr){
//        System.out.println("I do better at technology rather than raise a child!");
//    }
    
    
    public void techDevelop(BuildingArray b){
        Scanner sc = new Scanner(System.in);
        //升級
        System.out.println("請輸入升級項目：\n1:文明\n2:軍營\n3:伐木場\n4:煉鋼廠\n5:房屋");
        int n = sc.nextInt();
        String tmp = "";
        switch(n){
            case 1:
                tmp = "University";
                break;
            case 2:
                tmp = "Barracks";
                break;
            case 3:
                tmp = "Wood";
                break;
            case 4:
                tmp = "Fe";
                break;
            case 5:
                tmp = "PeopleHouse";
                break;
        }
        for(int i=0; i<b.getIndex(); i++){
            if(b.arr[i].getBuildingName().equals(tmp)){
                b.arr[i].techDevelop();
            }
        }
        
                
    }
    
    public void techDevelop(){
        if(getBuildingLevel()<getLimit()){
            super.setBuildingLevel(super.getBuildingLevel()+1);
            super.setCivilLevel(super.getCivilLevel()+1);
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
        System.out.println("I'm University ! Not " + str +" !");
    }
}
