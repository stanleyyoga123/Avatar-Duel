package com.avatarduel.controller;

import com.avatarduel.model.Card;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Class to render card
 */

public class CardRender {

    /**
     * Make Close Card
     * @param radius Radius
     * @param width Width
     * @param height Height
     * @return VBox VBox
     * @throws IOException Input Output
     */
    public static VBox makeCloseCard(int radius, double width, double height) throws IOException {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(CardRender.class.getResource("../fxml/CloseCard.fxml"));
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
     * Make Close Card
     * @param radius Radius
     * @return VBox
     * @throws IOException Input Output
     */
    public static VBox makeCloseCard(int radius) throws IOException {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(CardRender.class.getResource("../fxml/CloseCard.fxml"));
        VBox temp = load.load();
        VBox temp2 = (VBox) temp.getChildren().get(0);
        HBox temp3 = (HBox) temp2.getChildren().get(1);
        Ellipse temp4 = (Ellipse) temp3.getChildren().get(1);
        temp4.setRadiusX(radius);
        temp4.setRadiusY(radius);
        return temp;
    }

    /**
     * Make Card
     * @param type Type
     * @param imageSize Image Size
     * @param topHeight Top Height
     * @param card Card
     * @param prefWidth Preferable Width
     * @param prefHeight Preferable Height
     * @param fontSize Font Size
     * @param fontAtt Font Size Attribute
     * @return VBox
     * @throws IOException Input Ouput
     * @throws URISyntaxException URI
     */
    public static VBox makeCard(String type,
                         double imageSize,
                         double topHeight,
                         Card card,
                         double prefWidth,
                         double prefHeight,
                         double fontSize,
                         double fontAtt) throws IOException, URISyntaxException {
        FXMLLoader load = new FXMLLoader();
        if(type.equals("Land")){
            load.setLocation(CardRender.class.getResource("../fxml/Land.fxml"));
        }
        else if(type.equals("Skill")){
            load.setLocation(CardRender.class.getResource("../fxml/SkillCard.fxml"));
        }

        else{
            load.setLocation(CardRender.class.getResource("../fxml/CharacterCard.fxml"));
        }

        VBox temp = load.load();
        HBox temp_ = (HBox) temp.getChildren().get(1);

        ImageView image = (ImageView) temp_.getChildren().get(1);
        String addition;
        if(card.getClass().getSimpleName().equals("Land")){
            addition = "land/";
        } else if (card.getClass().getSimpleName().equals("Skill")) {
            addition = "skill/";
        } else {
            addition = "character/";
        }
        image.setImage(new Image(String.valueOf(new File(CardRender.class.getResource("../card/image/" + addition + card.getName() + ".png").toURI().toString()))));
        image.setFitWidth(imageSize);
        image.setFitHeight(imageSize);

        HBox top = (HBox) temp.getChildren().get(0);
        top.setMinHeight(topHeight);

        Text cardName = (Text) top.getChildren().get(0);
        cardName.setText(card.getName());
        cardName.setFont(Font.font("Verdana", fontSize));
        cardName.setWrappingWidth(fontSize*8);

        VBox bottom = (VBox) temp.getChildren().get(2);
        Text cardDescription = (Text) bottom.getChildren().get(0);
        cardDescription.setText(card.getDescription());
        cardDescription.setWrappingWidth(prefWidth-20);
        cardDescription.setFont(Font.font("Verdana", fontSize-2));
        if(fontSize == 4) {
            VBox.setMargin(cardDescription, new Insets(0,0,0,0));
            cardDescription.setWrappingWidth(prefWidth-10);
        }

        Text cardElement = (Text) top.getChildren().get(4);
        cardElement.setText(card.getElement().toString());
        cardElement.setFont(Font.font("Verdana", fontSize));

        Text cardType = (Text) top.getChildren().get(2);
        cardType.setText(card.getClass().getSimpleName());
        cardType.setFont(Font.font("Verdana", 0));

        temp.setPrefHeight(prefHeight);
        temp.setPrefWidth(prefWidth);
        temp.setMinHeight(prefHeight);
        temp.setMinWidth(prefWidth);
        temp.setMaxHeight(prefHeight);
        temp.setMaxWidth(prefWidth);

        if(card.getClass().getSimpleName().equals("Character")){
            HBox attribute = (HBox) bottom.getChildren().get(2);

            Text atk = (Text) attribute.getChildren().get(0);
            Text def = (Text) attribute.getChildren().get(2);
            Text pow = (Text) attribute.getChildren().get(4);

            atk.setFont(Font.font("Verdana", fontAtt));
            def.setFont(Font.font("Verdana", fontAtt));
            pow.setFont(Font.font("Verdana", fontAtt));

            atk.setText("ATTACK " + card.getAttribute().getAttack());
            def.setText("DEFEND " + card.getAttribute().getDefense());
            pow.setText("POWER " + card.getAttribute().getPower());
        }
        else if(card.getClass().getSimpleName().equals("Skill")){
            HBox attribute = (HBox) bottom.getChildren().get(4);

            Text atk = (Text) attribute.getChildren().get(0);
            Text def = (Text) attribute.getChildren().get(2);
            Text pow = (Text) attribute.getChildren().get(4);

            atk.setFont(Font.font("Verdana", fontAtt));
            def.setFont(Font.font("Verdana", fontAtt));
            pow.setFont(Font.font("Verdana", fontAtt));

            atk.setText("ATTACK " + card.getAttribute().getAttack());
            def.setText("DEFEND " + card.getAttribute().getDefense());
            pow.setText("POWER " + card.getAttribute().getPower());

            Text skill = (Text) bottom.getChildren().get(2);
            skill.setText(String.valueOf(card.getEffect()));
            skill.setFont(Font.font("Verdana", fontAtt));

        }

        temp.setId(String.valueOf(Math.random()));
        return temp;
    }
}
