package com.seventhtill.item.armour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {

    @Test
    void getArmourClassModifier() {
        int expectedValue = 2;

        Shield testShield = new Shield();

        int actualValue = testShield.getArmourClassModifier(0);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getBaseArmour() {
        int expectedValue = 2;

        Shield testShield = new Shield();

        int actualValue = testShield.getBaseArmour();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isDisadvantage() {
        boolean expectedValue = false;

        Shield testShield = new Shield();

        boolean actualValue = testShield.isDisadvantage();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getWeight() {
        int expectedValue = 6;

        Shield testShield = new Shield();

        int actualValue = testShield.getWeight();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getName() {
        String expectedValue = "Shield";

        Shield testShield = new Shield();

        String actualValue = testShield.getName();

        assertEquals(actualValue, expectedValue);
    }
}