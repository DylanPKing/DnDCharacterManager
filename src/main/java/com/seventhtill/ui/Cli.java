package com.seventhtill.ui;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.HeavyArmour;
import com.seventhtill.item.weapon.SimpleWeapon;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.item.weapon.WeaponAttackType;
import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Class that will be responsible for the Command Line Interface
// NOTE only public methods are implemented using the command
// NOTE private member functions are used by the class internally only
// NOTE this is the request class for the command pattern
public class Cli {
    private Scanner scanner;

    // Constructor
    public Cli() {
        initCli();
    }

    // The main menu for the application
    void mainMenu() {
        System.out.println("Welcome to the DnD app, choose an option:\n" +
                "1) Create a new character.\n" +
                "2) Modify an existing character.\n" +
                "3) Delete a character.\n" +
                "4) Show character list.\n" +
                "5) Quit app");
        String userInput = this.scanner.nextLine();
        selectWindow(userInput);
    }

    //------From here the methods are all private and used internally------\\

    // Clean up method to properly close the scanner
    private void EndCli() {
        this.scanner.close();
        System.out.println("Closing the DnD app.\nGoodbye");
        System.exit(0);
    }

    // Method to initialise the scanner and get it ready to read input
    private void initCli() {
        this.scanner = new Scanner(System.in);
    }

    // Method that checks the user input
    private void selectWindow(String userInput) {
        switch(userInput) {
            case "1":
                characterCreationControl();
                break;
            case "2":
                unavailable();
                break;
            case "3":
                unavailable();
                break;
            case "4":
                unavailable();
                break;
            case "5":
                EndCli();
                break;
            default:
                invalidInput(userInput);
                break;
        }
    }

    // The control hub for character creation
    private void characterCreationControl() {
        // This method will call multiple methods asking for the user to specify
        // things like name, race, class etc.
        String characterName = createCharacterName();
        Race characterRace = createCharacterRace();
        DnDClass characterClass = createCharacterClass();
        Character character invokeBuilder(
                characterName, characterRace, characterClass);
    }

    // NOTE the builder hasn't been merged yet, so I'm making
    // NOTE a wild assumption that this will work once the builder is merged in
    // Method that invokes the builder to build the new character
    private Character invokeBuilder(
            String name, Race race, DnDClass DndClass) {
        CharacterBuilder newCharacter = new CharacterSheet();
        CharacterDirector director = new CharacterDirector(newCharacter);
        director.makeCharacter();

        Character aNewCharacter = director.getCharacter();

        // These are temporary fillers before the implementation of ui
        Armour armour = new HeavyArmour(20,"Platemail",
                false, 10);
        WeaponAttackType attacktype = null;
        List<String> properties = null;
        Weapon weapon = new SimpleWeapon(attacktype, 4,
                "Light Hammer", properties);

        aNewCharacter.setCharacterName(name);
        aNewCharacter.setCharacterRace(race);
        aNewCharacter.setCharacterClass(DndClass);
        aNewCharacter.setCharacterArmour(armour);
        aNewCharacter.setCharacterWeapon(weapon);
    }

    // The method to create a name
    private String createCharacterName(){
        String characterName = "";
        Pattern pattern = Pattern.compile(
                        "[^abcdefghijklmnopqrstuvwxyz'\\s]",
                        Pattern.CASE_INSENSITIVE);
        while(true) {
            System.out.println("Welcome to the character creator menu.\nFirst" +
                    " come up with  a name for your character:");
            characterName = this.scanner.nextLine();

            Matcher matcher = pattern.matcher(characterName);
            if (matcher.find()) {
                error("'" + characterName + "' doesn't look like a " +
                        "name to me ngl...\nUse only " +
                        "alphabetic characters. \nOh ya, before I forget, " +
                        "you can also use spaces and apostrophes. \nHave fun" +
                        "\n\n");
            } else {
                break;
            }
        }
        return characterName;
    }

    // The method to create a race
    private Race createCharacterRace() {
        Race characterRace = null;
        // Using the abstract factory to create a race
        System.out.println("Next, choose your race:\n" +
                "1) Dwarf.\n" +
                "2) Elf.\n" +
                "3) Halfling.\n" +
                "4) Human.\n" +
                "5) Cancel\n");
        String userInput = this.scanner.nextLine();

        // Handling the input
        switch(userInput) {
            case "1":
                characterRace = getDwarfRace();
                return  characterRace;
            case "2":
                characterRace = getElfRace();
                return characterRace;
            case "3":
                characterRace = getHalflingRace();
                return  characterRace;
            case "4":
                characterRace = getHumanRace();
                return characterRace;
            case "5":
                System.out.println("Cancelling and returning to the main menu");
                mainMenu();
                break;
            default:
                error("'" + userInput + "' is not a valid input.\n" +
                        "How about you follow the instructions for a change?");
                createCharacterRace();
                break;
        }
        // Null is okay here since this line will never actually kick in.
        return characterRace;
    }

    // Used to get the dwarf
    private Race getDwarfRace() {
        // Using the abstract factory
        Race characterRace = null;
        AbstractFactory raceFactory = FactoryProducer.getFactory(
                "dwarf");
        System.out.println("Okay, what type of dwarf would you like to be?:\n" +
                "1) Hill Dwarf.\n" +
                "2) Mountain Dwarf\n" +
                "3) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterRace = raceFactory.getRace("hilldwarf");
                return characterRace;
            case "2":
                characterRace = raceFactory.getRace("mountaindwarf");
                return characterRace;
            case "3":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterRace();
            default:
                error("This is not a valid input, try again...");
                getDwarfRace();
        }
        // Null is okay here since this line will never actually kick in.
        return characterRace;
    }

    // Used to get the elf
    private Race getElfRace() {
        // Using the abstract factory
        Race characterRace = null;
        AbstractFactory raceFactory = FactoryProducer.getFactory(
                "elf");
        System.out.println("Okay, what type of elf would you like to be?:\n" +
                "1) High Elf.\n" +
                "2) Wood Elf\n" +
                "3) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterRace = raceFactory.getRace("highelf");
                return characterRace;
            case "2":
                characterRace = raceFactory.getRace("woodelf");
                return characterRace;
            case "3":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterRace();
            default:
                error("This is not a valid input, try again...");
                getElfRace();
        }
        // Null is okay here since this line will never actually kick in.
        return characterRace;
    }

    // Used to get the halfing
    private Race getHalflingRace() {
        // Using the abstract factory
        Race characterRace = null;
        AbstractFactory raceFactory = FactoryProducer.getFactory(
                "halfling");
        System.out.println("Okay, what type of halfling would you " +
                "like to be?:\n" +
                "1) Light Foot Halfling.\n" +
                "2) Stout Halfling\n" +
                "3) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterRace = raceFactory.getRace(
                        "lightfoothalfling");
                return characterRace;
            case "2":
                characterRace = raceFactory.getRace("stouthalfling");
                return characterRace;
            case "3":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterRace();
            default:
                error("This is not a valid input, try again...");
                getHalflingRace();
        }
        // Null is okay here since this line will never actually kick in.
        return characterRace;
    }

    // Used to get the human
    private Race getHumanRace() {
        // Using the abstract factory
        Race characterRace = null;
        AbstractFactory raceFactory = FactoryProducer.getFactory(
                "human");
        System.out.println("Do you want to be a standard human?:\n" +
                "1) Standard Human.\n" +
                "2) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterRace = raceFactory.getRace("highelf");
                return characterRace;
            case "2":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterRace();
            default:
                error("This is not a valid input, try again...");
                getHumanRace();
        }
        // Null is okay here since this line will never actually kick in.
        return characterRace;
    }

    // Method that will create a DnDClass
    private DnDClass createCharacterClass() {
        DnDClass characterClass = null;

        // Using the abstract factory to create a class
        System.out.println("Now, choose your class:\n" +
                "1) Cleric.\n" +
                "2) Fighter.\n" +
                "3) Rogue.\n" +
                "4) Wizard.\n" +
                "5) Cancel\n");
        String userInput = this.scanner.nextLine();

        // Handling the input
        switch(userInput) {
            case "1":
                characterClass = getClericClass();
                return  characterClass;
            case "2":
                characterClass = getFighterClass();
                return characterClass;
            case "3":
                characterClass = getRogueClass();
                return  characterClass;
            case "4":
                characterClass = getWizardClass();
                return characterClass;
            case "5":
                System.out.println("Cancelling and returning to the main menu");
                mainMenu();
                break;
            default:
                error("'" + userInput + "' is not a valid input.\n" +
                        "How about you follow the instructions for a change?");
                createCharacterClass();
                break;
        }
        // Null is okay here since this line will never actually kick in.
        return characterClass;
    }

    // Get the cleric
    // NOTE class branch was merged after I started work on this branch
    private DnDClass getClericClass() {
        // Using the abstract factory
        DnDClass characterClass = null;
        AbstractFactoryDndClass classFactory =
                FactoryProducerClass.getFactory(
                "cleric");
        System.out.println("Okay, what type of cleric would you like to be?:\n" +
                "1) Cleric.\n" +
                "2) Life Domain Cleric\n" +
                "3) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterClass = classFactory.getDndClass("cleric");
                return characterClass;
            case "2":
                characterClass = classFactory.getDndClass("lifedomaincleric");
                return characterClass;
            case "3":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterClass();
            default:
                error("This is not a valid input, try again...");
                getClericClass();
        }
        // Null is okay here since this line will never actually kick in.
        return characterClass;
    }

    // Get the fighter
    private DnDClass getFighterClass() {
        // Using the abstract factory
        DnDClass characterClass = null;
        AbstractFactoryDndClass classFactory =
                FactoryProducerClass.getFactory(
                        "fighter");
        System.out.println("Okay, what type of cleric would you like to be?:\n" +
                "1) Fighter.\n" +
                "2) Champion Fighter\n" +
                "3) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterClass = classFactory.getDndClass("fighter");
                return characterClass;
            case "2":
                characterClass = classFactory.getDndClass("championfighter");
                return characterClass;
            case "3":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterClass();
            default:
                error("This is not a valid input, try again...");
                getFighterClass();
        }
        // Null is okay here since this line will never actually kick in.
        return characterClass;
    }

    // Get the Rogue
    private DnDClass getRogueClass() {
        // Using the abstract factory
        DnDClass characterClass = null;
        AbstractFactoryDndClass classFactory =
                FactoryProducerClass.getFactory(
                        "rogue");
        System.out.println("Okay, what type of cleric would you like to be?:\n" +
                "1) Rogue.\n" +
                "2) Thief Rogue\n" +
                "3) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterClass = classFactory.getDndClass("rogue");
                return characterClass;
            case "2":
                characterClass = classFactory.getDndClass("thiefrogue");
                return characterClass;
            case "3":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterClass();
            default:
                error("This is not a valid input, try again...");
                getRogueClass();
        }
        // Null is okay here since this line will never actually kick in.
        return characterClass;
    }

    // Get the wizard
    private DnDClass getWizardClass() {
        // Using the abstract factory
        DnDClass characterClass = null;
        AbstractFactoryDndClass classFactory =
                FactoryProducerClass.getFactory(
                        "wizard");
        System.out.println("Okay, what type of cleric would you like to be?:\n" +
                "1) Wizard.\n" +
                "2) Evocation Wizard\n" +
                "3) Cancel\n");
        String userInput = this.scanner.nextLine();
        switch (userInput) {
            case "1":
                characterClass = classFactory.getDndClass("wizard");
                return characterClass;
            case "2":
                characterClass = classFactory.getDndClass("evocationwizard");
                return characterClass;
            case "3":
                System.out.println("Cancelling and returning to previous menu");
                createCharacterClass();
            default:
                error("This is not a valid input, try again...");
                getWizardClass();
        }
        // Null is okay here since this line will never actually kick in.
        return characterClass;
    }

    // Temp method while implementing functionality
    private void unavailable() {
        System.out.println("Sorry this feature is not yet available");
        mainMenu();
    }

    // Method that handles invalid input
    private void invalidInput(String userInput) {
        System.out.printf("'%s' is not a valid input Dingus. Try following the " +
                                    "instructions ya?\n", userInput);
        mainMenu();
    }

    // Custom error message
    private void error(String errorMessage) {
        System.out.printf(errorMessage);
    }
}
