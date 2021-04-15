package com.seventhtill.race.elf;

import java.util.ArrayList;

// Concrete class High Elf that extends base elf
public class HighElf extends Elf {
    private String name;
    // Temporarily just storing the cantrips to be handled properly later on
    private ArrayList<String> cantrips;

    // Constructors
    public HighElf() {
        super();
        initName();
        addAbilityScoreIncrease();
        addAbility();
    }

    // Takes a string to learn the extra language and cantrip
    public HighElf(String extraLanguage, String cantrip) {
        super();
        initName();
        addAbilityScoreIncrease();
        addAbility();
        addCantrip(cantrip);
        addLanguage(extraLanguage);
    }

    @Override
    public void initName() {
        this.name = "HIGH ELF";
    }

    // Setting the High elf specific values
    private void addAbilityScoreIncrease() {
        this.abilityScoreIncrease.put("Intelligence", 1);
    }

    private void addAbility() {
        this.abilities.add("Elf Weapon Training");
    }

    public void addCantrip(String cantrip) {
        this.cantrips = new ArrayList<>();
        this.cantrips.add(cantrip);
    }

    public void addLanguage(String extraLanguage) {
        this.languages.add(extraLanguage);
    }

    @Override
    public String getName() {
        return name;
    }
}
