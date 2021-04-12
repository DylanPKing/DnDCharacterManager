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
    public SimpleMeleeWeaponHelper() {
        this.properties = new ArrayList<>();
        this.attackType = null;
        this.name = "";
        this.weight = 0;
    }

    // The main creating function
    public ArrayList<Weapon> init() {
        ArrayList<Weapon> simpleMeleeWeapons = new ArrayList<>();
        List<String> properties;

        // Create Club
        properties = propertiesAssembler("Light");
        simpleMeleeWeapons.add(build("Club", 4, DamageType.BLUDGEONING, 2, properties));
        // Create Dagger
        properties = propertiesAssembler("Finesse", "Light", "Thrown (range 20/60)");
        simpleMeleeWeapons.add(build("Dagger", 4, DamageType.PIERCING, 1, properties));
        // Create Greatclub
        properties = propertiesAssembler("Two-handed");
        simpleMeleeWeapons.add(build("Greatclub", 8, DamageType.BLUDGEONING, 10, properties));
        // Create Handaxe
        properties = propertiesAssembler("Light", "Thrown (range 20/60)");
        simpleMeleeWeapons.add(build("Handaxe", 6, DamageType.SLASHING, 2, properties));
        // Create Javelin
        properties = propertiesAssembler("Thrown (range 30/120)");
        simpleMeleeWeapons.add(build("Javelin", 6, DamageType.PIERCING, 2, properties));
        // Create Light hammer
        properties = propertiesAssembler("Light", "Thrown (range 20/60)");
        simpleMeleeWeapons.add(build("Light hammer", 4, DamageType.BLUDGEONING, 2, properties));
        // Create Mace
        properties = new ArrayList<>();
        simpleMeleeWeapons.add(build("Mace", 6, DamageType.BLUDGEONING, 4, properties));
        // Create Quarterstaff
        properties = propertiesAssembler("Versatile (1d8)");
        simpleMeleeWeapons.add(build("Quarterstaff", 6, DamageType.BLUDGEONING, 4, properties));
        // Create Sickle
        properties = propertiesAssembler("Light");
        simpleMeleeWeapons.add(build("Sickle", 4, DamageType.SLASHING, 2, properties));
        // Create Spear
        properties = propertiesAssembler("Thrown (range 20/60)", "versatile (1d8)");
        simpleMeleeWeapons.add(build("Spear", 6, DamageType.PIERCING, 3, properties));

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
