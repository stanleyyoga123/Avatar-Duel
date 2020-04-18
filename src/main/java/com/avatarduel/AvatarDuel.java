package com.avatarduel;

import com.avatarduel.games.GameFlow;
import com.avatarduel.model.Card;
import com.avatarduel.model.HandDeck;
import com.avatarduel.model.attribute.Deck;

import javafx.application.Application;
import javafx.stage.Stage;

public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SKILLAURA_CSV_FILE_PATH = "card/data/character.csv";

  @Override
  public void start(Stage stage) {
    try{
//      GameFlow startState = new GameFlow();
//
//      FXMLLoader loader = new FXMLLoader();
//      loader.setLocation(getClass().getResource("fxml/Arena.fxml"));
//      Parent root = loader.load(); // Manggil Controller
//      Scene scene = new Scene(root,1600,900);
//      stage.setScene(scene);
//      stage.show();
//      ((ArenaController) loader.getController()).init();
//      ((ArenaController) loader.getController()).updateHand(1, startState.getPlayer1().getHandDeck());
//      ((ArenaController) loader.getController()).updateHand(2, startState.getPlayer2().getHandDeck());
      GameFlow flow = new GameFlow();
      flow.gameLoop();
      stage.setScene(flow.getScene());
      stage.show();
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    launch();
  }
}