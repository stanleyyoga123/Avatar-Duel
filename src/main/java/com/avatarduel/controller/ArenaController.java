package com.avatarduel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.avatarduel.model.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ArenaController {
    @FXML private VBox leftBox;
    @FXML private Text descriptionText;
    @FXML private Button button;
    @FXML private CardHandController deck1Controller;
    @FXML private CardHandController deck2Controller;
    @FXML private MidFieldController mid1Controller;
    @FXML private MidFieldController mid2Controller;

    public Button getButton() { return this.button; }

    public CardHandController getDeck1() { return this.deck1Controller; }

    public CardHandController getDeck2() { return this.deck2Controller; }

    public MidFieldController getMid1() { return this.mid1Controller; }

    public MidFieldController getMid2() { return this.mid2Controller; }

    public void setLeftBox(VBox leftBox) {
        this.leftBox.getChildren().set(0, leftBox);
    }

    public void setDescriptionText(String text) {
        descriptionText.setText(text);
        descriptionText.setWrappingWidth(Utility.LEFT_PREF_WIDTH - 30);
    }

    public void setPower(int player, int fire, int water, int earth, int air, int remFire, int remWater, int remEarth, int remAir) {
        if(player == 1){
            VBox parent = (VBox) mid1Controller.getHbox().getChildren().get(1);
            Text firePow = (Text) parent.getChildren().get(0);
            firePow.setText("Fire " + remFire + " / " + fire);
            Text waterPow = (Text) parent.getChildren().get(1);
            waterPow.setText("Water " + remWater + " / " + water);
            Text earthPow = (Text) parent.getChildren().get(2);
            earthPow.setText("Earth " + remEarth + " / " + earth);
            Text airPow = (Text) parent.getChildren().get(3);
            airPow.setText("Air " + remAir + " / " + air);
        }
    }

    public void init() {
        try {

            deck1Controller.updateHand(new ArrayList<Card>());
            deck2Controller.updateHand(new ArrayList<Card>());
            mid1Controller.updateField(new ArrayList<Card>(), new ArrayList<Card>());
            mid2Controller.updateField(new ArrayList<Card>(), new ArrayList<Card>());
            mid1Controller.setDeckCard(CardRender.makeCloseCard(Utility.DRAW_DECK_ELLIPSE_RADIUS));
            mid2Controller.setDeckCard(CardRender.makeCloseCard(Utility.DRAW_DECK_ELLIPSE_RADIUS));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        deck1Controller.setDeckHover();
        deck2Controller.setDeckHover();
        mid1Controller.setMidHover();
        mid2Controller.setMidHover();
        deck1Controller.connect(this);
        deck2Controller.connect(this);
        mid1Controller.connect(this);
        mid2Controller.connect(this);
    }
}