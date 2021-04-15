package com.seventhtill.race.halfling;

// Concrete class Light foot halfling that extends base halfling
public class LightfootHalfling extends Halfling {
    private String name;
    // Constructor
    public LightfootHalfling() {
        super();
        initName();
        addAbilityScoreIncrease();
        addAbility();
    }

    @Override
    public void initName() {
        this.name = "LIGHTFOOT HALFLING";
    }

    // Add light foot halfling specific attributes
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Charisma", 1);
    }

    private void addAbility() {
        this.abilities.add("Naturally Stealthy");
    }

    @Override
    public String getName() {
        return name;
    }
}
