package com.seventhtill.item.weapon;

import java.util.List;

public class MartialWeapon extends Weapon {
    public MartialWeapon(
            WeaponAttackType attackType, int damageDice, int weight, String name, List<String> properties
    ) {
        super(attackType, damageDice, weight, name, properties);
    }
}
