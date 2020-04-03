package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LandController implements Initializable {

    private String name;
    private String description;
    private String imagePath;

    @FXML private Label cardDescription;
    @FXML private Label cardName;
    @FXML private ImageView cardImage;

    /**
     * Constructor
     *
     * @param name
     * @param description
     * @param imagePath
     */
    public LandController(String name, String description, String imagePath){
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cardName.setText(name);
        cardDescription.setText(description);
        try{
            Image image = new Image(String.valueOf(new File(getClass().getResource(this.imagePath).toURI().toString())));
            System.out.println(new File(this.imagePath).toURI().toString());
            cardImage.setImage(image);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
