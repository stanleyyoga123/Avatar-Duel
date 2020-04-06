package com.avatarduel.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;

public class ArenaController {

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

    public VBox makeCloseCard(int radius, double width, double height) throws IOException {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("../fxml/CloseCard.fxml"));
        VBox temp = load.load();
        VBox temp2 = (VBox) temp.getChildren().get(0);
        HBox temp3 = (HBox) temp2.getChildren().get(1);
        Ellipse temp4 = (Ellipse) temp3.getChildren().get(1);
        temp4.setRadiusX(radius);
        temp4.setRadiusY(radius);
        temp2.setPrefHeight(height);
        temp2.setPrefWidth(width);
        temp2.setMinHeight(height);
        temp2.setMinWidth(width);
        temp2.setMaxHeight(height);
        temp2.setMaxWidth(width);
        return temp;
    }

    public void init() {

        try {
            for(int k = 0; k < 8; k++){
                deck1Controller.getHbox().getChildren().set(k, makeCloseCard(40));
                deck2Controller.getHbox().getChildren().set(k, makeCloseCard(40));
            }
            for(int k = 0; k < 8; k++){
                VBox set1 = (VBox) mid1Controller.getHbox().getChildren().get(0);
                VBox set2 = (VBox) mid2Controller.getHbox().getChildren().get(0);
                VBox[] arr = {set1, set2};

                for(VBox temp : arr){
                    for(int j = 0; j < 2; j++){
                        HBox temp_ = (HBox) temp.getChildren().get(j);
                        BorderPane temp__ = (BorderPane) temp_.getChildren().get(k);
                        temp__.setPrefHeight(100);
                        temp__.setPrefWidth(125);
                        temp__.setMinHeight(100);
                        temp__.setMinWidth(125);
                        temp__.setMaxHeight(100);
                        temp__.setMaxWidth(125);
                        temp__.setCenter(makeCloseCard(20, 65, 90));
                    }
                }
            }
            VBox set1 = (VBox) mid1Controller.getHbox().getChildren().get(1);
            VBox set2 = (VBox) mid2Controller.getHbox().getChildren().get(1);

            set1.getChildren().set(4, makeCloseCard(30));
            set2.getChildren().set(4, makeCloseCard(30));

            leftBox.getChildren().set(0, makeCloseCard(100, 263, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
