package com.avatarduel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Character;
import com.avatarduel.model.Skill;
import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Controller for mid field
 */

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
    @FXML private Text deckSize;

    /**
     * Connector between controller
     * @param main Main
     */
    public void connect(ArenaController main) { this.main = main; }

    /**
     * Getter HBox
     * @return HBox
     */
    public HBox getHbox() { return hbox; }

    /**
     * Converter into Card
     * @param inside Inside Border Pane
     * @return Card
     */
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
            selectedCard = new Land(
                    cardName.getText(),
                    Element.valueOf(cardElement.getText()),
                    cardDescription.getText()
            );
        }
        else if(cardType.getText().equals("Character")){
            Text cardDescription = (Text) bottom.getChildren().get(0);
            HBox attribute = (HBox) bottom.getChildren().get(2);
            Text cardAttack = (Text) attribute.getChildren().get(0);
            Text cardDefense = (Text) attribute.getChildren().get(2);
            Text cardPower = (Text) attribute.getChildren().get(4);
            selectedCard = new Character(
                    cardName.getText(),
                    Element.valueOf(cardElement.getText()),
                    cardDescription.getText(),
                    new Attribute(
                            Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")),
                            Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")),
                            Integer.valueOf(cardPower.getText().replaceAll("\\D+", ""))
                    )
            );
        }
        else{
            Text cardDescription = (Text) bottom.getChildren().get(0);
            Text cardEffect = (Text) bottom.getChildren().get(2);
            HBox attribute = (HBox) bottom.getChildren().get(4);
            Text cardAttack = (Text) attribute.getChildren().get(0);
            Text cardDefense = (Text) attribute.getChildren().get(2);
            Text cardPower = (Text) attribute.getChildren().get(4);
            selectedCard = new Skill(
                    cardName.getText(),
                    Element.valueOf(cardElement.getText()),
                    cardDescription.getText(),
                    Effect.valueOf(cardEffect.getText()),
                    new Attribute(
                            Integer.valueOf(cardAttack.getText().replaceAll("\\D+", "")),
                            Integer.valueOf(cardDefense.getText().replaceAll("\\D+", "")),
                            Integer.valueOf(cardPower.getText().replaceAll("\\D+", ""))
                    )
            );
        }
        return selectedCard;
    }

    /**
     * Getter FrontPane
     * @param index Index
     * @return BorderPane
     */
    private BorderPane getFrontPane(int index) {
        VBox left = (VBox) hbox.getChildren().get(0);
        HBox front = (HBox) left.getChildren().get(0);
        return (BorderPane) front.getChildren().get(index);
    }

    /**
     * Getter BackPane
     * @param index Index
     * @return BackPane
     */
    private BorderPane getBackPane(int index) {
        VBox left = (VBox) hbox.getChildren().get(0);
        HBox front = (HBox) left.getChildren().get(1);
        return (BorderPane) front.getChildren().get(index);
    }

    /**
     * Getter Card by Index from front field
     * @param index Index
     * @return Card
     */
    public Card getIndexCardFront(int index) { return getCard(getFrontPane(index)); }

    /**
     * Getter Card by Index from back field
     * @param index Index
     * @return Card
     */
    public Card getIndexCardBack(int index) { return getCard(getBackPane(index)); }

    /**
     * Getter all Card front field
     * @return List of Card
     */
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

    /**
     * Getter all Card back field
     * @return List of Card
     */
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

    /**
     * Getter Fire text
     * @return Text
     */
    public Text getFire() { return fire; }

    /**
     * Getter Water text
     * @return Text
     */
    public Text getWater() { return water; }

    /**
     * Getter Earth text
     * @return Text
     */
    public Text getEarth() { return earth; }

    /**
     * Getter Air text
     * @return Text
     */
    public Text getAir() { return air; }

    /**
     * Getter Energy text
     * @return Text
     */
    public Text getEnergy() { return energy; }

    /**
     * Getter Deck Size text
     * @return Text
     */
    public Text getDeckSize() { return deckSize; }

    /**
     * Setter for Deck Card
     * @param card Card
     */
    public void setDeckCard(VBox card) { rightBox.getChildren().set(6, card); }

    /**
     * Setter Fire text
     * @param fire Fire
     */
    public void setFire(Text fire) { this.fire = fire; }

    /**
     * Setter Water text
     * @param water Water
     */
    public void setWater(Text water) { this.water = water;}

    /**
     * Setter Earth text
     * @param earth Earth
     */
    public void setEarth(Text earth) { this.earth = earth; }

    /**
     * Setter Air Text
     * @param air Air
     */
    public void setAir(Text air) { this.air = air; }

    /**
     * Setter Energy text
     * @param energy Energy
     */
    public void setEnergy(Text energy) { this.energy = energy; }

    /**
     * Setter Deck Size
     * @param deckSize Deck Size
     */
    public void setDeckSize(Text deckSize) { this.deckSize = deckSize; }

    /**
     * Change Front Field by index
     * @param card Card
     * @param index Index
     */
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

    /**
     * Change Back Field by index
     * @param card Card
     * @param index Index
     */
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

    /**
     * Update Field
     * @param playerFrontCard Player Front Card
     * @param playerBackCard Player Back Card
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
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
            changeMidTop(CardRender.makeCloseCard(Utility.MID_ELLIPSE_RADIUS, Utility.MID_PREF_WIDTH, Utility.MID_PREF_HEIGHT), j);
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
            changeMidBot(CardRender.makeCloseCard(Utility.MID_ELLIPSE_RADIUS, Utility.MID_PREF_WIDTH, Utility.MID_PREF_HEIGHT), j);
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

    /**
     * Hover event setter
     */
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
