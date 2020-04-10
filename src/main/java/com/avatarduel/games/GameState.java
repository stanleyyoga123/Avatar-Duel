package com.avatarduel.games;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.controller.MidFieldController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import com.avatarduel.model.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import java.util.ArrayList;

abstract public class GameState {

    public int findCard(Card card, ArrayList<Card> deck1) {
        System.out.println(deck1.size());
        for(int i = 0; i < deck1.size(); i++){
            System.out.print(card.getName());
            System.out.println(" " + deck1.get(i).getName());
            if(card.getName().equals(deck1.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    public abstract void setMouseClick(GameFlow main);
}
