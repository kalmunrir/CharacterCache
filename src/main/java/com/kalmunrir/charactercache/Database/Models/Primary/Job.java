package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class Job extends Model {
    private final String name;
    private final int hitDie;
    private final String spellCastingAbility;

    public Job(int id, String name, int hitDie, String spellCastingAbility) {
        super(id);
        this.name = name;
        this.hitDie = hitDie;
        this.spellCastingAbility = spellCastingAbility;
    }

    public String getName() {
        return this.name;
    }

    public int getHitDie() {
        return this.hitDie;
    }

    public String getSpellCastingAbility() {
        return this.spellCastingAbility;
    }
}
