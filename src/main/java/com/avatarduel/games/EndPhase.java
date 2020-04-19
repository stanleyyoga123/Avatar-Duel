package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Class to control End Phase
 */

public class EndPhase extends GameState {

    /**
     * Set everthing into default
     * @param main Main
     */
    private void returnDefault(GameFlow main) {
        main.getPlayer1().setPlayedLand(false);
        main.getPlayer2().setPlayedLand(false);
        for(int i = 0; i < main.getUsedP1().size(); i++) {
            main.getUsedP1().remove(0);
        }
        for(int i = 0; i < main.getUsedP2().size(); i++) {
            main.getUsedP2().remove(0);
        }
        main.getPlayer1().getRemPower().setRemainingWater(main.getPlayer1().getPower().getWaterPower());
        main.getPlayer1().getRemPower().setRemainingFire(main.getPlayer1().getPower().getFirePower());
        main.getPlayer1().getRemPower().setRemainingAir(main.getPlayer1().getPower().getAirPower());
        main.getPlayer1().getRemPower().setRemainingEarth(main.getPlayer1().getPower().getEarthPower());
        main.getPlayer1().getRemPower().setRemainingEnergy(main.getPlayer1().getPower().getEnergyPower());
        main.getPlayer2().getRemPower().setRemainingWater(main.getPlayer2().getPower().getWaterPower());
        main.getPlayer2().getRemPower().setRemainingFire(main.getPlayer2().getPower().getFirePower());
        main.getPlayer2().getRemPower().setRemainingAir(main.getPlayer2().getPower().getAirPower());
        main.getPlayer2().getRemPower().setRemainingEarth(main.getPlayer2().getPower().getEarthPower());
        main.getPlayer2().getRemPower().setRemainingEnergy(main.getPlayer2().getPower().getEnergyPower());
        ((ArenaController)main.getLoader().getController()).setPower(1, main.getPlayer1());
        ((ArenaController)main.getLoader().getController()).setPower(2, main.getPlayer2());
    }

    /**
     * Set Event for End Phase
     * @param main Main
     */
    @Override
    public void event(GameFlow main) {
        if(main.getPlayer1().getDrawDeck().getCardSize() <= 0 || main.getPlayer1().getHealth() <= 0) {
            System.out.println("Player 2 Win");
            main.setGameState(new EndPhase());
            return;
        } else if(main.getPlayer2().getDrawDeck().getCardSize() <= 0 || main.getPlayer2().getHealth() <= 0) {
            System.out.println("Player 1 Win");
            main.setGameState(new EndPhase());
            return;
        }
        if(main.getCurPlayer() == 1) {
            main.setCurPlayer(2);
        } else {
            main.setCurPlayer(1);
        }
        returnDefault(main);
    }

    /**
     * Change State from End Phase into Draw Phase
     * @param main Main
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    @Override
    public void changeState(GameFlow main) throws IOException, URISyntaxException {
        if(main.getPlayer1().getDrawDeck().getCardSize() <= 0 || main.getPlayer1().getHealth() <= 0) {
            main.getGameState().deleteMouseClick(main);
            ((ArenaController)main.getLoader().getController()).setCurPhase("Player 2 Win");
            main.setGameState(new EndPhase());
            main.getGameState().event(main);
            System.out.println("Player 2 Win");
            return;
        } else if(main.getPlayer2().getDrawDeck().getCardSize() <= 0 || main.getPlayer2().getHealth() <= 0) {
            main.getGameState().deleteMouseClick(main);
            ((ArenaController)main.getLoader().getController()).setCurPhase("Player 1 Win");
            main.setGameState(new EndPhase());
            main.getGameState().event(main);
            System.out.println("Player 1 Win");
            return;
        }
        main.getGameState().deleteMouseClick(main);
        ((ArenaController)main.getLoader().getController()).setCurPhase("Draw Phase");
        main.setGameState(new DrawPhase());
        main.getGameState().event(main);
    }
}
