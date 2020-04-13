package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;

public class DrawPhase extends GameState {

    public void setMouseClick(GameFlow main) {
        System.out.println(main.getPlayer1().getHandDeck());
        System.out.println(main.getPlayer2().getHandDeck());
        if(main.getCurPlayer() == 1){
            if(main.getPlayer1().getHandDeck().size() < 8){
                main.getPlayer1().getHandDeck().add(main.getPlayer1().getDrawDeck().pop());
                try {
                    ((ArenaController)main.getLoader().getController()).getDeck1().updateHand(main.getPlayer1().getHandDeck());
                } catch (Exception e) {
                    //
                }
            }
        } else {
            if(main.getPlayer2().getHandDeck().size() < 8){
                main.getPlayer2().getHandDeck().add(main.getPlayer2().getDrawDeck().pop());
                try {
                    ((ArenaController)main.getLoader().getController()).getDeck2().updateHand(main.getPlayer2().getHandDeck());
                } catch (Exception e) {
                    //
                }
            }
        }

    }
}
