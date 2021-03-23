package com.seventhtill.item.armour;

public class MediumArmour implements Armour {
    private int baseArmour;
    private String name;
    private boolean disadvantage;
    private int weight;

    public MediumArmour(int baseArmour, String name, boolean disadvantage, int weight) {
        this.baseArmour = baseArmour;
        this.name = name;
        this.disadvantage = disadvantage;
        this.weight = weight;
    }

    @Override
    public int getBaseArmour() {
        return baseArmour;
    }

    @Override
    public boolean isDisadvantage() {
        return disadvantage;
    }

    @Override
    public int getArmourClassModifier(int dexModifier) {
        dexModifier = Math.min(dexModifier, 2);
        return Armour.super.getArmourClassModifier(dexModifier);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
