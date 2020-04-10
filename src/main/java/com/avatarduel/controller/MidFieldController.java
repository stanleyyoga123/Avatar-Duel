package com.avatarduel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.builder.LandBuilder;
import com.avatarduel.builder.SkillBuilder;
import com.avatarduel.model.Card;
import com.avatarduel.model.Effect;
import com.avatarduel.model.Element;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MidFieldController {

    private ArenaController main;

    @FXML private HBox hbox;
    @FXML private BorderPane card0;
    @FXML private BorderPane card1;
    @FXML private BorderPane card2;
    @FXML private BorderPane card3;
    @FXML private BorderPane card4;
    @FXML private BorderPane card5;
    @FXML private BorderPane card6;
    @FXML private BorderPane card7;
    @FXML private BorderPane card8;
    @FXML private BorderPane card9;
    @FXML private BorderPane card10;
    @FXML private BorderPane card11;
    @FXML private VBox rightBox;
    @FXML private Text fire;
    @FXML private Text water;
    @FXML private Text earth;
    @FXML private Text air;
    @FXML private Text energy;

    public void connect(ArenaController main) { this.main = main; }

    public HBox getHbox() {
        return hbox;
    }

    private Card getCard(BorderPane inside) {
        Card selectedCard;
        VBox parent = (VBox) inside.getCenter();
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

    private BorderPane getFrontPane(int index) {
        VBox left = (VBox) hbox.getChildren().get(0);
        HBox front = (HBox) left.getChildren().get(0);
        return (BorderPane) front.getChildren().get(index);
    }

    private BorderPane getBackPane(int index) {
        VBox left = (VBox) hbox.getChildren().get(0);
        HBox front = (HBox) left.getChildren().get(1);
        return (BorderPane) front.getChildren().get(index);
    }

    public Card getIndexCardFront(int index) {
        return getCard(getFrontPane(index));

    }

    public Card getIndexCardBack(int index) {
        return getCard(getBackPane(index));
    }

    public ArrayList<Card> getCardFront() {
        ArrayList<Card> ret = new ArrayList<Card>();
        for(int i = 0; i < 8; i++) {
            try {
                ret.add(getIndexCardFront(i));
            } catch (Exception e) {
                break;
            }
        }
        return ret;
    }

    public ArrayList<Card> getCardBack() {
        ArrayList<Card> ret = new ArrayList<Card>();
        for(int i = 0; i < 8; i++) {
            try{
                ret.add(getIndexCardBack(i));
            } catch (Exception e) {
                break;
            }
        }
        return ret;
    }

    public Text getFire() { return fire; }

    public Text getWater() { return water; }

    public Text getEarth() { return earth; }

    public Text getAir() { return air; }

    public Text getEnergy() { return energy; }

    public void setDeckCard(VBox card) { rightBox.getChildren().set(5, card); }

    public void setFire(Text fire) { this.fire = fire; }

    public void setWater(Text water) { this.water = water;}

    public void setEarth(Text earth) { this.earth = earth; }

    public void setAir(Text air) { this.air = air; }

    public void changeMidTop(VBox card, int index){
        ArrayList<BorderPane> list = new ArrayList<BorderPane>();
        list.add(card0);
        list.add(card1);
        list.add(card2);
        list.add(card3);
        list.add(card4);
        list.add(card5);

        list.get(index).setCenter(card);
        list.get(index).setPrefHeight(100);
        list.get(index).setPrefWidth(125);
        list.get(index).setMinHeight(100);
        list.get(index).setMinWidth(125);
        list.get(index).setMaxHeight(100);
        list.get(index).setMaxWidth(125);
    }

    public void changeMidBot(VBox card, int index){
        ArrayList<BorderPane> list = new ArrayList<BorderPane>();
        list.add(card6);
        list.add(card7);
        list.add(card8);
        list.add(card9);
        list.add(card10);
        list.add(card11);

        list.get(index).setCenter(card);
        list.get(index).setPrefHeight(100);
        list.get(index).setPrefWidth(125);
        list.get(index).setMinHeight(100);
        list.get(index).setMinWidth(125);
        list.get(index).setMaxHeight(100);
        list.get(index).setMaxWidth(125);
    }

    public void updateField(ArrayList<Card> playerFrontCard, ArrayList<Card> playerBackCard) throws IOException, URISyntaxException {
        int j;
        for(j = 0; j < playerFrontCard.size(); j++) {
            changeMidTop(CardRender.makeCard(
                    playerFrontCard.get(j).getClass().getSimpleName(),
                    Utility.MID_IMAGE_SIZE,
                    Utility.MID_TOP_HEIGHT,
                    playerFrontCard.get(j),
                    Utility.MID_PREF_WIDTH,
                    Utility.MID_PREF_HEIGHT,
                    Utility.MID_FONT_SIZE,
                    Utility.MID_FONT_ATT
            ), j);
        }
        for(; j < Utility.MID_MAX; j++){
            System.out.println(j);
            this.changeMidTop(CardRender.makeCloseCard(Utility.MID_ELLIPSE_RADIUS, Utility.MID_PREF_WIDTH, Utility.MID_PREF_HEIGHT), j);
        }

        for(j = 0; j < playerBackCard.size(); j++) {
            changeMidBot(CardRender.makeCard(
                    playerBackCard.get(j).getClass().getSimpleName(),
                    Utility.MID_IMAGE_SIZE,
                    Utility.MID_TOP_HEIGHT,
                    playerBackCard.get(j),
                    Utility.MID_PREF_WIDTH,
                    Utility.MID_PREF_HEIGHT,
                    Utility.MID_FONT_SIZE,
                    Utility.MID_FONT_ATT
            ), j);
        }
        for(; j < Utility.MID_MAX; j++){
            this.changeMidBot(CardRender.makeCloseCard(Utility.MID_ELLIPSE_RADIUS, Utility.MID_PREF_WIDTH, Utility.MID_PREF_HEIGHT), j);
        }
        try{
            main.getDeck1().setDeckHover();
            main.getDeck2().setDeckHover();
            main.getMid1().setMidHover();
            main.getMid2().setMidHover();
        } catch(Exception e) {
            //
        }
    }

    public void setMidHover() {
        VBox temp = (VBox) this.getHbox().getChildren().get(0);
        for (int i = 0; i < Utility.MID_MAX; i++) {
            HBox temp_ = (HBox) temp.getChildren().get(0);
            int finalI = i;
            BorderPane temp__ = (BorderPane) temp_.getChildren().get(i);
            BorderPane finalTemp__ = temp__;
            temp__.getCenter().setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__.getCenter().setStyle("-fx-background-color:#dae7f3");
                    try {
                        main.setLeftBox(CardRender.makeCard(getCardFront().get(finalI).getClass().getSimpleName(),
                                Utility.LEFT_IMAGE_SIZE,
                                Utility.LEFT_TOP_HEIGHT,
                                getCardFront().get(finalI),
                                Utility.LEFT_PREF_WIDTH,
                                Utility.LEFT_PREF_HEIGHT,
                                Utility.LEFT_FONT_SIZE,
                                Utility.LEFT_FONT_ATT));
                        main.setDescriptionText(getCardFront().get(finalI).getDescription());
                    } catch (Exception e) {
                        main.setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            temp__.getCenter().setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__.getCenter().setStyle("");
                    try {
                        CardRender.makeCloseCard(Utility.MID_ELLIPSE_RADIUS, Utility.MID_PREF_WIDTH, Utility.MID_PREF_HEIGHT);
                        main.setDescriptionText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            temp_ = (HBox) temp.getChildren().get(1);
            temp__ = (BorderPane) temp_.getChildren().get(i);
            BorderPane finalTemp__1 = temp__;
            temp__.getCenter().setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__1.getCenter().setStyle("-fx-background-color:#dae7f3");
                    try {
                        main.setLeftBox(CardRender.makeCard(getCardBack().get(finalI).getClass().getSimpleName(),
                                Utility.LEFT_IMAGE_SIZE,
                                Utility.LEFT_TOP_HEIGHT,
                                getCardBack().get(finalI),
                                Utility.LEFT_PREF_WIDTH,
                                Utility.LEFT_PREF_HEIGHT,
                                Utility.LEFT_FONT_SIZE,
                                Utility.LEFT_FONT_ATT));
                        main.setDescriptionText(getCardBack().get(finalI).getDescription());
                    } catch (Exception e) {
                        main.setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            temp__.getCenter().setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__1.getCenter().setStyle("");
                    try {
                        CardRender.makeCloseCard(Utility.MID_ELLIPSE_RADIUS, Utility.MID_PREF_WIDTH, Utility.MID_PREF_HEIGHT);
                        main.setDescriptionText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
