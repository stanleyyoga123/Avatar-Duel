package com.avatarduel.games;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.builder.LandBuilder;
import com.avatarduel.builder.SkillBuilder;
import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.CardHandController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainPhase1 extends GameState{

    private Card selectedCard;

    @Override
    public void start(int curPlayer, Player player1, Player player2) throws IOException, URISyntaxException {

    }

    @Override
    public void end() {

    }

    @Override
    public void setMouseClick(FXMLLoader loader, int curPlayer, Player player1, Player player2) {
        // Mouse Click on Deck
        CardHandController deckController;
        if(curPlayer == 1){
            deckController = ((ArenaController)loader.getController()).getDeck1();
        }
        else{
            deckController = ((ArenaController)loader.getController()).getDeck2();
        }
        for(int i = 0; i < 8; i++){
            try{
                int finalI = i;
                deckController.getHbox().getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        VBox temp = (VBox) deckController.getHbox().getChildren().get(finalI);
                        HBox top = (HBox) temp.getChildren().get(0);
                        Text cardName = (Text) top.getChildren().get(0);
                        Text cardType = (Text) top.getChildren().get(2);
                        Text cardElement = (Text) top.getChildren().get(4);
                        VBox bottom = (VBox) temp.getChildren().get(2);
                        if(cardType.getText().equals("Land")){
                            Text cardDescription = (Text) bottom.getChildren().get(0);
                            selectedCard = new LandBuilder()
                                    .name(cardName.getText())
                                    .description(cardDescription.getText())
                                    .element(Element.valueOf(cardElement.getText()))
                                    .build();
                        }
                        else if(cardType.getText().equals("Character")){
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
                        else{
                            Text cardDescription = (Text) bottom.getChildren().get(0);
                            Text cardEffect = (Text) bottom.getChildren().get(2);
                            HBox attribute = (HBox) bottom.getChildren().get(4);
                            Text cardAttack = (Text) attribute.getChildren().get(0);
                            Text cardDefense = (Text) attribute.getChildren().get(2);
                            Text cardPower = (Text) attribute.getChildren().get(4);
                            selectedCard = new SkillBuilder()
                                    .name(cardName.getText())
                                    .description(cardDescription.getText())
                                    .element(Element.valueOf(cardElement.getText()))
                                    .attack(Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")))
                                    .defense(Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")))
                                    .power(Integer.valueOf(cardPower.getText().replaceAll("\\D+", "")))
                                    .effect(Effect.valueOf(cardEffect.getText()))
                                    .build();
                        }
                    }
                });

                deckController.getHbox().getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        int index = 0;
                        if(curPlayer == 1){
                            if(!player1.isPlayedLand()){
                                if(selectedCard.getClass().getSimpleName().equals("Character")){
                                    player1.getMidTopDeck().add(selectedCard);
                                    index = findCard(selectedCard, player1.getHandDeck());
                                    player1.getHandDeck().remove(index);
                                }
                                else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                                    player1.getMidBotDeck().add(selectedCard);
                                    index = findCard(selectedCard, player1.getHandDeck());
                                    player1.getHandDeck().remove(index);
                                }
                                else{
                                    if(player1.isPlayedLand()){
                                        System.out.println("AKAN MASUK SINI");
                                    }
                                    else{
                                        System.out.println("ANJING");
                                        index = findCard(selectedCard, player1.getHandDeck());
                                        player1.getHandDeck().remove(index);
                                        player1.setIsPlayedLand(true);
                                    }
                                }
                            }
                        }
                        try {
                            ((ArenaController)loader.getController()).updateHand(1, player1.getHandDeck());
                            ((ArenaController)loader.getController()).updateField(player1.getMidTopDeck(), player1.getMidBotDeck(), player2.getMidTopDeck(), player2.getMidBotDeck());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        setMouseClick(loader, curPlayer, player1, player2);
                    }
                });

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        // Mouse Click on Mid Front Field
        MidFieldController midController;
        if(curPlayer == 1){
            midController = ((ArenaController)loader.getController()).getMid1();
        }
        else{
            midController = ((ArenaController)loader.getController()).getMid2();
        }
        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        for(int i = 0; i < 8; i++){
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(set.getChildren().get(finalI).getRotate() > 0){
                        set.getChildren().get(finalI).setRotate(0);
                    }
                    else {
                        set.getChildren().get(finalI).setRotate(90);
                    }
                }
            });
        }
    }
}
