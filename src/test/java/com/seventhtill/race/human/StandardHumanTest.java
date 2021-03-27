package com.seventhtill.race.human;

import com.seventhtill.race.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StandardHumanTest {
    private Race character;

    @BeforeEach
    void setUp() {
        character = new StandardHuman();
    }

    // Currently not implemented until I handle the UI for this
    @Test
    void addLanguage() {
    }

    @Test
    void getAbilityScoreIncrease() {
        // Arrange
        Map<String, Integer> expectedAbilityScores = new HashMap<>();
        expectedAbilityScores.put("Strength", 1);
        expectedAbilityScores.put("Dexterity", 1);
        expectedAbilityScores.put("Constitution", 1);
        expectedAbilityScores.put("Intelligence", 1);
        expectedAbilityScores.put("Wisdom", 1);
        expectedAbilityScores.put("Charisma", 1);
        // Act
        Map<String, Integer> actualAbilityScores =
                character.getAbilityScoreIncrease();
        //Assert
        assertEquals(expectedAbilityScores, actualAbilityScores);
    }

    @Test
    void getAbilities() {
        // Arrange
        ArrayList<String> expectedAbilities = new ArrayList<>();
        // Act
        ArrayList<String> actualAbilities = character.getAbilities();
        // Assert
        assertEquals(expectedAbilities, actualAbilities);
    }

    @Test
    void getLanguages() {
        // Arrange
        ArrayList<String> expectedLanguages = new ArrayList<>();
        expectedLanguages.add("Common");
        // Act
        ArrayList<String> actualLanguages = character.getLanguages();
        // Assert
        assertEquals(expectedLanguages, actualLanguages);
    }
}