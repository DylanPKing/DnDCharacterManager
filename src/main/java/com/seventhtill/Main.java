package com.seventhtill;

        import com.seventhtill.characterSheet.Character;
        import com.seventhtill.characterSheet.CharacterBuilder;
        import com.seventhtill.characterSheet.CharacterDirector;
        import com.seventhtill.characterSheet.CharacterSheet;
        import com.seventhtill.dndclass.AbstractFactoryDndClass;
        import com.seventhtill.dndclass.FactoryProducerClass;
        import com.seventhtill.dndclass.DnDClass;
        import com.seventhtill.race.AbstractFactory;
        import com.seventhtill.race.FactoryProducer;
        import com.seventhtill.race.Race;

public class Main {
    public static void main(String[] args) {
        AbstractFactoryDndClass classFactory = FactoryProducerClass.getFactory("cleric");
        DnDClass character = classFactory.getDndClass("Cleric");
        System.out.println(character.getHealth());
        System.out.println(character.getHitDie());
        System.out.println(character.getSavingThrows());

        AbstractFactory raceFactory = FactoryProducer.getFactory("elf");
        Race aCharacter = raceFactory.getRace("woodelf");
        System.out.println(aCharacter.getAbilities());

        CharacterBuilder newCharacter = new CharacterSheet();
        CharacterDirector characterDirector = new CharacterDirector(newCharacter);
        characterDirector.makeCharacter();

        Character aNewCharacter = characterDirector.getCharacter();

        System.out.println("Character Built:");
        System.out.println("Character Name: " + aNewCharacter.getCharacterName());
        System.out.println("Character Race: " + aNewCharacter.getCharacterRace());
        System.out.println("Character Class: " + aNewCharacter.getCharacterClass());
        System.out.println("Character Items: " + aNewCharacter.getCharacterItem());
        System.out.println("Character Armour: " + aNewCharacter.getCharacterArmour());
        System.out.println("Character Weapon: " + aNewCharacter.getCharacterWeapon());
    }
}
