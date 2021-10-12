package com.company;

public interface CardEffect {
    boolean canEffect(Player p1, Player p2);

    void actionForAll(Player p1, Player p2);

    public Card[] getAllCard();

    public Card getThisCard();

//    public String toString();

    public Card[] removeCardFromCardSet(Card[] updateCardSet, int position);

    public Card[] addToCardSet(Card[] originalCardSet, Card newCard);

}

