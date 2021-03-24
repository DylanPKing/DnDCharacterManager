package com.seventhtill.characterSheet;

public class CharacterDirector {
    //create character using builder interface
    private CharacterBuilder characterBuilder;

    public CharacterDirector(CharacterBuilder characterBuilder){
        this.characterBuilder = characterBuilder;
    }

    public DnDCharacter getCharacter(){
        return this.characterBuilder.getCharacter();
    }

    public void makeCharacter() {
        this.characterBuilder.buildCharacterName();
        this.characterBuilder.buildCharacterRace();
        this.characterBuilder.buildCharacterClass();
        this.characterBuilder.buildCharacterItems();
        this.characterBuilder.buildCharacterWeapon();
        this.characterBuilder.buildCharacterArmour();
    }
}
