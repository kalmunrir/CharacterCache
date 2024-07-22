package com.kalmunrir.charactercache.Database.Models.Secondary;

public class CharacterAbilityScore extends SecondaryModel {
    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;


    public CharacterAbilityScore(int id, int foreignKey, int strength, int dexterity, int constitution,
                                 int intelligence, int wisdom, int charisma) {
        super(id, foreignKey);
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getCharisma() {
        return this.charisma;
    }
}
