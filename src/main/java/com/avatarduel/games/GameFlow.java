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

/**
 * Class to control the Game Flow
 */

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

    /**
     * Getter for Pair Aura Player 1
     * @return List of Integer
     */
    public ArrayList<Integer> getPairAuraP1() {
        return pairAuraP1;
    }

    /**
     * Getter for Pair Aura Player 2
     * @return List of Integer
     */
    public ArrayList<Integer> getPairAuraP2() {
        return pairAuraP2;
    }

    /**
     * Getter for Pair Power Up Player 1
     * @return List of Integer
     */
    public ArrayList<Integer> getPairPowerUpP1() {
        return pairPowerUpP1;
    }

    /**
     * Getter for Pair Power Up Player 2
     * @return List of Integer
     */
    public ArrayList<Integer> getPairPowerUpP2() {
        return pairPowerUpP2;
    }

    /**
     * Getter for Used Card Player 1
     * @return List of Integer
     */
    public ArrayList<Integer> getUsedP1() { return usedP1; }

    /**
     * Getter for Used Card Player 2
     * @return List of iNteger
     */
    public ArrayList<Integer> getUsedP2() { return usedP2; }

    /**
     * Getter Player 1
     * @return Player
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Getter Player 2
     * @return Player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Getter current player
     * @return int
     */
    public int getCurPlayer() {
        return curPlayer;
    }

    /**
     * Get the loader
     * @return FXMLLoader
     */
    public FXMLLoader getLoader() {
        return loader;
    }

    /**
     * Setter for current player
     * @param player Player
     */
    public void setCurPlayer(int player) { curPlayer = player; }

    /**
     * Event for Button
     * @param loader Loader
     */
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
            }
        });
    }

    /**
     * Cheat for the sake of debugging
     * @param cardHandP1 Card Hand Player 1
     * @param cardHandP2 Card Hand Player 2
     */
    private void cheat(ArrayList<Card> cardHandP1, ArrayList<Card> cardHandP2) {
        CharacterReader charRead = new CharacterReader();
        LandReader landRead = new LandReader();
        SkillReader skillRead = new SkillReader();
        List<Character> listChar = charRead.getCharacterList();
        List<Land> listLand = landRead.getLandList();
        List<Skill> listSkill = skillRead.getSkillList();
        try {
            charRead.loadCards();
            landRead.loadCards();
            skillRead.loadCards();
        }
        catch (Exception exc) {
            // do something about it
        }
        cardHandP1.add(listChar.get(0));
        cardHandP1.add(listChar.get(1));
        cardHandP1.add(listSkill.get(0));
        cardHandP1.add(listSkill.get(1));
        cardHandP1.add(listSkill.get(2));
        cardHandP1.add(listSkill.get(1));
        cardHandP1.add(listSkill.get(0));
        cardHandP2.add(listChar.get(0));
        cardHandP2.add(listChar.get(1));
        cardHandP2.add(listSkill.get(0));
        cardHandP2.add(listSkill.get(1));
        cardHandP2.add(listSkill.get(2));
        cardHandP2.add(listSkill.get(1));
        cardHandP2.add(listSkill.get(0));
    }

    /**
     * Start State
     * @throws IOException Input Output
     * @throws URISyntaxException URI
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
//        cheat(cardHandP1, cardHandP2);

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
        gameState.event(this);
        ((ArenaController) loader.getController()).getDeck1().updateHand(this.getPlayer1().getHandDeck());
        ((ArenaController) loader.getController()).getDeck2().updateHand(this.getPlayer2().getHandDeck());

        addButtonEvent(loader);
        ((ArenaController) loader.getController()).setP1Health(player1.getHealth());
        ((ArenaController) loader.getController()).setP2Health(player2.getHealth());
    }

    /**
     * Main game loop
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    public void gameLoop() throws IOException, URISyntaxException {
        if(curPlayer == 1) {
            ((ArenaController)getLoader().getController()).getDeck2().updateHand(new ArrayList<>());
        } else {
            ((ArenaController)getLoader().getController()).getDeck1().updateHand(new ArrayList<>());
        }
        gameState.changeState(this);
    }

    /**
     * Getter for scene
     * @return Scene
     */
    public Scene getScene() { return this.scene; }

    /**
     * Getter for GameState
     * @return GameState
     */
    public GameState getGameState() { return this.gameState; }

    /**
     * Setter for GameState
     * @param gameState GameState
     */
    public void setGameState(GameState gameState) { this.gameState = gameState; }

}
