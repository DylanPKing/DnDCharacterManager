package com.seventhtill.race.halfling;

import com.seventhtill.race.Race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Abstract class for all Halflings
public abstract class Halfling implements Race {
    // Fields for traits/abilities common to every halfling
    protected Map<String, Integer> abilityScoreIncrease;
    protected ArrayList<String> abilities;
    protected ArrayList<String> languages;

    // Constructor
    public Halfling() {
        initAbilityScoreIncrease();
        initAbilities();
        initLanguages();
    }

    // Setting up initial values
    private void initAbilityScoreIncrease() {
        this.abilityScoreIncrease = new HashMap<>();
        this.abilityScoreIncrease.put("Dexterity", 2);
    }

    private void initAbilities() {
        this.abilities = new ArrayList<>();
        this.abilities.add("Lucky");
        this.abilities.add("Brave");
        this.abilities.add("Halfling Nimbleness");
    }

    private void initLanguages() {
        this.languages = new ArrayList<>();
        this.languages.add("Common");
        this.languages.add("Halfling");
    }

    // Getters for the data
    public Map<String, Integer> getAbilityScoreIncrease() {
        // Imma return a deep copy of the actual map to ensure that it is safe.
        return  new HashMap<>(this.abilityScoreIncrease);
    }

    public ArrayList<String> getAbilities() {
        // Once again return a deep copy
        return new ArrayList<>(this.abilities);
    }

    public ArrayList<String> getLanguages() {
        // And here deep copy also
        return new ArrayList<>(this.languages);
    }
}
