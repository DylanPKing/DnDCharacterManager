package com.seventhtill.race.halfling;

import com.seventhtill.race.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LightfootHalflingTest {
    private Race character;

    @BeforeEach
    void setUp() {
        character = new LightfootHalfling();
    }

    @Test
    void getAbilityScoreIncrease() {
        // Arrange
        Map<String, Integer> expectedAbilityScores = new HashMap<>();
        expectedAbilityScores.put("Dexterity", 2);
        expectedAbilityScores.put("Charisma", 1);
        // Act
        Map<String, Integer> actualAbilityScores =
                character.getAbilityScoreIncrease();
        // Assert
        assertEquals(expectedAbilityScores, actualAbilityScores);
    }

    @Test
    void getAbilities() {
        // Arrange
        ArrayList<String> expectedAbilities = new ArrayList<>();
        expectedAbilities.add("Lucky");
        expectedAbilities.add("Brave");
        expectedAbilities.add("Halfling Nimbleness");
        expectedAbilities.add("Naturally Stealthy");
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
        expectedLanguages.add("Halfling");
        // Act
        ArrayList<String> actualLanguages = character.getLanguages();
        // Assert
        assertEquals(expectedLanguages, actualLanguages);
    }
}