package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.avatarduel.builder.LandBuilder;
import com.avatarduel.controller.ArenaController;
import com.avatarduel.model.*;
import com.avatarduel.reader.CharacterReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;
import com.avatarduel.reader.LandReader;

import static com.avatarduel.model.Element.AIR;
import static com.avatarduel.model.Element.FIRE;

public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SKILLAURA_CSV_FILE_PATH = "card/data/character.csv";

  @Override
  public void start(Stage stage) {
    LandReader landReader = new LandReader();
    CharacterReader characterReader = new CharacterReader();

    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);

    try{
      landReader.loadCards();
      characterReader.loadCards();
    } catch(Exception e) {
      System.out.println(e);
    }

    ArrayList<Card> cardList = new ArrayList<Card>();
    Land card = new LandBuilder()
            .name("Aang")
            .description("He's Aang")
            .element(AIR)
            .build();
    cardList.add(card);
    cardList.add(card);
//    cardList.add(new Land());
//    cardList.add(new Character());
//    cardList.add(new Skill());
//    System.out.println(cardList.get(2).getClass().getSimpleName());
//    cardList.add(new LandBuilder().name("APALAH").element(FIRE).build());
    System.out.println(cardList.get(0).getClass().getSimpleName());

    try{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("fxml/Arena.fxml"));
      Parent root = loader.load(); // Manggil Controller
      Scene scene = new Scene(root,1600,900);
      stage.setScene(scene);
      stage.show();
      ((ArenaController) loader.getController()).init();
      ((ArenaController) loader.getController()).updateHand(1,cardList);
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    launch();
  }
}