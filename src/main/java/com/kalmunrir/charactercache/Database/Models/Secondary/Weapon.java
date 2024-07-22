package com.kalmunrir.charactercache.Database.Models.Secondary;

public class Weapon extends Item {
    private final String distance;
    private final int damageDie;
    private final int numDie;
    private final String damageType;
    
    public Weapon(int id, int foreignKey, String name, double pricePerUnit, int weightPerUnit, int quantity, 
                  String category, String description, String distance, int damageDie, int numDie, String damageType) {
        super(id, foreignKey, name, pricePerUnit, weightPerUnit, quantity, category, description);
        this.distance = distance;
        this.damageDie = damageDie;
        this.numDie = numDie;
        this.damageType = damageType;
    }

    public String getDistance() {
        return this.distance;
    }

    public int getDamageDie() {
        return this.damageDie;
    }

    public int getNumDie() {
        return this.numDie;
    }

    public String getDamageType() {
        return this.damageType;
    }
}
