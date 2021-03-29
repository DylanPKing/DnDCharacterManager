package com.seventhtill.ui;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.cleric.baseCleric;
import com.seventhtill.dndclass.fighter.baseFighter;
import com.seventhtill.dndclass.rogue.baseRogue;
import com.seventhtill.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterWeaponCreationMenu {
    Weapon characterWeapon;
    CharacterWeaponCreationMenu() {
        this.characterWeapon = null;
    }

    // Method that will handle the creation of starting weapons
    public int createCharacterWeapon(DnDClass dndClass, Scanner scanner) {
        SimpleMeleeWeaponHelper simpleMeleeHelper = new SimpleMeleeWeaponHelper();
        SimpleRangedWeaponHelper simpleRangedHelper = new SimpleRangedWeaponHelper();
        MartialMeleeWeaponHelper martialMeleeHelper = new MartialMeleeWeaponHelper();
        MartialRangedWeaponHelper martialRangedHelper = new MartialRangedWeaponHelper();
        // First set up arrays of each type of weapon
        ArrayList<Weapon> simpleMeleeWeapons = simpleMeleeHelper.init();
        ArrayList<Weapon> simpleRangedWeapons = simpleRangedHelper.init();
        ArrayList<Weapon> martialMeleeWeapons = martialMeleeHelper.init();
        ArrayList<Weapon> martialRangedWeapons = martialRangedHelper.init();
        // Then create the wondow with options based on the class
        return weaponSelectWindow(dndClass, simpleMeleeWeapons, simpleRangedWeapons, martialMeleeWeapons, martialRangedWeapons, scanner);
    }

    // create the ui for weapon choice
    private int weaponSelectWindow(DnDClass dndClass, ArrayList<Weapon> simpleMelee, ArrayList<Weapon> simpleRanged, ArrayList<Weapon> martialMelee, ArrayList<Weapon> martialRanged, Scanner scanner) {
        if(dndClass instanceof baseCleric) {
            String text = "Now that you have decided to be a cleric, it's time to choose your weapon.\n";
            List<Weapon> clericWeapons = Stream.of(simpleMelee, simpleRanged).flatMap(Collection::stream).collect(Collectors.toList());
            return displayWindow(clericWeapons, text, scanner);
        }
        else if(dndClass instanceof baseFighter) {
            String text = "Now that you have decided to be a fighter, it's time to choose your weapon.\n";
            List<Weapon> fighterWeapons = Stream.of(simpleMelee, simpleRanged, martialMelee, martialRanged).flatMap(Collection::stream).collect(Collectors.toList());
            return displayWindow(fighterWeapons, text, scanner);

        }
        else if(dndClass instanceof baseRogue) {
            String text = "Now that you have decided to be a rogue, it's time to choose your weapon.\n";
            // have to get specific martial weapons for the rogue
            List<Weapon> allowedMartials = new ArrayList<>();
            List<Weapon> allMartials = Stream.of(martialMelee, martialRanged).flatMap(Collection::stream).collect(Collectors.toList());
            for(Weapon weapon : allMartials) {
                switch (weapon.getName()) {
                    case "Longsword":
                    case "Rapier":
                    case "Shortsword":
                    case "Crossbow, hand":
                        allowedMartials.add(weapon);
                }
            }
            List<Weapon> rogueWeapons = Stream.of(simpleMelee, simpleRanged, allowedMartials).flatMap(Collection::stream).collect(Collectors.toList());
            return displayWindow(rogueWeapons, text, scanner);
        }
        else {
            String text = "Now that you have decided to be a wizard, it's time to choose your weapon.\n";
            List<Weapon> allSimples = Stream.of(simpleMelee, simpleRanged).flatMap(Collection::stream).collect(Collectors.toList());
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
            return displayWindow(wizardWeapons, text, scanner);
        }
    }

    private int displayWindow(List<Weapon> weapons, String text, Scanner scanner) {
        System.out.println(text);
        int control = 0;
        for(Weapon weapon : weapons) {
            System.out.printf("%d) %s.\n", control + 1, weapon.getName());
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
                characterWeapon = weapons.get(i);
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
