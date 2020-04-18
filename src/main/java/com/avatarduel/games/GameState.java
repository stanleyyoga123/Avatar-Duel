package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import com.avatarduel.model.type.Effect;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

abstract public class GameState {

    private int findIndexAura(GameFlow main, int player, int index) {
        int ans = 0;
        int counter = 0;
        MidFieldController midController;

        if(player == 1) {
            midController = ((ArenaController)main.getLoader().getController()).getMid1();
        } else {
            midController = ((ArenaController)main.getLoader().getController()).getMid2();
        }

        for(int i = 0; i < midController.getCardBack().size(); i++) {
            if(midController.getCardBack().get(i).getEffect() == Effect.AURA) {
                counter++;
            }
            if(counter == index+1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    private int findIndexPowerUp(GameFlow main, int player, int index) {
        int ans = 0;
        int counter = 0;
        MidFieldController midController;

        if(player == 1) {
            midController = ((ArenaController)main.getLoader().getController()).getMid1();
        } else {
            midController = ((ArenaController)main.getLoader().getController()).getMid2();
        }

        for(int i = 0; i < midController.getCardBack().size(); i++) {
            if(midController.getCardBack().get(i).getEffect() == Effect.POWER_UP) {
                counter++;
            }
            if(counter == index+1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    protected void desSkillP1(GameFlow main, int cardIndex) {
        ArrayList<Integer> myField = new ArrayList<Integer>();
        ArrayList<Integer> enemyField = new ArrayList<Integer>();

        for(int i = 0; i < main.getPairAuraP1().size(); i++) {
            if(main.getPairAuraP1().get(i) == cardIndex) {
                myField.add(findIndexAura(main, 1, i));
            }
        }
        for(int i = 0; i < main.getPairAuraP2().size(); i++) {
            if(main.getPairAuraP2().get(i) == cardIndex-10) {
                enemyField.add(findIndexAura(main, 2, i));
            }
        }

        for(int i = 0; i < main.getPairPowerUpP1().size(); i++) {
            if(main.getPairPowerUpP1().get(i) == cardIndex) {
                myField.add(findIndexPowerUp(main, 1, i));
            }
        }
        for(int i = 0; i < main.getPairPowerUpP2().size(); i++) {
            if(main.getPairPowerUpP2().get(i) == cardIndex-10) {
                enemyField.add(findIndexPowerUp(main, 2, i));
            }
        }
        System.out.println("DEBUG");
        System.out.println(main.getPairAuraP1());
        System.out.println(main.getPairAuraP2());
        System.out.println(main.getPairPowerUpP1());
        System.out.println(main.getPairPowerUpP2());
        System.out.println(myField);
        System.out.println(enemyField);

        main.getPairAuraP1().remove(new Integer(cardIndex));
        main.getPairAuraP2().remove(new Integer(cardIndex + 10));
        main.getPairPowerUpP1().remove(new Integer(cardIndex));
        main.getPairPowerUpP2().remove(new Integer(cardIndex + 10));


        Collections.sort(myField);
        Collections.sort(enemyField);

        for(int i = 0; i < myField.size(); i++) {
            myField.set(i, myField.get(i) - i);
        }
        for(int i = 0; i < enemyField.size(); i++) {
            enemyField.set(i, enemyField.get(i) - i);
        }

        for(int i = 0; i < myField.size(); i++) {
            int index = myField.get(i);
            if(index != -1) {
                main.getPlayer1().getMidDeck().getMidBotDeck().remove(index);
            }
        }
        for(int i = 0; i < enemyField.size(); i++) {
            int index = enemyField.get(i);
            if(index != -1) {
                main.getPlayer2().getMidDeck().getMidBotDeck().remove(index);
            }
        }
    }

    protected void desSkillP2(GameFlow main, int cardIndex) {
        ArrayList<Integer> myField = new ArrayList<Integer>();
        ArrayList<Integer> enemyField = new ArrayList<Integer>();


        for(int i = 0; i < main.getPairAuraP2().size(); i++) {
            if(main.getPairAuraP2().get(i) == cardIndex) {
                myField.add(findIndexAura(main,2,i));
            }
        }
        for(int i = 0; i < main.getPairAuraP1().size(); i++) {
            if(main.getPairAuraP1().get(i) == cardIndex-10) {
                enemyField.add(findIndexAura(main,1,i));
            }
        }

        for(int i = 0; i < main.getPairPowerUpP2().size(); i++) {
            if(main.getPairPowerUpP2().get(i) == cardIndex) {
                myField.add(findIndexPowerUp(main, 2, i));
            }
        }
        for(int i = 0; i < main.getPairPowerUpP1().size(); i++) {
            if(main.getPairPowerUpP1().get(i) == cardIndex-10) {
                enemyField.add(findIndexPowerUp(main, 1, i));
            }
        }

        main.getPairAuraP2().remove(new Integer(cardIndex));
        main.getPairAuraP1().remove(new Integer(cardIndex + 10));
        main.getPairPowerUpP2().remove(new Integer(cardIndex));
        main.getPairPowerUpP1().remove(new Integer(cardIndex + 10));

        System.out.println("DEBUG");
        System.out.println(myField);
        System.out.println(enemyField);

        Collections.sort(myField);
        Collections.sort(enemyField);

        for(int i = 0; i < myField.size(); i++) {
            myField.set(i, myField.get(i) - i);
        }
        for(int i = 0; i < enemyField.size(); i++) {
            enemyField.set(i, enemyField.get(i) - i);
        }

        for(int i = 0; i < myField.size(); i++) {
            int index = myField.get(i);
            if(index != -1) {
                main.getPlayer2().getMidDeck().getMidBotDeck().remove(index);
            }
        }
        for(int i = 0; i < enemyField.size(); i++) {
            int index = enemyField.get(i);
            if(index != -1) {
                main.getPlayer1().getMidDeck().getMidBotDeck().remove(index);
            }
        }
    }

    public void deleteMouseClick(GameFlow main) {
        MidFieldController midController = ((ArenaController)main.getLoader().getController()).getMid1();
        VBox temp = (VBox) midController.getHbox().getChildren().get(0);
        HBox setBot = (HBox) temp.getChildren().get(1);
        HBox set = (HBox) temp.getChildren().get(0);

        MidFieldController midController2 = ((ArenaController)main.getLoader().getController()).getMid2();
        VBox temp2 = (VBox) midController2.getHbox().getChildren().get(0);
        HBox setBot2 = (HBox) temp2.getChildren().get(1);
        HBox set2 = (HBox) temp2.getChildren().get(0);
        for(int i = 0; i < 8; i++) {
            int finalI = i;
            ((ArenaController)main.getLoader().getController()).getDeck1().getHbox().getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) { }
            });
            ((ArenaController)main.getLoader().getController()).getDeck2().getHbox().getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) { }
            });
            ((ArenaController)main.getLoader().getController()).getDeck1().getHbox().getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) { }
            });
            ((ArenaController)main.getLoader().getController()).getDeck2().getHbox().getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) { }
            });
            try {
                setBot.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
            try {
                setBot2.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
            try {
                setBot.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
            try {
                setBot2.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
            try {
                set.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
            try {
                set2.getChildren().get(i).setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
            try {
                set.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
            try {
                set2.getChildren().get(i).setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) { }
                });
            } catch (Exception e) {
                // do nothing
            }
        }
    }

    public abstract void setMouseClick(GameFlow main) throws IOException, URISyntaxException;
}
