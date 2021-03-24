package com.seventhtill.item.weapon;

import com.seventhtill.common.DamageType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SimpleWeaponTest {

    @Test
    void getName() {
        String expectedName = "Test Weapon";
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        SimpleWeapon testWeapon = new SimpleWeapon(attackType, 2, expectedName, properties);

        String actualName = testWeapon.getName();

        assert expectedName.equals(actualName);
    }

    @Test
    void getWeight() {
        int expectedWeight = 2;
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        SimpleWeapon testWeapon = new SimpleWeapon(attackType, expectedWeight, "Test Weapon", properties);

        int actualWeight = testWeapon.getWeight();

        assert expectedWeight == actualWeight;
    }

    @Test
    void getProperties() {
        List<String> expectedProperties = new ArrayList<>();
        expectedProperties.add("Property 1");
        expectedProperties.add("Property 2");

        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        SimpleWeapon testWeapon = new SimpleWeapon(attackType, 2, "Test Weapon", expectedProperties);

        List<String> actualProperties = testWeapon.getProperties();

        assert expectedProperties.equals(actualProperties);
        assert expectedProperties != actualProperties;

    }

    @Test
    void setName() {
        String expectedName = "Test Weapon";
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        SimpleWeapon testWeapon = new SimpleWeapon(attackType, 2, "expectedName", properties);

        testWeapon.setName(expectedName);
        String actualName = testWeapon.getName();

        assert expectedName.equals(actualName);
    }

    @Test
    void setWeight() {
        int expectedWeight = 2;
        MeleeWeaponAttack attackType = new MeleeWeaponAttack(6, DamageType.BLUDGEONING);
        List<String> properties = new ArrayList<>();
        SimpleWeapon testWeapon = new SimpleWeapon(attackType, 4, "Test Weapon", properties);

        testWeapon.setWeight(expectedWeight);
        int actualWeight = testWeapon.getWeight();

        assert expectedWeight == actualWeight;
    }
}