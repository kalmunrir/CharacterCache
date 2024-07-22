package com.kalmunrir.charactercache.Database.Models.Secondary;

public class CharacterSurvivability extends SecondaryModel {
    private final int armorClass;
    private final int initiative;
    private final int speed;
    private final int totalHP;
    private int currentHP;
    private int tempHP;
    private final int passivePerception;
    private int deathSavesSuccess;
    private int deathSavesFail;
    private int inspiration;
    
    public CharacterSurvivability(int id, int foreignKey, int armorClass, int initiative, int speed, int totalHP, 
                                  int currentHP, int tempHP, int passivePerception, int deathSavesSuccess, 
                                  int deathSavesFail, int inspiration) {
        super(id, foreignKey);
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.totalHP = totalHP;
        this.currentHP = currentHP;
        this.tempHP = tempHP;
        this.passivePerception = passivePerception;
        this.deathSavesSuccess = deathSavesSuccess;
        this.deathSavesFail = deathSavesFail;
        this.inspiration = inspiration;
    }

    public int getArmorClass() {
        return this.armorClass;
    }

    public int getInitiative() {
        return this.initiative;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getTotalHP() {
        return this.totalHP;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getTempHP() {
        return this.tempHP;
    }

    public void setTempHP(int tempHP) {
        this.tempHP = tempHP;
    }

    public int getPassivePerception() {
        return this.passivePerception;
    }

    public int getDeathSavesSuccess() {
        return this.deathSavesSuccess;
    }

    public void setDeathSavesSuccess(int deathSavesSuccess) {
        this.deathSavesSuccess = deathSavesSuccess;
    }

    public int getDeathSavesFail() {
        return this.deathSavesFail;
    }

    public void setDeathSavesFail(int deathSavesFail) {
        this.deathSavesFail = deathSavesFail;
    }

    public int getInspiration() {
        return this.inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }
}