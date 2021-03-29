package com.seventhtill.ui;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.cleric.baseCleric;
import com.seventhtill.dndclass.fighter.baseFighter;
import com.seventhtill.dndclass.rogue.baseRogue;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.LightArmour;
import com.seventhtill.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterArmourCreationMenu {
    Armour characterArmour;
    CharacterArmourCreationMenu() {
        this.characterArmour = null;
    }

    // Method that will handle the creation of starting armour
    public int createCharacterArmour(DnDClass dndClass, Scanner scanner) {
        LightArmourHelper lightArmourHelper = new LightArmourHelper();
        MediumArmourHelper mediumArmourHelper = new MediumArmourHelper();
        HeavyArmourHelper heavyArmourHelper = new HeavyArmourHelper();
        ShieldHelper shieldHelper = new ShieldHelper();
        // Make lists for these
        ArrayList<Armour> lightArmour = lightArmourHelper.init();
        ArrayList<Armour> mediumArmour = mediumArmourHelper.init();
        ArrayList<Armour> heavyArmour = heavyArmourHelper.init();
        ArrayList<Armour> shield = shieldHelper.init();
        return armourSelectWindow(dndClass, lightArmour, mediumArmour, heavyArmour, shield, scanner);
    }

    private int armourSelectWindow(DnDClass dndClass, ArrayList<Armour> light, ArrayList<Armour> medium, ArrayList<Armour> heavy, ArrayList<Armour> shield, Scanner scanner) {
        String text = "Now, select your starting armour.\n";
        if(dndClass instanceof baseCleric) {
            List<Armour> clericArmour = Stream.of(light, medium).flatMap(Collection::stream).collect(Collectors.toList());
            return displayWindow(clericArmour, text, scanner);
        }
        else if(dndClass instanceof baseFighter) {
            List<Armour> fighterArmour = Stream.of(light, medium, heavy).flatMap(Collection::stream).collect(Collectors.toList());
            return displayWindow(fighterArmour, text, scanner);
        }
        else if(dndClass instanceof baseRogue) {
            return displayWindow(light, text, scanner);
        }
        else {
            // Do nothing since wizard dont get armour
            return 1;
        }
    }

    private int displayWindow(List<Armour> armourList, String text, Scanner scanner) {
        System.out.println(text);
        int control = 0;
        for(Armour armour : armourList) {
            System.out.printf("%d) %s.\n", control + 1, armour.getName());
            control++;
        }
        System.out.printf("%d) Cancel.", control + 1);
        // Get the input
        String userInput = scanner.nextLine();

        Pattern pattern = Pattern.compile("[^0123456789]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userInput);
        if (matcher.find() || userInput.equals("")) {
            error("This is not a valid input, try again...\n");
            return 0;
        }
        if(userInput.equals(String.valueOf(control + 1))) {
            System.out.println("Cancelling and returning to previous menu\n");
            return -1;
        }
        for(int i = 0; i < control; i++) {
            if (userInput.equals(String.valueOf(i + 1))) {
                characterArmour = armourList.get(i);
            }
        }
        // If I get this far it means all went well
        return 1;
    }

    // Custom error message
    private void error(String errorMessage) {
        System.out.print(errorMessage);
    }
}
