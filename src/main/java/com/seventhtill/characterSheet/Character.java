package com.seventhtill.characterSheet;

public class Character implements CharacterSheetPlan{
    //Defines the specifics of the character
    //placeholders for factories and items
    private String aRace;
    private String aClass;
    private String anItem;

    @Override
    public void setCharacterRace(String racePlaceholder) {
        aRace = racePlaceholder;
    }

    public String getaRace() {
        return aRace;
    }

    @Override
    public void setCharacterClass(String classPlaceholder) {
        aClass = classPlaceholder;
    }

    public String getaClass() {
        return aClass;
    }

    @Override
    public void setCharacterItems(String itemPlaceholder) {
        anItem = itemPlaceholder;
    }

    public String getAnItem() {
        return anItem;
    }
}
