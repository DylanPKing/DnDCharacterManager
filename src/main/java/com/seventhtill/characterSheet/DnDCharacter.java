package com.seventhtill.characterSheet;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.item.Item;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.race.Race;

public class DnDCharacter implements CharacterSheetPlan{
    //Defines the specifics of the character
    private String characterName;
    private Race characterRace;
    private DnDClass characterClass;
    private Item characterItem;
    private Weapon characterWeapon;
    private Armour characterArmour;

    public void setCharacterName(String name) {
        characterName = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    @Override
    public void setCharacterRace(Race race) {
        characterRace = race;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    @Override
    public void setCharacterClass(DnDClass aClass) {
        characterClass= aClass;
    }

    public DnDClass getCharacterClass() {
        return characterClass;
    }

    @Override
    public void setCharacterItems(Item item) {
        characterItem = item;
    }

    public Item getCharacterItem() {
        return characterItem;
    }

    @Override
    public void setCharacterWeapon(Weapon weapon) {
        characterWeapon = weapon;
    }

    public Weapon getCharacterWeapon() {
        return  characterWeapon;
    }

    @Override
    public void setCharacterArmour(Armour armour) {
        characterArmour = armour;
    }

    public Armour getCharacterArmour() {
        return characterArmour;
    }
}
