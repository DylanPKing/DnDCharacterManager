package com.seventhtill.dbManager;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.item.Item;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.race.Race;

public class DnDCharacterDTO {
    private String characterName;
    private Race characterRace;
    private DnDClass characterClass;
    private Item characterItem;
    private Weapon characterWeapon;
    private Armour characterArmour;

    DnDCharacterDTO(String characterName, Race characterRace, DnDClass characterClass, Item characterItem, Weapon characterWeapon, Armour characterArmour) {
        this.characterName = characterName;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.characterItem = characterItem;
        this.characterWeapon = characterWeapon;
        this.characterArmour = characterArmour;
    }

    public void setCharacterName(String name) {
        characterName = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterRace(Race race) {
        characterRace = race;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    public void setCharacterClass(DnDClass aClass) {
        characterClass= aClass;
    }

    public DnDClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterItems(Item item) {
        characterItem = item;
    }

    public Item getCharacterItem() {
        return characterItem;
    }

    public void setCharacterWeapon(Weapon weapon) {
        characterWeapon = weapon;
    }

    public Weapon getCharacterWeapon() {
        return  characterWeapon;
    }

    public void setCharacterArmour(Armour armour) {
        characterArmour = armour;
    }

    public Armour getCharacterArmour() {
        return characterArmour;
    }
}
