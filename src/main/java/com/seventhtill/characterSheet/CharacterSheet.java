package com.seventhtill.characterSheet;

public class CharacterSheet implements CharacterBuilder{
    private DnDCharacter character;

    public CharacterSheet() {
        this.character = new DnDCharacter();
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

    public DnDCharacter getCharacter() {
        return this.character;
    }
}