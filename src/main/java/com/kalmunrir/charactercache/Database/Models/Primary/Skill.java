package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class Skill extends Model {
    private final String name;
    private final String description;
    private final String ability;


    public Skill(int id, String name, String description, String ability) {
        super(id);
        this.name = name;
        this.description = description;
        this.ability = ability;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAbility() {
        return this.ability;
    }
}
