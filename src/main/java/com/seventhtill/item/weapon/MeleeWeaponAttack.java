package com.seventhtill.item.weapon;

public class MeleeWeaponAttack implements WeaponAttackType {
    private final int damageDie;

    public MeleeWeaponAttack(int damageDie) {
        this.damageDie = damageDie;
    }

    @Override
    public int getDamageDie() {
        return damageDie;
    }
}
