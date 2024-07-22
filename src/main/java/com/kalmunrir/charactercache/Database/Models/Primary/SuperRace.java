package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class SuperRace extends Model {
    private final String name;

    public SuperRace(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
