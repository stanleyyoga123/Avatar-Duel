package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.CardHandController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.*;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MainPhase1 extends GameState{

    private Card selectedCard;
    private Card selectedCard2;
    private int selectedCardIndex;
    private int selectedCard2Index;
    private boolean isSkill = false;

    private void placeCard(GameFlow main) {
        int index = 0;
        int power = 0;
        Player player;
        if(main.getCurPlayer() == 1) {
            player = main.getPlayer1();
        } else {
            player = main.getPlayer2();
        }
        if(!isSkill){
            if(selectedCard.getElement() == Element.WATER){
                power = player.getRemPower().getRemainingWater();
            } else if(selectedCard.getElement() == Element.FIRE) {
                power = player.getRemPower().getRemainingFire();
            } else if(selectedCard.getElement() == Element.AIR) {
                power = player.getRemPower().getRemainingAir();
            } else if(selectedCard.getElement() == Element.ENERGY) {
                power = player.getRemPower().getRemainingEnergy();
            } else {
                power = player.getRemPower().getRemainingEarth();
            }
            if(power >= selectedCard.getAttribute().getPower()){
                if(selectedCard.getClass().getSimpleName().equals("Character")){
                    if(player.getMidDeck().getMidTopDeck().size() < 8){
                        player.getMidDeck().getMidTopDeck().add(selectedCard);
                        player.getHandDeck().remove(selectedCardIndex);
                        if(selectedCard.getElement() == Element.WATER){
                            player.getRemPower().setRemainingWater(power - selectedCard.getAttribute().getPower());
                        } else if(selectedCard.getElement() == Element.FIRE) {
                            player.getRemPower().setRemainingFire(power - selectedCard.getAttribute().getPower());
                        } else if(selectedCard.getElement() == Element.AIR) {
                            player.getRemPower().setRemainingAir(power - selectedCard.getAttribute().getPower());
                        } else if(selectedCard.getElement() == Element.ENERGY){
                            player.getRemPower().setRemainingEnergy(power - selectedCard.getAttribute().getPower());
                        } else {
                            player.getRemPower().setRemainingEarth(power - selectedCard.getAttribute().getPower());
                        }
                    }
                } else if(selectedCard.getClass().getSimpleName().equals("Skill")) {
                    if(player.getMidDeck().getMidBotDeck().size() < 8){
                        if(player.getMidDeck().getMidTopDeck().size() > 0 || main.getPlayer2().getMidDeck().getMidTopDeck().size() > 0){
                            player.getMidDeck().getMidBotDeck().add(selectedCard);
                            player.getHandDeck().remove(selectedCardIndex);
                            isSkill = true;
                            if(selectedCard.getElement() == Element.WATER){
                                player.getRemPower().setRemainingWater(power - selectedCard.getAttribute().getPower());
                            } else if(selectedCard.getElement() == Element.FIRE) {
                                player.getRemPower().setRemainingFire(power - selectedCard.getAttribute().getPower());
                            } else if(selectedCard.getElement() == Element.AIR) {
                                player.getRemPower().setRemainingAir(power - selectedCard.getAttribute().getPower());
                            } else {
                                player.getRemPower().setRemainingEarth(power - selectedCard.getAttribute().getPower());
                            }
                        }
                    }
                }
                else{
                    if(!player.isPlayedLand()){
                        player.getHandDeck().remove(selectedCardIndex);
                        player.setPlayedLand(true);
                        if(selectedCard.getElement() == Element.WATER) {
                            player.getRemPower().setRemainingWater(player.getRemPower().getRemainingWater() + 1);
                            player.getPower().setWaterPower(player.getPower().getWaterPower() + 1);
                        } else if(selectedCard.getElement() == Element.FIRE) {
                            player.getRemPower().setRemainingFire(player.getRemPower().getRemainingFire() + 1);
                            player.getPower().setFirePower(player.getPower().getFirePower() + 1);
                        } else if(selectedCard.getElement() == Element.AIR) {
                            player.getRemPower().setRemainingAir(player.getRemPower().getRemainingAir() + 1);
                            player.getPower().setAirPower(player.getPower().getAirPower() + 1);
                        } else if(selectedCard.getElement() == Element.EARTH){
                            player.getRemPower().setRemainingEarth(player.getRemPower().getRemainingEarth() + 1);
                            player.getPower().setEarthPower(player.getPower().getEarthPower() + 1);
                        } else {
                            player.getRemPower().setRemainingEnergy(player.getRemPower().getRemainingEnergy() + 1);
                            player.getPower().setEnergyPower(player.getPower().getEnergyPower() + 1);
                        }
                    }
                }
                ((ArenaController)main.getLoader().getController()).setPower(main.getCurPlayer(), player);
            }
        }
    }

    private void eventDeck(GameFlow main) {
        CardHandController deckController;
        Player player;
        if(main.getCurPlayer() == 1) {
            player = main.getPlayer1();
        } else {
            player = main.getPlayer2();
        }

        if(main.getCurPlayer() == 1){
            deckController = ((ArenaController)main.getLoader().getController()).getDeck1();
        } else {
            deckController = ((ArenaController)main.getLoader().getController()).getDeck2();
        }
        for(int i = 0; i < 8; i++){
            try{
                int finalI = i;
                deckController.getHbox().getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        MouseButton button = event.getButton();
                        if(button == MouseButton.PRIMARY) {
                            selectedCardIndex = finalI;
                            selectedCard = deckController.getCardHand(finalI);
                        } else {
                            player.getHandDeck().remove(finalI);
                        }
                    }
                });

                deckController.getHbox().getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        int index = 0;
                        int power = 0;
                        MouseButton button = event.getButton();
                        if(button == MouseButton.PRIMARY) {
//                        // CHEAT
//                        Player player;
//                        Player oppPlayer;
//                        if(main.getCurPlayer() == 1) {
//                            player = main.getPlayer1();
//                            oppPlayer = main.getPlayer2();
//                        } else {
//                            player = main.getPlayer2();
//                            oppPlayer = main.getPlayer1();
//                        }
//                        if(!isSkill){
//                            if(selectedCard.getClass().getSimpleName().equals("Character")) {
//                                player.getMidDeck().getMidTopDeck().add(selectedCard);
//                                player.getHandDeck().remove(selectedCardIndex);
//                            } else if(selectedCard.getClass().getSimpleName().equals("Skill")) {
//                                if(player.getMidDeck().getMidBotDeck().size() < 8){
//                                    if(player.getMidDeck().getMidTopDeck().size() > 0 || oppPlayer.getMidDeck().getMidTopDeck().size() > 0){
//                                        player.getMidDeck().getMidBotDeck().add(selectedCard);
//                                        player.getHandDeck().remove(selectedCardIndex);
//                                        isSkill = true;
//                                    }
//                                }
//                            } else {
//                                if(!player.isPlayedLand()){
//                                    player.getHandDeck().remove(selectedCardIndex);
//                                    player.setPlayedLand(true);
//                                }
//                            }
//                        }

                            // Yang bukan cheat
                            placeCard(main);
                        }

                        try {
                            if(main.getCurPlayer() == 1){
                                ((ArenaController)main.getLoader().getController()).getDeck1().updateHand(main.getPlayer1().getHandDeck());
                                ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidDeck().getMidTopDeck(), main.getPlayer1().getMidDeck().getMidBotDeck());
                            } else {
                                ((ArenaController)main.getLoader().getController()).getDeck2().updateHand(main.getPlayer2().getHandDeck());
                                ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidDeck().getMidTopDeck(), main.getPlayer2().getMidDeck().getMidBotDeck());
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

    private void skillEffect(GameFlow main) {
        if(selectedCard.getEffect() == Effect.AURA) {
            if(main.getCurPlayer() == 1){
                main.getPlayer1().getMidDeck().getMidTopDeck().get(selectedCard2Index).getAttribute().setAttack(selectedCard2.getAttribute().getAttack() + selectedCard.getAttribute().getAttack());
                main.getPlayer1().getMidDeck().getMidTopDeck().get(selectedCard2Index).getAttribute().setDefense(selectedCard2.getAttribute().getDefense() + selectedCard.getAttribute().getDefense());
                main.getPairAuraP1().add(selectedCard2Index);
            } else {
                main.getPlayer2().getMidDeck().getMidTopDeck().get(selectedCard2Index).getAttribute().setAttack(selectedCard2.getAttribute().getAttack() + selectedCard.getAttribute().getAttack());
                main.getPlayer2().getMidDeck().getMidTopDeck().get(selectedCard2Index).getAttribute().setDefense(selectedCard2.getAttribute().getDefense() + selectedCard.getAttribute().getDefense());
                main.getPairAuraP2().add(selectedCard2Index);
            }
        } else if (selectedCard.getEffect() == Effect.POWER_UP) {
            // TO DO Power Up
        } else {
            // TO DO Destroy
        }
        isSkill = false;
        try {
            ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidDeck().getMidTopDeck(), main.getPlayer1().getMidDeck().getMidBotDeck());
            ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidDeck().getMidTopDeck(), main.getPlayer2().getMidDeck().getMidBotDeck());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setMouseClick(main);
    }

    private void eventMidFront(GameFlow main){
        MidFieldController midController;
        if(main.getCurPlayer() == 1){
            midController = ((ArenaController)main.getLoader().getController()).getMid1();
        } else {
            midController = ((ArenaController)main.getLoader().getController()).getMid2();
        }

        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        int size = 0;

        if(main.getCurPlayer() == 1){
            size = main.getPlayer1().getMidDeck().getMidTopDeck().size();
        } else {
            size = main.getPlayer2().getMidDeck().getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++){
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(isSkill){
                        selectedCard2Index = finalI;
                        selectedCard2 = midController.getIndexCardFront(finalI);
                        skillEffect(main);
                    } else {
                        if(set.getChildren().get(finalI).getRotate() > 0){
                            set.getChildren().get(finalI).setRotate(0);
                        } else {
                            set.getChildren().get(finalI).setRotate(90);
                        }
                    }
                }
            });
        }
    }

    private void eventBack(GameFlow main) {
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

            set = player.getMidDeck().getMidTopDeck();
            set.get(idx).getAttribute().setAttack(player.getMidDeck().getMidTopDeck().get(idx).getAttribute().getAttack() - selectedCard.getAttribute().getAttack());
            set.get(idx).getAttribute().setDefense(player.getMidDeck().getMidTopDeck().get(idx).getAttribute().getDefense() - selectedCard.getAttribute().getDefense());
        } else {

        }
        System.out.println("DEBUG");
        System.out.println(main.getPairAuraP2());
        skill.remove(selectedCardIndex);
        System.out.println(skill);
        player.getMidDeck().getMidBotDeck().remove(selectedCardIndex);

        try {
            ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidDeck().getMidTopDeck(), main.getPlayer1().getMidDeck().getMidBotDeck());
            ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidDeck().getMidTopDeck(), main.getPlayer2().getMidDeck().getMidBotDeck());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setMouseClick(main);
    }

    private void eventMidBack(GameFlow main) {
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
                    selectedCardIndex = finalI;
                    selectedCard = midController2.getIndexCardBack(finalI);
                }
            });
            setBot.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    eventBack(main);
                }
            });
            setBot2.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) { eventBack(main); }
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
