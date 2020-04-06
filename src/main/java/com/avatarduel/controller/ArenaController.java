package com.avatarduel.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ArenaController {

    @FXML HBox parentController;
    @FXML VBox leftBoxController;
    @FXML Card cardLeftController;
    @FXML Pane descriptionTextController;
    @FXML VBox rightBoxController;
    @FXML CardHandController deck1Controller;
    @FXML CardHandController deck2Controller;
    @FXML MidFieldController mid1Controller;
    @FXML MidFieldController mid2Controller;

    public void init() {

        ArrayList<Card> cardList = deck1Controller.getCardList();

        for(Card card : cardList){
            card.init(this);
            card.getEllipse().setRadiusY(40);
            card.getEllipse().setRadiusX(40);
        }

        cardList = deck2Controller.getCardList();

        for(Card card : cardList){
            card.getEllipse().setRadiusY(40);
            card.getEllipse().setRadiusX(40);
        }

        cardList = mid1Controller.getCardList();

        for(Card card : cardList){
            card.getEllipse().setRadiusY(20);
            card.getEllipse().setRadiusX(20);
        }

        cardList = mid2Controller.getCardList();

        for(Card card : cardList){
            card.getEllipse().setRadiusY(20);
            card.getEllipse().setRadiusX(20);
        }

        mid1Controller.getDeckCardController().getEllipse().setRadiusY(30);
        mid1Controller.getDeckCardController().getEllipse().setRadiusX(30);
        mid2Controller.getDeckCardController().getEllipse().setRadiusY(30);
        mid2Controller.getDeckCardController().getEllipse().setRadiusX(30);
        cardLeftController.getEllipse().setRadiusX(100);
        cardLeftController.getEllipse().setRadiusY(100);
        cardLeftController.getParent().setPrefHeight(400);

//        for(Card card : cardList) {
//            card.init(this);
//            double scale = deck1Controller.getHbox().getHeight()/card.getHeight();
//            double imageHeight = card.getCardImage().getFitHeight() * scale - 2;
//            double imageWidth = card.getCardImage().getFitWidth() * scale - 2;
//            card.getCardTop().setMinHeight(20);
//            VBox.setMargin(card.getCardTop(), new Insets(2,2,2,2));
//            VBox.setMargin(card.getCardBody(), new Insets(2,2,2,2));
//            VBox.setMargin(card.getCardBottom(), new Insets(2,2,2,2));
//            card.getCardImage().setFitHeight(imageHeight);
//            card.getCardImage().setFitWidth(imageWidth);
//            double elementHeight = card.getCardElement().getFitHeight() * scale - 8;
//            double elementWidth = card.getCardElement().getFitWidth() * scale - 8;
//            card.getCardElement().setFitHeight(elementHeight);
//            card.getCardElement().setFitWidth(elementWidth);
//            card.getTextDescription().setFont(Font.font("Verdana", 3));
//            card.getTextName().setFont(Font.font("Verdana", 8));
//        }
//
//        cardList = deck2Controller.getCardList();
//        for(Card card : cardList) {
//            card.init(this);
//            double scale = deck2Controller.getHbox().getHeight()/card.getHeight();
//            double imageHeight = card.getCardImage().getFitHeight() * scale - 2;
//            double imageWidth = card.getCardImage().getFitWidth() * scale - 2;
//            card.getCardTop().setMinHeight(20);
//            VBox.setMargin(card.getCardTop(), new Insets(2,2,2,2));
//            VBox.setMargin(card.getCardBody(), new Insets(2,2,2,2));
//            VBox.setMargin(card.getCardBottom(), new Insets(2,2,2,2));
//            card.getCardImage().setFitHeight(imageHeight);
//            card.getCardImage().setFitWidth(imageWidth);
//            double elementHeight = card.getCardElement().getFitHeight() * scale - 8;
//            double elementWidth = card.getCardElement().getFitWidth() * scale - 8;
//            card.getCardElement().setFitHeight(elementHeight);
//            card.getCardElement().setFitWidth(elementWidth);
//            card.getTextDescription().setFont(Font.font("Verdana", 3));
//            card.getTextName().setFont(Font.font("Verdana", 8));
//        }
//
//        cardList = mid1Controller.getCardList();
//        for(Card card : cardList) {
//            card.init(this);
//            double scale = mid1Controller.getHbox().getHeight()/card.getHeight()/2;
//            double imageHeight = card.getCardImage().getFitHeight() * scale - 6;
//            double imageWidth = card.getCardImage().getFitWidth() * scale - 6;
//            card.getCardTop().setMinHeight(10);
//            VBox.setMargin(card.getCardTop(), new Insets(1,1,1,1));
//            VBox.setMargin(card.getCardBody(), new Insets(1,1,1,1));
//            VBox.setMargin(card.getCardBottom(), new Insets(1,1,1,1));
//            card.getCardImage().setFitHeight(imageHeight);
//            card.getCardImage().setFitWidth(imageWidth);
//            double elementHeight = card.getCardElement().getFitHeight() * scale - 5;
//            double elementWidth = card.getCardElement().getFitWidth() * scale - 5;
//            card.getCardElement().setFitHeight(elementHeight);
//            card.getCardElement().setFitWidth(elementWidth);
//            card.getTextDescription().setFont(Font.font("Verdana", 2));
//            card.getTextName().setFont(Font.font("Verdana", 4));
//        }
//        mid1Controller.getDeckCardController().getEllipse().setRadiusY(30);
//        mid1Controller.getDeckCardController().getEllipse().setRadiusX(30);
//
//        cardList = mid2Controller.getCardList();
//        for(Card card : cardList) {
//            card.init(this);
//            double scale = mid2Controller.getHbox().getHeight()/card.getHeight()/2;
//            double imageHeight = card.getCardImage().getFitHeight() * scale - 6;
//            double imageWidth = card.getCardImage().getFitWidth() * scale - 6;
//            card.getCardTop().setMinHeight(10);
//            VBox.setMargin(card.getCardTop(), new Insets(1,1,1,1));
//            VBox.setMargin(card.getCardBody(), new Insets(1,1,1,1));
//            VBox.setMargin(card.getCardBottom(), new Insets(1,1,1,1));
//            card.getCardImage().setFitHeight(imageHeight);
//            card.getCardImage().setFitWidth(imageWidth);
//            double elementHeight = card.getCardElement().getFitHeight() * scale - 5;
//            double elementWidth = card.getCardElement().getFitWidth() * scale - 5;
//            card.getCardElement().setFitHeight(elementHeight);
//            card.getCardElement().setFitWidth(elementWidth);
//            card.getTextDescription().setFont(Font.font("Verdana", 2));
//            card.getTextName().setFont(Font.font("Verdana", 4));
//        }
//
//        mid2Controller.getDeckCardController().getEllipse().setRadiusY(30);
//        mid2Controller.getDeckCardController().getEllipse().setRadiusX(30);
//
//        cardLeftController.getCardTop().setMinHeight(40);
//        cardLeftController.getParent().setPrefHeight(500);
//        VBox.setMargin(cardLeftController.getCardTop(), new Insets(5,5,5,5));
//        VBox.setMargin(cardLeftController.getCardBody(), new Insets(5,5,5,5));
//        VBox.setMargin(cardLeftController.getCardBottom(), new Insets(5,5,5,5));
//        cardLeftController.getCardImage().setFitHeight(213);
//        cardLeftController.getCardImage().setFitWidth(213);
//        double elementHeight = 35;
//        double elementWidth = 35;
//        cardLeftController.getCardElement().setFitHeight(elementHeight);
//        cardLeftController.getCardElement().setFitWidth(elementWidth);
    }
}
