package com.seventhtill.ui;

import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.common.DamageType;
import com.seventhtill.dndclass.AbstractFactoryDndClass;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.FactoryProducerClass;
import com.seventhtill.dndclass.cleric.baseCleric;
import com.seventhtill.dndclass.fighter.baseFighter;
import com.seventhtill.dndclass.rogue.baseRogue;
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
        Weapon characterWeapon = createCharacterWeapon(characterClass);
        HashMap<String, Integer> characterAttributes =
                createCharacterAttributes(characterRace);

        // Add the created properties to the built character
        DnDCharacter character = invokeBuilder(
                characterName, characterRace, characterClass,
                characterAttributes);
        System.out.println(characterWeapon.getName());
        //EndCli();

//        System.out.println(character.getCharacterName());
//        System.out.println(character.getCharacterRace());
//        System.out.println(character.getCharacterClass());
        // There will be a call to write to db here.

        // Then back to main menu
        mainMenu();
    }

    // NOTE the builder hasn't been merged yet, so I'm making
    // NOTE a wild assumption that this will work once the builder is merged in
    // Method that invokes the builder to build the new character
    private DnDCharacter invokeBuilder(
            String name, Race race, DnDClass DndClass,
            HashMap<String, Integer> characterAttributes) {
        CharacterBuilder newCharacter = new CharacterSheet();
        CharacterDirector director = new CharacterDirector(newCharacter);
        director.makeCharacter();

        DnDCharacter aNewCharacter = director.getCharacter();

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
        aNewCharacter.setCharacterAttributes(characterAttributes);
        aNewCharacter.setCharacterArmour(armour);
        aNewCharacter.setCharacterWeapon(weapon);

        return aNewCharacter;
    }

    // The method to create a name
    private String createCharacterName(){
        String characterName;
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
        Race characterRace;
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
                mainMenu();
                break;
        }
        // Null is okay here since this line will never actually kick in.
        return characterRace;
    }

    // Method that will create a DnDClass
    private DnDClass createCharacterClass() {
        DnDClass characterClass;

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
                mainMenu();
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
        Race characterRace;
        String cancel = "Cancelling and returning to previous menu";
        String errorMessage = "This is not a valid input, try again...";

        // Setting the prompt text
        String text;
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
                    mainMenu();
                }
                characterRace = raceFactory.getRace(subRace2);
                return characterRace;
            case "3":
                if(subRace2.equals("null")) {
                    error(errorMessage);
                    mainMenu();
                }
                System.out.println(cancel);
                mainMenu();
            default:
                error(errorMessage);
                mainMenu();
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
        DnDClass characterClass;
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
                mainMenu();
            default:
                error(errorMessage);
                mainMenu();
        }
        //Can be null since code never reaches this line
        return characterClass;
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

    // Method that will handle the creation of starting weapons
    private Weapon createCharacterWeapon(DnDClass dndClass) {
        SimpleMeleeWeaponHelper simpleMeleeHelper =
                new SimpleMeleeWeaponHelper();
        SimpleRangedWeaponHelper simpleRangedHelper =
                new SimpleRangedWeaponHelper();
        MartialMeleeWeaponHelper martialMeleeHelper =
                new MartialMeleeWeaponHelper();
        MartialRangedWeaponHelper martialRangedHelper =
                new MartialRangedWeaponHelper();
        // First set up arrays of each type of weapon
        ArrayList<Weapon> simpleMeleeWeapons = simpleMeleeHelper.init();
        ArrayList<Weapon> simpleRangedWeapons =
                simpleRangedHelper.init();
        ArrayList<Weapon> martialMeleeWeapons = martialMeleeHelper.init();
        ArrayList<Weapon> martialRangedWeapons = martialRangedHelper.init();
        return weaponSelectWindow(dndClass, simpleMeleeWeapons,
                simpleRangedWeapons, martialMeleeWeapons,
                martialRangedWeapons);
    }

    // create the ui for weapon choice
    private Weapon weaponSelectWindow(DnDClass dndClass,
                                      ArrayList<Weapon> simpleMelee,
                                      ArrayList<Weapon> simpleRanged,
                                      ArrayList<Weapon> martialMelee,
                                      ArrayList<Weapon> martialRanged) {
        if(dndClass instanceof baseCleric) {
            String text = "Now that you have decided to be a cleric, it's time " +
                    "to choose your weapon.\n";
            List<Weapon> clericWeapons =
                    Stream.of(simpleMelee, simpleRanged).flatMap(
                            Collection::stream).collect(Collectors.toList());
            return displayWindow(clericWeapons, text);
        }
        else if(dndClass instanceof baseFighter) {
            String text = "Now that you have decided to be a fighter, it's time " +
                    "to choose your weapon.\n";
            List<Weapon> fighterWeapons =
                    Stream.of(simpleMelee, simpleRanged, martialMelee,
                            martialRanged).flatMap(Collection::stream).collect(
                                    Collectors.toList());
            return displayWindow(fighterWeapons, text);

        }
        else if(dndClass instanceof baseRogue) {
            String text = "Now that you have decided to be a rogue, it's time " +
                    "to choose your weapon.\n";
            // have to get specific martial weapons for the rogue
            List<Weapon> allowedMartials = new ArrayList<>();
            List<Weapon> allMartials =
                    Stream.of(martialMelee, martialRanged).flatMap(
                            Collection::stream).collect(Collectors.toList());
            for(Weapon weapon : allMartials) {
                switch (weapon.getName()) {
                    case "Longsword":
                    case "Rapier":
                    case "Shortsword":
                    case "Crossbow, hand":
                        allowedMartials.add(weapon);
                }
            }
            List<Weapon> rogueWeapons =
                    Stream.of(simpleMelee, simpleRanged, allowedMartials).flatMap(
                            Collection::stream).collect(Collectors.toList());
            return displayWindow(rogueWeapons, text);
        }
        else {
            String text = "Now that you have decided to be a wizard, it's time " +
                    "to choose your weapon.\n";
            List<Weapon> allSimples = Stream.of(simpleMelee,
                    simpleRanged).flatMap(Collection::stream).collect(
                            Collectors.toList());
            List<Weapon> wizardWeapons = new ArrayList<>();
            for(Weapon weapon : allSimples) {
                switch (weapon.getName()) {
                    case "Dagger":
                    case "Dart":
                    case "Sling":
                    case "Quarterstaff":
                    case "Crossbow, light":
                        wizardWeapons.add(weapon);
                }
            }
            return displayWindow(wizardWeapons, text);
        }
    }

    private Weapon displayWindow(List<Weapon> weapons, String text) {
        System.out.println(text);
        int control = 0;
        for(Weapon weapon : weapons) {
            System.out.printf("%d) %s.\n", control + 1, weapon.getName());
            control++;
        }
        System.out.printf("%d) Cancel.", control + 1);
        String userInput = scanner.nextLine();
        if(userInput.equals(String.valueOf(control + 1))) {
            System.out.println("Cancelling and returning to main menu\n");
            mainMenu();
        }
        for(int i = 0; i < control; i++) {
            if(userInput.equals(String.valueOf(i + 1))) {
                return weapons.get(i);
            }
        }
        return null;
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
        System.out.print(errorMessage);
    }
}
