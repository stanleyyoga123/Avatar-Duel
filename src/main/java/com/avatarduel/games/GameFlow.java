package com.avatarduel.games;

import java.util.*;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.builder.PlayerBuilder;
import com.avatarduel.controller.ArenaController;
import com.avatarduel.model.*;
import com.avatarduel.model.Character;
import com.avatarduel.reader.CharacterReader;
import com.avatarduel.reader.LandReader;
import com.avatarduel.reader.SkillReader;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameFlow {

    private GameState gameState;
    private ArrayList<Pair<Card, Card>> pairAura;
    private ArrayList<Pair<Card, Card>> pairPowerUp;
    private Player player1;
    private Player player2;
    private int curPlayer;
    private Scene scene;
    private Parent root;
    private String curState;
    private FXMLLoader loader;

    public Player getPlayer1() { return this.player1; }

    public Player getPlayer2() { return this.player2; }

    public void addButtonEvent(FXMLLoader loader) {
        Button button = ((ArenaController)loader.getController()).getButton();
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameLoop();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                if(curState.equals("Draw Phase")){
                    curState = "Main Phase 1";
                }
                else if(curState.equals("Main Phase 1")){
                    curState = "Battle Phase";
                }
                else if(curState.equals("Battle Phase")){
                    curState = "Main Phase 2";
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
        Random ran = new Random();

        Stack<Card> drawDeckP1 = new Stack<Card>();
        Stack<Card> drawDeckP2 = new Stack<Card>();
        CharacterReader characterReader = new CharacterReader();
        LandReader landReader = new LandReader();
        SkillReader skillReader = new SkillReader();

        characterReader.loadCards();
        landReader.loadCards();
        skillReader.loadCards();

        ArrayList<Card> cardMidTopP1 = new ArrayList<Card>();
        ArrayList<Card> cardMidBotP1 = new ArrayList<Card>();
        ArrayList<Card> cardMidTopP2 = new ArrayList<Card>();
        ArrayList<Card> cardMidBotP2 = new ArrayList<Card>();

        ArrayList<Card> cardHandP1 = new ArrayList<Card>();
        ArrayList<Card> cardHandP2 = new ArrayList<Card>();


        List<Character> listCharacter = characterReader.getCharacterList();
        List<Land> listLand = landReader.getLandList();
        List<Skill> listSkill = skillReader.getSkillList();

        for(int i = 0; i < 60; i++){
            int te = ran.nextInt(3);
            if(te == 0){
                drawDeckP1.add(listCharacter.get(ran.nextInt(48)));
            }
            else if(te == 1){
                drawDeckP1.add(listLand.get(ran.nextInt(16)));
            }
            else{
                drawDeckP1.add(listSkill.get(ran.nextInt(28)));
            }
            te = ran.nextInt(3);
            if(te == 0){
                drawDeckP2.add(listCharacter.get(ran.nextInt(48)));
            }
            else if(te == 1){
                drawDeckP2.add(listLand.get(ran.nextInt(16)));
            }
            else{
                drawDeckP2.add(listSkill.get(ran.nextInt(28)));
            }
        }

        for(int i = 0; i < 7; i++){
            int te = ran.nextInt(3);
            if(te == 0){
                cardHandP1.add(listCharacter.get(ran.nextInt(48)));
            }
            else if(te == 1){
                cardHandP1.add(listLand.get(ran.nextInt(16)));
            }
            else{
                cardHandP1.add(listSkill.get(ran.nextInt(28)));
            }
            te = ran.nextInt(3);
            if(te == 0){
                cardHandP2.add(listCharacter.get(ran.nextInt(48)));
            }
            else if(te == 1){
                cardHandP2.add(listLand.get(ran.nextInt(16)));
            }
            else{
                cardHandP2.add(listSkill.get(ran.nextInt(28)));
            }
        }
        for(int i = 0; i < 7; i++){
            System.out.print(cardHandP1.get(i).getClass().getSimpleName());
            System.out.println(" " + cardHandP1.get(i).getName());
        }
        player1 = new PlayerBuilder()
                .player(1)
                .drawDeck(drawDeckP1)
                .health(80)
                .waterPower(0)
                .airPower(0)
                .earthPower(0)
                .firePower(0)
                .handDeck(cardHandP1)
                .midTopDeck(cardMidTopP1)
                .midBotDeck(cardMidBotP1)
                .remainingWater(0)
                .remainingAir(0)
                .remainingEarth(0)
                .remainingFire(0)
                .isPlayedLand(false)
                .build();

        player2 = new PlayerBuilder()
                .player(2)
                .drawDeck(drawDeckP2)
                .health(80)
                .waterPower(0)
                .airPower(0)
                .earthPower(0)
                .firePower(0)
                .handDeck(cardHandP2)
                .midTopDeck(cardMidTopP2)
                .midBotDeck(cardMidBotP2)
                .remainingWater(0)
                .remainingAir(0)
                .remainingEarth(0)
                .remainingFire(0)
                .isPlayedLand(false)
                .build();

        this.curPlayer = 1;
        this.curState = "Draw Phase";

        // Start State
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/Arena.fxml"));
        root = loader.load(); // Manggil Controller
        scene = new Scene(root,1600,900);

        ((ArenaController) loader.getController()).init();
        ((ArenaController) loader.getController()).updateHand(1, this.getPlayer1().getHandDeck());
        ((ArenaController) loader.getController()).updateHand(2, this.getPlayer2().getHandDeck());

        gameState = new DrawPhase();
        gameState.setMouseClick(loader, curPlayer, player1, player2);
        ((ArenaController) loader.getController()).updateHand(1, this.getPlayer1().getHandDeck());
        ((ArenaController) loader.getController()).updateHand(2, this.getPlayer2().getHandDeck());

        addButtonEvent(loader);
    }

    public void gameLoop() throws IOException, URISyntaxException {
        if(gameState.getClass().getSimpleName().equals("DrawPhase")){
            gameState = new MainPhase1();
            gameState.setMouseClick(loader, curPlayer, player1, player2);
            System.out.println("Main Phase 1");
        }
        else if(gameState.getClass().getSimpleName().equals("MainPhase1")){
            gameState = new BattlePhase();
            System.out.println("Battle Phase");
        }
        else if(gameState.getClass().getSimpleName().equals("BattlePhase")){
            gameState = new MainPhase2();
            System.out.println("Main Phase 2");
        }
        else if(gameState.getClass().getSimpleName().equals("MainPhase2")){
            gameState = new EndPhase();
            System.out.println("End Phase");
        }
        else{
            gameState = new DrawPhase();
            System.out.println("Draw Phase");
        }
    }

    public Scene getScene() { return this.scene; }

}
