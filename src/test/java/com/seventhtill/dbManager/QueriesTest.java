package com.seventhtill.dbManager;

import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.common.DamageType;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.cleric.Cleric;
import com.seventhtill.dndclass.fighter.Fighter;
import com.seventhtill.dndclass.rogue.Rogue;
import com.seventhtill.dndclass.wizard.Wizard;
import com.seventhtill.item.Item;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.HeavyArmour;
import com.seventhtill.item.armour.LightArmour;
import com.seventhtill.item.armour.MediumArmour;
import com.seventhtill.item.weapon.*;
import com.seventhtill.race.Race;
import com.seventhtill.race.dwarf.HillDwarf;
import com.seventhtill.race.dwarf.MountainDwarf;
import com.seventhtill.race.elf.HighElf;
import com.seventhtill.race.halfling.Halfling;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class QueriesTest {
    private DnDCharacter aNewCharacter;
    private DnDCharacterDTO aDnDCharacterDTO;

    @BeforeEach
    void setUp(){
        //Set up builder

        //CharacterBuilder newCharacter = new CharacterSheet();
        //CharacterDirector characterDirector = new CharacterDirector(newCharacter);
        //characterDirector.makeCharacter();

        //Character
        //DnDCharacter aNewCharacter = characterDirector.getCharacter();

        //Set up sample races
        Race elf = new HighElf();
        Race dwarf = new HillDwarf();
        Race dwarf2 = new MountainDwarf();

        //Set up sample classes
        DnDClass cleric = new Cleric();
        DnDClass rogue = new Rogue();
        DnDClass fighter = new Fighter();

        //Sample attributes
        //Map<String, Integer> attributes = aNewCharacter.getCharacterAttributes();

        //Set up sample armours
        Armour heavyArmour = new HeavyArmour(20,"Platemail", false, 10);
        Armour mediumArmour = new MediumArmour(14, "Iron", false, 8);
        Armour lightArmour = new LightArmour(8, "Scale", true, 6);

        //Set up sample weapons
        WeaponAttackType prc = new MeleeWeaponAttack(6, DamageType.PIERCING);
        WeaponAttackType bld = new MeleeWeaponAttack(4, DamageType.BLUDGEONING);
        List<String> properties = null;
        Weapon simpleWeapon = new SimpleWeapon(bld, 4, "Light Hammer", properties);
        Weapon martialWeapon = new MartialWeapon(prc, 3, "Wabbajack", properties);

        //Item
        Item item = null;

        //Create an elf
        //aNewCharacter.setCharacterName("John boi");
        //aNewCharacter.setCharacterRace(elf);
        //aNewCharacter.setCharacterAttributes((HashMap<String, Integer>) attributes);
        //aNewCharacter.setCharacterClass(cleric);
        //aNewCharacter.setCharacterItems(item);
        //aNewCharacter.setCharacterArmour(mediumArmour);
        //aNewCharacter.setCharacterWeapon(simpleWeapon);

        //Create a DTO character
        aDnDCharacterDTO = new DnDCharacterDTO("Fella", dwarf, fighter, item, martialWeapon,
                heavyArmour, 20, "Platemail", false, 10,
                prc, 3, "Wabbajack", properties, 6, DamageType.PIERCING);
    }

    @Test
    void addArmour() {
        // Arranged in the beforeEach
        // Act
        String query = "INSERT INTO armourTest (name, disadvantage, baseArmour)" +
                " VALUES " + aDnDCharacterDTO.getArmourName()
                + aDnDCharacterDTO.isDisadvantage() + aDnDCharacterDTO.getBaseArmour();
        String retrieveQuery = "SELECT * from armourTest WHERE name = " + aDnDCharacterDTO.getArmourName();
        // Assert
        assertEquals(query, retrieveQuery);
    }

    @Test
    void addWeapon() {
    }

    @Test
    void addDnDCharacter() {
    }

    @Test
    void retrieveDnDCharacter() {
    }

    @Test
    void getWeaponID() {
    }

    @Test
    void updateWeapon() {
    }

    @Test
    void getArmourID() {
    }

    @Test
    void updateArmour() {
    }

    @Test
    void updateDnDCharacter() {
    }
}