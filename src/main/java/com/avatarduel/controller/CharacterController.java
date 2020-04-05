package com.avatarduel.controller;

import com.avatarduel.reader.CharacterReader;
import com.avatarduel.model.Character;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;

public class CharacterController {

    private CharacterReader characterData;

    @FXML private Text cardName;
    @FXML private Text cardDescription;
    @FXML private ImageView cardImage;

    private CardHandController parent;

    public void initialize() {
        Random rand = new Random();
        int index = rand.nextInt(48);

        characterData = new CharacterReader();

        try {
            characterData.loadCards();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Character cardChar = characterData.getCharacterList().get(index);
        cardName.setText(cardChar.getName());
        cardDescription.setText(cardChar.getDescription());

        try{
            Image image = new Image(String.valueOf(new File(getClass().getResource(cardChar.getPath()).toURI().toString())));
            System.out.println(new File(cardChar.getPath()).toURI().toString());
            cardImage.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
