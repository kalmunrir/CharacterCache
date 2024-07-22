package com.kalmunrir.charactercache.Database.Models.Primary;

import com.kalmunrir.charactercache.Database.Models.Model;

public class Spell extends Model {
    private final String name;
    private final int level;
    private final boolean ritual;
    private final boolean concentration;
    private final String castingTime;
    private final String distance;
    private final String duration;
    private final String materials;
    private final String description;

    public Spell(int id, String name, int level, boolean ritual, boolean concentration, String castingTime,
                 String distance, String duration, String materials, String description) {
        super(id);
        this.name = name;
        this.level = level;
        this.ritual = ritual;
        this.concentration = concentration;
        this.castingTime = castingTime;
        this.distance = distance;
        this.duration = duration;
        this.materials = materials;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isRitual() {
        return this.ritual;
    }

    public boolean isConcentration() {
        return this.concentration;
    }

    public String getCastingTime() {
        return this.castingTime;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getMaterials() {
        return this.materials;
    }

    public String getDescription() {
        return this.description;
    }
}
