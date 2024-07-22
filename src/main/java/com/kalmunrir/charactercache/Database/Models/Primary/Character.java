package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class Character extends Model {
    private String name;
    private String alignment;
    private String backstory;
    private String background;
    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;
    private String physicalDescription;
    private String politics;
    private final int proficiencyBonus;
    private final String playerName;
    private String notes;


    public Character(int id, String name, String alignment, String backstory, String background, 
                     String personalityTraits, String ideals, String bonds, String flaws, String physicalDescription, 
                     String politics, int proficiencyBonus, String playerName, String notes) {
        super(id);
        this.name = name;
        this.alignment = alignment;
        this.backstory = backstory;
        this.background = background;
        this.personalityTraits = personalityTraits;
        this.ideals = ideals;
        this.bonds = bonds;
        this.flaws = flaws;
        this.physicalDescription = physicalDescription;
        this.politics = politics;
        this.proficiencyBonus = proficiencyBonus;
        this.playerName = playerName;
        this.notes = notes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getBackstory() {
        return this.backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPersonalityTraits() {
        return this.personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return this.ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return this.bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return this.flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public String getPhysicalDescription() {
        return this.physicalDescription;
    }

    public void setPhysicalDescription(String physicalDescription) {
        this.physicalDescription = physicalDescription;
    }

    public String getPolitics() {
        return this.politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public int getProficiencyBonus() {
        return this.proficiencyBonus;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
