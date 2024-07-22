package com.kalmunrir.charactercache.Database.Models.Join;

public class CharacterSkill extends JoinModel {
    private final int modifier;
    private final boolean expertise;

    public CharacterSkill(int id, int characterId, int skillId, int modifier,boolean expertise) {
        super(id, characterId, skillId);
        this.modifier = modifier;
        this.expertise = expertise;
    }

    public int getModifier() {
        return modifier;
    }

    public boolean isExpertise() {
        return expertise;
    }
}
