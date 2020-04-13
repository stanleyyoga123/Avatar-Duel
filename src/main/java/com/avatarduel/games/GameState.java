package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

abstract public class GameState {

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
