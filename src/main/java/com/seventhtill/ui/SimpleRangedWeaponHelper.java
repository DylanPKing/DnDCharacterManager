package com.seventhtill.ui;

import com.seventhtill.common.DamageType;
import com.seventhtill.item.weapon.RangedWeaponAttack;
import com.seventhtill.item.weapon.SimpleWeapon;
import com.seventhtill.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleRangedWeaponHelper {
    private List<String> properties;
    private RangedWeaponAttack attackType;
    private String name;
    private int weight;

    // Constructor
    public SimpleRangedWeaponHelper() {
        this.properties = new ArrayList<>();
        this.attackType = null;
        this.name = "";
        this.weight = 0;
    }

    public ArrayList<Weapon> init() {
        ArrayList<Weapon> simpleRangedWeapons = new ArrayList<>();
        List<String> propertiesList;

        // Create Crossbow, light
        propertiesList = propertiesAssembler("Ammunition (range 80/320)",
                "Loading", "Two-handed");
        simpleRangedWeapons.add(build("Crossbow, light", 8,
                DamageType.PIERCING, 5, propertiesList));
        // Create Dart
        propertiesList = propertiesAssembler("Finesse", "Thrown (range 20/60)");
        simpleRangedWeapons.add(build("Dart", 4,
                DamageType.PIERCING, /*0.25*/1 , propertiesList));
        // Create Shortbow
        propertiesList = propertiesAssembler("Ammunition (range 80/320)",
                "Two-handed");
        simpleRangedWeapons.add(build("Shortbow", 6,
                DamageType.PIERCING, 2 , propertiesList));
        // Create Sling
        propertiesList = propertiesAssembler("Ammunition (range 30/120)");
        simpleRangedWeapons.add(build("Sling", 4,
                DamageType.BLUDGEONING, 0 , propertiesList));
        return  simpleRangedWeapons;
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
        this.attackType =
                new RangedWeaponAttack(damageDie, damageType);
        this.weight = weight;
        this.properties = properties;

        return new SimpleWeapon(this.attackType, this.weight,
                this.name, this.properties);
    }
}
