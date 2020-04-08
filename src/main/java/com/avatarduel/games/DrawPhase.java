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

    @Override
    public void start(int curPlayer, Player player1, Player player2) throws IOException, URISyntaxException {
        if(curPlayer == 1){
            if(player1.getHandDeck().size() < 8){
                player1.getHandDeck().add(player1.getDrawDeck().pop());
            }
        }
        else{
            if(player2.getHandDeck().size() < 8){
                player2.getHandDeck().add(player2.getDrawDeck().pop());
            }
        }
    }

    @Override
    public void end() {

    }

    public void setMouseClick(FXMLLoader loader, int curPlayer, Player player1, Player player2) {}
}
