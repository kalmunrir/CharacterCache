package com.kalmunrir.charactercache.Database.Models.Secondary;

public class CharacterSpellSlots extends SecondaryModel {
    private final int totalFirstLevelSS;
    private final int totalSecondLevelSS;
    private final int totalThirdLevelSS;
    private final int totalFourthLevelSS;
    private final int totalFifthLevelSS;
    private final int totalSixthLevelSS;
    private final int totalSeventhLevelSS;
    private final int totalEighthLevelSS;
    private final int totalNinthLevelSS;
    private int currentFirstLevelSS;
    private int currentSecondLevelSS;
    private int currentThirdLevelSS;
    private int currentFourthLevelSS;
    private int currentFifthLevelSS;
    private int currentSixthLevelSS;
    private int currentSeventhLevelSS;
    private int currentEighthLevelSS;
    private int currentNinthLevelSS;

    public CharacterSpellSlots(int id, int foreignKey, int totalFirstLevelSS, int totalSecondLevelSS,
                               int totalThirdLevelSS, int totalFourthLevelSS, int totalFifthLevelSS,
                               int totalSixthLevelSS, int totalSeventhLevelSS, int totalEighthLevelSS,
                               int totalNinthLevelSS, int currentFirstLevelSS, int currentSecondLevelSS,
                               int currentThirdLevelSS, int currentFourthLevelSS, int currentFifthLevelSS,
                               int currentSixthLevelSS, int currentSeventhLevelSS, int currentEighthLevelSS,
                               int currentNinthLevelSS) {
        super(id, foreignKey);
        this.totalFirstLevelSS = totalFirstLevelSS;
        this.totalSecondLevelSS = totalSecondLevelSS;
        this.totalThirdLevelSS = totalThirdLevelSS;
        this.totalFourthLevelSS = totalFourthLevelSS;
        this.totalFifthLevelSS = totalFifthLevelSS;
        this.totalSixthLevelSS = totalSixthLevelSS;
        this.totalSeventhLevelSS = totalSeventhLevelSS;
        this.totalEighthLevelSS = totalEighthLevelSS;
        this.totalNinthLevelSS = totalNinthLevelSS;
        this.currentFirstLevelSS = currentFirstLevelSS;
        this.currentSecondLevelSS = currentSecondLevelSS;
        this.currentThirdLevelSS = currentThirdLevelSS;
        this.currentFourthLevelSS = currentFourthLevelSS;
        this.currentFifthLevelSS = currentFifthLevelSS;
        this.currentSixthLevelSS = currentSixthLevelSS;
        this.currentSeventhLevelSS = currentSeventhLevelSS;
        this.currentEighthLevelSS = currentEighthLevelSS;
        this.currentNinthLevelSS = currentNinthLevelSS;
    }

    public int getTotalFirstLevelSS() {
        return this.totalFirstLevelSS;
    }

    public int getTotalSecondLevelSS() {
        return this.totalSecondLevelSS;
    }

    public int getTotalThirdLevelSS() {
        return this.totalThirdLevelSS;
    }

    public int getTotalFourthLevelSS() {
        return this.totalFourthLevelSS;
    }

    public int getTotalFifthLevelSS() {
        return this.totalFifthLevelSS;
    }

    public int getTotalSixthLevelSS() {
        return this.totalSixthLevelSS;
    }

    public int getTotalSeventhLevelSS() {
        return this.totalSeventhLevelSS;
    }

    public int getTotalEighthLevelSS() {
        return this.totalEighthLevelSS;
    }

    public int getTotalNinthLevelSS() {
        return this.totalNinthLevelSS;
    }

    public int getCurrentFirstLevelSS() {
        return this.currentFirstLevelSS;
    }

    public void setCurrentFirstLevelSS(int currentFirstLevelSS) {
        this.currentFirstLevelSS = currentFirstLevelSS;
    }

    public int getCurrentSecondLevelSS() {
        return this.currentSecondLevelSS;
    }

    public void setCurrentSecondLevelSS(int currentSecondLevelSS) {
        this.currentSecondLevelSS = currentSecondLevelSS;
    }

    public int getCurrentThirdLevelSS() {
        return this.currentThirdLevelSS;
    }

    public void setCurrentThirdLevelSS(int currentThirdLevelSS) {
        this.currentThirdLevelSS = currentThirdLevelSS;
    }

    public int getCurrentFourthLevelSS() {
        return this.currentFourthLevelSS;
    }

    public void setCurrentFourthLevelSS(int currentFourthLevelSS) {
        this.currentFourthLevelSS = currentFourthLevelSS;
    }

    public int getCurrentFifthLevelSS() {
        return this.currentFifthLevelSS;
    }

    public void setCurrentFifthLevelSS(int currentFifthLevelSS) {
        this.currentFifthLevelSS = currentFifthLevelSS;
    }

    public int getCurrentSixthLevelSS() {
        return this.currentSixthLevelSS;
    }

    public void setCurrentSixthLevelSS(int currentSixthLevelSS) {
        this.currentSixthLevelSS = currentSixthLevelSS;
    }

    public int getCurrentSeventhLevelSS() {
        return this.currentSeventhLevelSS;
    }

    public void setCurrentSeventhLevelSS(int currentSeventhLevelSS) {
        this.currentSeventhLevelSS = currentSeventhLevelSS;
    }

    public int getCurrentEighthLevelSS() {
        return this.currentEighthLevelSS;
    }

    public void setCurrentEighthLevelSS(int currentEighthLevelSS) {
        this.currentEighthLevelSS = currentEighthLevelSS;
    }

    public int getCurrentNinthLevelSS() {
        return this.currentNinthLevelSS;
    }

    public void setCurrentNinthLevelSS(int currentNinthLevelSS) {
        this.currentNinthLevelSS = currentNinthLevelSS;
    }
}
