package com.kalmunrir.charactercache.Database.Models.Secondary;

public class TypicalSpeaker extends SecondaryModel {
    private final String name;

    public TypicalSpeaker(int id, int foreignKey, String name) {
        super(id, foreignKey);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
