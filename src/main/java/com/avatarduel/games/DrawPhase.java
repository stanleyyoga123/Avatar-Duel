package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Class to Control Draw Phase
 */

public class DrawPhase extends GameState {

    /**
     * Set event for Draw Phase
     * @param main Main
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    @Override
    public void event(GameFlow main) throws IOException, URISyntaxException {
        if(main.getCurPlayer() == 1){
            if(main.getPlayer1().getHandDeck().size() < 8){
                main.getPlayer1().getHandDeck().add(main.getPlayer1().getDrawDeck().draw());
            }
            try {
                ((ArenaController)main.getLoader().getController()).getDeck1().updateHand(main.getPlayer1().getHandDeck());
            } catch (Exception e) {
                //
            }
        } else {
            if(main.getPlayer2().getHandDeck().size() < 8){
                main.getPlayer2().getHandDeck().add(main.getPlayer2().getDrawDeck().draw());
            }
            try {
                ((ArenaController)main.getLoader().getController()).getDeck2().updateHand(main.getPlayer2().getHandDeck());
            } catch (Exception e) {
                //
            }
        }
        ((ArenaController)main.getLoader().getController()).setDeckSize(main.getPlayer1().getDrawDeck().getCardSize(), main.getPlayer2().getDrawDeck().getCardSize());
    }

    /**
     * Change state from Draw Phase into Main Phase 1
     * @param main Main
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    @Override
    public void changeState(GameFlow main) throws IOException, URISyntaxException {
        main.getGameState().deleteMouseClick(main);
        ((ArenaController)main.getLoader().getController()).setCurPhase("Main Phase 1");
        main.setGameState(new MainPhase1());
        main.getGameState().event(main);
    }
}
