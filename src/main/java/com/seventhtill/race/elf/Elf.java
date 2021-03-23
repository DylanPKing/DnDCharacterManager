package com.seventhtill.race.elf;

import com.seventhtill.magic.Magical;
import com.seventhtill.race.Race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// The abstract class for all elves
public abstract class Elf implements Race, Magical {
    // Fields for traits/abilities common to every elf
    protected Map<String, Integer> abilityScoreIncrease;
    protected ArrayList<String> abilities;
    protected ArrayList<String> languages;

    // Constructor
    public Elf() {
        initAbilityScoreIncrease();
        initAbilities();
        initLanguages();
    }

    // Set up of the traits initially
    private  void initAbilityScoreIncrease() {
        this.abilityScoreIncrease = new HashMap<>();
        this.abilityScoreIncrease.put("Dexterity", 2);
    }

    private void initAbilities() {
        this.abilities = new ArrayList<>();
        this.abilities.add("Darkvision");
        this.abilities.add("Keen Senses");
        this.abilities.add("Fey Ancestry");
        this.abilities.add("Trance");
    }

    private void initLanguages() {
        this.languages = new ArrayList<>();
        this.languages.add("Common");
        this.languages.add("Elvish");
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
