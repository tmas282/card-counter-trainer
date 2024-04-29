package com.tmas282.cardcountertrainer.cards;

import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.net.URL;

public class Card {
    private Image img;
    private Suits suit;
    private CardValues value;

    public Card(Suits suit, CardValues value) throws FileNotFoundException {
        this.suit = suit;
        this.value = value;
        if(!findImageOfCard(suit, value)){
            throw new FileNotFoundException("Image of file not found.");
        }
    }
    private boolean findImageOfCard(Suits suit, CardValues value){
        char suitS;
        if (suit == Suits.Clubs){
            suitS = 'c';
        } else if (suit == Suits.Diamonds) {
            suitS = 'd';
        } else if (suit == Suits.Spades) {
            suitS = 's';
        }
        else {
            suitS = 'h';
        }
        char valueS;
        int indexEnumValue = value.ordinal();
        if(indexEnumValue != 0 && indexEnumValue != 1 && indexEnumValue != 10 && indexEnumValue != 11 && indexEnumValue != 12){
            valueS = String.valueOf(indexEnumValue).toCharArray()[0];
        }
        else{
            valueS = value.toString().toCharArray()[0];
        }
        URL strOfImg = getClass().getResource(String.format("%c%c.jpg",valueS,suitS));
        if(strOfImg == null)
            return false;
        img = new Image(strOfImg.toString());
        return true;
    }

    public Image getImg() {
        return img;
    }
}
