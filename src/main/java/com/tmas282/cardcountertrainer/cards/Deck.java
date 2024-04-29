package com.tmas282.cardcountertrainer.cards;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    static private Deck deck;

    static public Deck getInstance() throws FileNotFoundException {
        if(deck == null){
            Deck.deck = new Deck();
        }
        return Deck.deck;
    }

    private Deck() throws FileNotFoundException {
        this.theDeck = new ArrayList<Card>();
        generateDeck();
    }
    private ArrayList<Card> theDeck;

    public boolean removeCard(Card card){
        return theDeck.remove(card);
    }
    public Card getRandomCard(){
        if(getLen() == 0)
            return null;
        int rNum = (new Random()).nextInt(getLen());
        Card cardChoosed = theDeck.get(rNum);
        return cardChoosed;
    }
    public int getLen(){
        return theDeck.size();
    }
    public void generateDeck() throws FileNotFoundException {
        for (Suits suit:
                Suits.values()) {
            for (CardValues value:
                    CardValues.values()) {
                this.theDeck.addLast(new Card(suit,value));
            }
        }
    }
}
