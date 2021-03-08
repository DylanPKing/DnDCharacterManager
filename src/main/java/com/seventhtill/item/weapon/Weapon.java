package com.seventhtill.item.weapon;

import com.seventhtill.item.Item;

import java.util.List;

public abstract class Weapon  implements Item {
    protected WeaponAttackType attackType;
    private int weight;
    private String name;
    private final List<String> propetries;

    public Weapon(WeaponAttackType attackType, int weight, String name, List<String> properties) {
        this.attackType = attackType;
        this.weight = weight;
        this.name = name;
        this.propetries = properties;
    }
}
