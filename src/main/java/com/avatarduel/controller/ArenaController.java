package com.avatarduel.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.avatarduel.model.Card;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ArenaController {

    private static final int DECK_ELLIPSE_RADIUS = 40;
    private static final int DECK_TOP_HEIGHT = 20;
    private static final int DECK_IMAGE_SIZE = 89;
    private static final int DECK_PREF_WIDTH = 120;
    private static final int DECK_PREF_HEIGHT = 200;
    private static final int DECK_FONT_SIZE = 8;

    private static final int MID_ELLIPSE_RADIUS = 20;
    private static final int MID_TOP_HEIGHT = 10;
    private static final int MID_IMAGE_SIZE = 40;
    private static final int MID_PREF_WIDTH = 73;
    private static final int MID_PREF_HEIGHT = 100;
    private static final int MID_FONT_SIZE = 6;

    private static final int DRAW_DECK_ELLIPSE_RADIUS = 30;

    private static final int LEFT_ELLIPSE_RADIUS = 100;
    private static final int LEFT_TOP_HEIGHT = 40;
    private static final int LEFT_IMAGE_SIZE = 170;
    private static final int LEFT_PREF_WIDTH = 263;
    private static final int LEFT_PREF_HEIGHT = 400;
    private static final int LEFT_FONT_SIZE = 15;

    private ArrayList<Card> deck1;
    private ArrayList<Card> deck2;
    private ArrayList<Card> mid1Bot;
    private ArrayList<Card> mid2Bot;
    private ArrayList<Card> mid1Top;
    private ArrayList<Card> mid2Top;

    @FXML VBox leftBox;
    @FXML Text descriptionText;
    @FXML CardHandController deck1Controller;
    @FXML CardHandController deck2Controller;
    @FXML MidFieldController mid1Controller;
    @FXML MidFieldController mid2Controller;

//    @FXML public void initialize() {
//        System.out.println("Application started");
//        deck1Controller.init(this);
//        deck2Controller.init(this);
//        mid1Controller.init(this);
//        mid2Controller.init(this);
//    }

    public void setMidHover(){
        VBox temp = (VBox) mid1Controller.getHbox().getChildren().get(0);
        for(int i = 0; i < 8; i++) {
            HBox temp_ = (HBox) temp.getChildren().get(0);
            int finalI = i;
            BorderPane temp__ = (BorderPane) temp_.getChildren().get(i);
            BorderPane finalTemp__ = temp__;
            temp__.getCenter().setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__.getCenter().setStyle("-fx-background-color:#dae7f3");
                    try {
                        setLeftBox(makeCard(mid1Top.get(finalI).getClass().getSimpleName(),
                                LEFT_IMAGE_SIZE,
                                LEFT_TOP_HEIGHT,
                                mid1Top.get(finalI),
                                LEFT_PREF_WIDTH,
                                LEFT_PREF_HEIGHT,
                                LEFT_FONT_SIZE));
                        setDescriptionText(mid1Top.get(finalI).getDescription());
                    } catch (Exception e) {
                        setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            temp__.getCenter().setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__.getCenter().setStyle("");
                    try {
                        makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT);
                        setDescriptionText("");
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
                        setLeftBox(makeCard(mid1Bot.get(finalI).getClass().getSimpleName(),
                                LEFT_IMAGE_SIZE,
                                LEFT_TOP_HEIGHT,
                                mid1Bot.get(finalI),
                                LEFT_PREF_WIDTH,
                                LEFT_PREF_HEIGHT,
                                LEFT_FONT_SIZE));
                        setDescriptionText(mid1Bot.get(finalI).getDescription());
                    } catch (Exception e) {
                        setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            temp__.getCenter().setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__1.getCenter().setStyle("");
                    try {
                        makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT);
                        setDescriptionText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        temp = (VBox) mid2Controller.getHbox().getChildren().get(0);
        for(int i = 0; i < 8; i++) {
            HBox temp_ = (HBox) temp.getChildren().get(0);
            int finalI = i;
            BorderPane temp__ = (BorderPane) temp_.getChildren().get(i);
            BorderPane finalTemp__ = temp__;
            temp__.getCenter().setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__.getCenter().setStyle("-fx-background-color:#dae7f3");
                    try {
                        setLeftBox(makeCard(mid2Top.get(finalI).getClass().getSimpleName(),
                                LEFT_IMAGE_SIZE,
                                LEFT_TOP_HEIGHT,
                                mid2Top.get(finalI),
                                LEFT_PREF_WIDTH,
                                LEFT_PREF_HEIGHT,
                                LEFT_FONT_SIZE));
                        setDescriptionText(mid2Top.get(finalI).getDescription());
                    } catch (Exception e) {
                        setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            temp__.getCenter().setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__.getCenter().setStyle("");
                    try {
                        makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT);
                        setDescriptionText("");
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
                        setLeftBox(makeCard(mid2Bot.get(finalI).getClass().getSimpleName(),
                                LEFT_IMAGE_SIZE,
                                LEFT_TOP_HEIGHT,
                                mid2Bot.get(finalI),
                                LEFT_PREF_WIDTH,
                                LEFT_PREF_HEIGHT,
                                LEFT_FONT_SIZE));
                        setDescriptionText(mid2Bot.get(finalI).getDescription());
                    } catch (Exception e) {
                        setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            temp__.getCenter().setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    finalTemp__1.getCenter().setStyle("");
                    try {
                        makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT);
                        setDescriptionText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void setDeckHover(){
        for(int i = 0; i < 8; i++){
            int finalI = i;
            deck1Controller.getHbox().getChildren().get(i).setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        deck1Controller.getHbox().getChildren().get(finalI).setStyle("-fx-background-color:#dae7f3;");
                        setLeftBox(makeCard(deck1.get(finalI).getClass().getSimpleName(),
                                LEFT_IMAGE_SIZE,
                                LEFT_TOP_HEIGHT,
                                deck1.get(finalI),
                                LEFT_PREF_WIDTH,
                                LEFT_PREF_HEIGHT,
                                LEFT_FONT_SIZE));
                        setDescriptionText(deck1.get(finalI).getDescription());
                    } catch (Exception e) {
                        setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            deck1Controller.getHbox().getChildren().get(i).setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        deck1Controller.getHbox().getChildren().get(finalI).setStyle("");
                        setLeftBox(makeCloseCard(LEFT_ELLIPSE_RADIUS, LEFT_PREF_WIDTH, LEFT_PREF_HEIGHT));
                        setDescriptionText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            deck2Controller.getHbox().getChildren().get(i).setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        deck2Controller.getHbox().getChildren().get(finalI).setStyle("-fx-background-color:#dae7f3;");
                        setLeftBox(makeCard(deck2.get(finalI).getClass().getSimpleName(),
                                LEFT_IMAGE_SIZE,
                                LEFT_TOP_HEIGHT,
                                deck2.get(finalI),
                                LEFT_PREF_WIDTH,
                                LEFT_PREF_HEIGHT,
                                LEFT_FONT_SIZE));
                        System.out.println(finalI);
                        setDescriptionText(deck2.get(finalI).getDescription());
                    } catch (Exception e) {
                        setDescriptionText("");
                        System.out.println("Kartu Kosong");
                    }
                }
            });
            deck2Controller.getHbox().getChildren().get(i).setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        deck2Controller.getHbox().getChildren().get(finalI).setStyle("");
                        setLeftBox(makeCloseCard(LEFT_ELLIPSE_RADIUS, LEFT_PREF_WIDTH, LEFT_PREF_HEIGHT));
                        setDescriptionText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public VBox getLeftBox() { return this.leftBox; }

    public void setLeftBox(VBox leftBox) {
        this.leftBox.getChildren().set(0, leftBox);
    }

    public void setDescriptionText(String text) {
        descriptionText.setText(text);
    }

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

    public void changeHand(int player, VBox card, int index){
        if(player == 1){
            deck1Controller.getHbox().getChildren().set(index, card);
        }
        else{
            deck2Controller.getHbox().getChildren().set(index, card);
        }
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
                         Card card,
                         double prefWidth,
                         double prefHeight,
                         double fontSize) throws IOException, URISyntaxException {
        FXMLLoader load = new FXMLLoader();
        if(type.equals("Land")){
            load.setLocation(getClass().getResource("../fxml/Land.fxml"));
        }
        else if(type.equals("Character")){
            load.setLocation(getClass().getResource("../fxml/CharacterCard.fxml"));
        }

        else{
            load.setLocation(getClass().getResource("../fxml/SkillCard.fxml"));
        }

        VBox temp = load.load();
        HBox temp_ = (HBox) temp.getChildren().get(1);

        ImageView image = (ImageView) temp_.getChildren().get(1);
        String addition;
        if(card.getClass().getSimpleName().equals("Land")){
            addition = "land/";
        } else if (card.getClass().getSimpleName().equals("Character")) {
            addition = "character/";
        } else {
            addition = "skill/";
        }
        System.out.println(card.getClass().getSimpleName());
        System.out.println(addition);
        System.out.println(card.getName());
        image.setImage(new Image(String.valueOf(new File(getClass().getResource("../card/image/" + addition + card.getName() + ".png").toURI().toString()))));
        image.setFitWidth(imageSize);
        image.setFitHeight(imageSize);

        HBox top = (HBox) temp.getChildren().get(0);
        top.setMinHeight(topHeight);

        Text cardName = (Text) top.getChildren().get(0);
        cardName.setText(card.getName());
        cardName.setFont(Font.font("Verdana", fontSize));

        VBox bottom = (VBox) temp.getChildren().get(2);
        Text cardDescription = (Text) bottom.getChildren().get(0);
        cardDescription.setText(card.getDescription());
        cardDescription.setFont(Font.font("Verdana", fontSize-2));

        Text cardElement = (Text) top.getChildren().get(2);
        cardElement.setText(card.getElement().toString());
        cardElement.setFont(Font.font("Verdana", fontSize));

        temp.setPrefHeight(prefHeight);
        temp.setPrefWidth(prefWidth);
        temp.setMinHeight(prefHeight);
        temp.setMinWidth(prefWidth);
        temp.setMaxHeight(prefHeight);
        temp.setMaxWidth(prefWidth);

        if(!card.getClass().getSimpleName().equals("Land")){
            HBox attribute = (HBox) bottom.getChildren().get(2);

            Text atk = (Text) attribute.getChildren().get(0);
            Text def = (Text) attribute.getChildren().get(2);
            Text pow = (Text) attribute.getChildren().get(4);

            atk.setFont(Font.font("Verdana", 4));
            def.setFont(Font.font("Verdana", 4));
            pow.setFont(Font.font("Verdana", 4));

            atk.setText("ATTACK " + card.getAttack());
            def.setText("DEFEND " + card.getDefense());
            pow.setText("POWER " + card.getPower());
        }

        temp.setId(String.valueOf(Math.random()));
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

    /**
     * To Change Hand Card
     *
     * @param player
     * @param card
     * @throws IOException
     */
    public void updateHand(int player, ArrayList<Card> card) throws IOException, URISyntaxException {
        int i;
        System.out.println(deck1Controller.getHbox().getChildren());
        for(i = 0; i < card.size(); i++){
            this.changeHand(player,
                    makeCard(
                        card.get(i).getClass().getSimpleName(),
                        DECK_IMAGE_SIZE,
                        DECK_TOP_HEIGHT,
                        card.get(i),
                        DECK_PREF_WIDTH,
                        DECK_PREF_HEIGHT,
                        DECK_FONT_SIZE
                    ), i);
        }
        for(; i < 8; i++){
            this.changeHand(player, makeCloseCard(DECK_ELLIPSE_RADIUS, DECK_PREF_WIDTH, DECK_PREF_HEIGHT), i);
        }
        setDeckHover();
        setMidHover();
        if(player == 1){
            this.deck1 = (ArrayList<Card>) card.clone();
        }
        else{
            this.deck2 = (ArrayList<Card>) card.clone();
        }
    }

    /**
     * To Change Field Card
     *
     * @param player1FrontCard
     * @param player1BackCard
     * @param player2FrontCard
     * @param player2BackCard
     * @throws IOException
     */
    public void updateField(ArrayList<Card> player1FrontCard, ArrayList<Card> player1BackCard, ArrayList<Card> player2FrontCard, ArrayList<Card> player2BackCard) throws IOException, URISyntaxException {
        int i;
        ArrayList<ArrayList<ArrayList<Card>>> list = new ArrayList<ArrayList<ArrayList<Card>>>();
        ArrayList<ArrayList<Card>> list_top = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<Card>> list_bot = new ArrayList<ArrayList<Card>>();
        list_top.add(player1FrontCard);
        list_bot.add(player1BackCard);
        list_top.add(player2FrontCard);
        list_bot.add(player2BackCard);
        list.add(list_top);
        list.add(list_bot);

        for(int j = 0; j < list_top.size(); j++){
            for(i = 0; i < list_top.get(j).size(); i++){
                changeMidTop(j,
                        makeCard(
                                list_top.get(j).getClass().getSimpleName(),
                                MID_IMAGE_SIZE,
                                MID_TOP_HEIGHT,
                                list_top.get(j).get(i),
                                MID_PREF_WIDTH,
                                MID_PREF_HEIGHT,
                                MID_FONT_SIZE
                        ), i);
            }
            for(; i < 8; i++){
                this.changeMidTop(j, makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT), i);
            }
        }
        for(int j = 0; j < list_bot.size(); j++){
            for(i = 0; i < list_bot.get(j).size(); i++){
                changeMidBot(j,
                        makeCard(
                                list_bot.get(j).get(i).getClass().getSimpleName(),
                                MID_IMAGE_SIZE,
                                MID_TOP_HEIGHT,
                                list_bot.get(j).get(i),
                                MID_PREF_WIDTH,
                                MID_PREF_HEIGHT,
                                MID_FONT_SIZE
                        ), i);
            }
            for(; i < 8; i++){
                this.changeMidBot(j, makeCloseCard(MID_ELLIPSE_RADIUS, MID_PREF_WIDTH, MID_PREF_HEIGHT), i);
            }
        }
        mid1Top = (ArrayList<Card>) player1FrontCard.clone();
        mid2Top = (ArrayList<Card>) player2FrontCard.clone();
        mid1Bot = (ArrayList<Card>) player1BackCard.clone();
        mid2Bot = (ArrayList<Card>) player2BackCard.clone();
    }

    public void init() {
        try {
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
        setDeckHover();
        setMidHover();
    }
}
