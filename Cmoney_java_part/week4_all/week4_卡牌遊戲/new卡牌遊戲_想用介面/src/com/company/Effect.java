package com.company;

public interface Effect {
//     void doBuff(Player p1,Player p2);
      boolean canEffect(Player p1, Player cpu);
      int action(Player p1, Player cpu) ;
}
