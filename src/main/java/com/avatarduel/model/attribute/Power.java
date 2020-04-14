package com.avatarduel.model.attribute;

public class Power {
    private int airPower;
    private int waterPower;
    private int earthPower;
    private int firePower;
    private int energyPower;

    public Power(int airPower, int waterPower, int earthPower, int firePower, int energyPower) {
        this.airPower = airPower;
        this.waterPower = waterPower;
        this.earthPower = earthPower;
        this.firePower = firePower;
        this.energyPower = energyPower;
    }

    public int getAirPower() {
        return airPower;
    }

    public void setAirPower(int airPower) {
        this.airPower = airPower;
    }

    public int getWaterPower() {
        return waterPower;
    }

    public void setWaterPower(int waterPower) {
        this.waterPower = waterPower;
    }

    public int getEarthPower() {
        return earthPower;
    }

    public void setEarthPower(int earthPower) {
        this.earthPower = earthPower;
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    public int getEnergyPower() {
        return energyPower;
    }

    public void setEnergyPower(int energyPower) {
        this.energyPower = energyPower;
    }
}
