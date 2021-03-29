package com.seventhtill.ui;

import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.dndclass.AbstractFactoryDndClass;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.FactoryProducerClass;
import com.seventhtill.dndclass.cleric.baseCleric;
import com.seventhtill.dndclass.fighter.baseFighter;
import com.seventhtill.dndclass.rogue.baseRogue;
import com.seventhtill.dndclass.wizard.baseWizard;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.HeavyArmour;
import com.seventhtill.item.weapon.*;
import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Class that will be responsible for the Command Line Interface
// NOTE this is the request class for the command pattern
public class Cli {
    private Scanner scanner;
    private MainMenu mainMenu;
    private CharacterNameCreationMenu characterNameCreationMenu;
    private CharacterRaceCreationMenu characterRaceCreationMenu;
    private CharacterClassCreationMenu characterClassCreationMenu;
    private CharacterWeaponCreationMenu characterWeaponCreationMenu;
    private CharacterArmourCreationMenu characterArmourCreationMenu;
    private HashMap<String, Integer> characterAttributes;

    // Constructor
    public Cli() {
        initCli();
    }

    // Clean up method to properly close the scanner
    private void EndCli() {
        this.scanner.close();
        System.out.println("Closing the DnD app.\nGoodbye");
        //System.exit(0);
    }

    // Method to initialise the scanner and get it ready to read input
    private void initCli() {
        this.scanner = new Scanner(System.in);
        this.mainMenu = new MainMenu();
        this.characterNameCreationMenu = new CharacterNameCreationMenu();
        this.characterRaceCreationMenu = new CharacterRaceCreationMenu();
        this.characterClassCreationMenu = new CharacterClassCreationMenu();
        this.characterWeaponCreationMenu = new CharacterWeaponCreationMenu();
        this.characterArmourCreationMenu = new CharacterArmourCreationMenu();
        this.characterAttributes = new HashMap<>();
    }

    // Loop for the ui
    public void run() {
        // Methods here should return -1 for cancel, 0 for error and 1 for success
        boolean running = true;
        int input = 0;
        while(running) {
            input = mainMenu.mainMenu(scanner);
            switch (input) {
                case -1:
                    running = false;
                    break;
                case 0:
                    invalidInput();
                    break;
                case 1:
                    characterCreationControl();
                    break;
                case 2:
                case 3:
                case 4:
                    unavailable();
                    break;
            }
        }
        EndCli();
    }

    // The control hub for character creation
    private void characterCreationControl() {
        int input = 0;
        boolean doneRace = false;
        boolean doneClass;
        boolean doneWeapon;
        boolean doneArmour;
        // This method will call multiple methods asking for the user to specify
        // things like name, race, class etc.
        String characterName = characterNameCreationMenu.createCharacterName(scanner);
        while(!doneRace) {
            input = characterRaceCreationMenu.createCharacterName(scanner);
            switch (input) {
                case -1:
                case 0:
                    return;
                case 1:
                    doneRace = true;
                    break;
            }
            doneClass = false;
            // We can set the attributes here since they are reliant on the race
            this.characterAttributes = createCharacterAttributes(characterRaceCreationMenu.characterRace);
            while(!doneClass) {
                input = characterClassCreationMenu.createCharacterClass(scanner);
                switch (input) {
                    case -1:
                        doneRace =false;
                        doneClass = true;
                        break;
                    case 1:
                        doneClass = true;
                        break;
                }
                // Control to allow to go back a step
                if(!doneRace) {
                    break;
                }
                doneWeapon = false;
                while(!doneWeapon) {
                    input = characterWeaponCreationMenu.createCharacterWeapon(characterClassCreationMenu.characterClass, scanner);
                    switch (input) {
                        case -1:
                            doneClass =false;
                            doneWeapon = true;
                            break;
                        case 1:
                            doneWeapon = true;
                            break;
                    }
                    if(!doneClass) {
                        break;
                    }
                    doneArmour = false;
                    while(!doneArmour) {
                        input = characterArmourCreationMenu.createCharacterArmour(characterClassCreationMenu.characterClass, scanner);
                        switch (input) {
                            case -1:
                                doneWeapon =false;
                                doneArmour = true;
                                break;
                            case 1:
                                doneArmour = true;
                                break;
                        }
                        if(!doneWeapon) {
                            break;
                        }
                    }
                }
            }
        }

        // Add the created properties to the built character
        // NOTE wizard has no armour
        if(characterClassCreationMenu.characterClass instanceof baseWizard) {
            DnDCharacter character = invokeBuilder(characterName, characterRaceCreationMenu.characterRace, characterClassCreationMenu.characterClass,
                    this.characterAttributes, characterWeaponCreationMenu.characterWeapon, null);
        }
        else {
            DnDCharacter character = invokeBuilder(characterName, characterRaceCreationMenu.characterRace, characterClassCreationMenu.characterClass,
                    this.characterAttributes, characterWeaponCreationMenu.characterWeapon, characterArmourCreationMenu.characterArmour);
        }
        // There will be a call to write to db here.
        // TODO @Chief needs to get the db going to write the character to db before returning to the main menu
    }

    // Method that invokes the builder to build the new character
    private DnDCharacter invokeBuilder(String name, Race race, DnDClass DndClass, HashMap<String, Integer> characterAttributes, Weapon weapon, Armour armour) {
        CharacterBuilder newCharacter = new CharacterSheet();
        CharacterDirector director = new CharacterDirector(newCharacter);
        director.makeCharacter();

        DnDCharacter aNewCharacter = director.getCharacter();

        aNewCharacter.setCharacterName(name);
        aNewCharacter.setCharacterRace(race);
        aNewCharacter.setCharacterClass(DndClass);
        aNewCharacter.setCharacterAttributes(characterAttributes);
        aNewCharacter.setCharacterWeapon(weapon);
        aNewCharacter.setCharacterArmour(armour);

        return aNewCharacter;
    }

    // Method to generate the starting attributes
    private HashMap<String, Integer> createCharacterAttributes(Race race) {
        HashMap<String, Integer> characterAttributes = new HashMap<>();
        Random statValue = new Random();

        // The values are rolled with the allowable range being [3-18]
        characterAttributes.put("Strength",
                statValue.nextInt(16) + 3);
        characterAttributes.put("Dexterity",
                statValue.nextInt(16) + 3);
        characterAttributes.put("Constitution",
                statValue.nextInt(16) + 3);
        characterAttributes.put("Intelligence",
                statValue.nextInt(16) + 3);
        characterAttributes.put("Wisdom",
                statValue.nextInt(16) + 3);
        characterAttributes.put("Charisma",
                statValue.nextInt(16) + 3);
        Map tempList = race.getAbilityScoreIncrease();
        tempList.forEach((key, value) -> characterAttributes.put((String)key, characterAttributes.get(key) + (int)value));
        return  characterAttributes;
    }

    // Temp method while implementing functionality
    private void unavailable() {
        System.out.println("Sorry this feature is not yet available");
    }

    // Method that handles invalid input
    private void invalidInput() {
        System.out.println("That is not a valid input Dingus. Try following the instructions ya?\n");
    }

    // Custom error message
    private void error(String errorMessage) {
        System.out.print(errorMessage);
    }
}
