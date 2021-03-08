package com.seventhtill.item.weapon;

import com.seventhtill.common.DamageType;

public class RangedWeaponAttack implements  WeaponAttackType {
    private final int damageDie;
    private final DamageType damageType;

    public RangedWeaponAttack(int damageDie, DamageType damageType) {
        this.damageDie = damageDie;
        this.damageType = damageType;
    }

    @Override
    public int getDamageDie() {
        return damageDie;
    }

    @Override
    public DamageType getDamageType() {
        return damageType;
    }
}
