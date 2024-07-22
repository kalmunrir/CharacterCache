package com.kalmunrir.charactercache.Database.Models.Secondary;

public class Subjob extends SecondaryModel {
    private final String name;
    private final String description;

    public Subjob(int id, int foreignKey, String name, String description) {
        super(id, foreignKey);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
