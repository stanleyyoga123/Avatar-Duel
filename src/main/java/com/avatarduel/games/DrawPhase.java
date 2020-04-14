package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;

import java.io.IOException;
import java.net.URISyntaxException;

public class DrawPhase extends GameState {

    public void setMouseClick(GameFlow main) throws IOException, URISyntaxException {
        if(main.getCurPlayer() == 1){
            if(main.getPlayer1().getHandDeck().size() < 8){
                main.getPlayer1().getHandDeck().add(main.getPlayer1().getDrawDeck().getCardsDeck().pop());
            }
            try {
                ((ArenaController)main.getLoader().getController()).getDeck1().updateHand(main.getPlayer1().getHandDeck());
            } catch (Exception e) {
                //
            }
        } else {
            if(main.getPlayer2().getHandDeck().size() < 8){
                main.getPlayer2().getHandDeck().add(main.getPlayer2().getDrawDeck().getCardsDeck().pop());
            }
            try {
                ((ArenaController)main.getLoader().getController()).getDeck2().updateHand(main.getPlayer2().getHandDeck());
            } catch (Exception e) {
                //
            }
        }
    }
}
