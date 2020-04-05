package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

import java.util.ArrayList;


public class CardHandController {

    private ArenaController arenaController;

    @FXML private HBox hbox;
    @FXML private LandController card1Controller;
    @FXML private LandController card2Controller;
    @FXML private LandController card3Controller;
    @FXML private LandController card4Controller;
    @FXML private LandController card5Controller;
    @FXML private LandController card6Controller;
    @FXML private LandController card7Controller;
    @FXML private LandController card8Controller;

    public void init(ArenaController arc) {
        this.arenaController = arc;
    }

    public HBox getHbox() {
        return hbox;
    }

    public ArrayList<LandController> getCardList(){
        ArrayList<LandController> cardList = new ArrayList<LandController>();
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
