package com.seventhtill.dbManager;

public class Queries {

    String addArmour(DnDCharacterDTO DnDCharacterDTO) {
        String query = "INSERT INTO armour (name, disadvantage, baseArmour)" +
                " VALUES " + DnDCharacterDTO.getArmourName()
                + DnDCharacterDTO.isDisadvantage() + DnDCharacterDTO.getBaseArmour();
        return query;
    }

    String addWeapon(DnDCharacterDTO DnDCharacterDTO) {
        String query = "INSERT INTO weapon (weight, properties, damageDie, damageType)" +
                " VALUES " + DnDCharacterDTO.getWeaponWeight() + DnDCharacterDTO.getProperties()
                + DnDCharacterDTO.getDamageDie() + DnDCharacterDTO.getDamageType();
        return query;
    }

    String addDnDCharacter(DnDCharacterDTO DnDCharacterDTO) {
        String query = "INSERT INTO dndcharacter (characterName, characterRace, characterClass, characterWeapon, characterArmour)" +
                " VALUES " + DnDCharacterDTO.getCharacterName() + DnDCharacterDTO.getCharacterRace()
                + DnDCharacterDTO.getCharacterClass() + DnDCharacterDTO.getCharacterWeapon() +
                DnDCharacterDTO.getCharacterArmour();
        return query;
    }
    String retrieveDnDCharacter() {
        String query = "SELECT * FROM dndcharacter, armour, weapon" +
                " WHERE characterArmour = armour.id" +
                " OR characterWeapon = weapon.id";
        return query;
    }
}
