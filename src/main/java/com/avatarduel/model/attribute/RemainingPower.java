package com.avatarduel.model.attribute;

/**
 * Class Contains Remaining Power
 */

public class RemainingPower {
    private int remainingAir;
    private int remainingWater;
    private int remainingEarth;
    private int remainingFire;
    private int remainingEnergy;

    /**
     * Constructor for Remaining Power
     * @param remainingAir Remaining Air
     * @param remainingWater Remaining Water
     * @param remainingEarth Remaining Earth
     * @param remainingFire Remaining Fire
     * @param remainingEnergy Remaining Energy
     */
    public RemainingPower(int remainingAir, int remainingWater, int remainingEarth, int remainingFire, int remainingEnergy) {
        this.remainingAir = remainingAir;
        this.remainingWater = remainingWater;
        this.remainingEarth = remainingEarth;
        this.remainingFire = remainingFire;
        this.remainingEnergy = remainingEnergy;
    }

    /**
     * Getter for Remaining Air
     * @return Air
     */
    public int getRemainingAir() {
        return remainingAir;
    }

    /**
     * Setter for Remaining Air
     * @param remainingAir Air
     */
    public void setRemainingAir(int remainingAir) {
        this.remainingAir = remainingAir;
    }

    /**
     * Getter for Remaining Water
     * @return Water
     */
    public int getRemainingWater() {
        return remainingWater;
    }

    /**
     * Setter for Remaining Water
     * @param remainingWater Water
     */
    public void setRemainingWater(int remainingWater) {
        this.remainingWater = remainingWater;
    }

    /**
     * Getter for Remaining Earth
     * @return Earth
     */
    public int getRemainingEarth() {
        return remainingEarth;
    }

    /**
     * Setter for Remaining Earth
     * @param remainingEarth Earth
     */
    public void setRemainingEarth(int remainingEarth) {
        this.remainingEarth = remainingEarth;
    }

    /**
     * Getter for Remaining Fire
     * @return Fire
     */
    public int getRemainingFire() {
        return remainingFire;
    }

    /**
     * Setter for Remaining Fire
     * @param remainingFire Fire
     */
    public void setRemainingFire(int remainingFire) {
        this.remainingFire = remainingFire;
    }

    /**
     * Getter for Remaining Energy
     * @return Energy
     */
    public int getRemainingEnergy() {
        return remainingEnergy;
    }

    /**
     * Setter for Remaining Energy
     * @param remainingEnergy Energy
     */
    public void setRemainingEnergy(int remainingEnergy) {
        this.remainingEnergy = remainingEnergy;
    }
}
