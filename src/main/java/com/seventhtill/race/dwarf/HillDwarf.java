package com.seventhtill.race.dwarf;

import java.util.ArrayList;

// Concrete class Hill Dwarf that extends Dwarf
public class HillDwarf extends Dwarf{
    // Temporarily storing the Dwarven Toughness (HP +1) in a list. Needs to be
    // handled later once character is setup. Possibly use command.
    private ArrayList<String> uniqueTraits;

    // Constructor
    public HillDwarf() {
        super();
        initUniqueTraits();
        addAbilityScoreIncrease();
    }

    // Set up the unique traits value
    private void initUniqueTraits() {
        this.uniqueTraits = new ArrayList<>();
        this.uniqueTraits.add("Dwarven Toughness");
    }

    // Adding 2 wisdom to the ability scores
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Wisdom", 1);
    }
}
