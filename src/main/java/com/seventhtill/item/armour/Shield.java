package com.seventhtill.item.armour;

public class Shield implements Armour {
    private int baseArmour;
    private String name;
    private int weight;

    public Shield() {
        this.baseArmour = 2;
        this.name = "Shield";
        this.weight = 6;
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
        return false;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return 0;
    }
}
