package com.company;

public class Resource {
    private int wood;
    private int iron;

    public Resource(int wood, int iron) {
        this.wood = wood;
        this.iron = iron;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }
}
