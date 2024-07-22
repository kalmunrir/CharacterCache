package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class AbilityBonus extends Model {
    private final String ability;
    private final int bonus;


    public AbilityBonus(int id, String ability, int bonus) {
        super(id);
        this.ability = ability;
        this.bonus = bonus;
    }

    public String getAbility() {
        return this.ability;
    }

    public int getBonus() {
        return this.bonus;
    }
}
