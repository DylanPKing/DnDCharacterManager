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
        characterRace = characterRaceSelection(userInput);

        return characterRace;
    }

    // Method to handle the base race input
    private Race characterRaceSelection(String userInput) {
        Race characterRace = null;
        // Handling the input
        switch(userInput) {
            case "1":
                characterRace = GetGenericRace("dwarf",
                        "hilldwarf",
                        "mountaindwarf",
                        "Hill Dwarf",
                        "Mountain Dwarf");
                return  characterRace;
            case "2":
                characterRace = GetGenericRace("elf",
                        "highelf",
                        "woodelf",
                        "High Elf",
                        "Wood Elf");
                return characterRace;
            case "3":
                characterRace = GetGenericRace("halfling",
                        "lightfoothalfling",
                        "stouthalfling",
                        "Light Foot Halfling",
                        "Stout Halfling");
                return  characterRace;
            case "4":
                characterRace = GetGenericRace("human",
                        "standardhuman",
                        "null",
                        "Standard Human",
                        "null");
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
        characterClass = characterClassSelection(userInput);

       return characterClass;
    }

    private DnDClass characterClassSelection(String userInput) {
        DnDClass characterClass = null;
        // Handling the input
        switch(userInput) {
            case "1":
                characterClass = GetGenericClass("cleric",
                        "cleric",
                        "lifedomaincleric",
                        "Cleric",
                        "Life Domain Cleric");
                return  characterClass;
            case "2":
                characterClass = GetGenericClass("fighter",
                        "fighter",
                        "championfighter",
                        "Fighter",
                        "Champion Fighter");
                return characterClass;
            case "3":
                characterClass = GetGenericClass("rogue",
                        "rogue",
                        "thiefrogue",
                        "Rogue",
                        "Thief Rogue");
                return  characterClass;
            case "4":
                characterClass = GetGenericClass("wizard",
                        "wizard",
                        "evocationwizard",
                        "Wizard",
                        "Evocation Wizard");
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

    // This method will be a modular getRace method to stop duplication
    private Race GetGenericRace(String baseRace,
                                String subRace1,
                                String subRace2,
                                String subRace1Text,
                                String subRace2Text) {
        Race characterRace = null;
        String cancel = "Cancelling and returning to previous menu";
        String errorMessage = "This is not a valid input, try again...";

        // Setting the prompt text
        String text = "";
        if(subRace2.equals("null")) {
            text = "Okay, what type of " + baseRace + " would you like to be?:\n" +
                    "1) " + subRace1Text + ".\n" +
                    "2) Cancel.\n";
        }
        else {
            text = "Okay, what type of " + baseRace + " would you like to be?:\n" +
                    "1) " + subRace1Text + ".\n" +
                    "2) " + subRace2Text + ".\n" +
                    "3) Cancel.\n";
        }

        // Making an abstract factory to handle the creation process
        AbstractFactory raceFactory = FactoryProducer.getFactory(baseRace);
        System.out.println(text);
        String userInput = scanner.nextLine();
        characterRace = GenericRaceValidator(raceFactory,
                userInput,
                subRace1,
                subRace2,
                cancel,
                errorMessage);

        return characterRace;
    }

    // This method will be able to remove duplicated code
    private Race GenericRaceValidator(AbstractFactory raceFactory,
                                      String userInput,
                                      String subRace1,
                                      String subRace2,
                                      String cancel,
                                      String errorMessage) {
        Race characterRace = null;
        switch (userInput) {
            case "1":
                characterRace = raceFactory.getRace(subRace1);
                return characterRace;
            case "2":
                if(subRace2.equals("null")) {
                    System.out.println(cancel);
                    createCharacterRace();
                }
                characterRace = raceFactory.getRace(subRace2);
                return characterRace;
            case "3":
                if(subRace2.equals("null")) {
                    error(errorMessage);
                    createCharacterRace();
                }
                System.out.println(cancel);
                createCharacterRace();
            default:
                error(errorMessage);
                createCharacterRace();
        }
        //Can be null since code never reaches this line
        return characterRace;
    }

    // Generic class selector helper
    private DnDClass GetGenericClass(String baseClass,
                                     String subClass1,
                                     String subClass2,
                                     String subClass1Text,
                                     String subClass2Text) {
        DnDClass characterClass = null;
        String cancel = "Cancelling and returning to previous menu";
        String errorMessage = "This is not a valid input, try again...";
        String text = "Okay, what type of " + baseClass +
                " would you like to be?:\n" +
                "1) " + subClass1Text + ".\n" +
                "2) " + subClass2Text + ".\n" +
                "3) Cancel.\n";

        // Making an abstract factory to handle the creation process
        AbstractFactoryDndClass classFactory =
                FactoryProducerClass.getFactory(baseClass);
        System.out.println(text);
        String userInput = scanner.nextLine();
        characterClass = GenericClassValidator(classFactory,
                userInput,
                subClass1,
                subClass2,
                cancel,
                errorMessage);

        return characterClass;
    }

    // Generic creator for classes
    private DnDClass GenericClassValidator(
            AbstractFactoryDndClass classFactory,
            String userInput,
            String subClass1,
            String subClass2,
            String cancel,
            String errorMessage) {
        DnDClass characterClass = null;
        switch (userInput) {
            case "1":
                characterClass = classFactory.getDndClass(subClass1);
                return characterClass;
            case "2":
                characterClass = classFactory.getDndClass(subClass2);
                return characterClass;
            case "3":
                System.out.println(cancel);
                createCharacterRace();
            default:
                error(errorMessage);
                createCharacterRace();
        }
        //Can be null since code never reaches this line
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
