package com.kalmunrir.charactercache.Database.Models.Secondary;

public class MultijobRequirement extends SecondaryModel {
    private final String ability;
    private final int required;

    public MultijobRequirement(int id, int foreignKey, String ability, int required) {
        super(id, foreignKey);
        this.ability = ability;
        this.required = required;
    }


    public String getAbility() {
        return this.ability;
    }

    public int getRequired() {
        return this.required;
    }
}
