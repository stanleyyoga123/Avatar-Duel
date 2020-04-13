package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;

public class BattlePhase extends GameState {

    private Card selectedCard;
    private int selectedCardIndex;
    private Card selectedEnemyCard;
    private int selectedEnemyCardIndex;
    private boolean isEnemyDef;

    private void decIndex(GameFlow main, int index) {
        if(main.getCurPlayer() == 1) {
            for(int i = 0; i < main.getUsedP1().size(); i++) {
                if(main.getUsedP1().get(i) >= index) {
                    main.getUsedP1().set(i, main.getUsedP1().get(i) - 1);
                }
            }
        } else {
            for(int i = 0; i < main.getUsedP2().size(); i++) {
                if(main.getUsedP2().get(i) >= index) {
                    main.getUsedP2().set(i, main.getUsedP2().get(i) - 1);
                }
            }
        }
    }

    private void desSkillP1(GameFlow main, int cardIndex) {
        ArrayList<Integer> indexAura = new ArrayList<Integer>();
        ArrayList<Integer> indexPowerUp = new ArrayList<Integer>();
        for(int i = 0; i < main.getPairAuraP1().size(); i++) {
            if(main.getPairAuraP1().get(i) == cardIndex) {
                indexAura.add(i);
            }
        }
        for(int i = 0; i < main.getPairPowerUpP1().size(); i++) {
            if(main.getPairPowerUpP1().get(i) == cardIndex) {
                indexPowerUp.add(i);
            }
        }

        main.getPairAuraP1().remove(new Integer(cardIndex));
        main.getPairPowerUpP1().remove(new Integer(cardIndex));
        for(int i = 0; i < indexAura.size(); i++) {
            indexPowerUp.add(indexAura.get(i));
        }

        Collections.sort(indexPowerUp);

        for(int i = 0; i < indexPowerUp.size(); i++) {
            indexPowerUp.set(i, indexPowerUp.get(i) - i);
        }

        for(int i = 0; i < indexPowerUp.size(); i++) {
            int index = indexPowerUp.get(i);
            main.getPlayer1().getMidBotDeck().remove(index);
        }
    }

    private void desSkillP2(GameFlow main, int cardIndex) {
        ArrayList<Integer> indexAura = new ArrayList<Integer>();
        ArrayList<Integer> indexPowerUp = new ArrayList<Integer>();
        for(int i = 0; i < main.getPairAuraP2().size(); i++) {
            if(main.getPairAuraP2().get(i) == cardIndex) {
                indexAura.add(i);
            }
        }
        for(int i = 0; i < main.getPairPowerUpP2().size(); i++) {
            if(main.getPairPowerUpP2().get(i) == cardIndex) {
                indexPowerUp.add(i);
            }
        }

        main.getPairAuraP2().remove(new Integer(cardIndex));
        main.getPairPowerUpP2().remove(new Integer(cardIndex));
        for(int i = 0; i < indexAura.size(); i++) {
            indexPowerUp.add(indexAura.get(i));
        }
        Collections.sort(indexPowerUp);

        for(int i = 0; i < indexPowerUp.size(); i++) {
            indexPowerUp.set(i, indexPowerUp.get(i) - i);
        }

        for(int i = 0; i < indexPowerUp.size(); i++) {
            int index = indexPowerUp.get(i);
            main.getPlayer2().getMidBotDeck().remove(index);
        }
    }

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
            size = main.getPlayer1().getMidTopDeck().size();
        } else {
            size = main.getPlayer2().getMidTopDeck().size();
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
            size = main.getPlayer2().getMidTopDeck().size();
        } else {
            size = main.getPlayer1().getMidTopDeck().size();
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

    private int enemyAttUsed() {
        if(isEnemyDef) {
            return selectedEnemyCard.getDefense();
        }
        return selectedEnemyCard.getAttack();
    }

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
            if(enemyPlayer.getMidTopDeck().size() == 0) {
                enemyPlayer.setHealth(enemyPlayer.getHealth() - selectedCard.getAttack());
            } else {
                if(selectedCard.getAttack() >= enemyAttUsed()) {
                    if(selectedCard.getAttack() > enemyAttUsed()) {
                        if(main.getCurPlayer() == 1) {
                            main.getPlayer2().getMidTopDeck().remove(selectedEnemyCardIndex);
                            desSkillP2(main, selectedEnemyCardIndex);
                        } else {
                            main.getPlayer1().getMidTopDeck().remove(selectedEnemyCardIndex);
                            desSkillP1(main, selectedEnemyCardIndex);
                        }
                    } else {
                        if(main.getCurPlayer() == 1) {
                            main.getPlayer1().getMidTopDeck().remove(selectedCardIndex);
                            main.getPlayer2().getMidTopDeck().remove(selectedEnemyCardIndex);
                            desSkillP1(main, selectedCardIndex);
                            desSkillP2(main, selectedEnemyCardIndex);
                        } else {
                            main.getPlayer2().getMidTopDeck().remove(selectedCardIndex);
                            main.getPlayer1().getMidTopDeck().remove(selectedEnemyCardIndex);
                            desSkillP2(main, selectedCardIndex);
                            desSkillP1(main, selectedEnemyCardIndex);
                        }
                    }
                    used.add(selectedCardIndex);
                    decIndex(main, selectedCardIndex);
                    System.out.println("DI SINI YANG DICEK");
                    System.out.println(main.getPlayer1().getMidTopDeck());
                    System.out.println(main.getPlayer1().getMidBotDeck());
                    System.out.println(main.getPlayer2().getMidTopDeck());
                    System.out.println(main.getPlayer2().getMidBotDeck());
                    System.out.println(main.getUsedP1());
                    System.out.println(main.getUsedP2());

                    if(!isEnemyDef) {
                        if(main.getCurPlayer() == 1) {
                            main.getPlayer2().setHealth(main.getPlayer2().getHealth() - (selectedCard.getAttack() - selectedEnemyCard.getAttack()));
                        } else {
                            main.getPlayer1().setHealth(main.getPlayer1().getHealth() - (selectedCard.getAttack() - selectedEnemyCard.getAttack()));
                        }
                    }
                } else {
                    if(main.getCurPlayer() == 1) {
                        main.getPlayer1().setHealth(main.getPlayer1().getHealth() - (selectedCard.getAttack() - enemyAttUsed()));
                    } else {
                        main.getPlayer2().setHealth(main.getPlayer2().getHealth() - (selectedCard.getAttack() - enemyAttUsed()));
                    }
                    if(!isEnemyDef) {
                        if(main.getCurPlayer() == 1) {
                            main.getPlayer1().getMidTopDeck().remove(selectedCardIndex);
                        } else {
                            main.getPlayer2().getMidTopDeck().remove(selectedCardIndex);
                        }
                        used.add(selectedCardIndex);
                        decIndex(main, selectedCardIndex);
                    }
                }
            }
        }
        try {
            ((ArenaController)main.getLoader().getController()).getMid1().updateField(main.getPlayer1().getMidTopDeck(), main.getPlayer1().getMidBotDeck());
            ((ArenaController)main.getLoader().getController()).getMid2().updateField(main.getPlayer2().getMidTopDeck(), main.getPlayer2().getMidBotDeck());
        } catch (Exception e) {
            //
        }
    }

    private void removeBackground(GameFlow main) {
        VBox temp = (VBox) ((ArenaController) main.getLoader().getController()).getMid1().getHbox().getChildren().get(0);
        HBox set = (HBox) temp.getChildren().get(0);
        for(int i = 0; i < main.getPlayer1().getMidTopDeck().size(); i++) {
            set.getChildren().get(i).setStyle("");
        }
        VBox temp2 = (VBox) ((ArenaController) main.getLoader().getController()).getMid2().getHbox().getChildren().get(0);
        HBox set2 = (HBox) temp2.getChildren().get(0);
        for(int i = 0; i < main.getPlayer2().getMidTopDeck().size(); i++) {
            set2.getChildren().get(i).setStyle("");
        }
    }

    private void execution(GameFlow main) {
        Player enemyPlayer;
        if(main.getCurPlayer() == 1) {
            enemyPlayer = main.getPlayer2();
        } else {
            enemyPlayer = main.getPlayer1();
        }
        if(selectedCard != null) {
            if(enemyPlayer.getMidTopDeck().size() == 0) {
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

    @Override
    public void setMouseClick(GameFlow main) {
        setPlayerCard(main);
        setEnemyCard(main);
    }
}
