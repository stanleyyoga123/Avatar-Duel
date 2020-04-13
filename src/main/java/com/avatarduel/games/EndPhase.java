package com.avatarduel.games;

import com.avatarduel.model.Player;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URISyntaxException;

public class EndPhase extends GameState {

    private void returnDef(GameFlow main) {
        main.getPlayer1().setIsPlayedLand(false);
        main.getPlayer2().setIsPlayedLand(false);
        for(int i = 0; i < main.getUsedP1().size(); i++) {
            main.getUsedP1().remove(0);
        }
        for(int i = 0; i < main.getUsedP2().size(); i++) {
            main.getUsedP2().remove(0);
        }
    }

    @Override
    public void setMouseClick(GameFlow main) {
        if(main.getCurPlayer() == 1) {
            main.setCurPlayer(2);
        } else {
            main.setCurPlayer(1);
        }
        returnDef(main);
    }
}
