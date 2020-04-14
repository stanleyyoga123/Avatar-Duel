package com.avatarduel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.avatarduel.model.Card;
import com.avatarduel.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ArenaController {
    @FXML private VBox leftBox;
    @FXML private Text descriptionText;
    @FXML private Text curPhase;
    @FXML private Text p1Health;
    @FXML private Text p2Health;
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

    public void setPower(int curPlayer, Player player) {
        VBox parent;
        if(curPlayer == 1){
            parent = (VBox) mid1Controller.getHbox().getChildren().get(1);
        } else {
            parent = (VBox) mid2Controller.getHbox().getChildren().get(1);
        }
        Text firePow = (Text) parent.getChildren().get(0);
        firePow.setText("Fire " + player.getRemPower().getRemainingFire() + " / " + player.getPower().getFirePower());
        Text waterPow = (Text) parent.getChildren().get(1);
        waterPow.setText("Water " + player.getRemPower().getRemainingWater() + " / " + player.getPower().getWaterPower());
        Text earthPow = (Text) parent.getChildren().get(2);
        earthPow.setText("Earth " + player.getRemPower().getRemainingEarth() + " / " + player.getPower().getEarthPower());
        Text airPow = (Text) parent.getChildren().get(3);
        airPow.setText("Air " + player.getRemPower().getRemainingAir() + " / " + player.getPower().getAirPower());
        Text energyPow = (Text) parent.getChildren().get(4);
        energyPow.setText("Energy " + player.getRemPower().getRemainingEnergy() + " / " + player.getPower().getEnergyPower());
    }

    public void setCurPhase(String curPhase) {
        this.curPhase.setText(curPhase);
    }

    public void setP1Health(int Health) { p1Health.setText("Player 1 Health = " + Health); }

    public void setP2Health(int Health) { p2Health.setText("Player 2 Health = " + Health); }

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