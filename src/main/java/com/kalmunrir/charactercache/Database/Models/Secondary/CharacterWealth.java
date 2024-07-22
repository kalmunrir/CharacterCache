package com.kalmunrir.charactercache.Database.Models.Secondary;

public class CharacterWealth extends SecondaryModel {
    private int copperPieces;
    private int silverPieces;
    private int electrumPieces;
    private int goldPieces;
    private int platinumPieces;
    private double totalWealth;
    
    public CharacterWealth(int id, int foreignKey, int copperPieces, int silverPieces, int electrumPieces, 
                           int goldPieces, int platinumPieces, double totalWealth) {
        super(id, foreignKey);
        this.copperPieces = copperPieces;
        this.silverPieces = silverPieces;
        this.electrumPieces = electrumPieces;
        this.goldPieces = goldPieces;
        this.platinumPieces = platinumPieces;
        this.totalWealth = totalWealth;
    }

    public int getCopperPieces() {
        return this.copperPieces;
    }

    public void setCopperPieces(int copperPieces) {
        this.copperPieces = copperPieces;
    }

    public int getSilverPieces() {
        return this.silverPieces;
    }

    public void setSilverPieces(int silverPieces) {
        this.silverPieces = silverPieces;
    }

    public int getElectrumPieces() {
        return this.electrumPieces;
    }

    public void setElectrumPieces(int electrumPieces) {
        this.electrumPieces = electrumPieces;
    }

    public int getGoldPieces() {
        return this.goldPieces;
    }

    public void setGoldPieces(int goldPieces) {
        this.goldPieces = goldPieces;
    }

    public int getPlatinumPieces() {
        return this.platinumPieces;
    }

    public void setPlatinumPieces(int platinumPieces) {
        this.platinumPieces = platinumPieces;
    }

    public double getTotalWealth() {
        return this.totalWealth;
    }

    public void setTotalWealth(double totalWealth) {
        this.totalWealth = totalWealth;
    }
}
