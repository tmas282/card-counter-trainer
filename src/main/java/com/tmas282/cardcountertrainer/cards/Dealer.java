package com.tmas282.cardcountertrainer.cards;

import java.io.FileNotFoundException;

public class Dealer {
    private Deck deck;
    public Dealer() throws FileNotFoundException {
        deck = Deck.getInstance();
    }
    public Card getACard(){
        Card card = deck.getRandomCard();
        deck.removeCard(card);
        return card;
    }
    public boolean checkIfDeckIsOver() throws FileNotFoundException {
        if (deck.getLen() == 0){
            deck.generateDeck();
            return true;
        }
        return false;
    }
}
