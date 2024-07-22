package com.kalmunrir.charactercache.Database.Models.Secondary;

public class Race extends SecondaryModel {
    private final String name;
    private final String size;
    private final int walkSpeed;
    private final int flySpeed;
    private final int swimSpeed;

    public Race(int id, int foreignKey, String name, String size, int walkSpeed, int flySpeed, int swimSpeed) {
        super(id, foreignKey);
        this.name = name;
        this.size = size;
        this.walkSpeed = walkSpeed;
        this.flySpeed = flySpeed;
        this.swimSpeed = swimSpeed;
    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.size;
    }

    public int getWalkSpeed() {
        return this.walkSpeed;
    }

    public int getFlySpeed() {
        return this.flySpeed;
    }

    public int getSwimSpeed() {
        return this.swimSpeed;
    }
}
