package com.seventhtill.item.weapon;

import com.seventhtill.common.DamageType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class MartialWeaponTest {

    @Test
    void getName() {
        String expectedName = "Test Weapon";
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        MartialWeapon testWeapon = new MartialWeapon(attackType, 2, expectedName, properties);

        String actualName = testWeapon.getName();

        assertEquals(actualName, expectedName);
    }

    @Test
    void getWeight() {
        int expectedWeight = 2;
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        MartialWeapon testWeapon = new MartialWeapon(attackType, expectedWeight, "Test Weapon", properties);

        int actualWeight = testWeapon.getWeight();

        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    void getProperties() {
        List<String> expectedProperties = new ArrayList<>();
        expectedProperties.add("Property 1");
        expectedProperties.add("Property 2");

        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        MartialWeapon testWeapon = new MartialWeapon(attackType, 2, "Test Weapon", expectedProperties);

        List<String> actualProperties = testWeapon.getProperties();

        assertEquals(actualProperties, expectedProperties);
        assertNotSame(expectedProperties, actualProperties);

    }

    @Test
    void setName() {
        String expectedName = "Test Weapon";
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        MartialWeapon testWeapon = new MartialWeapon(attackType, 2, "expectedName", properties);

        testWeapon.setName(expectedName);
        String actualName = testWeapon.getName();

        assertEquals(actualName, expectedName);
    }

    @Test
    void setWeight() {
        int expectedWeight = 2;
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        MartialWeapon testWeapon = new MartialWeapon(attackType, 4, "Test Weapon", properties);

        testWeapon.setWeight(expectedWeight);
        int actualWeight = testWeapon.getWeight();

        assertEquals(expectedWeight, actualWeight);
    }
}