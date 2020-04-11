package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BattlePhase extends GameState {

    private Card selectedCard;
    private Card selectedEnemyCard;
    private int index;
    private boolean isEnemyDef;

    public void setPlayerCard(GameFlow main) {
        MidFieldController midFieldController;
        if(main.getCurPlayer() == 1) {
            midFieldController = ((ArenaController) main.getLoader().getController()).getMid1();
        } else {
            midFieldController = ((ArenaController) main.getLoader().getController()).getMid2();
        }
        VBox temp = (VBox) midFieldController.getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        int size = 0;

        if(main.getCurPlayer() == 1) {
            size = main.getPlayer1().getMidTopDeck().size();
        } else {
            size = main.getPlayer2().getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++) {
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCard = midFieldController.getIndexCardFront(finalI);
                }
            });
        }
    }

    public void setEnemyCard(GameFlow main) {
        MidFieldController midFieldController;
        if(main.getCurPlayer() == 1) {
            midFieldController = ((ArenaController) main.getLoader().getController()).getMid2();
        } else {
            midFieldController = ((ArenaController) main.getLoader().getController()).getMid1();
        }
        VBox temp = (VBox) midFieldController.getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        int size = 0;

        if(main.getCurPlayer() == 1) {
            size = main.getPlayer2().getMidTopDeck().size();
        } else {
            size = main.getPlayer1().getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++) {
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedEnemyCard = midFieldController.getIndexCardFront(finalI);
                    if(set.getChildren().get(finalI).getRotate() != 0) {
                        isEnemyDef = true;
                    } else {
                        isEnemyDef = false;
                    }
                }
            });
        }
    }

    public int enemyAttUsed() {
        if(isEnemyDef) {
            return selectedEnemyCard.getDefense();
        }
        return selectedEnemyCard.getAttack();
    }

    public void battlePhase(GameFlow main) {
        if(isEnemyDef) {
            if(selectedCard.getAttack() >=  enemyAttUsed()) {

            }
        }
    }

    @Override
    public void setMouseClick(GameFlow main) {

    }
}
