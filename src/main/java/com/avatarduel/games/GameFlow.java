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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameFlow {

    private GameState gameState;
    private Player player1;
    private Player player2;
    private int curPlayer;
    private Scene scene;
    private Parent root;

    public Player getPlayer1() { return this.player1; }

    public Player getPlayer2() { return this.player2; }

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
    }

    public void gameLoop() throws IOException, URISyntaxException {

        // Start State
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/Arena.fxml"));
        root = loader.load(); // Manggil Controller
        scene = new Scene(root,1600,900);

        ((ArenaController) loader.getController()).init();
        ((ArenaController) loader.getController()).updateHand(1, this.getPlayer1().getHandDeck());
        ((ArenaController) loader.getController()).updateHand(2, this.getPlayer2().getHandDeck());

        gameState = new DrawPhase();
        gameState.start(curPlayer, player1, player2);
        ((ArenaController) loader.getController()).updateHand(1, this.getPlayer1().getHandDeck());
        ((ArenaController) loader.getController()).updateHand(2, this.getPlayer2().getHandDeck());

        if(gameState.getClass().getSimpleName().equals("DrawPhase")){
            gameState = new MainPhase1();
            gameState.setMouseClick(loader, curPlayer, player1, player2);
        }
    }

    public Scene getScene() { return this.scene; }

}
