package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.avatarduel.loader.LandLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;
import com.avatarduel.loader.CardLoader;
import com.avatarduel.reader.LandReader;

public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SKILLAURA_CSV_FILE_PATH = "card/data/character.csv";
  
  @Override
  public void start(Stage stage) {
    LandReader landReader = new LandReader();

    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);

    try{
      landReader.loadCards();
    } catch(Exception e) {
      System.out.println(e);
    }

    try{
      CardLoader loader = new LandLoader("Land", landReader.getLandList().get(0).getName(), landReader.getLandList().get(0).getDescription());
      loader.init();
      Parent root = loader.getLoader().load();
      stage.setTitle("Hello World");
      stage.setScene(new Scene(root, 400, 500));
      stage.show();
    } catch(Exception e) {
      System.out.println(e);
    }

  }

  public static void main(String[] args) {
    launch();
  }
}