package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class Feature extends Model {
    private final String name;
    private final int reqLevel;
    private final String description;

    public Feature(int id, String name, int reqLevel, String description) {
        super(id);
        this.name = name;
        this.reqLevel = reqLevel;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public int getReqLevel() {
        return this.reqLevel;
    }

    public String getDescription() {
        return this.description;
    }
}
