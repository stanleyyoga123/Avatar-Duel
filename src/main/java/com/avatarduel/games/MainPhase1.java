package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.CardHandController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;

public class MainPhase1 extends GameState{

    private Card selectedCard;
    private Card selectedCard2;
    private int selectedCardIndex;
    private int selectedCard2Index;
    private boolean isSkill = false;

    private void placeCard(GameFlow main) {
        int index = 0;
        int power = 0;
        if(main.getCurPlayer() == 1){
            if(!main.getPlayer1().isPlayedLand()){
                if(!isSkill){
                    if(selectedCard.getElement() == Element.WATER){
                        power = main.getPlayer1().getRemainingWater();
                    }
                    else if(selectedCard.getElement() == Element.FIRE){
                        power = main.getPlayer1().getRemainingFire();
                    }
                    else if(selectedCard.getElement() == Element.AIR){
                        power = main.getPlayer1().getRemainingAir();
                    }
                    else{
                        power = main.getPlayer1().getRemainingEarth();
                    }
                    if(power >= selectedCard.getPower()){
                        if(selectedCard.getClass().getSimpleName().equals("Character")){
                            if(main.getPlayer1().getMidTopDeck().size() < 8){
                                main.getPlayer1().getMidTopDeck().add(selectedCard);
                                main.getPlayer1().getHandDeck().remove(selectedCardIndex);
                            }
                        }
                        else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                            if(main.getPlayer1().getMidBotDeck().size() < 8){
                                if(main.getPlayer1().getMidTopDeck().size() > 0 || main.getPlayer2().getMidTopDeck().size() > 0){
                                    main.getPlayer1().getMidBotDeck().add(selectedCard);
                                    main.getPlayer1().getHandDeck().remove(selectedCardIndex);
                                    isSkill = true;
                                }
                            }
                        }
                        else{
                            if(main.getPlayer1().isPlayedLand()){ }
                            else{
                                main.getPlayer1().getHandDeck().remove(selectedCardIndex);
                                main.getPlayer1().setIsPlayedLand(true);
                            }
                        }
                    }
                }
            }
        }
        else{
            if(!main.getPlayer2().isPlayedLand()){
                if(selectedCard.getElement() == Element.WATER){
                    power = main.getPlayer2().getRemainingWater();
                }
                else if(selectedCard.getElement() == Element.FIRE){
                    power = main.getPlayer2().getRemainingFire();
                }
                else if(selectedCard.getElement() == Element.AIR){
                    power = main.getPlayer2().getRemainingAir();
                }
                else{
                    power = main.getPlayer2().getRemainingEarth();
                }
                if(power >= selectedCard.getPower()){
                    if(selectedCard.getClass().getSimpleName().equals("Character")){
                        main.getPlayer2().getMidTopDeck().add(selectedCard);
                        main.getPlayer2().getHandDeck().remove(selectedCardIndex);
                    }
                    else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                        if(main.getPlayer2().getMidBotDeck().size() < 8){
                            if(main.getPlayer1().getMidTopDeck().size() > 0 || main.getPlayer2().getMidTopDeck().size() > 0){
                                main.getPlayer2().getMidBotDeck().add(selectedCard);
                                main.getPlayer2().getHandDeck().remove(selectedCardIndex);
                                isSkill = true;
                            }
                        }
                    }
                    else{
                        if(main.getPlayer2().isPlayedLand()){ }
                        else{
                            main.getPlayer2().getHandDeck().remove(selectedCardIndex);
                            main.getPlayer2().setIsPlayedLand(true);
                        }
                    }
                }
            }
        }
    }

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
                        selectedCardIndex = finalI;
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
                                main.getPlayer1().getHandDeck().remove(selectedCardIndex);
                            }
                            else if(selectedCard.getClass().getSimpleName().equals("Skill")){
                                if(main.getPlayer1().getMidBotDeck().size() < 8){
                                    if(main.getPlayer1().getMidTopDeck().size() > 0 || main.getPlayer2().getMidTopDeck().size() > 0){
                                        main.getPlayer1().getMidBotDeck().add(selectedCard);
                                        main.getPlayer1().getHandDeck().remove(selectedCardIndex);
                                        isSkill = true;
                                    }
                                }
                            }
                            else{
                                if(main.getPlayer1().isPlayedLand()){ }
                                else{
                                    main.getPlayer1().getHandDeck().remove(selectedCardIndex);
                                    main.getPlayer1().setIsPlayedLand(true);
                                }
                            }
                        }

////                         Yang bukan cheat
//                        placeCard(main);

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
                        selectedCard2Index = finalI;
                        selectedCard2 = midController.getIndexCardFront(finalI);
                        if(selectedCard.getEffect() == Effect.AURA) {
                            if(main.getCurPlayer() == 1){
                                main.getPlayer1().getMidTopDeck().get(selectedCard2Index).setAttack(selectedCard2.getAttack() + selectedCard.getAttack());
                                main.getPlayer1().getMidTopDeck().get(selectedCard2Index).setDefense(selectedCard2.getDefense() + selectedCard.getDefense());
                                main.getPairAuraP1().add(selectedCard2Index);
                            }
                            else{
                                main.getPlayer2().getMidTopDeck().get(selectedCard2Index).setAttack(selectedCard2.getAttack() + selectedCard.getAttack());
                                main.getPlayer2().getMidTopDeck().get(selectedCard2Index).setDefense(selectedCard2.getDefense() + selectedCard.getDefense());
                                main.getPairAuraP2().add(selectedCard2Index);
                            }
                        } else if (selectedCard.getEffect() == Effect.POWER_UP) {
                            // TO DO Power Up
                        } else {
                            // TO DO Destroy
                        }
                        isSkill = false;
                        try {
                            ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidTopDeck(), main.getPlayer1().getMidBotDeck());
                            ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidTopDeck(), main.getPlayer2().getMidBotDeck());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        setMouseClick(main);
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
        MidFieldController midController = ((ArenaController)main.getLoader().getController()).getMid1();
        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox setBot = (HBox) temp.getChildren().get(1);

        MidFieldController midController2 = ((ArenaController)main.getLoader().getController()).getMid2();
        VBox temp2 = (VBox) midController2.getHbox().getChildren().get(0);
        HBox setBot2 = (HBox) temp2.getChildren().get(1);
        for(int i = 0; i < 6; i++){
            int finalI = i;
            setBot.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCardIndex = finalI;
                    selectedCard = midController.getIndexCardBack(finalI);
                }
            });
            setBot2.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCardIndex = finalI + 10;
                    selectedCard = midController2.getIndexCardBack(finalI);
                }
            });
            setBot.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Player player;
                    int idx = 0;
                    ArrayList<Integer> skill;
                    if(main.getCurPlayer() == 1) {
                        player = main.getPlayer1();
                        if(selectedCard.getEffect() == Effect.AURA) {
                            idx = main.getPairAuraP1().get(selectedCardIndex);
                            skill = main.getPairAuraP1();
                        } else {
                            idx = main.getPairPowerUpP1().get(selectedCardIndex);
                            skill = main.getPairPowerUpP1();
                        }
                    } else {
                        player = main.getPlayer2();
                        if(selectedCard.getEffect() == Effect.AURA) {
                            idx = main.getPairAuraP2().get(selectedCardIndex);
                            skill = main.getPairAuraP2();
                        } else {
                            idx = main.getPairPowerUpP2().get(selectedCardIndex);
                            skill = main.getPairPowerUpP2();
                        }
                    }

                    if(selectedCard.getEffect() == Effect.AURA) {
                        ArrayList<Card> set;
                        if(idx > 10) {
                            if(main.getCurPlayer() == 1) {
                                set = main.getPlayer2().getMidTopDeck();
                            } else {
                                set = main.getPlayer1().getMidTopDeck();
                            }
                            idx -= 10;
                        } else {
                            set = player.getMidTopDeck();
                        }
                        set.get(idx).setAttack(player.getMidTopDeck().get(idx).getAttack() - selectedCard.getAttack());
                        set.get(idx).setDefense(player.getMidTopDeck().get(idx).getDefense() - selectedCard.getDefense());
                    }
                    skill.remove(selectedCardIndex);
                    System.out.println(skill);
                    player.getMidBotDeck().remove(selectedCardIndex);

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
