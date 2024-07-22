package com.kalmunrir.charactercache.Database.Models.Secondary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class SecondaryModel extends Model {
    private final int foreignKey;

    public SecondaryModel(int id, int foreignKey) {
        super(id);
        this.foreignKey = foreignKey;
    }

    public int getForeignKey() {
        return foreignKey;
    }
}
