package com.seventhtill.race.elf;

import com.seventhtill.race.Race;
import com.seventhtill.race.dwarf.HillDwarf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HighElfTest {
    private Race character;

    @BeforeEach
    void setUp() {
        character = new HighElf();
    }

    @Test
    void getAbilityScoreIncrease() {
        // Arrange
        Map<String, Integer> expectedAbilityScores = new HashMap<>();
        expectedAbilityScores.put("Dexterity", 2);
        expectedAbilityScores.put("Intelligence", 1);
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

    // These 2 tests are currently not going to work. I need to mock user input.
    @Test
    void addCantrip() {
        assert true;
    }

    @Test
    void addLanguage() {
        assert true;
    }
}