package com.seventhtill.ui;

import com.seventhtill.common.DamageType;
import com.seventhtill.item.weapon.RangedWeaponAttack;
import com.seventhtill.item.weapon.SimpleWeapon;
import com.seventhtill.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class MartialRangedWeaponHelper {
    private List<String> properties;
    private RangedWeaponAttack attackType;
    private String name;
    private int weight;

    // Constructor
    MartialRangedWeaponHelper() {
        this.properties = new ArrayList<>();
        this.attackType = null;
        this.name = "";
        this.weight = 0;
    }

    public ArrayList<Weapon> init() {
        ArrayList<Weapon> martialRangedWeapons = new ArrayList<>();
        List<String> properties;

        // Create Blowgun
        properties = propertiesAssembler("Ammunition (range 25/100)",
                "Loading");
        martialRangedWeapons.add(build("Blowgun", 1,
                DamageType.PIERCING, 1, properties));
        // Create Crossbow, hand
        properties = propertiesAssembler("Ammunition (range 30/120)", "Light",
                "Loading");
        martialRangedWeapons.add(build("Crossbow, hand",
                6, DamageType.PIERCING, 3, properties));
        // Create Crossbow, heavy
        properties = propertiesAssembler("Ammunition (range 100/400)",
                "Heavy", "Loading", "Two-handed");
        martialRangedWeapons.add(build("Crossbow, heavy",
                10, DamageType.PIERCING, 18, properties));
        // Create Longbow
        properties = propertiesAssembler("Ammunition (range 150/600)",
                "Heavy", "Two-handed");
        martialRangedWeapons.add(build("Longbow", 8,
                DamageType.PIERCING, 2, properties));
        // Create Net
        properties = propertiesAssembler("Special", "Thrown (range 5/15)");
        martialRangedWeapons.add(build("Net", 0,
                null, 3, properties));
        return  martialRangedWeapons;
    }

    // Method to assemble any number of properties and return a list
    private List<String> propertiesAssembler(String... properties) {
        List<String> listOfProperties = new ArrayList<>();
        for(String property : properties) {
            listOfProperties.add(property);
        }
        return listOfProperties;
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
