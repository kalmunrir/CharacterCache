package com.kalmunrir.charactercache.Database.Models.Secondary;

public class Item extends SecondaryModel {
    private String name;
    private double pricePerUnit;
    private int weightPerUnit;
    private int quantity;
    private String category;
    private String description;
    
    public Item(int id, int foreignKey, String name, double pricePerUnit, int weightPerUnit, int quantity,
                String category, String description) {
        super(id, foreignKey);
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.weightPerUnit = weightPerUnit;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerUnit() {
        return this.pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getWeightPerUnit() {
        return this.weightPerUnit;
    }

    public void setWeightPerUnit(int weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
