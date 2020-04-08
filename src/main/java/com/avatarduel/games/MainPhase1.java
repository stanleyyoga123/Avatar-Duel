package com.avatarduel.games;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.builder.LandBuilder;
import com.avatarduel.builder.SkillBuilder;
import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.CardHandController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainPhase1 extends GameState{

    private Card selectedCard;
    private Card selectedCard2;
    private boolean isSkill = false;

    /**
     * Set event on deck card
     *
     * @param loader
     * @param curPlayer
     * @param player1
     * @param player2
     */
    private void eventDeck(FXMLLoader loader, int curPlayer, Player player1, Player player2) {
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
                        int power = 0;

                        // CHEAT
                        if(!isSkill){
                            if(selectedCard.getClass().getSimpleName().equals("Character")){
                                player1.getMidTopDeck().add(selectedCard);
                                index = findCard(selectedCard, player1.getHandDeck());
                                player1.getHandDeck().remove(index);
                            }
                            else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                                if(player1.getMidBotDeck().size() < 8){
                                    if(player1.getMidTopDeck().size() > 0 || player2.getMidTopDeck().size() > 0){
                                        player1.getMidBotDeck().add(selectedCard);
                                        index = findCard(selectedCard, player1.getHandDeck());
                                        player1.getHandDeck().remove(index);
                                        isSkill = true;
                                    }
                                }
                            }
                            else{
                                if(player1.isPlayedLand()){ }
                                else{
                                    index = findCard(selectedCard, player1.getHandDeck());
                                    player1.getHandDeck().remove(index);
                                    player1.setIsPlayedLand(true);
                                }
                            }
                        }

                        if(curPlayer == 1){
                            if(!player1.isPlayedLand()){
                                if(!isSkill){
                                    if(selectedCard.getElement() == Element.WATER){
                                        power = player1.getRemainingWater();
                                    }
                                    else if(selectedCard.getElement() == Element.FIRE){
                                        power = player1.getRemainingFire();
                                    }
                                    else if(selectedCard.getElement() == Element.AIR){
                                        power = player1.getRemainingAir();
                                    }
                                    else{
                                        power = player1.getRemainingEarth();
                                    }
                                    if(power >= selectedCard.getPower()){
                                        if(selectedCard.getClass().getSimpleName().equals("Character")){
                                            if(player1.getMidTopDeck().size() < 8){
                                                player1.getMidTopDeck().add(selectedCard);
                                                index = findCard(selectedCard, player1.getHandDeck());
                                                player1.getHandDeck().remove(index);
                                            }
                                        }
                                        else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                                            if(player1.getMidBotDeck().size() < 8){
                                                if(player1.getMidTopDeck().size() > 0 || player2.getMidTopDeck().size() > 0){
                                                    player1.getMidBotDeck().add(selectedCard);
                                                    index = findCard(selectedCard, player1.getHandDeck());
                                                    player1.getHandDeck().remove(index);
                                                    isSkill = true;
                                                }
                                            }
                                        }
                                        else{
                                            if(player1.isPlayedLand()){ }
                                            else{
                                                index = findCard(selectedCard, player1.getHandDeck());
                                                player1.getHandDeck().remove(index);
                                                player1.setIsPlayedLand(true);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            if(!player2.isPlayedLand()){
                                if(selectedCard.getElement() == Element.WATER){
                                    power = player2.getRemainingWater();
                                }
                                else if(selectedCard.getElement() == Element.FIRE){
                                    power = player2.getRemainingFire();
                                }
                                else if(selectedCard.getElement() == Element.AIR){
                                    power = player2.getRemainingAir();
                                }
                                else{
                                    power = player2.getRemainingEarth();
                                }
                                if(power >= selectedCard.getPower()){
                                    if(selectedCard.getClass().getSimpleName().equals("Character")){
                                        player2.getMidTopDeck().add(selectedCard);
                                        index = findCard(selectedCard, player2.getHandDeck());
                                        player2.getHandDeck().remove(index);
                                    }
                                    else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                                        if(player2.getMidBotDeck().size() < 8){
                                            if(player1.getMidTopDeck().size() > 0 || player2.getMidTopDeck().size() > 0){
                                                player2.getMidBotDeck().add(selectedCard);
                                                index = findCard(selectedCard, player2.getHandDeck());
                                                player2.getHandDeck().remove(index);
                                                isSkill = true;
                                            }
                                        }
                                    }
                                    else{
                                        if(player2.isPlayedLand()){ }
                                        else{
                                            index = findCard(selectedCard, player2.getHandDeck());
                                            player2.getHandDeck().remove(index);
                                            player2.setIsPlayedLand(true);
                                        }
                                    }
                                }
                            }
                        }
                        try {
                            if(curPlayer == 1){
                                ((ArenaController)loader.getController()).updateHand(1, player1.getHandDeck());
                            }
                            else{
                                ((ArenaController)loader.getController()).updateHand(2, player2.getHandDeck());
                            }
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
    }

    /**
     * Set event on mid front
     *
     * @param loader
     * @param curPlayer
     * @param player1
     * @param player2
     */
    private void eventMidFront(FXMLLoader loader, int curPlayer, Player player1, Player player2){
        // Mouse Click on Current Player Mid Front Field
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
                    if(isSkill){
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
                        selectedCard2 = new CharacterBuilder()
                                .name(cardName.getText())
                                .description(cardDescription.getText())
                                .element(Element.valueOf(cardElement.getText()))
                                .attack(Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")))
                                .defense(Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")))
                                .power(Integer.valueOf(cardPower.getText().replaceAll("\\D+", "")))
                                .build();
                        System.out.println("WAH MASUK");
                        int index = 0;
                        if(curPlayer == 1){
                            index = findCard(selectedCard2, player1.getMidTopDeck());
                            player1.getMidTopDeck().get(index).setAttack(selectedCard2.getAttack() + selectedCard.getAttack());
                            player1.getMidTopDeck().get(index).setDefense(selectedCard2.getDefense() + selectedCard.getDefense());
                        }
                        else{
                            index = findCard(selectedCard2, player2.getMidTopDeck());
                            player2.getMidTopDeck().get(index).setAttack(selectedCard2.getAttack() + selectedCard.getAttack());
                            player2.getMidTopDeck().get(index).setDefense(selectedCard2.getDefense() + selectedCard.getDefense());
                        }
                        isSkill = false;
                    }
                    else{
                        if(set.getChildren().get(finalI).getRotate() > 0){
                            set.getChildren().get(finalI).setRotate(0);
                        }
                        else {
                            set.getChildren().get(finalI).setRotate(90);
                        }
                    }
                }
            });
        }
    }

    /**
     * Set event on mid back
     *
     * @param loader
     * @param curPlayer
     * @param player1
     * @param player2
     */
    private void eventMidBack(FXMLLoader loader, int curPlayer, Player player1, Player player2){
        MidFieldController midController;
        if(curPlayer == 1){
            midController = ((ArenaController)loader.getController()).getMid1();
        }
        else{
            midController = ((ArenaController)loader.getController()).getMid2();
        }
        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox setBot = (HBox) temp.getChildren().get(1);
        for(int i = 0; i < 8; i++){
            int finalI = i;
            setBot.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    BorderPane temp_ = (BorderPane) setBot.getChildren().get(finalI);
                    VBox temp = (VBox) temp_.getCenter();
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
            setBot.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    int index = 0;
                    if(curPlayer == 1){
                        index = findCard(selectedCard, player1.getMidBotDeck());
                        player1.getMidBotDeck().remove(index);
                    }
                    else{
                        index = findCard(selectedCard, player2.getMidBotDeck());
                        player2.getMidBotDeck().remove(index);
                    }
                    try {
                        System.out.println(player1.getMidBotDeck());
                        ((ArenaController)loader.getController()).updateField(player1.getMidTopDeck(), player1.getMidBotDeck(), player2.getMidTopDeck(), player2.getMidBotDeck());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    setMouseClick(loader, curPlayer, player1, player2);
                }
            });
        }
    }

    @Override
    public void setMouseClick(FXMLLoader loader, int curPlayer, Player player1, Player player2) {
        eventDeck(loader, curPlayer, player1, player2);
        eventMidFront(loader, curPlayer, player1, player2);
        eventMidBack(loader, curPlayer, player1, player2);
    }
}
