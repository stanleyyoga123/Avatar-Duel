package com.avatarduel;

import com.avatarduel.games.GameFlow;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main Class
 */

public class AvatarDuel extends Application {

  @Override
  public void start(Stage stage) {
    try{
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