package com.seventhtill.item.weapon;

import java.util.List;

public class SimpleWeapon extends Weapon {

    public SimpleWeapon(WeaponAttackType attackType, int weight, String name, List<String> properties) {
        super(attackType, weight, name, properties);
    }
}
