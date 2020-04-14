package com.avatarduel.model.attribute;

public class RemainingPower {
    private int remainingAir;
    private int remainingWater;
    private int remainingEarth;
    private int remainingFire;
    private int remainingEnergy;

    public RemainingPower(int remainingAir, int remainingWater, int remainingEarth, int remainingFire, int remainingEnergy) {
        this.remainingAir = remainingAir;
        this.remainingWater = remainingWater;
        this.remainingEarth = remainingEarth;
        this.remainingFire = remainingFire;
        this.remainingEnergy = remainingEnergy;
    }

    public int getRemainingAir() {
        return remainingAir;
    }

    public void setRemainingAir(int remainingAir) {
        this.remainingAir = remainingAir;
    }

    public int getRemainingWater() {
        return remainingWater;
    }

    public void setRemainingWater(int remainingWater) {
        this.remainingWater = remainingWater;
    }

    public int getRemainingEarth() {
        return remainingEarth;
    }

    public void setRemainingEarth(int remainingEarth) {
        this.remainingEarth = remainingEarth;
    }

    public int getRemainingFire() {
        return remainingFire;
    }

    public void setRemainingFire(int remainingFire) {
        this.remainingFire = remainingFire;
    }

    public int getRemainingEnergy() {
        return remainingEnergy;
    }

    public void setRemainingEnergy(int remainingEnergy) {
        this.remainingEnergy = remainingEnergy;
    }
}
