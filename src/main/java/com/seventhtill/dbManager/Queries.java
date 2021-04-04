package com.seventhtill.dbManager;

import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.item.weapon.WeaponAttackType;

public class Queries {

    //Add an armour to the armour db
    String addArmour(DnDCharacterDTO DnDCharacterDTO) {
        String query = "INSERT INTO armour (name, disadvantage, baseArmour)" +
                " VALUES " + DnDCharacterDTO.getArmourName()
                + DnDCharacterDTO.isDisadvantage() + DnDCharacterDTO.getBaseArmour();
        return query;
    }

    //Add a weapon to the weapon db
    String addWeapon(DnDCharacterDTO DnDCharacterDTO) {
        String query = "INSERT INTO weapon (weight, properties, damageDie, damageType)" +
                " VALUES " + DnDCharacterDTO.getWeaponWeight() + DnDCharacterDTO.getProperties()
                + DnDCharacterDTO.getDamageDie() + DnDCharacterDTO.getDamageType();
        return query;
    }

    //Add a DnD Character to the dndcharacter db
    String addDnDCharacter(DnDCharacterDTO DnDCharacterDTO) {
        String query = "INSERT INTO dndcharacter (characterName, characterRace, characterClass, characterWeapon, characterArmour)" +
                " VALUES " + DnDCharacterDTO.getCharacterName() + DnDCharacterDTO.getCharacterRace()
                + DnDCharacterDTO.getCharacterClass() + DnDCharacterDTO.getCharacterWeapon() +
                DnDCharacterDTO.getCharacterArmour();
        return query;
    }

    //Retrieve DnD Characters where the weapon and armour ids match their armour and weapon table corresponding entries
    String retrieveDnDCharacter() {
        String query = "SELECT * FROM dndcharacter, armour, weapon" +
                " WHERE characterArmour = armour.id" +
                " OR characterWeapon = weapon.id";
        return query;
    }

    //Retrieve a weapon's id based on it's name
    String getWeaponID(Weapon weapon) {
        String name = weapon.getName();
        String query = "SELECT weapon.id FROM weapon WHERE weapon.name = " + name;
        return query;
    }

    //Update weapon based on it's id
    String updateWeapon(Weapon weapon, WeaponAttackType attackType, int id) {
        String query = "UPDATE weapon set weapon.name = " + weapon.getName() +
                ", weapon.weight = " + weapon.getWeight() +
                ", weapon.properties = " + weapon.getProperties() +
                ", weapon.damageType = " + attackType.getDamageType() +
                ", weapon.damageDie = " + attackType.getDamageDie() +
                ", WHERE weapon.id = " + id;
        return query;
    }

    //Retrieve an armour's id based on it's name
    String getArmourID(Armour armour) {
        String name = armour.getName();
        String query = "SELECT armour.id from armour WHERE armour.name = " + name;
        return query;
    }

    //Update armour based on it's id
    String updateArmour(Armour armour) {
        String query = "UPDATE armour set armour.name = " + armour.getName() +
                ", armour.weight = " + armour.getWeight() +
                ",armour.baseArmour = " + armour.getBaseArmour() +
                ",armour.disadvantage = " + armour.isDisadvantage() +
                ", WHERE armour.id = ";
        return query;
    }

    //Update a DnDCharacter based on it's original name.
    String updateDnDCharacter(DnDCharacterDTO DnDCharacterDTO, DnDCharacter DnDCharacter) {
        int armourID = 0;
        int weaponID = 0;
        String query = "UPDATE dndcharacter set dndcharacter.characterName = " + DnDCharacterDTO.getCharacterName() +
                ", dndcharacter.characterRace = " + DnDCharacterDTO.getCharacterRace() +
                ", dndcharacter.characterClass = " + DnDCharacterDTO.getCharacterClass() +
                ", WHERE dndcharacter.characterName = " + DnDCharacter.getCharacterName();
                //update armour and weapon based on the ids in the UI implementation
        return query;
    }
}
