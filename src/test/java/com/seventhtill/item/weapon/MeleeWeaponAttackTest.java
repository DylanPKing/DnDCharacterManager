package com.seventhtill.item.weapon;

import com.seventhtill.common.DamageType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeleeWeaponAttackTest {
    @Test
    void getDamageDie() {
        int expectedValue = 6;
        MeleeWeaponAttack testAttackType = new MeleeWeaponAttack(expectedValue, DamageType.BLUDGEONING);

        int actualValue = testAttackType.getDamageDie();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getDamageType() {
        DamageType expectedValue = DamageType.ACID;
        MeleeWeaponAttack testAttackType = new MeleeWeaponAttack(6, expectedValue);

        DamageType actualValue = testAttackType.getDamageType();

        assertEquals(expectedValue, actualValue);
    }
}