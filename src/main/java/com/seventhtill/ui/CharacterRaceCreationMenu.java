package com.seventhtill.ui;

import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;

import java.util.Scanner;

// Class that will handle the menu for race picking
public class CharacterRaceCreationMenu {
    Race characterRace;
    CharacterRaceCreationMenu() {
        characterRace = null;
    }

    // Race selection main screen
    public int createCharacterName(Scanner scanner) {
        int input = 0;
        boolean raceSelected = false;
        while(!raceSelected) {
            System.out.println("Next, choose your race:\n" +
                    "1) Dwarf.\n" +
                    "2) Elf.\n" +
                    "3) Halfling.\n" +
                    "4) Human.\n" +
                    "5) Cancel\n");
            String userInput = scanner.nextLine();
            input = characterRaceSelection(userInput, scanner);
            switch (input) {
                case -1:
                    return -1;
                case 1:
                    raceSelected = true;
                    break;
            }
        }
        return 1;
    }

    // Method to handle the base race input
    private int characterRaceSelection(String userInput, Scanner scanner) {
        // Handling the input
        switch(userInput) {
            case "1":
                return GetGenericRace("dwarf", "hilldwarf", "mountaindwarf", "Hill Dwarf", "Mountain Dwarf", scanner);
            case "2":
                return GetGenericRace("elf", "highelf", "woodelf", "High Elf", "Wood Elf", scanner);
            case "3":
                return GetGenericRace("halfling", "lightfoothalfling", "stouthalfling", "Light Foot Halfling", "Stout Halfling", scanner);
            case "4":
                return GetGenericRace("human", "standardhuman", "null", "Standard Human", "null", scanner);
            case "5":
                System.out.println("Cancelling and returning to the main menu");
                return -1;
            default:
                error("'" + userInput + "' is not a valid input.\n" +
                        "How about you follow the instructions for a change?\n");
                return 0;
        }
    }

    // Sub race text screen
    private int GetGenericRace(String baseRace, String subRace1, String subRace2, String subRace1Text, String subRace2Text, Scanner scanner) {
        String cancel = "Cancelling and returning to previous menu";
        String errorMessage = "This is not a valid input, try again...";
        // Setting the prompt text
        String text;
            // If human
            if (subRace2.equals("null")) {
                text = "Okay, what type of " + baseRace + " would you like to be?:\n" +
                        "1) " + subRace1Text + ".\n" +
                        "2) Cancel.\n";
            } else {
                text = "Okay, what type of " + baseRace + " would you like to be?:\n" +
                        "1) " + subRace1Text + ".\n" +
                        "2) " + subRace2Text + ".\n" +
                        "3) Cancel.\n";
            }

            // Making an abstract factory to handle the creation process
            AbstractFactory raceFactory = FactoryProducer.getFactory(baseRace);
            System.out.println(text);
            String userInput = scanner.nextLine();
            // if this is -1 loop
            return GenericRaceValidator(raceFactory, userInput, subRace1, subRace2, cancel, errorMessage);
    }

        private int GenericRaceValidator(AbstractFactory raceFactory, String userInput, String subRace1, String subRace2, String cancel, String errorMessage) {
        switch (userInput) {
            case "1":
                characterRace = raceFactory.getRace(subRace1);
                return 1;
            case "2":
                // If human
                if(subRace2.equals("null")) {
                    System.out.println(cancel);
                    return -2;
                }
                characterRace = raceFactory.getRace(subRace2);
                return 1;
            case "3":
                // If human
                if(subRace2.equals("null")) {
                    error(errorMessage);
                    return 0;
                }
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
