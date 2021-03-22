package com.seventhtill.characterSheet;

public class CharacterSheet implements CharacterBuilder{
    private Character character;

    public CharacterSheet() {
        this.character = new Character();
    }

    @Override
    public void buildCharacterRace() {
        character.setCharacterRace("Human");
    }

    @Override
    public void buildCharacterClass() {
        character.setCharacterClass("Cleric");
    }

    @Override
    public void buildCharacterItems() {
        character.setCharacterItems("Rugsack of goods");
    }

    public Character getCharacter() {
        return this.character;
    }
}