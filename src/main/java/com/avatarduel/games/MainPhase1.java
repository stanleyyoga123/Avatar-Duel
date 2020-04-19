package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.CardHandController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Class to Control Main Phase 1
 */

public class MainPhase1 extends GameState {

    private Card selectedCard;
    private Card selectedCard2;
    private int selectedCardIndex;
    private int selectedCard2Index;
    private boolean isSkill = false;

    /**
     * Method to place card into field
     *
     * @param main Main
     */
    private void placeCard(GameFlow main) {
        int index = 0;
        int power = 0;
        Player player;
        if (main.getCurPlayer() == 1) {
            player = main.getPlayer1();
        } else {
            player = main.getPlayer2();
        }
        if (!isSkill) {
            if (selectedCard.getElement() == Element.WATER) {
                power = player.getRemPower().getRemainingWater();
            } else if (selectedCard.getElement() == Element.FIRE) {
                power = player.getRemPower().getRemainingFire();
            } else if (selectedCard.getElement() == Element.AIR) {
                power = player.getRemPower().getRemainingAir();
            } else if (selectedCard.getElement() == Element.ENERGY) {
                power = player.getRemPower().getRemainingEnergy();
            } else {
                power = player.getRemPower().getRemainingEarth();
            }
            if (power >= selectedCard.getAttribute().getPower()) {
                if (selectedCard.getClass().getSimpleName().equals("Character")) {
                    if (player.getMidDeck().getMidTopDeck().size() < 8) {
                        player.getMidDeck().getMidTopDeck().add(selectedCard);
                        player.getHandDeck().remove(selectedCardIndex);
                        if (selectedCard.getElement() == Element.WATER) {
                            player.getRemPower().setRemainingWater(power - selectedCard.getAttribute().getPower());
                        } else if (selectedCard.getElement() == Element.FIRE) {
                            player.getRemPower().setRemainingFire(power - selectedCard.getAttribute().getPower());
                        } else if (selectedCard.getElement() == Element.AIR) {
                            player.getRemPower().setRemainingAir(power - selectedCard.getAttribute().getPower());
                        } else if (selectedCard.getElement() == Element.ENERGY) {
                            player.getRemPower().setRemainingEnergy(power - selectedCard.getAttribute().getPower());
                        } else {
                            player.getRemPower().setRemainingEarth(power - selectedCard.getAttribute().getPower());
                        }
                    }
                } else if (selectedCard.getClass().getSimpleName().equals("Skill")) {
                    if (player.getMidDeck().getMidBotDeck().size() < 8) {
                        if (player.getMidDeck().getMidTopDeck().size() > 0 || main.getPlayer2().getMidDeck().getMidTopDeck().size() > 0) {
                            player.getMidDeck().getMidBotDeck().add(selectedCard);
                            player.getHandDeck().remove(selectedCardIndex);
                            isSkill = true;
                            if (selectedCard.getElement() == Element.WATER) {
                                player.getRemPower().setRemainingWater(power - selectedCard.getAttribute().getPower());
                            } else if (selectedCard.getElement() == Element.FIRE) {
                                player.getRemPower().setRemainingFire(power - selectedCard.getAttribute().getPower());
                            } else if (selectedCard.getElement() == Element.AIR) {
                                player.getRemPower().setRemainingAir(power - selectedCard.getAttribute().getPower());
                            } else {
                                player.getRemPower().setRemainingEarth(power - selectedCard.getAttribute().getPower());
                            }
                        }
                    }
                } else {
                    if (!player.isPlayedLand()) {
                        player.getHandDeck().remove(selectedCardIndex);
                        player.setPlayedLand(true);
                        if (selectedCard.getElement() == Element.WATER) {
                            player.getRemPower().setRemainingWater(player.getRemPower().getRemainingWater() + 1);
                            player.getPower().setWaterPower(player.getPower().getWaterPower() + 1);
                        } else if (selectedCard.getElement() == Element.FIRE) {
                            player.getRemPower().setRemainingFire(player.getRemPower().getRemainingFire() + 1);
                            player.getPower().setFirePower(player.getPower().getFirePower() + 1);
                        } else if (selectedCard.getElement() == Element.AIR) {
                            player.getRemPower().setRemainingAir(player.getRemPower().getRemainingAir() + 1);
                            player.getPower().setAirPower(player.getPower().getAirPower() + 1);
                        } else if (selectedCard.getElement() == Element.EARTH) {
                            player.getRemPower().setRemainingEarth(player.getRemPower().getRemainingEarth() + 1);
                            player.getPower().setEarthPower(player.getPower().getEarthPower() + 1);
                        } else {
                            player.getRemPower().setRemainingEnergy(player.getRemPower().getRemainingEnergy() + 1);
                            player.getPower().setEnergyPower(player.getPower().getEnergyPower() + 1);
                        }
                    }
                }
                ((ArenaController) main.getLoader().getController()).setPower(main.getCurPlayer(), player);
            }
        }
    }

    /**
     * Event for Deck
     *
     * @param main Main
     */
    private void eventDeck(GameFlow main) {
        CardHandController deckController;
        Player player;
        if (main.getCurPlayer() == 1) {
            player = main.getPlayer1();
        } else {
            player = main.getPlayer2();
        }

        if (main.getCurPlayer() == 1) {
            deckController = ((ArenaController) main.getLoader().getController()).getDeck1();
        } else {
            deckController = ((ArenaController) main.getLoader().getController()).getDeck2();
        }
        for (int i = 0; i < 8; i++) {
            try {
                int finalI = i;
                deckController.getHbox().getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        MouseButton button = event.getButton();
                        if (button == MouseButton.PRIMARY) {
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
                        if (button == MouseButton.PRIMARY) {
//                            // CHEAT
//                            Player player;
//                            Player oppPlayer;
//                            if (main.getCurPlayer() == 1) {
//                                player = main.getPlayer1();
//                                oppPlayer = main.getPlayer2();
//                            } else {
//                                player = main.getPlayer2();
//                                oppPlayer = main.getPlayer1();
//                            }
//                            if (!isSkill) {
//                                if (selectedCard.getClass().getSimpleName().equals("Character")) {
//                                    player.getMidDeck().getMidTopDeck().add(selectedCard);
//                                    player.getHandDeck().remove(selectedCardIndex);
//                                } else if (selectedCard.getClass().getSimpleName().equals("Skill")) {
//                                    if (player.getMidDeck().getMidBotDeck().size() < 8) {
//                                        if (player.getMidDeck().getMidTopDeck().size() > 0 || oppPlayer.getMidDeck().getMidTopDeck().size() > 0) {
//                                            player.getMidDeck().getMidBotDeck().add(selectedCard);
//                                            player.getHandDeck().remove(selectedCardIndex);
//                                            isSkill = true;
//                                        }
//                                    }
//                                } else {
//                                    if (!player.isPlayedLand()) {
//                                        player.getHandDeck().remove(selectedCardIndex);
//                                        player.setPlayedLand(true);
//                                    }
//                                }
//                            }
                            // Yang bukan cheat
                            placeCard(main);
                        }

                        try {
                            if (main.getCurPlayer() == 1) {
                                ((ArenaController) main.getLoader().getController()).getDeck1().updateHand(main.getPlayer1().getHandDeck());
                                ((ArenaController) main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidDeck().getMidTopDeck(), main.getPlayer1().getMidDeck().getMidBotDeck());
                            } else {
                                ((ArenaController) main.getLoader().getController()).getDeck2().updateHand(main.getPlayer2().getHandDeck());
                                ((ArenaController) main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidDeck().getMidTopDeck(), main.getPlayer2().getMidDeck().getMidBotDeck());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        event(main);
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to trigger Skill Effect
     *
     * @param main Main
     */
    private void skillEffect(GameFlow main) {
        Player player;
        Player opponent;
        ArrayList<Integer> aura;
        ArrayList<Integer> powerUp;
        if (main.getCurPlayer() == 1) {
            player = main.getPlayer1();
            opponent = main.getPlayer2();
            aura = main.getPairAuraP1();
            powerUp = main.getPairPowerUpP1();
        } else {
            player = main.getPlayer2();
            opponent = main.getPlayer1();
            aura = main.getPairAuraP2();
            powerUp = main.getPairPowerUpP2();
        }
        if (selectedCard.getEffect() == Effect.AURA) {
            if (selectedCard2Index > 9) {
                opponent.getMidDeck().getMidTopDeck().get(selectedCard2Index - 10).getAttribute().setAttack(selectedCard2.getAttribute().getAttack() + selectedCard.getAttribute().getAttack());
                opponent.getMidDeck().getMidTopDeck().get(selectedCard2Index - 10).getAttribute().setDefense(selectedCard2.getAttribute().getDefense() + selectedCard.getAttribute().getDefense());
            } else {
                player.getMidDeck().getMidTopDeck().get(selectedCard2Index).getAttribute().setAttack(selectedCard2.getAttribute().getAttack() + selectedCard.getAttribute().getAttack());
                player.getMidDeck().getMidTopDeck().get(selectedCard2Index).getAttribute().setDefense(selectedCard2.getAttribute().getDefense() + selectedCard.getAttribute().getDefense());
            }
            aura.add(selectedCard2Index);
        } else if (selectedCard.getEffect() == Effect.DESTROY) {
            if (selectedCard2Index > 9) {
                if (main.getCurPlayer() == 1) {
                    desSkillP1(main, selectedCard2Index);
                } else {
                    desSkillP2(main, selectedCard2Index);
                }
                opponent.getMidDeck().getMidTopDeck().remove(selectedCard2Index - 10);
            } else {
                if (main.getCurPlayer() == 1) {
                    desSkillP1(main, selectedCard2Index);
                } else {
                    desSkillP2(main, selectedCard2Index);
                }
                player.getMidDeck().getMidTopDeck().remove(selectedCard2Index);
            }
            player.getMidDeck().getMidBotDeck().remove(player.getMidDeck().getMidBotDeck().size() - 1);
        } else {
            powerUp.add(selectedCard2Index);
        }
        isSkill = false;
        try {
            ((ArenaController) main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidDeck().getMidTopDeck(), main.getPlayer1().getMidDeck().getMidBotDeck());
            ((ArenaController) main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidDeck().getMidTopDeck(), main.getPlayer2().getMidDeck().getMidBotDeck());
        } catch (Exception e) {
            e.printStackTrace();
        }
        event(main);
    }

    /**
     * Click Event for Front Field
     *
     * @param main Main
     */
    private void eventMidFront(GameFlow main) {
        VBox temp = (VBox) ((ArenaController) main.getLoader().getController()).getMid1().getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);

        VBox temp2 = (VBox) ((ArenaController) main.getLoader().getController()).getMid2().getHbox().getChildren().get(0);
        HBox set2 = (HBox) temp2.getChildren().get(0);

        int size = main.getPlayer1().getMidDeck().getMidTopDeck().size();
        int size2 = main.getPlayer2().getMidDeck().getMidTopDeck().size();

        for (int i = 0; i < size; i++) {
            int finalI = i;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (main.getCurPlayer() == 1) {
                        if (isSkill) {
                            selectedCard2Index = finalI;
                            selectedCard2 = ((ArenaController) main.getLoader().getController()).getMid1().getIndexCardFront(finalI);
                            skillEffect(main);
                        } else {
                            if (set.getChildren().get(finalI).getRotate() > 0) {
                                set.getChildren().get(finalI).setRotate(0);
                            } else {
                                set.getChildren().get(finalI).setRotate(90);
                            }
                        }
                    } else {
                        if (isSkill) {
                            selectedCard2Index = finalI + 10;
                            selectedCard2 = ((ArenaController) main.getLoader().getController()).getMid1().getIndexCardFront(finalI);
                            skillEffect(main);
                        }
                    }
                }
            });
        }
        for (int i = 0; i < size2; i++) {
            int finalI = i;
            set2.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (main.getCurPlayer() == 2) {
                        if (isSkill) {
                            selectedCard2Index = finalI;
                            selectedCard2 = ((ArenaController) main.getLoader().getController()).getMid2().getIndexCardFront(finalI);
                            skillEffect(main);
                        } else {
                            if (set2.getChildren().get(finalI).getRotate() > 0) {
                                set2.getChildren().get(finalI).setRotate(0);
                            } else {
                                set2.getChildren().get(finalI).setRotate(90);
                            }
                        }
                    } else {
                        if (isSkill) {
                            selectedCard2Index = finalI + 10;
                            selectedCard2 = ((ArenaController) main.getLoader().getController()).getMid2().getIndexCardFront(finalI);
                            skillEffect(main);
                        }
                    }
                }
            });
        }
    }

    /**
     * Event for Back Field
     *
     * @param main Main
     */
    private void eventBack(GameFlow main) {
        Player player;
        Player opponent;
        int idx = 0;
        ArrayList<Integer> skill;
        if (main.getCurPlayer() == 1) {
            player = main.getPlayer1();
            opponent = main.getPlayer2();
            if (selectedCard.getEffect() == Effect.AURA) {
                idx = main.getPairAuraP1().get(selectedCardIndex);
                skill = main.getPairAuraP1();
            } else {
                idx = main.getPairPowerUpP1().get(selectedCardIndex);
                skill = main.getPairPowerUpP1();
            }
        } else {
            player = main.getPlayer2();
            opponent = main.getPlayer1();
            if (selectedCard.getEffect() == Effect.AURA) {
                idx = main.getPairAuraP2().get(selectedCardIndex);
                skill = main.getPairAuraP2();
            } else {
                idx = main.getPairPowerUpP2().get(selectedCardIndex);
                skill = main.getPairPowerUpP2();
            }
        }

        if (selectedCard.getEffect() == Effect.AURA) {
            ArrayList<Card> set;
            if (idx > 9) {
                set = opponent.getMidDeck().getMidTopDeck();
                idx -= 10;
            } else {
                set = player.getMidDeck().getMidTopDeck();
            }
            set.get(idx).getAttribute().setAttack(set.get(idx).getAttribute().getAttack() - selectedCard.getAttribute().getAttack());
            set.get(idx).getAttribute().setDefense(set.get(idx).getAttribute().getDefense() - selectedCard.getAttribute().getDefense());
        } else {

        }
        skill.remove(selectedCardIndex);
        player.getMidDeck().getMidBotDeck().remove(selectedCardIndex);


        try {
            ((ArenaController) main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidDeck().getMidTopDeck(), main.getPlayer1().getMidDeck().getMidBotDeck());
            ((ArenaController) main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidDeck().getMidTopDeck(), main.getPlayer2().getMidDeck().getMidBotDeck());
        } catch (Exception e) {
            e.printStackTrace();
        }
        event(main);
    }

    /**
     * Click Event for Back Field
     *
     * @param main Main
     */
    private void eventMidBack(GameFlow main) {
        MidFieldController midController;
        if (main.getCurPlayer() == 1) {
            midController = ((ArenaController) main.getLoader().getController()).getMid1();
        } else {
            midController = ((ArenaController) main.getLoader().getController()).getMid2();
        }
        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox setBot = (HBox) temp.getChildren().get(1);

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            setBot.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCardIndex = finalI;
                    selectedCard = midController.getIndexCardBack(finalI);
                }
            });
            setBot.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    eventBack(main);
                }
            });
        }
    }

    /**
     * Set Event for Main Phase 1
     *
     * @param main Main
     */
    @Override
    public void event(GameFlow main) {
        eventDeck(main);
        eventMidFront(main);
        eventMidBack(main);
    }

    /**
     * Change State from Main Phase 1 into Battle Phase
     *
     * @param main Main
     * @throws IOException        Input Output
     * @throws URISyntaxException URI
     */
    @Override
    public void changeState(GameFlow main) throws IOException, URISyntaxException {
        if (!isSkill) {
            main.getGameState().deleteMouseClick(main);
            ((ArenaController) main.getLoader().getController()).setCurPhase("Battle Phase");
            main.setGameState(new BattlePhase());
            main.getGameState().event(main);
        }
    }
}