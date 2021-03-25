package com.seventhtill;

import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.dndclass.AbstractFactoryDndClass;
import com.seventhtill.dndclass.FactoryProducerClass;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.cleric.Cleric;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.HeavyArmour;
import com.seventhtill.item.weapon.SimpleWeapon;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.item.weapon.WeaponAttackType;
import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;
import com.seventhtill.race.elf.HighElf;
import com.seventhtill.ui.BuildCli;
import com.seventhtill.ui.Cli;
import com.seventhtill.ui.CommandInvoker;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        AbstractFactoryDndClass classFactory = FactoryProducerClass.getFactory("cleric");
//        DnDClass character = classFactory.getDndClass("Cleric");
//        System.out.println(character.getHealth());
//        System.out.println(character.getHitDie());
//        System.out.println(character.getSavingThrows());
//
//        AbstractFactory raceFactory = FactoryProducer.getFactory("elf");
//        Race aCharacter = raceFactory.getRace("woodelf");
//        System.out.println(aCharacter.getAbilities());
//
//        CharacterBuilder newCharacter = new CharacterSheet();
//        CharacterDirector characterDirector = new CharacterDirector(newCharacter);
//        characterDirector.makeCharacter();
//
//        DnDCharacter aNewCharacter = characterDirector.getCharacter();
//        Race elf = new HighElf();
//        DnDClass cleric = new Cleric();
//        //Can't make an item right now
//        Armour armour = new HeavyArmour(20,"Platemail", false, 10);
//        WeaponAttackType attacktype = null;
//        List<String> properties = null;
//        Weapon weapon = new SimpleWeapon(attacktype, 4, "Light Hammer", properties);
//
//        aNewCharacter.setCharacterName("John Boi");
//        aNewCharacter.setCharacterRace(elf);
//        aNewCharacter.setCharacterClass(cleric);
//        //aNewCharacter.setCharacterItems();
//        aNewCharacter.setCharacterArmour(armour);
//        aNewCharacter.setCharacterWeapon(weapon);
//        System.out.println("Character Built:");
//        System.out.println("Character Name: " + aNewCharacter.getCharacterName());
//        System.out.println("Character Race: " + aNewCharacter.getCharacterRace());
//        System.out.println("Character Class: " + aNewCharacter.getCharacterClass());
//        System.out.println("Character Items: " + aNewCharacter.getCharacterItem());
//        System.out.println("Character Armour: " + aNewCharacter.getCharacterArmour());
//        System.out.println("Character Weapon: " + aNewCharacter.getCharacterWeapon());
        // Set up the runtime using the command pattern
        Cli ui = new Cli();
        BuildCli setupUi = new BuildCli(ui);
        CommandInvoker command = new CommandInvoker();
        command.addCommand(setupUi);

        // Execute the commands that were set up
        command.executeCommands();
    }
}
