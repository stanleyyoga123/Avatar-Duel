package com.avatarduel.games;

import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URISyntaxException;

public class BattlePhase extends GameState {

    private Card selectedCard;
    private Card selectedEnemyCard;

    private void setPlayerMid(){

    }

    @Override
    public void setMouseClick(FXMLLoader loader, int curPlayer, Player player1, Player player2) {

    }
}
