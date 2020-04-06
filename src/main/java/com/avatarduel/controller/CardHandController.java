package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

import java.util.ArrayList;


public class CardHandController {

    private ArenaController arenaController;

    @FXML private HBox hbox;
    @FXML private Card card1Controller;
    @FXML private Card card2Controller;
    @FXML private Card card3Controller;
    @FXML private Card card4Controller;
    @FXML private Card card5Controller;
    @FXML private Card card6Controller;
    @FXML private Card card7Controller;
    @FXML private Card card8Controller;

    public void init(ArenaController arc) {
        this.arenaController = arc;
    }

    public HBox getHbox() {
        return hbox;
    }

    public ArrayList<Card> getCardList(){
        ArrayList<Card> cardList = new ArrayList<Card>();
        cardList.add(card1Controller);
        cardList.add(card2Controller);
        cardList.add(card3Controller);
        cardList.add(card4Controller);
        cardList.add(card5Controller);
        cardList.add(card6Controller);
        cardList.add(card7Controller);
        cardList.add(card8Controller);
        return cardList;
    }
}
