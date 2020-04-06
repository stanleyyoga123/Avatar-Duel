package com.avatarduel.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ArenaController {

    private static final int DECK_ELLIPSE_RADIUS = 40;
    private static final int DECK_IMAGE_SIZE = 89;
    private static final int DECK_PREF_WIDTH = 120;
    private static final int DECK_PREF_HEIGHT = 200;
    private static final int DECK_FONT_SIZE = 8;

    private static final int MID_ELLIPSE_RADIUS = 20;
    private static final int MID_IMAGE_SIZE = 40;
    private static final int MID_PREF_WIDTH = 73;
    private static final int MID_PREF_HEIGHT = 100;
    private static final int MID_FONT_SIZE = 6;

    private static final int DRAW_DECK_ELLIPSE_RADIUS = 30;

    private static final int LEFT_ELLIPSE_RADIUS = 100;
    private static final int LEFT_IMAGE_SIZE = 170;
    private static final int LEFT_PREF_WIDTH = 263;
    private static final int LEFT_PREF_HEIGHT = 400;
    private static final int LEFT_FONT_SIZE = 15;


    @FXML VBox leftBox;
    @FXML CardHandController deck1Controller;
    @FXML CardHandController deck2Controller;
    @FXML MidFieldController mid1Controller;
    @FXML MidFieldController mid2Controller;

    public VBox makeCloseCard(int radius) throws IOException {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("../fxml/CloseCard.fxml"));
        VBox temp = load.load();
        VBox temp2 = (VBox) temp.getChildren().get(0);
        HBox temp3 = (HBox) temp2.getChildren().get(1);
        Ellipse temp4 = (Ellipse) temp3.getChildren().get(1);
        temp4.setRadiusX(radius);
        temp4.setRadiusY(radius);
        return temp;
    }

    public void changeMidTop(int player, VBox card, int index){
        VBox temp;
        if(player == 1){
            temp = (VBox) mid1Controller.getHbox().getChildren().get(0);
        }
        else{
            temp = (VBox) mid2Controller.getHbox().getChildren().get(0);
        }
        HBox temp_ = (HBox) temp.getChildren().get(0);
        BorderPane temp__ = (BorderPane) temp_.getChildren().get(index);
        temp__.setPrefHeight(100);
        temp__.setPrefWidth(125);
        temp__.setMinHeight(100);
        temp__.setMinWidth(125);
        temp__.setMaxHeight(100);
        temp__.setMaxWidth(125);
        temp__.setCenter(card);
    }

    public void changeMidBot(int player, VBox card, int index){
        VBox temp;
        if(player == 1){
            temp = (VBox) mid1Controller.getHbox().getChildren().get(0);
        }
        else{
            temp = (VBox) mid2Controller.getHbox().getChildren().get(0);
        }
        HBox temp_ = (HBox) temp.getChildren().get(1);
        BorderPane temp__ = (BorderPane) temp_.getChildren().get(index);
        temp__.setPrefHeight(100);
        temp__.setPrefWidth(125);
        temp__.setMinHeight(100);
        temp__.setMinWidth(125);
        temp__.setMaxHeight(100);
        temp__.setMaxWidth(125);
        temp__.setCenter(card);
    }

    public VBox makeCard(String type,
                         double imageSize,
                         double topHeight,
                         String name,
                         String description,
                         String element,
                         int attack,
                         int defense,
                         int power,
                         double prefWidth,
                         double prefHeight,
                         double fontSize) throws IOException {

        VBox temp = makeCard(type, imageSize, topHeight, name, description, element, prefWidth, prefHeight, fontSize);
        VBox bottom = (VBox) temp.getChildren().get(2);
        HBox attribute = (HBox) bottom.getChildren().get(2);

        Text atk = (Text) attribute.getChildren().get(0);
        Text def = (Text) attribute.getChildren().get(2);
        Text pow = (Text) attribute.getChildren().get(4);

        atk.setFont(Font.font("Verdana", 4));
        def.setFont(Font.font("Verdana", 4));
        pow.setFont(Font.font("Verdana", 4));

        atk.setText("ATTACK " + attack);
        def.setText("DEFEND " + defense);
        pow.setText("POWER " + power);

        return temp;
    }

    public VBox makeCard(String type,
                         double imageSize,
                         double topHeight,
                         String name,
                         String description,
                         String element,
                         double prefWidth,
                         double prefHeight,
                         double fontSize) throws IOException {
        FXMLLoader load = new FXMLLoader();
        if(type == "Land"){
            load.setLocation(getClass().getResource("../fxml/Land.fxml"));
        }
        else if(type == "Character"){
            load.setLocation(getClass().getResource("../fxml/CharacterCard.fxml"));
        }
        else{
            load.setLocation(getClass().getResource("../fxml/SkillCard.fxml"));
        }

        VBox temp = load.load();
        HBox temp_ = (HBox) temp.getChildren().get(1);

        ImageView image = (ImageView) temp_.getChildren().get(1);
        image.setFitWidth(imageSize);
        image.setFitHeight(imageSize);

        HBox top = (HBox) temp.getChildren().get(0);
        top.setMinHeight(topHeight);

        Text cardName = (Text) top.getChildren().get(0);
        cardName.setText(name);
        cardName.setFont(Font.font("Verdana", fontSize));

        VBox bottom = (VBox) temp.getChildren().get(2);
        Text cardDescription = (Text) bottom.getChildren().get(0);
        cardDescription.setText(description);
        cardDescription.setFont(Font.font("Verdana", fontSize-2));

        Text cardElement = (Text) top.getChildren().get(2);
        cardElement.setText(element);
        cardElement.setFont(Font.font("Verdana", fontSize));

        temp.setPrefHeight(prefHeight);
        temp.setPrefWidth(prefWidth);
        temp.setMinHeight(prefHeight);
        temp.setMinWidth(prefWidth);
        temp.setMaxHeight(prefHeight);
        temp.setMaxWidth(prefWidth);

        return temp;
    }

    public VBox makeCloseCard(int radius, double width, double height) throws IOException {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("../fxml/CloseCard.fxml"));
        VBox temp = load.load();
        VBox temp2 = (VBox) temp.getChildren().get(0);
        HBox temp3 = (HBox) temp2.getChildren().get(1);
        Ellipse temp4 = (Ellipse) temp3.getChildren().get(1);
        temp4.setRadiusX(radius);
        temp4.setRadiusY(radius);
        temp.setPrefHeight(height);
        temp.setPrefWidth(width);
        temp.setMinHeight(height);
        temp.setMinWidth(width);
        temp.setMaxHeight(height);
        temp.setMaxWidth(width);
        return temp;
    }

    public void init() {
        try {
            double scale = deck1Controller.getHbox().getHeight()/650d;

            for(int k = 0; k < 8; k++){
                deck1Controller.getHbox().getChildren().set(k, makeCloseCard(DECK_ELLIPSE_RADIUS, DECK_PREF_WIDTH, DECK_PREF_HEIGHT));
                deck2Controller.getHbox().getChildren().set(k, makeCloseCard(DECK_ELLIPSE_RADIUS, DECK_PREF_WIDTH, DECK_PREF_HEIGHT));
            }
            for(int k = 0; k < 8; k++){
                VBox set1 = (VBox) mid1Controller.getHbox().getChildren().get(0);
                VBox set2 = (VBox) mid2Controller.getHbox().getChildren().get(0);
                VBox[] arr = {set1, set2};

                int count = 0;

                for(VBox temp : arr){
                    if(count < 1){
                        for(int j = 0; j < 2; j++){

                            HBox temp_ = (HBox) temp.getChildren().get(j);
                            BorderPane temp__ = (BorderPane) temp_.getChildren().get(k);
                            temp__.setPrefHeight(100);
                            temp__.setPrefWidth(125);
                            temp__.setMinHeight(100);
                            temp__.setMinWidth(125);
                            temp__.setMaxHeight(100);
                            temp__.setMaxWidth(125);
                            temp__.setCenter(makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT));
                        }
                    }
                    else{
                        for(int j = 0; j < 2; j++){

                            HBox temp_ = (HBox) temp.getChildren().get(j);
                            BorderPane temp__ = (BorderPane) temp_.getChildren().get(k);
                            temp__.setPrefHeight(100);
                            temp__.setPrefWidth(125);
                            temp__.setMinHeight(100);
                            temp__.setMinWidth(125);
                            temp__.setMaxHeight(100);
                            temp__.setMaxWidth(125);
                            temp__.setCenter(makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT));
                        }
                    }
                    System.out.println(count);
                    count++;
                }
            }
            VBox set1 = (VBox) mid1Controller.getHbox().getChildren().get(1);
            VBox set2 = (VBox) mid2Controller.getHbox().getChildren().get(1);

            set1.getChildren().set(4, makeCloseCard(DRAW_DECK_ELLIPSE_RADIUS));
            set2.getChildren().set(4, makeCloseCard(DRAW_DECK_ELLIPSE_RADIUS));

            leftBox.getChildren().set(0, makeCloseCard(LEFT_ELLIPSE_RADIUS, LEFT_PREF_WIDTH, LEFT_PREF_HEIGHT));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
