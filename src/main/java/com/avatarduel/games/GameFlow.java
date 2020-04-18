package com.avatarduel.games;

import java.util.*;

import com.avatarduel.controller.ArenaController;
import com.avatarduel.model.*;
import com.avatarduel.model.Character;
import com.avatarduel.model.attribute.Deck;
import com.avatarduel.model.attribute.MidDeck;
import com.avatarduel.model.attribute.Power;
import com.avatarduel.model.attribute.RemainingPower;
import com.avatarduel.reader.CharacterReader;
import com.avatarduel.reader.LandReader;
import com.avatarduel.reader.SkillReader;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameFlow {

    private GameState gameState;
    private ArrayList<Integer> pairAuraP1;
    private ArrayList<Integer> pairPowerUpP1;
    private ArrayList<Integer> pairAuraP2;
    private ArrayList<Integer> pairPowerUpP2;
    private ArrayList<Integer> usedP1;
    private ArrayList<Integer> usedP2;
    private Player player1;
    private Player player2;
    private int curPlayer;
    private Scene scene;
    private Parent root;
    private String curState;
    private FXMLLoader loader;

    public ArrayList<Integer> getPairAuraP1() {
        return pairAuraP1;
    }

    public ArrayList<Integer> getPairAuraP2() {
        return pairAuraP2;
    }

    public ArrayList<Integer> getPairPowerUpP1() {
        return pairPowerUpP1;
    }

    public ArrayList<Integer> getPairPowerUpP2() {
        return pairPowerUpP2;
    }

    public ArrayList<Integer> getUsedP1() { return usedP1; }

    public ArrayList<Integer> getUsedP2() { return usedP2; }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getCurPlayer() {
        return curPlayer;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setCurPlayer(int player) { curPlayer = player; }

    public void addButtonEvent(FXMLLoader loader) {
        Button button = ((ArenaController)loader.getController()).getButton();
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameLoop();
                } catch (Exception e) {
                    //;
                }
                if(curState.equals("Draw Phase")){
                    curState = "Main Phase 1";
                }
                else if(curState.equals("Main Phase 1")){
                    curState = "Battle Phase";
                }
                else{
                    curState = "Draw Phase";
                }
            }
        });
    }

    /**
     * Start State
     */
    public GameFlow() throws IOException, URISyntaxException {

        pairAuraP1 = new ArrayList<Integer>();
        pairAuraP2 = new ArrayList<Integer>();
        pairPowerUpP1 = new ArrayList<Integer>();
        pairPowerUpP2 = new ArrayList<Integer>();
        usedP1 = new ArrayList<Integer>();
        usedP2 = new ArrayList<Integer>();

        ArrayList<Card> cardMidTopP1 = new ArrayList<Card>();
        ArrayList<Card> cardMidBotP1 = new ArrayList<Card>();
        ArrayList<Card> cardMidTopP2 = new ArrayList<Card>();
        ArrayList<Card> cardMidBotP2 = new ArrayList<Card>();

        ArrayList<Card> cardHandP1 = new ArrayList<Card>();
        ArrayList<Card> cardHandP2 = new ArrayList<Card>();

        Deck p1Deck = new Deck();
        Deck p2Deck = new Deck();

        // Inititate Card Hand
        for(int i = 0; i < 7; i++){
            cardHandP1.add(p1Deck.draw());
            cardHandP2.add(p2Deck.draw());
        }

        player1 = new Player(
                cardHandP1,
                80,
                false,
                new MidDeck(
                        cardMidTopP1,
                        cardMidBotP1
                ),
                p1Deck,
                new Power(0, 0, 0, 0, 0),
                new RemainingPower(0, 0, 0, 0, 0)
        );

        player2 = new Player(
                cardHandP2,
                80,
                false,
                new MidDeck(
                        cardMidTopP2,
                        cardMidBotP2
                ),
                p2Deck,
                new Power(0, 0, 0, 0, 0),
                new RemainingPower(0, 0, 0, 0, 0)
        );

        this.curPlayer = 2;
        this.curState = "Draw Phase";

        // Start State
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/Arena.fxml"));
        root = loader.load(); // Manggil Controller
        scene = new Scene(root,1600,900);

        ((ArenaController) loader.getController()).init();
        ((ArenaController) loader.getController()).getDeck1().updateHand(this.getPlayer1().getHandDeck());
        ((ArenaController) loader.getController()).getDeck2().updateHand(this.getPlayer2().getHandDeck());

        gameState = new DrawPhase();
        gameState.setMouseClick(this);
        ((ArenaController) loader.getController()).getDeck1().updateHand(this.getPlayer1().getHandDeck());
        ((ArenaController) loader.getController()).getDeck2().updateHand(this.getPlayer2().getHandDeck());

        addButtonEvent(loader);
        ((ArenaController) loader.getController()).setP1Health(player1.getHealth());
        ((ArenaController) loader.getController()).setP2Health(player2.getHealth());
    }

    public void gameLoop() throws IOException, URISyntaxException {
        System.out.println("CURRENT PLAYER = " + curPlayer);
        if(curPlayer == 1) {
            ((ArenaController)getLoader().getController()).getDeck2().updateHand(new ArrayList<>());
        } else {
            ((ArenaController)getLoader().getController()).getDeck1().updateHand(new ArrayList<>());
        }
        if(gameState.getClass().getSimpleName().equals("DrawPhase")){
            gameState.deleteMouseClick(this);
            gameState = new MainPhase1();
            ((ArenaController)loader.getController()).setCurPhase("Main Phase 1");
            gameState.setMouseClick(this);
            System.out.println("Main Phase 1");

        }
        else if(gameState.getClass().getSimpleName().equals("MainPhase1")){
            gameState.deleteMouseClick(this);
            gameState = new BattlePhase();
            gameState.setMouseClick(this);
            ((ArenaController)loader.getController()).setCurPhase("Battle Phase");
            System.out.println("Battle Phase");
        }
        else if(gameState.getClass().getSimpleName().equals("BattlePhase")){
            gameState.deleteMouseClick(this);
            gameState = new EndPhase();
            ((ArenaController)loader.getController()).setCurPhase("End Phase");
            gameState.setMouseClick(this);
            System.out.println("End Phase");
        }
        else{
            gameState.deleteMouseClick(this);
            gameState = new DrawPhase();
            ((ArenaController)loader.getController()).setCurPhase("Draw Phase");
            gameState.setMouseClick(this);
            System.out.println("Draw Phase");
        }
    }

    public Scene getScene() { return this.scene; }

}
