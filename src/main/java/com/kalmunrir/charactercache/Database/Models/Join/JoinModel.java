package com.kalmunrir.charactercache.Database.Models.Join;

import com.kalmunrir.charactercache.Database.Models.Model;

public class JoinModel extends Model {
    private final int leftTableId;
    private final int rightTableId;

    public JoinModel(int id, int leftTableId, int rightTableId) {
        super(id);
        this.leftTableId = leftTableId;
        this.rightTableId = rightTableId;
    }

    public int getLeftTableId() {
        return leftTableId;
    }

    public int getRightTableId() {
        return rightTableId;
    }
}
