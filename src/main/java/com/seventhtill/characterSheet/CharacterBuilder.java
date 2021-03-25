package com.seventhtill.characterSheet;

public interface CharacterBuilder {
    //Defines what a character has
    void buildCharacterName();

    void buildCharacterRace();

    void buildCharacterClass();

    void buildCharacterAttributes();

    void buildCharacterItems();

    void buildCharacterWeapon();

    void buildCharacterArmour();

    DnDCharacter getCharacter();
}
