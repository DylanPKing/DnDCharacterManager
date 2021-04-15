package com.seventhtill.race.dwarf;

// Concrete class for Mountain Dwarf that extends Dwarf
public class MountainDwarf extends Dwarf {
    // Constructor
    private String name;
    public MountainDwarf() {
        super();
        initName();
        addAbilityScoreIncrease();
        addAbility();
    }

    @Override
    public void initName() {
        this.name = "MOUNTAIN DWARF";
    }

    // Add Dwarven Armour Training ability
    private void addAbility() {
        this.abilities.add("Dwarven Armour Training");
    }

    // Adding 2 wisdom to the ability scores
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Strength", 2);
    }

    @Override
    public String getName() {
        return name;
    }
}
