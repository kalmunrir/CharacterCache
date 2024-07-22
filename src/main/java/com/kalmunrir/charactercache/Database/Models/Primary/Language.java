package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class Language extends Model {
    private final String name;
    private final String type;

    public Language(int id, String name, String type) {
        super(id);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
