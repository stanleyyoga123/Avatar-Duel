package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BattlePhase extends GameState {

    private Card selectedCard;
    private int selectedCardIndex;
    private Card selectedEnemyCard;
    private int selectedEnemyCardIndex;
    private boolean isEnemyDef;

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
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCardIndex = finalI;
                    selectedCard = midFieldController.getIndexCardFront(finalI);
                    execution(main);
                    System.out.println("ENEMY HEALTH = " + main.getPlayer2().getHealth());
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
            set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedEnemyCard = midFieldController.getIndexCardFront(finalI);
                    selectedEnemyCardIndex = finalI;
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
        if(main.getCurPlayer() == 1) {
            enemyPlayer = main.getPlayer2();
        } else {
            enemyPlayer = main.getPlayer1();
        }

        if(enemyPlayer.getMidTopDeck().size() == 0) {
            enemyPlayer.setHealth(enemyPlayer.getHealth() - selectedCard.getAttack());
        } else {
            if(selectedCard.getAttack() >= enemyAttUsed()) {
                if(main.getCurPlayer() == 1) {
                    main.getPlayer2().getMidTopDeck().remove(selectedEnemyCardIndex);
                } else {
                    main.getPlayer1().getMidTopDeck().remove(selectedEnemyCardIndex);
                }
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
                }
            }
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
            } else {
                if(selectedEnemyCard != null) {
                    battlePhase(main);
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
