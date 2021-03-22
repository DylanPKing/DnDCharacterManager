package com.seventhtill.characterSheet;

public interface CharacterSheetPlan {
    //plan for creating character

    //needs to take in race
    void setCharacterRace(String racePlaceholder);
    //needs to take in a class
    void setCharacterClass(String classPlaceholder);
    //needs to take in items
    void setCharacterItems(String itemPlaceholder);

}