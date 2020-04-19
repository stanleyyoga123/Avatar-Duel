package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Class to Control Battle Phase
 */

public class BattlePhase extends GameState {

    private Card selectedCard;
    private int selectedCardIndex;
    private Card selectedEnemyCard;
    private int selectedEnemyCardIndex;
    private boolean isEnemyDef;

    /**
     * Set mouse event on Player Card
     * @param main Main
     */
    private void setPlayerCard(GameFlow main) {
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
            size = main.getPlayer1().getMidDeck().getMidTopDeck().size();
        } else {
            size = main.getPlayer2().getMidDeck().getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++) {
            int finalI = i;
            int finalSize = size;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(set.getChildren().get(finalI).getRotate() < 90) {
                        for(int j = 0; j < finalSize; j++) {
                            set.getChildren().get(j).setStyle("");
                        }
                        selectedCardIndex = finalI;
                        selectedCard = midFieldController.getIndexCardFront(finalI);
                        execution(main);
                        set.getChildren().get(finalI).setStyle("-fx-background-color:#dae7f3");
                    }
                }
            });
        }
    }

    /**
     * Set mouse event on Enemy Card
     * @param main Main
     */
    private void setEnemyCard(GameFlow main) {
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
            size = main.getPlayer2().getMidDeck().getMidTopDeck().size();
        } else {
            size = main.getPlayer1().getMidDeck().getMidTopDeck().size();
        }

        for(int i = 0; i < size; i++) {
            int finalI = i;
            int finalSize = size;
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    for(int j = 0; j < finalSize; j++) {
                        set.getChildren().get(j).setStyle("");
                    }
                    selectedEnemyCard = midFieldController.getIndexCardFront(finalI);
                    selectedEnemyCardIndex = finalI;
                    set.getChildren().get(finalI).setStyle("-fx-background-color:#dae7f3");
                    if(set.getChildren().get(finalI).getRotate() != 0) {
                        isEnemyDef = true;
                    } else {
                        isEnemyDef = false;
                    }
                    execution(main);
                }
            });
        }
    }

    /**
     * Get Enemy Attribute Used when Attacked
     * @return Index
     */
    private int enemyAttUsed() {
        if(isEnemyDef) {
            return selectedEnemyCard.getAttribute().getDefense();
        }
        return selectedEnemyCard.getAttribute().getAttack();
    }

    /**
     * Event in the Battle Phase
     * @param main Main
     */
    private void battlePhase(GameFlow main) {
        Player enemyPlayer;
        ArrayList<Integer> used;
        if(main.getCurPlayer() == 1) {
            enemyPlayer = main.getPlayer2();
            used = main.getUsedP1();
        } else {
            enemyPlayer = main.getPlayer1();
            used = main.getUsedP2();
        }

        if(!used.contains(selectedCardIndex)){
            if(enemyPlayer.getMidDeck().getMidTopDeck().size() == 0) {
                enemyPlayer.setHealth(enemyPlayer.getHealth() - selectedCard.getAttribute().getAttack());
                used.add(selectedCardIndex);
            } else {
                if(selectedCard.getAttribute().getAttack() > enemyAttUsed()) {
                    if(main.getCurPlayer() == 1) {
                        main.getPlayer2().getMidDeck().getMidTopDeck().remove(selectedEnemyCardIndex);
                        desSkillP1(main, selectedEnemyCardIndex+10);
                    } else {
                        main.getPlayer1().getMidDeck().getMidTopDeck().remove(selectedEnemyCardIndex);
                        desSkillP2(main, selectedEnemyCardIndex+10);
                    }

                    ArrayList<Integer> powerUp;
                    if(main.getCurPlayer() == 1) {
                        powerUp = main.getPairPowerUpP1();
                    } else {
                        powerUp = main.getPairPowerUpP2();
                    }

                    if(!isEnemyDef) {
                        if(main.getCurPlayer() == 1) {
                            main.getPlayer2().setHealth(main.getPlayer2().getHealth() - (selectedCard.getAttribute().getAttack() - selectedEnemyCard.getAttribute().getAttack()));
                        } else {
                            main.getPlayer1().setHealth(main.getPlayer1().getHealth() - (selectedCard.getAttribute().getAttack() - selectedEnemyCard.getAttribute().getAttack()));
                        }
                    } else {
                        if(powerUp.contains(new Integer(selectedCardIndex))) {
                            if(main.getCurPlayer() == 1) {
                                main.getPlayer2().setHealth(main.getPlayer2().getHealth() - (selectedCard.getAttribute().getAttack() - selectedEnemyCard.getAttribute().getAttack()));
                            } else {
                                main.getPlayer1().setHealth(main.getPlayer1().getHealth() - (selectedCard.getAttribute().getAttack() - selectedEnemyCard.getAttribute().getAttack()));
                            }
                        }
                    }
                    used.add(selectedCardIndex);
                }
            }
            System.out.println("LIST OF USED");
            System.out.println(used);
        }
        ((ArenaController) main.getLoader().getController()).setP1Health(main.getPlayer1().getHealth());
        ((ArenaController) main.getLoader().getController()).setP2Health(main.getPlayer2().getHealth());
        try {
            ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidDeck().getMidTopDeck(), main.getPlayer1().getMidDeck().getMidBotDeck());
            ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidDeck().getMidTopDeck(), main.getPlayer2().getMidDeck().getMidBotDeck());
        } catch (Exception e) {
            //
        }
    }

    /**
     * Delete Background Card
     * @param main Main
     */
    private void removeBackground(GameFlow main) {
        VBox temp = (VBox) ((ArenaController) main.getLoader().getController()).getMid1().getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        for(int i = 0; i < main.getPlayer1().getMidDeck().getMidTopDeck().size(); i++) {
            set.getChildren().get(i).setStyle("");
        }
        VBox temp2 = (VBox) ((ArenaController) main.getLoader().getController()).getMid2().getHbox().getChildren().get(0);
        HBox set2 = (HBox) temp2.getChildren().get(0);
        for(int i = 0; i < main.getPlayer2().getMidDeck().getMidTopDeck().size(); i++) {
            set2.getChildren().get(i).setStyle("");
        }
    }

    /**
     * Controller when battle phase
     * @param main Main
     */
    private void execution(GameFlow main) {
        Player enemyPlayer;
        if(main.getCurPlayer() == 1) {
            enemyPlayer = main.getPlayer2();
        } else {
            enemyPlayer = main.getPlayer1();
        }
        if(selectedCard != null) {
            if(enemyPlayer.getMidDeck().getMidTopDeck().size() == 0) {
                battlePhase(main);
                removeBackground(main);
                selectedCard = null;
            } else {
                if(selectedEnemyCard != null) {
                    battlePhase(main);
                    removeBackground(main);
                    selectedCard = null;
                    selectedEnemyCard = null;
                }
            }
        }
    }

    /**
     * Set Event for battle Phase
     * @param main Main
     */
    @Override
    public void event(GameFlow main) {
        setPlayerCard(main);
        setEnemyCard(main);
    }

    /**
     * Change State from Battle Phase into End Phase
     * @param main Main
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    @Override
    public void changeState(GameFlow main) throws IOException, URISyntaxException {
        main.getGameState().deleteMouseClick(main);
        ((ArenaController)main.getLoader().getController()).setCurPhase("End Phase ");
        main.setGameState(new EndPhase());
        main.getGameState().event(main);
    }
}
