package com.seventhtill.ui;

import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.dbManager.DnDCharacterDTO;
import com.seventhtill.dbManager.Queries;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.wizard.baseWizard;
import com.seventhtill.interceptor.CharacterContext;
import com.seventhtill.interceptor.CharacterCreateInterceptor;
import com.seventhtill.interceptor.Dispatcher;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.ArmourComposite;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.race.Race;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.seventhtill.dbManager.Queries.*;

// Class that will be responsible for the Command Line Interface
// NOTE this is the request class for the command pattern
public class Cli {
    private static int armourId, weaponId;
    private static String oldName;
    private static Race oldRace;
    private static DnDClass oldClass;
    private Dispatcher dispatcher;
    private Scanner scanner;
    private MainMenu mainMenu;
    private CharacterNameCreationMenu characterNameCreationMenu;
    private CharacterRaceCreationMenu characterRaceCreationMenu;
    private CharacterClassCreationMenu characterClassCreationMenu;
    private CharacterWeaponCreationMenu characterWeaponCreationMenu;
    private CharacterArmourCreationMenu characterArmourCreationMenu;
    private HashMap<String, Integer> characterAttributes;

    //public access string variable for db update
    private String updateCharacterName;

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
        this.dispatcher = new Dispatcher();
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
    void run() {
        // Methods here should return -1 for cancel, 0 for error and 1 for success
        boolean running = true;
        int input;
        while(running) {
            input = mainMenu.mainMenu(scanner);
            switch (input) {
                case -1:
                    running = false;
                    break;
                case 1:
                    characterCreationControl();
                    break;
                case 2:
                    characterEditControl();
                    break;
                case 3:
                    characterDeleteControl();
                    break;
                case 4:
                    showCharactersControl();
                    break;
                case 0:
                default:
                    invalidInput();
                    break;
            }
        }
        EndCli();
    }

    // The control hub for character creation
    private void characterCreationControl() {
        int input;
        boolean doneRace = false;
        boolean doneClass;
        boolean doneWeapon;
        boolean doneArmour;
        CharacterCreateInterceptor interceptor = new CharacterCreateInterceptor();
        dispatcher.registerInterceptor(interceptor);
        dispatcher.dispatchCharacterCreateInterceptor();
        // This method will call multiple methods asking for the user to specify
        // things like name, race, class etc.
        String characterName = characterNameCreationMenu.createCharacterName(scanner);
        updateCharacterName = characterName;
        while(!doneRace) {
            input = characterRaceCreationMenu.createCharacterRace(scanner);
            switch (input) {
                case 1:
                    doneRace = true;
                    break;
                case -1:
                case 0:
                default:
                    return;
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
                    default:
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
                        default:
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
                            default:
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
        DnDCharacter character;
        if(characterClassCreationMenu.characterClass instanceof baseWizard) {
            character = invokeBuilder(characterName, characterRaceCreationMenu.characterRace, characterClassCreationMenu.characterClass,
                    this.characterAttributes, characterWeaponCreationMenu.characterWeapon, null);
        }
        else {
            character = invokeBuilder(characterName, characterRaceCreationMenu.characterRace, characterClassCreationMenu.characterClass,
                    this.characterAttributes, characterWeaponCreationMenu.characterWeapon, characterArmourCreationMenu.characterArmour);
        }
        //call to write to db here.
        DnDCharacterDTO aDnDCharacterDTO = new DnDCharacterDTO(character.getCharacterName(), character.getCharacterRace(), character.getCharacterClass(), character.getCharacterItem(), character.getCharacterWeapon(), character.getCharacterArmour(), character.getCharacterArmour().getBaseArmour(), character.getCharacterArmour().getName(), character.getCharacterArmour().isDisadvantage(), character.getCharacterArmour().getWeight(), character.getCharacterWeapon().getAttackType(), character.getCharacterWeapon().getWeight(), character.getCharacterWeapon().getName(), character.getCharacterWeapon().getProperties(), character.getCharacterWeapon().getAttackType().getDamageDie(), character.getCharacterWeapon().getAttackType().getDamageType());
        armourId = Queries.addArmour(aDnDCharacterDTO);
        weaponId = Queries.addWeapon(aDnDCharacterDTO);
        Queries.addDnDCharacter(aDnDCharacterDTO, armourId, weaponId);

        CharacterContext contextChar = new CharacterContext(character);
        dispatcher.dispatchCharacterCreateCompleteInterceptor(contextChar);
        dispatcher.removeInterceptor(interceptor);
    }

    // A method that will control the flow for editing a character
    private void characterEditControl() {
        //List of characters
        ArrayList<DnDCharacter> characters;
        characters = retrieveDnDCharacter();
        //invoke builder for character
        CharacterBuilder newCharacter = new CharacterSheet();
        CharacterDirector characterDirector = new CharacterDirector(newCharacter);
        characterDirector.makeCharacter();
        //objects to be filled
        DnDCharacter aNewCharacter = characterDirector.getCharacter();
        int input = 0;
        boolean done = false;
        String userInput;

        // The main loop for the menu
        while (!done) {
            System.out.println("Pick a character to edit:");
            for (int i = 0; i < characters.size(); i++) {
                System.out.printf("%d) %s.\n", i + 1, characters.get(i).getCharacterName());
                aNewCharacter.setCharacterName(characters.get(i).getCharacterName());
            }
            System.out.printf("%d) Cancel.\n", characters.size() + 1);

            userInput = scanner.nextLine();
            Pattern pattern = Pattern.compile("[^0123456789]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(userInput);
            if (matcher.find() || userInput.equals("")) {
                error();
                continue;
            }
            if (userInput.equals(String.valueOf(characters.size() + 1))) {
                System.out.println("Cancelling and returning to previous menu\n");
                return;
            }
            for (int i = 0; i < characters.size(); i++) {
                if (userInput.equals(String.valueOf(i + 1))) {
                    //old character params to be stored
                    oldName = characters.get(i).getCharacterName();
                    oldRace = characters.get(i).getCharacterRace();
                    oldClass = characters.get(i).getCharacterClass();
                    input = editMenu(characters.get(i));
                }
            }
            switch (input) {
                case -1:
                    return;
                case 1:
                    done = true;
                default:
                    break;
            }
        }
        //newChar
    }

    // Control for character deletion
    private void characterDeleteControl() {
        ArrayList<DnDCharacter> characters;
        characters = retrieveDnDCharacter();

        String userInput;
        boolean done = false;
        while(!done) {
            System.out.println("Pick a character to delete:");
            for (int i = 0; i < characters.size(); i++) {
                System.out.printf("%d) %s.\n", i + 1, characters.get(i).getCharacterName());
            }
            System.out.printf("%d) Cancel.\n", characters.size() + 1);

            userInput = scanner.nextLine();
            Pattern pattern = Pattern.compile("[^0123456789]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(userInput);
            if (matcher.find() || userInput.equals("")) {
                error();
                continue;
            }
            if (userInput.equals(String.valueOf(characters.size() + 1))) {
                System.out.println("Cancelling and returning to previous menu\n");
                return;
            }
            for (int i = 0; i < characters.size(); i++) {
                if (userInput.equals(String.valueOf(i + 1))) {
                    String name = characters.get(i).getCharacterName();
                    deleteDnDCharacter(name, weaponId, armourId );
                    done = true;
                    break;
                }
            }
        }
    }

    // Print a list of all characters in bd
    private void showCharactersControl() {
        ArrayList<DnDCharacter> characters;
        characters = retrieveDnDCharacter();

        for(DnDCharacter character : characters) {
            System.out.println(character.getCharacterName() + ", " +
                    character.getCharacterRace().getName() + ", " +
                    character.getCharacterClass().getName());
        }
        System.out.println("Hit enter to return to the main menu");
        scanner.nextLine();
    }

    // The menu for editing a stat
    private int editMenu(DnDCharacter character) {
        boolean done = false;
        int input = 0;
        while (!done) {
            System.out.println("now editing:");
            System.out.println(character.getCharacterName());
            System.out.println(character.getCharacterRace().getName());
            System.out.println(character.getCharacterClass().getName());
            System.out.println("Pick a trait to edit:\n" +
                    "1) Name.\n" +
                    "2) Race.\n" +
                    "3) Class.\n" +
                    "5 Cancel.\n");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    characterNameCreationMenu.createCharacterName(scanner);
                    updateDnDCharacterName(character.getCharacterName(), oldName, oldRace, oldClass);
                    System.out.println(character.getCharacterName());
                    input = 1;
                    break;
                case "2":
                    input  = characterRaceCreationMenu.createCharacterRace(scanner);
                    updateDnDCharacterRace(character.getCharacterRace(), oldName, oldRace, oldClass);
                    System.out.println("New Race: " + character.getCharacterRace() + "Old Race: " + oldRace);
                    break;
                case "3":
                    input  = characterClassCreationMenu.createCharacterClass(scanner);
                    updateDnDCharacterClass(character.getCharacterClass(), oldName, oldRace, oldClass);
                    break;
                case "4":
                    input  = characterWeaponCreationMenu.createCharacterWeapon(character.getCharacterClass(), scanner);
                    break;
                case "5":
                    System.out.println("Returning to previous menu");
                    return 0;
                default:
                    error();
                    break;
            }
            switch (input) {
                case 1:
                    done = true;
                    break;
                case 0:
                default:
                    error();
                    break;
            }
        }
        return 1;
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

    // Method that handles invalid input
    private void invalidInput() {
        System.out.println("That is not a valid input Dingus. Try following the instructions ya?\n");
    }

    // Custom error message
    private void error() {
        System.out.print("This is not a valid input, try again...\n");
    }
}
