package com.avatarduel.games;

import com.avatarduel.controller.ArenaController;

public class EndPhase extends GameState {

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

    @Override
    public void setMouseClick(GameFlow main) {
        if(main.getCurPlayer() == 1) {
            main.setCurPlayer(2);
        } else {
            main.setCurPlayer(1);
        }
        returnDefault(main);
    }
}
