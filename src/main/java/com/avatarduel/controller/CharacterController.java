package com.avatarduel.controller;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.builder.LandBuilder;
import com.avatarduel.builder.SkillBuilder;
import com.avatarduel.model.Card;
import com.avatarduel.model.Effect;
import com.avatarduel.model.Element;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class CharacterController implements CardLayout {

    private MidFieldController mid;
    private CardHandController hand;

    private static final int LEFT_ELLIPSE_RADIUS = 100;
    private static final int LEFT_TOP_HEIGHT = 40;
    private static final int LEFT_IMAGE_SIZE = 170;
    private static final int LEFT_PREF_WIDTH = 263;
    private static final int LEFT_PREF_HEIGHT = 400;
    private static final int LEFT_FONT_SIZE = 15;

    private double width = 400;
    private double height = 650;

    @FXML private VBox parent;

    public VBox getParent() {
        return parent;
    }

    public double getWidth() { return this.width; }

    public double getHeight() { return this.height; }

    public Card getCard() {
        Card selectedCard;
        HBox top = (HBox) parent.getChildren().get(0);
        Text cardName = (Text) top.getChildren().get(0);
        Text cardType = (Text) top.getChildren().get(2);
        Text cardElement = (Text) top.getChildren().get(4);
        VBox bottom = (VBox) parent.getChildren().get(2);
        if(cardType.getText().equals("Land")){
            Text cardDescription = (Text) bottom.getChildren().get(0);
            selectedCard = new LandBuilder()
                    .name(cardName.getText())
                    .description(cardDescription.getText())
                    .element(Element.valueOf(cardElement.getText()))
                    .build();
        }
        else if(cardType.getText().equals("Character")){
            Text cardDescription = (Text) bottom.getChildren().get(0);
            HBox attribute = (HBox) bottom.getChildren().get(2);
            Text cardAttack = (Text) attribute.getChildren().get(0);
            Text cardDefense = (Text) attribute.getChildren().get(2);
            Text cardPower = (Text) attribute.getChildren().get(4);
            selectedCard = new CharacterBuilder()
                    .name(cardName.getText())
                    .description(cardDescription.getText())
                    .element(Element.valueOf(cardElement.getText()))
                    .attack(Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")))
                    .defense(Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")))
                    .power(Integer.valueOf(cardPower.getText().replaceAll("\\D+", "")))
                    .build();
        }
        else{
            Text cardDescription = (Text) bottom.getChildren().get(0);
            Text cardEffect = (Text) bottom.getChildren().get(2);
            HBox attribute = (HBox) bottom.getChildren().get(4);
            Text cardAttack = (Text) attribute.getChildren().get(0);
            Text cardDefense = (Text) attribute.getChildren().get(2);
            Text cardPower = (Text) attribute.getChildren().get(4);
            selectedCard = new SkillBuilder()
                    .name(cardName.getText())
                    .description(cardDescription.getText())
                    .element(Element.valueOf(cardElement.getText()))
                    .attack(Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")))
                    .defense(Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")))
                    .power(Integer.valueOf(cardPower.getText().replaceAll("\\D+", "")))
                    .effect(Effect.valueOf(cardEffect.getText()))
                    .build();
        }
        return selectedCard;
    }

    @FXML
    void enter(MouseEvent event) {
    }

    @FXML
    void exit(MouseEvent event) throws IOException {
    }
}
