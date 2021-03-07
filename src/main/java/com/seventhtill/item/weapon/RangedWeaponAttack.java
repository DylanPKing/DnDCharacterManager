package com.seventhtill.item.weapon;

public class RangedWeaponAttack implements  WeaponAttackType {
    private final int damageDie;

    public RangedWeaponAttack(int damageDie) {
        this.damageDie = damageDie;
    }

    @Override
    public int getDamageDie() {
        return damageDie;
    }
}
