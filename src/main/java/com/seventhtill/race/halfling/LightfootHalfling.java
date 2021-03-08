package com.seventhtill.race.halfling;

// Concrete class Light foot halfling that extends base halfling
public class LightfootHalfling extends Halfling {
    // Constructor
    public LightfootHalfling() {
        super();
        addAbilityScoreIncrease();
        addAbility();
    }

    // Add light foot halfling specific attributes
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Charisma", 1);
    }

    private void addAbility() {
        this.abilities.add("Naturally Stealthy");
    }
}
