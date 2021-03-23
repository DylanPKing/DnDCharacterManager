package com.seventhtill.characterSheet;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.item.Item;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.race.Race;

public class CharacterSheet implements CharacterBuilder{
    private Character character;

    public CharacterSheet() {
        this.character = new Character();
    }

    @Override
    public void buildCharacterName() {
        this.character.setCharacterName(character.getCharacterName());
    }

    @Override
    public void buildCharacterRace() {
        character.setCharacterRace(character.getCharacterRace());
    }

    @Override
    public void buildCharacterClass() {
        character.setCharacterClass(character.getCharacterClass());
    }

    @Override
    public void buildCharacterItems() {
        character.setCharacterItems(character.getCharacterItem());
    }

    @Override
    public void buildCharacterWeapon() {
        character.setCharacterWeapon(character.getCharacterWeapon());
    }

    @Override
    public void buildCharacterArmour() {
        character.setCharacterArmour(character.getCharacterArmour());
    }

    public Character getCharacter() {
        return this.character;
    }
}