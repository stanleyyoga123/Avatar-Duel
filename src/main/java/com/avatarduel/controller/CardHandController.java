package com.avatarduel.controller;

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

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class CardHandController {

    private ArenaController main;

    @FXML private HBox hbox;

    public void connect(ArenaController main) { this.main = main; }

    public HBox getHbox() {
        return hbox;
    }

    public Card getCardHand(int index) {
        Card selectedCard;
        VBox parent = (VBox) hbox.getChildren().get(index);
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

    public ArrayList<Card> getAllCard() {
        ArrayList<Card> ret = new ArrayList<Card>();
        for(int i = 0; i < 8; i++) {
            try{
                ret.add(getCardHand(i));
            } catch (Exception e) {
                break;
            }
        }
        return ret;
    }

    public void setDeckHover(){
        for(int i = 0; i < Utility.DECK_MAX; i++){
            int finalI = i;
            getHbox().getChildren().get(i).setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        getHbox().getChildren().get(finalI).setStyle("-fx-background-color:#dae7f3;");
                        main.setLeftBox(CardRender.makeCard(getAllCard().get(finalI).getClass().getSimpleName(),
                                Utility.LEFT_IMAGE_SIZE,
                                Utility.LEFT_TOP_HEIGHT,
                                getAllCard().get(finalI),
                                Utility.LEFT_PREF_WIDTH,
                                Utility.LEFT_PREF_HEIGHT,
                                Utility.LEFT_FONT_SIZE,
                                Utility.LEFT_FONT_ATT));
                        main.setDescriptionText(getAllCard().get(finalI).getDescription());
                    } catch (Exception e) {
                        main.setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            getHbox().getChildren().get(i).setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        getHbox().getChildren().get(finalI).setStyle("");
                        main.setLeftBox(CardRender.makeCloseCard(Utility.LEFT_ELLIPSE_RADIUS, Utility.LEFT_PREF_WIDTH, Utility.LEFT_PREF_HEIGHT));
                        main.setDescriptionText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void changeHand(VBox card, int index){
        getHbox().getChildren().set(index, card);
    }

    public void updateHand(ArrayList<Card> card) throws IOException, URISyntaxException     {
        int i;
        for(i = 0; i < card.size(); i++){
            changeHand(CardRender.makeCard(
                            card.get(i).getClass().getSimpleName(),
                            Utility.DECK_IMAGE_SIZE,
                            Utility.DECK_TOP_HEIGHT,
                            card.get(i),
                            Utility.DECK_PREF_WIDTH,
                            Utility.DECK_PREF_HEIGHT,
                            Utility.DECK_FONT_SIZE,
                            Utility.DECK_FONT_ATT
                    ), i);
        }
        for(; i < Utility.DECK_MAX; i++){
            changeHand(CardRender.makeCloseCard(Utility.DECK_ELLIPSE_RADIUS, Utility.DECK_PREF_WIDTH, Utility.DECK_PREF_HEIGHT), i);
        }

        try{
            main.getDeck1().setDeckHover();
            main.getDeck2().setDeckHover();
            main.getMid1().setMidHover();
            main.getMid2().setMidHover();
        } catch(Exception e) {
            // Do Nothing
        }
    }
}
