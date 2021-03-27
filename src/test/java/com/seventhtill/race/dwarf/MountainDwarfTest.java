package com.seventhtill.race.dwarf;

import com.seventhtill.race.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MountainDwarfTest {
    private Race character;

    @BeforeEach
    void setUp() {
        character = new MountainDwarf();
    }

    @Test
    void getAbilityScoreIncrease() {
        // Arrange
        Map<String, Integer> expectedAbilityScores = new HashMap<>();
        expectedAbilityScores.put("Constitution", 2);
        expectedAbilityScores.put("Strength", 2);
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
        expectedAbilities.add("Darkvision");
        expectedAbilities.add("Dwarven Resilience");
        expectedAbilities.add("Dwarven Combat Training");
        expectedAbilities.add("Tool Proficiency");
        expectedAbilities.add("Stonecunning");
        expectedAbilities.add("Dwarven Armour Training");
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
        expectedLanguages.add("Dwarvish");
        // Act
        ArrayList<String> actualLanguages = character.getLanguages();
        // Assert
        assertEquals(expectedLanguages, actualLanguages);
    }
}