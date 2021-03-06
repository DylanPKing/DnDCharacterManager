package com.seventhtill.race.elf;

// Concrete class Wood elf that extends base elf
public class WoodElf extends Elf {
    // Constructor
    private String name;
    public WoodElf() {
        super();
        initName();
        addAbilityScoreIncrease();
        addAbility();
    }

    @Override
    public void initName() {
        this.name = "WOOD ELF";
    }

    // Setting the Wood elf specific values
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Wisdom", 1);
    }

    private void addAbility() {
        this.abilities.add("Elf Weapon Training");
        this.abilities.add("fleet of Foot");
        this.abilities.add("Mask of the Wild"); // Is this an item? or do i treat it as ability?
    }

    @Override
    public String getName() {
        return name;
    }
}
