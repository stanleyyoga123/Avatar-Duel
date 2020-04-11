package com.avatarduel.games;

import com.avatarduel.model.Card;
import java.util.ArrayList;

abstract public class GameState {

    public int findCard(Card card, ArrayList<Card> deck1) {
        for(int i = 0; i < deck1.size(); i++){
            if(card.getName().equals(deck1.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    public abstract void setMouseClick(GameFlow main);
}
