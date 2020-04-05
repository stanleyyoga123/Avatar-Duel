package com.avatarduel.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MidFieldController {

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
    @FXML private LandController card9Controller;
    @FXML private LandController card10Controller;
    @FXML private LandController card11Controller;
    @FXML private LandController card12Controller;
    @FXML private LandController card13Controller;
    @FXML private LandController card14Controller;
    @FXML private LandController card15Controller;
    @FXML private LandController card16Controller;
    @FXML private VBox leftBoxController;
    @FXML private VBox rightBoxController;
    @FXML private Text text1Controller;
    @FXML private Text text2Controller;
    @FXML private Text text3Controller;
    @FXML private Text text4Controller;
    @FXML private CloseCardController deckCardController;

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
        cardList.add(card9Controller);
        cardList.add(card10Controller);
        cardList.add(card11Controller);
        cardList.add(card12Controller);
        cardList.add(card13Controller);
        cardList.add(card14Controller);
        cardList.add(card15Controller);
        cardList.add(card16Controller);

        return cardList;
    }

    public VBox getLeftBoxController() {
        return leftBoxController;
    }

    public VBox getRightBoxController() {
        return rightBoxController;
    }

    public Text getText1Controller() {
        return text1Controller;
    }

    public Text getText2Controller() {
        return text2Controller;
    }

    public Text getText3Controller() {
        return this.text3Controller;
    }

    public Text getText4Controller() {
        return this.text4Controller;
    }

    public CloseCardController getDeckCardController() {
        return this.deckCardController;
    }

}

