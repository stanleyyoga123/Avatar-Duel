package com.avatarduel.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ArenaController {

    @FXML HBox parentController;
    @FXML VBox leftBoxController;
    @FXML LandController cardLeftController;
    @FXML Pane descriptionTextController;
    @FXML VBox rightBoxController;
    @FXML CardHandController deck1Controller;
    @FXML CardHandController deck2Controller;
    @FXML MidFieldController mid1Controller;
    @FXML MidFieldController mid2Controller;

    public void init() {
        ArrayList<LandController> cardList = deck1Controller.getCardList();

        for(LandController card : cardList) {
            card.init(this);
            double scale = deck1Controller.getHbox().getHeight()/card.getHeight();
            double imageHeight = card.getCardImage().getFitHeight() * scale - 2;
            double imageWidth = card.getCardImage().getFitWidth() * scale - 2;
            card.getCardTop().setMinHeight(20);
            VBox.setMargin(card.getCardTop(), new Insets(2,2,2,2));
            VBox.setMargin(card.getCardBody(), new Insets(2,2,2,2));
            VBox.setMargin(card.getCardBottom(), new Insets(2,2,2,2));
            card.getCardImage().setFitHeight(imageHeight);
            card.getCardImage().setFitWidth(imageWidth);
        }

        cardList = deck2Controller.getCardList();
        for(LandController card : cardList) {
            card.init(this);
            double scale = deck2Controller.getHbox().getHeight()/card.getHeight();
            double imageHeight = card.getCardImage().getFitHeight() * scale - 2;
            double imageWidth = card.getCardImage().getFitWidth() * scale - 2;
            card.getCardTop().setMinHeight(20);
            VBox.setMargin(card.getCardTop(), new Insets(2,2,2,2));
            VBox.setMargin(card.getCardBody(), new Insets(2,2,2,2));
            VBox.setMargin(card.getCardBottom(), new Insets(2,2,2,2));
            card.getCardImage().setFitHeight(imageHeight);
            card.getCardImage().setFitWidth(imageWidth);
        }

        cardList = mid1Controller.getCardList();
        for(LandController card : cardList) {
            card.init(this);
            double scale = mid1Controller.getHbox().getHeight()/card.getHeight()/2;
            double imageHeight = card.getCardImage().getFitHeight() * scale - 6;
            double imageWidth = card.getCardImage().getFitWidth() * scale - 6;
            card.getCardTop().setMinHeight(20);
            VBox.setMargin(card.getCardTop(), new Insets(1,1,1,1));
            VBox.setMargin(card.getCardBody(), new Insets(1,1,1,1));
            VBox.setMargin(card.getCardBottom(), new Insets(1,1,1,1));
            card.getCardImage().setFitHeight(imageHeight);
            card.getCardImage().setFitWidth(imageWidth);
        }
        mid1Controller.getDeckCardController().getRect().setHeight(100);
        mid1Controller.getDeckCardController().getRect().setWidth(75);

        cardList = mid2Controller.getCardList();
        for(LandController card : cardList) {
            card.init(this);
            double scale = mid2Controller.getHbox().getHeight()/card.getHeight()/2;
            double imageHeight = card.getCardImage().getFitHeight() * scale - 6;
            double imageWidth = card.getCardImage().getFitWidth() * scale - 6;
            card.getCardTop().setMinHeight(20);
            VBox.setMargin(card.getCardTop(), new Insets(1,1,1,1));
            VBox.setMargin(card.getCardBody(), new Insets(1,1,1,1));
            VBox.setMargin(card.getCardBottom(), new Insets(1,1,1,1));
            card.getCardImage().setFitHeight(imageHeight);
            card.getCardImage().setFitWidth(imageWidth);
        }

        mid2Controller.getDeckCardController().getRect().setHeight(100);
        mid2Controller.getDeckCardController().getRect().setWidth(75);

        cardLeftController.getCardTop().setMinHeight(40);
        cardLeftController.getParent().setPrefHeight(500);
        VBox.setMargin(cardLeftController.getCardTop(), new Insets(5,5,5,5));
        VBox.setMargin(cardLeftController.getCardBody(), new Insets(5,5,5,5));
        VBox.setMargin(cardLeftController.getCardBottom(), new Insets(5,5,5,5));
        cardLeftController.getCardImage().setFitHeight(213);
        cardLeftController.getCardImage().setFitWidth(213);

    }
}
