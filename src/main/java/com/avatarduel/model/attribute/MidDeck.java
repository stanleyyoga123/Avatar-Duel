package com.avatarduel.model.attribute;

import com.avatarduel.model.Card;

import java.util.ArrayList;

public class MidDeck {

    private ArrayList<Card> midTopDeck;
    private ArrayList<Card> midBotDeck;

    public MidDeck(ArrayList<Card> midTopDeck, ArrayList<Card> midBotDeck) {
        this.midTopDeck = midTopDeck;
        this.midBotDeck = midBotDeck;
    }

    public ArrayList<Card> getMidTopDeck() {
        return midTopDeck;
    }

    public void setMidTopDeck(ArrayList<Card> midTopDeck) {
        this.midTopDeck = midTopDeck;
    }

    public ArrayList<Card> getMidBotDeck() {
        return midBotDeck;
    }

    public void setMidBotDeck(ArrayList<Card> midBotDeck) {
        this.midBotDeck = midBotDeck;
    }
}
