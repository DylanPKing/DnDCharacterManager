package com.seventhtill.race.human;

import com.seventhtill.race.Race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Abstract class for human
public abstract class Human implements Race {
    // Fields for traits/abilities common to every human
    protected Map<String, Integer> abilityScoreIncrease;
    protected ArrayList<String> abilities;
    protected ArrayList<String> languages;

    // Constructor
    public Human() {
        initAbilityScoreIncrease();
        initAbilities();
        initLanguages();
    }

    public Human(String extraLanguage) {
        initAbilityScoreIncrease();
        initAbilities();
        initLanguages();
        addLanguage(extraLanguage);
    }

    // Setting up base human attributes
    private void initAbilityScoreIncrease() {
        this.abilityScoreIncrease = new HashMap<>();
        // Humans get +1 to all ability scores
        this.abilityScoreIncrease.put("Strenght", 1);
        this.abilityScoreIncrease.put("Dexterity", 1);
        this.abilityScoreIncrease.put("Constitution", 1);
        this.abilityScoreIncrease.put("Intelligence", 1);
        this.abilityScoreIncrease.put("Wisdom", 1);
        this.abilityScoreIncrease.put("Charisma", 1);
    }

    private void initAbilities() {
        // Humans start with no abilities but need to init the arraylist
        this.abilities = new ArrayList<>();
    }

    private void initLanguages() {
        this.languages = new ArrayList<>();
        this.languages.add("Common");
    }

    public void addLanguage(String extraLanguage) {
        this.languages.add(extraLanguage);
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
