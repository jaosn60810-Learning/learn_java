package com.company;

public class Test implements Effect{
    @Override
    public boolean canEffect(Player p1, Player cpu) {
        return false;
    }

    @Override
    public int action(Player p1, Player cpu) {
        return 0;
    }
}
