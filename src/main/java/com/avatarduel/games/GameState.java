package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

abstract public class GameState {
    FXMLLoader loader;
    Scene scene;
    Parent root;

    public void run() {
        try{
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/Arena.fxml"));
            System.out.println(loader.getLocation());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

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

    public abstract void start(int curPlayer, Player player1, Player player2) throws IOException, URISyntaxException;
    public abstract void end();
    public abstract void setMouseClick(FXMLLoader loader, int curPlayer, Player player1, Player player2);
}
