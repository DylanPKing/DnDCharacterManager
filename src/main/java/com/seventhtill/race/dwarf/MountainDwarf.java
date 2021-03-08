package com.seventhtill.race.dwarf;

import java.util.ArrayList;

// Concrete class for Mountain Dwarf that extends Dwarf
public class MountainDwarf extends Dwarf {
    // Constructor
    public MountainDwarf() {
        super();
        addAbilityScoreIncrease();
        addAbility();
    }

    // Add Dwarven Armour Training ability
    private void addAbility() {
        this.abilities.add("Dwarven Armour Training");
    }

    // Adding 2 wisdom to the ability scores
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Strength", 2);
    }
}
