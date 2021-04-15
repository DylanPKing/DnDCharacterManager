package com.seventhtill.item.weapon;

import com.seventhtill.common.DamageType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangedWeaponAttackTest {

    @Test
    void getDamageDie() {
        int expectedValue = 6;
        RangedWeaponAttack testAttackType = new RangedWeaponAttack(expectedValue, DamageType.BLUDGEONING);

        int actualValue = testAttackType.getDamageDie();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getDamageType() {
        DamageType expectedValue = DamageType.ACID;
        RangedWeaponAttack testAttackType = new RangedWeaponAttack(6, expectedValue);

        DamageType actualValue = testAttackType.getDamageType();

        assertEquals(expectedValue, actualValue);
    }
}