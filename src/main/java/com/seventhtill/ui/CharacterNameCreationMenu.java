package com.seventhtill.ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterNameCreationMenu {
    CharacterNameCreationMenu() {

    }

    // The create name text screen
    public String createCharacterName(Scanner scanner) {
        String characterName = "";
        boolean valid = false;
        while(!valid) {
            System.out.println("Welcome to the character creator menu.\nFirst come up with  a name for your character:");
            characterName = scanner.nextLine();
            valid = checkInput(characterName);
        }
        return characterName;
    }

    // Check the user input
    private boolean checkInput(String userInput) {
        Pattern pattern = Pattern.compile("[^abcdefghijklmnopqrstuvwxyz'\\s]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userInput);
        if (matcher.find() || userInput.equals("")) {
            error("'" + userInput + "' doesn't look like a name to me ngl...\nUse only alphabetic characters. \nOh ya, before I forget, you can also use spaces and apostrophes. \nHave fun\n\n");
            return false;
        }
        return true;
    }

    // Custom error message
    private void error(String errorMessage) {
        System.out.print(errorMessage);
    }
}
