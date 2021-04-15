package com.seventhtill.characterSheet;

import com.seventhtill.race.Race;
import com.seventhtill.race.elf.HighElf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DnDCharacterTest {
    private DnDCharacter aNewCharacter;
    @BeforeEach
    void setUp(){
        aNewCharacter = new DnDCharacter();
        //Create a race
        Race elf = new HighElf();
        aNewCharacter.setCharacterRace(elf);
    }

    @Test
    void setCharacterAttributes() {
        // Arrange
        HashMap<String, Integer> attrMap = new HashMap<>();
        attrMap.put("Strength", 1);
        attrMap.put("Dexterity", 1);
        attrMap.put("Constitution", 1);
        attrMap.put("Intelligence", 1);
        attrMap.put("Wisdom", 1);
        attrMap.put("Charisma", 1);
        //plus 2 dex, plus 1 int
        HashMap<String, Integer> expAttrMap = attrMap;
        expAttrMap.put("Dexterity",3);
        expAttrMap.put("Intelligence",2);
        // Act
        HashMap<String,Integer> actAttr = attrMap;
        aNewCharacter.setCharacterAttributes(actAttr);
        actAttr = (HashMap<String, Integer>) aNewCharacter.getCharacterAttributes();
        // Assert
        assertEquals(expAttrMap, actAttr);
    }
}