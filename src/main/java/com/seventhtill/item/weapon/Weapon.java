package com.seventhtill.item.weapon;

import com.seventhtill.item.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapon implements Item {
    private int id;
    protected WeaponAttackType attackType;
    private int weight;
    private String name;
    private final List<String> properties;

    public Weapon(WeaponAttackType attackType, int weight, String name, List<String> properties) {
        this.attackType = attackType;
        this.weight = weight;
        this.name = name;
        this.properties = properties;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getProperties() {
        return new ArrayList<>(properties);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
