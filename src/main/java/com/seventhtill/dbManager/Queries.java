package com.seventhtill.dbManager;

import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.dndclass.AbstractFactoryDndClass;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.FactoryProducerClass;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.item.weapon.WeaponAttackType;
import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;

import java.util.ArrayList;

import static java.lang.System.arraycopy;

public class Queries {

    //Add an armour to the armour db
    public static String addArmour(DnDCharacterDTO DnDCharacterDTO) {
        return "INSERT INTO armour (name, disadvantage, baseArmour)" +
                " VALUES " + DnDCharacterDTO.getArmourName()
                + DnDCharacterDTO.isDisadvantage() + DnDCharacterDTO.getBaseArmour();
    }

    //Add a weapon to the weapon db
    public static String addWeapon(DnDCharacterDTO DnDCharacterDTO) {
        return "INSERT INTO weapon (weight, properties, damageDie, damageType)" +
                " VALUES " + DnDCharacterDTO.getWeaponWeight() + DnDCharacterDTO.getProperties()
                + DnDCharacterDTO.getDamageDie() + DnDCharacterDTO.getDamageType();
    }

    //Add a DnD Character to the dndcharacter db
    public static String addDnDCharacter(DnDCharacterDTO DnDCharacterDTO) {
        return "INSERT INTO dndcharacter (characterName, characterRace, characterClass, characterWeapon, characterArmour)" +
                " VALUES " + DnDCharacterDTO.getCharacterName() + DnDCharacterDTO.getCharacterRace()
                + DnDCharacterDTO.getCharacterClass() + DnDCharacterDTO.getCharacterWeapon() +
                DnDCharacterDTO.getCharacterArmour();
    }

    //Retrieve DnD Characters where the weapon and armour ids match their armour and weapon table corresponding entries
    //public static String retrieveDnDCharacter() {
        //return "SELECT * FROM dndcharacter, armour, weapon" +
              //  " WHERE characterArmour = armour.id" +
               // " OR characterWeapon = weapon.id";
   // }

    //Retrieve DnD Characters where the weapon and armour ids match their armour and weapon table corresponding entries
    public static String retrieveDnDCharacter() {
        return "SELECT * FROM dndcharacter";
    }

    //Retrieve a weapon's id based on it's name
    public static String getWeaponID(Weapon weapon) {
        String name = weapon.getName();
        return "SELECT weapon.id FROM weapon WHERE weapon.name = " + name;
    }

    //Update weapon based on it's id
    public static String updateWeapon(Weapon weapon, WeaponAttackType attackType, int id) {
        return "UPDATE weapon set weapon.name = " + weapon.getName() +
                ", weapon.weight = " + weapon.getWeight() +
                ", weapon.properties = " + weapon.getProperties() +
                ", weapon.damageType = " + attackType.getDamageType() +
                ", weapon.damageDie = " + attackType.getDamageDie() +
                ", WHERE weapon.id = " + id;
    }

    //Retrieve an armour's id based on it's name
    public static String getArmourID(Armour armour) {
        String name = armour.getName();
        return "SELECT armour.id from armour WHERE armour.name = " + name;
    }

    //Update armour based on it's id
    public static String updateArmour(Armour armour) {
        return "UPDATE armour set armour.name = " + armour.getName() +
                ", armour.weight = " + armour.getWeight() +
                ",armour.baseArmour = " + armour.getBaseArmour() +
                ",armour.disadvantage = " + armour.isDisadvantage() +
                ", WHERE armour.id = ";
    }

    //Update a DnDCharacter based on it's original name.
    public static String updateDnDCharacter(String name, DnDCharacter newDnDCharacter) {
        return "UPDATE dndcharacter set dndcharacter.characterName = " + newDnDCharacter.getCharacterName() +
                ", dndcharacter.characterRace = " + newDnDCharacter.getCharacterRace() +
                ", dndcharacter.characterClass = " + newDnDCharacter.getCharacterClass() +
                ",dndcharacter.characterWeapon = " + newDnDCharacter.getCharacterWeapon() +
                ",dndcharacter.characterArmour = " + newDnDCharacter.getCharacterArmour() +
                ", WHERE dndcharacter.characterName = " + name;
    }

    public static String deleteDnDCharacter(String name) {
        return "DELETE from dndcharacter WHERE characterName = " + name;
    }
}
