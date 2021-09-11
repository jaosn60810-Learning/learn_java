package com.company;

public class Resource {
    private int amountWood;
    private int amountSteel;

    public int getAmountWood() {
        return amountWood;
    }

    public void addAmountWood(int amount) {
        this.amountWood += amount;
    }

    public void minusAmountWood(int amount) {
        if(amountWood < amount) {
            System.out.println("資源不足無法建造");
        }
        else this.amountWood -= amount;
    }

    public int getAmountSteel() {
        return amountSteel;
    }

    public void addAmountSteel(int amount) {
        this.amountSteel += amount;
    }

    public void minusAmountSteel(int amount) {
        if(amountSteel < amount) {
            System.out.println("資源不足無法建造");
        }
        else this.amountSteel -= amount;
    }
}
