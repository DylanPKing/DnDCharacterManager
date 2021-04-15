package com.seventhtill.race.elf;

import com.seventhtill.race.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WoodElfTest {
    private Race character;

    @BeforeEach
    void setUp() {
        character = new WoodElf();
    }

    @Test
    void getAbilityScoreIncrease() {
        // Arrange
        Map<String, Integer> expectedAbilityScores = new HashMap<>();
        expectedAbilityScores.put("Dexterity", 2);
        expectedAbilityScores.put("Wisdom", 1);
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
        expectedAbilities.add("Keen Senses");
        expectedAbilities.add("Fey Ancestry");
        expectedAbilities.add("Trance");
        expectedAbilities.add("Elf Weapon Training");
        expectedAbilities.add("fleet of Foot");
        expectedAbilities.add("Mask of the Wild");
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
        expectedLanguages.add("Elvish");
        // Act
        ArrayList<String> actualLanguages = character.getLanguages();
        // Assert
        assertEquals(expectedLanguages, actualLanguages);
    }
}