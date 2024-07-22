package com.kalmunrir.charactercache.Database.Models.Secondary;

public class Armor extends Item {
    private final String armorType;
    private final int armorClass;
    private final boolean withDex;
    private final int strengthReq;
    private final boolean stealthDis;

    public Armor(int id, int foreignKey, String name, double pricePerUnit, int weightPerUnit, int quantity,
                 String category, String description, String armorType, int armorClass, boolean withDex,
                 int strengthReq, boolean stealthDis) {
        super(id, foreignKey, name, pricePerUnit, weightPerUnit, quantity, category, description);
        this.armorType = armorType;
        this.armorClass = armorClass;
        this.withDex = withDex;
        this.strengthReq = strengthReq;
        this.stealthDis = stealthDis;
    }

    public String getArmorType() {
        return this.armorType;
    }

    public int getArmorClass() {
        return this.armorClass;
    }

    public boolean isWithDex() {
        return this.withDex;
    }

    public int getStrengthReq() {
        return this.strengthReq;
    }

    public boolean isStealthDis() {
        return this.stealthDis;
    }
}
