package com.seventhtill.ui;

import com.seventhtill.dndclass.AbstractFactoryDndClass;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.FactoryProducerClass;

import java.util.Scanner;

public class CharacterClassCreationMenu {
    public DnDClass characterClass;
    CharacterClassCreationMenu() {
        characterClass = null;
    }

    public  int createCharacterClass(Scanner scanner) {
        int input;
        boolean classSelected = false;
        while(!classSelected) {
            System.out.println("Now, choose your class:\n" +
                    "1) Cleric.\n" +
                    "2) Fighter.\n" +
                    "3) Rogue.\n" +
                    "4) Wizard.\n" +
                    "5) Cancel\n");
            String userInput = scanner.nextLine();
            input = characterClassSelection(userInput, scanner);
            switch (input) {
                case -1:
                    return -1;
                case 1:
                    classSelected = true;
                    break;
                default:
                    break;
            }
        }
        return 1;
    }

    private int characterClassSelection(String userInput, Scanner scanner) {
        // Handling the input
        switch(userInput) {
            case "1":
                return GetGenericClass("cleric", "cleric", "lifedomaincleric", "Cleric", "Life Domain Cleric", scanner);
            case "2":
                return  GetGenericClass("fighter", "fighter", "championfighter", "Fighter", "Champion Fighter", scanner);
            case "3":
                return  GetGenericClass("rogue", "rogue", "thiefrogue", "Rogue", "Thief Rogue", scanner);
            case "4":
                return GetGenericClass("wizard", "wizard", "evocationwizard", "Wizard", "Evocation Wizard", scanner);
            case "5":
                System.out.println("Cancelling and returning to the previous menu");
                return -1;
            default:
                error("'" + userInput + "' is not a valid input.\nHow about you follow the instructions for a change?\n");
                return 0;
        }
    }

        // Generic class selector helper
    private int GetGenericClass(String baseClass, String subClass1, String subClass2, String subClass1Text, String subClass2Text, Scanner scanner) {
        String cancel = "Cancelling and returning to previous menu";
        String errorMessage = "This is not a valid input, try again...";
        String text = "Okay, what type of " + baseClass +
                " would you like to be?:\n" +
                "1) " + subClass1Text + ".\n" +
                "2) " + subClass2Text + ".\n" +
                "3) Cancel.\n";

        // Making an abstract factory to handle the creation process
        AbstractFactoryDndClass classFactory = FactoryProducerClass.getFactory(baseClass);
        System.out.println(text);
        String userInput = scanner.nextLine();
        return GenericClassValidator(classFactory, userInput, subClass1, subClass2, cancel, errorMessage);
    }

    // Generic creator for classes
    private int GenericClassValidator(AbstractFactoryDndClass classFactory, String userInput, String subClass1, String subClass2, String cancel, String errorMessage) {
        switch (userInput) {
            case "1":
                characterClass = classFactory.getDndClass(subClass1);
                return 1;
            case "2":
                characterClass = classFactory.getDndClass(subClass2);
                return 1;
            case "3":
                System.out.println(cancel);
                return -2;
            default:
                error(errorMessage);
                return 0;
        }
    }

    // Custom error message
    private void error(String errorMessage) {
        System.out.print(errorMessage);
    }
}
