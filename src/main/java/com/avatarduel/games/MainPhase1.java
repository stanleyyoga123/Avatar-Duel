package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.CardHandController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.ArrayList;

public class MainPhase1 extends GameState{

    private Card selectedCard;
    private Card selectedCard2;
    private boolean isSkill = false;

    private void placeCard(int curPlayer, Player player1, Player player2) {
        int index = 0;
        int power = 0;
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
    }

    private void addPairAuraSkill(ArrayList<Pair<Card, Card>> pairAura) { pairAura.add(new Pair(selectedCard, selectedCard2)); }

    private void eventDeck(GameFlow main) {
        CardHandController deckController;
        if(main.getCurPlayer() == 1){
            deckController = ((ArenaController)main.getLoader().getController()).getDeck1();
        }
        else{
            deckController = ((ArenaController)main.getLoader().getController()).getDeck2();
        }
        for(int i = 0; i < 8; i++){
            try{
                int finalI = i;
                deckController.getHbox().getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        selectedCard = deckController.getCardHand(finalI);
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
                                main.getPlayer1().getMidTopDeck().add(selectedCard);
                                index = findCard(selectedCard, main.getPlayer1().getHandDeck());
                                main.getPlayer1().getHandDeck().remove(index);
                            }
                            else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                                if(main.getPlayer1().getMidBotDeck().size() < 8){
                                    if(main.getPlayer1().getMidTopDeck().size() > 0 || main.getPlayer2().getMidTopDeck().size() > 0){
                                        main.getPlayer1().getMidBotDeck().add(selectedCard);
                                        index = findCard(selectedCard, main.getPlayer1().getHandDeck());
                                        main.getPlayer1().getHandDeck().remove(index);
                                        isSkill = true;
                                    }
                                }
                            }
                            else{
                                if(main.getPlayer1().isPlayedLand()){ }
                                else{
                                    index = findCard(selectedCard, main.getPlayer1().getHandDeck());
                                    main.getPlayer1().getHandDeck().remove(index);
                                    main.getPlayer1().setIsPlayedLand(true);
                                }
                            }
                        }

                        placeCard(main.getCurPlayer(), main.getPlayer1(), main.getPlayer2());

                        try {
                            if(main.getCurPlayer() == 1){
                                ((ArenaController)main.getLoader().getController()).getDeck1().updateHand(main.getPlayer1().getHandDeck());
                                ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidTopDeck(), main.getPlayer1().getMidBotDeck());
                            }
                            else{
                                ((ArenaController)main.getLoader().getController()).getDeck2().updateHand(main.getPlayer2().getHandDeck());
                                ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidTopDeck(), main.getPlayer2().getMidBotDeck());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        setMouseClick(main);
                    }
                });

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void eventMidFront(GameFlow main){
        // Mouse Click on Current Player Mid Front Field
        MidFieldController midController;
        if(main.getCurPlayer() == 1){
            midController = ((ArenaController)main.getLoader().getController()).getMid1();
        }
        else{
            midController = ((ArenaController)main.getLoader().getController()).getMid2();
        }

        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        int size = 0;

        if(main.getCurPlayer() == 1){
            size = main.getPlayer1().getMidTopDeck().size();
        }
        else{
            size = main.getPlayer2().getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++){
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(isSkill){
                        selectedCard2 = midController.getIndexCardFront(finalI);
                        int index = 0;
                        if(main.getCurPlayer() == 1){
                            index = findCard(selectedCard2, main.getPlayer1().getMidTopDeck());
                            main.getPlayer1().getMidTopDeck().get(index).setAttack(selectedCard2.getAttack() + selectedCard.getAttack());
                            main.getPlayer1().getMidTopDeck().get(index).setDefense(selectedCard2.getDefense() + selectedCard.getDefense());
                        }
                        else{
                            index = findCard(selectedCard2, main.getPlayer2().getMidTopDeck());
                            main.getPlayer2().getMidTopDeck().get(index).setAttack(selectedCard2.getAttack() + selectedCard.getAttack());
                            main.getPlayer2().getMidTopDeck().get(index).setDefense(selectedCard2.getDefense() + selectedCard.getDefense());
                        }
                        addPairAuraSkill(main.getPairAura());
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

    private void eventMidBack(GameFlow main){
        MidFieldController midController;
        if(main.getCurPlayer() == 1){
            midController = ((ArenaController)main.getLoader().getController()).getMid1();
        }
        else{
            midController = ((ArenaController)main.getLoader().getController()).getMid2();
        }
        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox setBot = (HBox) temp.getChildren().get(1);
        for(int i = 0; i < 6; i++){
            int finalI = i;
            setBot.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCard = midController.getIndexCardBack(finalI);
                }
            });
            setBot.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    int index = 0;
                    if(main.getCurPlayer() == 1){
                        index = findCard(selectedCard, main.getPlayer1().getMidBotDeck());
                        main.getPlayer1().getMidBotDeck().remove(index);
                    }
                    else{
                        index = findCard(selectedCard, main.getPlayer2().getMidBotDeck());
                        main.getPlayer2().getMidBotDeck().remove(index);
                    }
                    try {
                        ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidTopDeck(), main.getPlayer1().getMidBotDeck());
                        ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidTopDeck(), main.getPlayer2().getMidBotDeck());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    setMouseClick(main);
                }
            });
        }
    }

    @Override
    public void setMouseClick(GameFlow main) {
        eventDeck(main);
        eventMidFront(main);
        eventMidBack(main);
    }
}
