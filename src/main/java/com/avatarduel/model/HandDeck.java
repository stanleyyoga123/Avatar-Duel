package com.avatarduel.model;

import java.util.List;

public class HandDeck extends Deck {
    
    public HandDeck() {
        super();
    }

    public List<Card> getCardsAtHand() {
        return this.cardsDeck;
    }

    public int getNumCardsAtHand() {
        return this.cardsDeck.size();
    }
}