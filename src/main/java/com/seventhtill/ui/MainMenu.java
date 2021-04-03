package com.seventhtill.ui;

import java.util.Scanner;

// Segment of ui that will handle main menu loop
public class MainMenu {
    MainMenu() {

    }

    // The main menu text screen
    public int mainMenu(Scanner scanner) {
        System.out.println("Welcome to the DnD app, choose an option:\n" +
                "1) Create a new character.\n" +
                "2) Modify an existing character.\n" +
                "3) Delete a character.\n" +
                "4) Show character list.\n" +
                "5) Quit app");
        String userInput = scanner.nextLine();
        return selectWindow(userInput);
    }

    // Method that checks the user input
    private int selectWindow(String userInput) {
        switch(userInput) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return -1;
            default:
                return 0;
        }
    }
}
