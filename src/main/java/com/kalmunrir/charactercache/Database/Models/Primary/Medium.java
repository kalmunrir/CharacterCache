package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class Medium extends Model {
    private final String shortName;
    private final String name;

    public Medium(int id, String shortName, String name) {
        super(id);
        this.shortName = shortName;
        this.name = name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getName() {
        return this.name;
    }
}
