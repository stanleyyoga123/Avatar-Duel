package com.avatarduel.model;

import com.avatarduel.model.attribute.Deck;

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

    public void addCardToHand(Card c) {
        this.cardsDeck.add(c);
    }
}