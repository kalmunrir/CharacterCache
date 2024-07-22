package com.kalmunrir.charactercache.Database.Models.Join;



public class CharacterJob extends JoinModel {
    private final boolean first; // is this the first class or multiclass
    private final int level;
    private final boolean isXP; // is it xp or milestone level up
    private int currentXP;
    private int xpToLevelUp;
    private int currentNumHitDie;
    
    public CharacterJob(int id, int leftTableId, int rightTableId, boolean first, int level, boolean isXP, 
                        int currentXP, int xpToLevelUp, int currentNumHitDie) {
        super(id, leftTableId, rightTableId);
        this.first = first;
        this.level = level;
        this.isXP = isXP;
        this.currentXP = currentXP;
        this.xpToLevelUp = xpToLevelUp;
        this.currentNumHitDie = currentNumHitDie;
    }

    public boolean isFirst() {
        return this.first;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isXP() {
        return this.isXP;
    }

    public int getCurrentXP() {
        return this.currentXP;
    }

    public void setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
    }

    public int getXpToLevelUp() {
        return this.xpToLevelUp;
    }

    public void setXpToLevelUp(int xpToLevelUp) {
        this.xpToLevelUp = xpToLevelUp;
    }

    public int getCurrentNumHitDie() {
        return this.currentNumHitDie;
    }

    public void setCurrentNumHitDie(int currentNumHitDie) {
        this.currentNumHitDie = currentNumHitDie;
    }
}
