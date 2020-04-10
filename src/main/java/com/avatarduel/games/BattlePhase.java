package com.avatarduel.games;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import com.avatarduel.model.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class BattlePhase extends GameState {

    private Card selectedCard;
    private Card selectedEnemyCard;



    private void setPlayerMid(FXMLLoader loader, int curPlayer, Player player1, Player player2){
        MidFieldController midController;
        if(curPlayer == 1){
            midController = ((ArenaController)loader.getController()).getMid1();
        }
        else{
            midController = ((ArenaController)loader.getController()).getMid2();
        }

        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        int size = 0;
        if(curPlayer == 1){
            size = player1.getMidTopDeck().size();
        }
        else{
            size = player2.getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++){
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    BorderPane temp_ = (BorderPane) set.getChildren().get(finalI);
                    VBox temp = (VBox) temp_.getCenter();
                    HBox top = (HBox) temp.getChildren().get(0);
                    Text cardName = (Text) top.getChildren().get(0);
                    Text cardElement = (Text) top.getChildren().get(4);
                    VBox bottom = (VBox) temp.getChildren().get(2);
                    Text cardDescription = (Text) bottom.getChildren().get(0);
                    HBox attribute = (HBox) bottom.getChildren().get(2);
                    Text cardAttack = (Text) attribute.getChildren().get(0);
                    Text cardDefense = (Text) attribute.getChildren().get(2);
                    Text cardPower = (Text) attribute.getChildren().get(4);
                    selectedCard = new CharacterBuilder()
                            .name(cardName.getText())
                            .description(cardDescription.getText())
                            .element(Element.valueOf(cardElement.getText()))
                            .attack(Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")))
                            .defense(Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")))
                            .power(Integer.valueOf(cardPower.getText().replaceAll("\\D+", "")))
                            .build();
                }
            });
        }
    }

    private void setEnemyMid(FXMLLoader loader, int curPlayer, Player player1, Player player2){
        MidFieldController midController;
        if(curPlayer == 1){
            midController = ((ArenaController)loader.getController()).getMid2();
        }
        else{
            midController = ((ArenaController)loader.getController()).getMid1();
        }

        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        int size = 0;
        if(curPlayer == 1){
            size = player1.getMidTopDeck().size();
        }
        else{
            size = player2.getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++){
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    BorderPane temp_ = (BorderPane) set.getChildren().get(finalI);
                    VBox temp = (VBox) temp_.getCenter();
                    HBox top = (HBox) temp.getChildren().get(0);
                    Text cardName = (Text) top.getChildren().get(0);
                    Text cardElement = (Text) top.getChildren().get(4);
                    VBox bottom = (VBox) temp.getChildren().get(2);
                    Text cardDescription = (Text) bottom.getChildren().get(0);
                    HBox attribute = (HBox) bottom.getChildren().get(2);
                    Text cardAttack = (Text) attribute.getChildren().get(0);
                    Text cardDefense = (Text) attribute.getChildren().get(2);
                    Text cardPower = (Text) attribute.getChildren().get(4);
                    selectedCard = new CharacterBuilder()
                            .name(cardName.getText())
                            .description(cardDescription.getText())
                            .element(Element.valueOf(cardElement.getText()))
                            .attack(Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")))
                            .defense(Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")))
                            .power(Integer.valueOf(cardPower.getText().replaceAll("\\D+", "")))
                            .build();
                }
            });
        }
    }

    @Override
    public void setMouseClick(GameFlow main) {

    }
}
