package com.seventhtill;

import com.seventhtill.characterSheet.Character;
import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Hello world!");
        AbstractFactory raceFactory = FactoryProducer.getFactory("elf");
        Race character = raceFactory.getRace("woodelf");
        System.out.println(character.getAbilities());*/

        CharacterBuilder aCharacter = new CharacterSheet();
        CharacterDirector characterDirector = new CharacterDirector(aCharacter);
        characterDirector.makeCharacter();

        Character firstCharacter = characterDirector.getCharacter();

        System.out.println("Character Built");
        System.out.println("Character Race: " + firstCharacter.getaRace());
        System.out.println("Character Class: " + firstCharacter.getaClass());
        System.out.println("Character Items: " + firstCharacter.getAnItem());
    }
}
