package com.avatarduel.model.attribute;

/**
 * Class contains Power
 */

public class Power {
    private int airPower;
    private int waterPower;
    private int earthPower;
    private int firePower;
    private int energyPower;

    /**
     * Constructor for Power
     * @param airPower Air Power
     * @param waterPower Water Power
     * @param earthPower Earth Power
     * @param firePower Fire Power
     * @param energyPower Energy Power
     */
    public Power(int airPower, int waterPower, int earthPower, int firePower, int energyPower) {
        this.airPower = airPower;
        this.waterPower = waterPower;
        this.earthPower = earthPower;
        this.firePower = firePower;
        this.energyPower = energyPower;
    }

    /**
     * Getter for Air Power
     * @return Air
     */
    public int getAirPower() {
        return airPower;
    }

    /**
     * Setter for Air Power
     * @param airPower Air
     */
    public void setAirPower(int airPower) {
        this.airPower = airPower;
    }

    /**
     * Getter for Water Power
     * @return Water
     */
    public int getWaterPower() {
        return waterPower;
    }

    /**
     * Setter for Water Power
     * @param waterPower Water
     */
    public void setWaterPower(int waterPower) {
        this.waterPower = waterPower;
    }

    /**
     * Getter for Earth Power
     * @return Earth
     */
    public int getEarthPower() {
        return earthPower;
    }

    /**
     * Setter for Earth Power
     * @param earthPower Earth
     */
    public void setEarthPower(int earthPower) {
        this.earthPower = earthPower;
    }

    /**
     * Getter for Fire Power
     * @return Fire
     */
    public int getFirePower() {
        return firePower;
    }

    /**
     * Setter for Fire Power
     * @param firePower Fire
     */
    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    /**
     * Getter for Energy Power
     * @return Energy
     */
    public int getEnergyPower() {
        return energyPower;
    }

    /**
     * Setter for Energy Power
     * @param energyPower Energy
     */
    public void setEnergyPower(int energyPower) {
        this.energyPower = energyPower;
    }
}
