package com.seventhtill.race.halfling;

// Concrete class Stout halfling that extends base halfling
public class StoutHalfling extends Halfling {
    // Constructor
    public StoutHalfling() {
        super();
        addAbilityScoreIncrease();
        addAbility();
    }

    // Add stout halfling specific attributes
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Constitution", 1);
    }

    private void addAbility() {
        this.abilities.add("Stout Resilience");
    }
}
