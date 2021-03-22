package com.seventhtill.characterSheet;

public interface CharacterBuilder {
    //Defines what a character has

    void buildCharacterRace();

    void buildCharacterClass();

    void buildCharacterItems();

    Character getCharacter();
}
