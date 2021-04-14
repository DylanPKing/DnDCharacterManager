package com.seventhtill.ui;

import com.seventhtill.common.DamageType;
import com.seventhtill.item.weapon.MeleeWeaponAttack;
import com.seventhtill.item.weapon.SimpleWeapon;
import com.seventhtill.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A class to help create the simple melee weapons for the ui
public class SimpleMeleeWeaponHelper {
    private List<String> properties;
    private MeleeWeaponAttack attackType;
    private String name;
    private int weight;

    // Constructor
    SimpleMeleeWeaponHelper() {
        this.properties = new ArrayList<>();
        this.attackType = null;
        this.name = "";
        this.weight = 0;
    }

    // The main creating function
    public ArrayList<Weapon> init() {
        ArrayList<Weapon> simpleMeleeWeapons = new ArrayList<>();
        List<String> propertiesList;

        // Create Club
        propertiesList = propertiesAssembler("Light");
        simpleMeleeWeapons.add(build("Club", 4, DamageType.BLUDGEONING, 2, propertiesList));
        // Create Dagger
        propertiesList = propertiesAssembler("Finesse", "Light", "Thrown (range 20/60)");
        simpleMeleeWeapons.add(build("Dagger", 4, DamageType.PIERCING, 1, propertiesList));
        // Create Greatclub
        propertiesList = propertiesAssembler("Two-handed");
        simpleMeleeWeapons.add(build("Greatclub", 8, DamageType.BLUDGEONING, 10, propertiesList));
        // Create Handaxe
        propertiesList = propertiesAssembler("Light", "Thrown (range 20/60)");
        simpleMeleeWeapons.add(build("Handaxe", 6, DamageType.SLASHING, 2, propertiesList));
        // Create Javelin
        propertiesList = propertiesAssembler("Thrown (range 30/120)");
        simpleMeleeWeapons.add(build("Javelin", 6, DamageType.PIERCING, 2, propertiesList));
        // Create Light hammer
        propertiesList = propertiesAssembler("Light", "Thrown (range 20/60)");
        simpleMeleeWeapons.add(build("Light hammer", 4, DamageType.BLUDGEONING, 2, propertiesList));
        // Create Mace
        propertiesList = new ArrayList<>();
        simpleMeleeWeapons.add(build("Mace", 6, DamageType.BLUDGEONING, 4, propertiesList));
        // Create Quarterstaff
        propertiesList = propertiesAssembler("Versatile (1d8)");
        simpleMeleeWeapons.add(build("Quarterstaff", 6, DamageType.BLUDGEONING, 4, propertiesList));
        // Create Sickle
        propertiesList = propertiesAssembler("Light");
        simpleMeleeWeapons.add(build("Sickle", 4, DamageType.SLASHING, 2, propertiesList));
        // Create Spear
        propertiesList = propertiesAssembler("Thrown (range 20/60)", "versatile (1d8)");
        simpleMeleeWeapons.add(build("Spear", 6, DamageType.PIERCING, 3, propertiesList));

        return simpleMeleeWeapons;
    }

    // Method to assemble any number of properties and return a list
    private List<String> propertiesAssembler(String... properties) {
        return new ArrayList<>(Arrays.asList(properties));
    }

    // Builder method to assemble into a weapon
    private Weapon build(String name, int damageDie,
                         DamageType damageType, int weight,
                         List<String> properties) {
        this.name = name;
        this.attackType = new MeleeWeaponAttack(damageDie, damageType);
        this.weight = weight;
        this.properties = properties;

        return new SimpleWeapon(this.attackType, this.weight, this.name, this.properties);
    }
}
