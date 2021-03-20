package com.seventhtill.item.armour;

public class HeavyArmour implements Armour {

    private int baseArmour;
    private String name;
    private boolean disadvantage;
    private int weight;

    public HeavyArmour(int baseArmour, String name, boolean disadvantage, int weight) {
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
    public int getArmourClassModifier(int dexModifier) {
        return getBaseArmour();
    }

    @Override
    public boolean isDisadvantage() {
        return disadvantage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
