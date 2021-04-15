package com.seventhtill.race.halfling;

// Concrete class Stout halfling that extends base halfling
public class StoutHalfling extends Halfling {
    private String name;
    // Constructor
    public StoutHalfling() {
        super();
        initName();
        addAbilityScoreIncrease();
        addAbility();
    }

    @Override
    public void initName() {
        this.name = "STOUT HALFLING";
    }

    // Add stout halfling specific attributes
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Constitution", 1);
    }

    private void addAbility() {
        this.abilities.add("Stout Resilience");
    }

    @Override
    public String getName() {
        return name;
    }
}
