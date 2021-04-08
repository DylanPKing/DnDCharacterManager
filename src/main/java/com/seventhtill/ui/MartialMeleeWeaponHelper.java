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
        List<String> properties;

        // Create Battleaxe
        properties = propertiesAssembler("Versatile (1d10)");
        martialMeleeWeapons.add(build("Battleaxe", 8,
                DamageType.SLASHING, 4, properties));
        // Create Flail
        properties = new ArrayList<>();
        martialMeleeWeapons.add(build("Flail", 8,
                DamageType.BLUDGEONING, 2, properties));
        // Create Glaive
        properties = propertiesAssembler("Heavy", "Reach", "Two-handed");
        martialMeleeWeapons.add(build("Glaive", 10,
                DamageType.SLASHING, 6, properties));
        // Create Greataxe
        properties = propertiesAssembler("Heavy", "Two-handed");
        martialMeleeWeapons.add(build("Greataxe", 12,
                DamageType.SLASHING, 8, properties));
        // Create Greatsword
        properties = propertiesAssembler("Heavy", "Two-handed");
        martialMeleeWeapons.add(build("Greatsword",
                6/*2d6*/, DamageType.SLASHING,
                6, properties));
        // Create Halberd
        properties = propertiesAssembler("Heavy", "Reach", "Two-handed");
        martialMeleeWeapons.add(build("Halberd", 10,
                DamageType.SLASHING, 6, properties));
        // Create Lance
        properties = propertiesAssembler("Reach", "Special");
        martialMeleeWeapons.add(build("Lance", 12,
                DamageType.PIERCING, 6, properties));
        // Create Longsword
        properties = propertiesAssembler("Versatile (1d10)");
        martialMeleeWeapons.add(build("Longsword", 8,
                DamageType.SLASHING, 3, properties));
        // Create Maul
        properties = propertiesAssembler("Heavy", "Two-handed");
        martialMeleeWeapons.add(build("Maul", 6/*2d6*/,
                DamageType.BLUDGEONING, 10, properties));
        // Create Morningstar
        properties = new ArrayList<>();
        martialMeleeWeapons.add(build("Morningstar", 8,
                DamageType.PIERCING, 4, properties));
        // Create Pike
        properties = propertiesAssembler("Heavy", "Reach", "Two-handed");
        martialMeleeWeapons.add(build("Pike", 10,
                DamageType.PIERCING, 18, properties));
        // Create Rapier
        properties = propertiesAssembler("Finesse");
        martialMeleeWeapons.add(build("Rapier", 8,
                DamageType.PIERCING, 2, properties));
        // Create Scimitar
        properties = propertiesAssembler("Finesse", "Light");
        martialMeleeWeapons.add(build("Scimitar", 6,
                DamageType.SLASHING, 3, properties));
        // Create Shortsword
        properties = propertiesAssembler("Finesse", "Light");
        martialMeleeWeapons.add(build("Shortsword", 6,
                DamageType.PIERCING, 2, properties));
        // Create Trident
        properties = propertiesAssembler("Thrown (range 20/60)",
                "Versatile (1d8)");
        martialMeleeWeapons.add(build("Trident", 6,
                DamageType.PIERCING, 4, properties));
        // Create War pick
        properties = new ArrayList<>();
        martialMeleeWeapons.add(build("War pick", 8,
                DamageType.PIERCING, 2, properties));
        // Create Warhammer
        properties = propertiesAssembler("Versarile (1d10)");
        martialMeleeWeapons.add(build("Warhammer", 8,
                DamageType.BLUDGEONING, 2, properties));
        // Create Whip
        properties = propertiesAssembler("Finesse", "Reach");
        martialMeleeWeapons.add(build("Whip", 4,
                DamageType.SLASHING, 3, properties));
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
