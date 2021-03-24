package com.seventhtill.characterSheet;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.item.Item;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.race.Race;

public interface CharacterSheetPlan {
    //plan for creating character
    void setCharacterName(String name);
    //needs to take in race
    void setCharacterRace(Race characterRace);
    //needs to take in a class
    void setCharacterClass(DnDClass characterClass);
    //needs to take in items
    void setCharacterItems(Item item);
    //set armour
    void setCharacterWeapon(Weapon weapon);
    //set weapon
    void setCharacterArmour(Armour armour);

}