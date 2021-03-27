package com.seventhtill.item.armour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediumArmourTest {

    @Test
    void getArmourClassModifierLessThanTwo() {
        int expectedValue = 12;

        int testBaseArmour = 11;
        MediumArmour testArmour = new MediumArmour(testBaseArmour, "Test Armour", false, 6);
        int testDexModifier = 1;

        int actualValue = testArmour.getArmourClassModifier(testDexModifier);

        assert expectedValue == actualValue;
    }

    @Test
    void getArmourClassModifierGreaterThanTwo() {
        int expectedValue = 13;

        int testBaseArmour = 11;
        MediumArmour testArmour = new MediumArmour(testBaseArmour, "Test Armour", false, 6);
        int testDexModifier = 3;

        int actualValue = testArmour.getArmourClassModifier(testDexModifier);

        assert expectedValue == actualValue;
    }

    @Test
    void getBaseArmour() {
        int expectedValue = 11;

        int testBaseArmour = 11;
        MediumArmour testArmour = new MediumArmour(testBaseArmour, "Test Armour", false, 6);

        int actualValue = testArmour.getBaseArmour();

        assert expectedValue == actualValue;
    }

    @Test
    void isDisadvantage() {
        boolean expectedValue = false;

        MediumArmour testArmour = new MediumArmour(10, "Test Armour", expectedValue, 6);

        boolean actualValue = testArmour.isDisadvantage();

        assert expectedValue == actualValue;
    }

    @Test
    void getWeight() {
        int expectedValue = 6;

        MediumArmour testArmour = new MediumArmour(10, "Test Armour", false, expectedValue);

        int actualValue = testArmour.getWeight();

        assert expectedValue == actualValue;
    }

    @Test
    void getName() {
        String expectedValue = "Test Armour";

        MediumArmour testArmour = new MediumArmour(10, expectedValue, false, 6);

        String actualValue = testArmour.getName();

        assert expectedValue.equals(actualValue);
    }
}