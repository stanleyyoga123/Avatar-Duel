package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.avatarduel.builder.LandBuilder;
import com.avatarduel.controller.ArenaController;
import com.avatarduel.games.GameFlow;
import com.avatarduel.model.*;
import com.avatarduel.reader.CharacterReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.avatarduel.model.Land;
import com.avatarduel.reader.LandReader;

import static com.avatarduel.model.Element.AIR;

public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SKILLAURA_CSV_FILE_PATH = "card/data/character.csv";

  @Override
  public void start(Stage stage) {
    try{
      GameFlow startState = new GameFlow();

      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("fxml/Arena.fxml"));
      Parent root = loader.load(); // Manggil Controller
      Scene scene = new Scene(root,1600,900);
      stage.setScene(scene);
      stage.show();
      ((ArenaController) loader.getController()).init();
      ((ArenaController) loader.getController()).updateHand(1, startState.getPlayer1().getHandDeck());
      ((ArenaController) loader.getController()).updateHand(2, startState.getPlayer2().getHandDeck());
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    launch();
  }
}