package com.seventhtill.ui;

import com.seventhtill.common.DamageType;
import com.seventhtill.item.weapon.MartialWeapon;
import com.seventhtill.item.weapon.MeleeWeaponAttack;
import com.seventhtill.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MartialMeleeWeaponHelper {
    private List<String> properties;
    private MeleeWeaponAttack attackType;
    private String name;
    private int weight;
    private final String heavy = "Heavy";

    // Constructor
    MartialMeleeWeaponHelper() {
        this.properties = new ArrayList<>();
        this.attackType = null;
        this.name = "";
        this.weight = 0;
    }

    // The main creating function
    public ArrayList<Weapon> init() {
        ArrayList<Weapon> martialMeleeWeapons = new ArrayList<>();
        List<String> propertiesList;

        // Create Battleaxe
        propertiesList = propertiesAssembler("Versatile (1d10)");
        martialMeleeWeapons.add(build("Battleaxe", 8,
                DamageType.SLASHING, 4, propertiesList));
        // Create Flail
        propertiesList = new ArrayList<>();
        martialMeleeWeapons.add(build("Flail", 8,
                DamageType.BLUDGEONING, 2, propertiesList));
        // Create Glaive
        propertiesList = propertiesAssembler(heavy, "Reach", "Two-handed");
        martialMeleeWeapons.add(build("Glaive", 10,
                DamageType.SLASHING, 6, propertiesList));
        // Create Greataxe
        propertiesList = propertiesAssembler(heavy, "Two-handed");
        martialMeleeWeapons.add(build("Greataxe", 12,
                DamageType.SLASHING, 8, propertiesList));
        // Create Greatsword
        propertiesList = propertiesAssembler(heavy, "Two-handed");
        martialMeleeWeapons.add(build("Greatsword",
                6/*2d6*/, DamageType.SLASHING,
                6, propertiesList));
        // Create Halberd
        propertiesList = propertiesAssembler(heavy, "Reach", "Two-handed");
        martialMeleeWeapons.add(build("Halberd", 10,
                DamageType.SLASHING, 6, propertiesList));
        // Create Lance
        propertiesList = propertiesAssembler("Reach", "Special");
        martialMeleeWeapons.add(build("Lance", 12,
                DamageType.PIERCING, 6, propertiesList));
        // Create Longsword
        propertiesList = propertiesAssembler("Versatile (1d10)");
        martialMeleeWeapons.add(build("Longsword", 8,
                DamageType.SLASHING, 3, propertiesList));
        // Create Maul
        propertiesList = propertiesAssembler(heavy, "Two-handed");
        martialMeleeWeapons.add(build("Maul", 6/*2d6*/,
                DamageType.BLUDGEONING, 10, propertiesList));
        // Create Morningstar
        propertiesList = new ArrayList<>();
        martialMeleeWeapons.add(build("Morningstar", 8,
                DamageType.PIERCING, 4, propertiesList));
        // Create Pike
        propertiesList = propertiesAssembler(heavy, "Reach", "Two-handed");
        martialMeleeWeapons.add(build("Pike", 10,
                DamageType.PIERCING, 18, propertiesList));
        // Create Rapier
        propertiesList = propertiesAssembler("Finesse");
        martialMeleeWeapons.add(build("Rapier", 8,
                DamageType.PIERCING, 2, propertiesList));
        // Create Scimitar
        propertiesList = propertiesAssembler("Finesse", "Light");
        martialMeleeWeapons.add(build("Scimitar", 6,
                DamageType.SLASHING, 3, propertiesList));
        // Create Shortsword
        propertiesList = propertiesAssembler("Finesse", "Light");
        martialMeleeWeapons.add(build("Shortsword", 6,
                DamageType.PIERCING, 2, propertiesList));
        // Create Trident
        propertiesList = propertiesAssembler("Thrown (range 20/60)",
                "Versatile (1d8)");
        martialMeleeWeapons.add(build("Trident", 6,
                DamageType.PIERCING, 4, propertiesList));
        // Create War pick
        propertiesList = new ArrayList<>();
        martialMeleeWeapons.add(build("War pick", 8,
                DamageType.PIERCING, 2, propertiesList));
        // Create Warhammer
        propertiesList = propertiesAssembler("Versarile (1d10)");
        martialMeleeWeapons.add(build("Warhammer", 8,
                DamageType.BLUDGEONING, 2, propertiesList));
        // Create Whip
        propertiesList = propertiesAssembler("Finesse", "Reach");
        martialMeleeWeapons.add(build("Whip", 4,
                DamageType.SLASHING, 3, propertiesList));
        return martialMeleeWeapons;
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
                new MeleeWeaponAttack(damageDie, damageType);
        this.weight = weight;
        this.properties = properties;

        return new MartialWeapon(this.attackType, this.weight,
                this.name, this.properties);
    }
}
