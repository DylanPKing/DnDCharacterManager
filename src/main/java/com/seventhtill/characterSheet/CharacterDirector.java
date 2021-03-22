package com.seventhtill.characterSheet;

public class CharacterDirector {
    //create character using builder interface
    private CharacterBuilder characterBuilder;

    public CharacterDirector(CharacterBuilder characterBuilder){
        this.characterBuilder = characterBuilder;
    }

    public Character getCharacter(){
        return this.characterBuilder.getCharacter();
    }

    public void makeCharacter() {
        this.characterBuilder.buildCharacterClass();
        this.characterBuilder.buildCharacterRace();
        this.characterBuilder.buildCharacterItems();
    }
}
