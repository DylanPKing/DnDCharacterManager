package com.seventhtill.interceptor;

import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.item.Item;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.race.Race;
import java.util.Map;

public class CharacterContext {
    private String characterName;
    private Map<String, Integer> attributes;
    private Race characterRace;
    private DnDClass characterClass;
    private Item characterItem;
    private Weapon characterWeapon;
    private Armour characterArmour;

    public CharacterContext(DnDCharacter character) {
        this.characterName = character.getCharacterName();
        this.attributes = character.getCharacterAttributes();
        this.characterRace = character.getCharacterRace();
        this.characterClass = character.getCharacterClass();
        this.characterItem = character.getCharacterItem();
        this.characterWeapon = character.getCharacterWeapon();
        this.characterArmour = character.getCharacterArmour();
    }
    public CharacterContext(String name, Map<String, Integer> attributes, Race race, DnDClass aClass, Item item,
                            Weapon weapon, Armour armour) {
        this.characterName = name;
        this.attributes = attributes;
        this.characterRace = race;
        this.characterClass = aClass;
        this.characterItem = item;
        this.characterWeapon = weapon;
        this.characterArmour = armour;
    }

    @Override
    public String toString() {
        return  "characterName='" + characterName +
                ", \nattributes=" + attributes +
                ", \ncharacterRace=" + characterRace +
                ", \ncharacterClass=" + characterClass +
                ", \ncharacterItem=" + characterItem +
                ", \ncharacterWeapon=" + characterWeapon +
                ", \ncharacterArmour=" + characterArmour;
    }
}