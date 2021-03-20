package com.seventhtill.race.dwarf;

import com.seventhtill.race.Race;
import java.util.*;

// Abstract class containing base information for a dwarf
public abstract class Dwarf implements Race {
    // Fields for traits/abilities common to every dwarf
    protected Map<String, Integer> abilityScoreIncrease;
    protected ArrayList<String> abilities;
    private ArrayList<String> languages;

    // Constructor for a base dwarf
    public Dwarf() {
        initAbilityScoreIncrease();
        initAbilities();
        initLanguages();
    }

    // Set up of the traits initially
    private  void initAbilityScoreIncrease() {
        this.abilityScoreIncrease = new HashMap<>();
        this.abilityScoreIncrease.put("Constitution", 2);
    }

    private void initAbilities() {
        this.abilities = new ArrayList<>();
        this.abilities.add("Darkvision");
        this.abilities.add("Dwarven Resilience");
        this.abilities.add("Dwarven Combat Training");
        this.abilities.add("Tool Proficiency");
        this.abilities.add("Stonecunning");
    }

    private void initLanguages() {
        this.languages = new ArrayList<>();
        this.languages.add("Common");
        this.languages.add("Dwarvish");
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
