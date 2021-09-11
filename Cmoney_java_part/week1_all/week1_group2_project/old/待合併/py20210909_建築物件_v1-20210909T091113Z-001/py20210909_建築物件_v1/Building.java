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
public abstract class Building {
    private int buildingTime;
    private int buildingLevel = 1;
    private int civilLevel = 1;
    private int limit ;
    private String buildingName;
    private int buildingNumber;

    public Building(int buildingTime) {
        this.buildingTime = buildingTime;
    }


    public int getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public int getCivilLevel() {
        return civilLevel;
    }

    public void setCivilLevel(int civilLevel) {
        this.civilLevel = civilLevel;
    }
    
    //BuildingTime不須更動
    public int getBuildingTime() {
        return buildingTime;
    }
    //BuildingName不須更動
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    
    //BuildingNumber不須更動
    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
    

    public void techDevelop(){
        System.out.println("No funtion!");
    }
    
    
}
