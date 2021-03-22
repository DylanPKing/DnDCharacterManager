package com.seventhtill;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Class that will be responsible for the Command Line Interface
// NOTE only public methods are implemented using the command
// NOTE private member functions are used by the class internally only
// NOTE this is the request class for the command pattern
public class Cli {
    private Scanner scanner;

    // Constructor
    Cli() {
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
                unavailable();
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
}
