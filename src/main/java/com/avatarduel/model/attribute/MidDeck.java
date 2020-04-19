package com.avatarduel.model.attribute;

import com.avatarduel.model.Card;
import java.util.ArrayList;

/**
 * Class contains Mid Deck
 */

public class MidDeck {

    private ArrayList<Card> midTopDeck;
    private ArrayList<Card> midBotDeck;

    /**
     * Constructor for Mid Deck
     * @param midTopDeck Mid Top Deck
     * @param midBotDeck Mid Bot Deck
     */
    public MidDeck(ArrayList<Card> midTopDeck, ArrayList<Card> midBotDeck) {
        this.midTopDeck = midTopDeck;
        this.midBotDeck = midBotDeck;
    }

    /**
     * Getter for Mid Top Deck
     * @return List of Card
     */
    public ArrayList<Card> getMidTopDeck() {
        return midTopDeck;
    }

    /**
     * Getter for Mid Bot Deck
     * @return List of Card
     */
    public ArrayList<Card> getMidBotDeck() {
        return midBotDeck;
    }
}
