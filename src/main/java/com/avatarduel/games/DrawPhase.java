package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class DrawPhase extends GameState {

    public void setMouseClick(GameFlow main) {
        if(main.getCurPlayer() == 1){
            if(main.getPlayer1().getHandDeck().size() < 8){
                main.getPlayer1().getHandDeck().add(main.getPlayer1().getDrawDeck().pop());
            }
        } else {
            if(main.getPlayer2().getHandDeck().size() < 8){
                main.getPlayer2().getHandDeck().add(main.getPlayer2().getDrawDeck().pop());
            }
        }
    }
}
