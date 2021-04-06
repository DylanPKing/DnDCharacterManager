package com.seventhtill.item.armour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmourCompositeTest {
    private ArmourComposite testArmourComposite;

    @BeforeEach
    void setUp() {
        testArmourComposite = new ArmourComposite();
        testArmourComposite.add(new LightArmour(10, "Test Armour", false, 6));
        testArmourComposite.add(new Shield());
    }

    @Test
    void getArmourClassModifier() {
        int expectedValue = 14;

        int testDexModifier = 2;

        int actualValue = testArmourComposite.getArmourClassModifier(testDexModifier);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getBaseArmour() {
        int expectedValue = 12;

        int actualValue = testArmourComposite.getBaseArmour();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isDisadvantage() {
        boolean expectedValue = false;

        boolean actualValue = testArmourComposite.isDisadvantage();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getWeight() {
        int expectedValue = 12;

        int actualValue = testArmourComposite.getWeight();

        assertEquals(expectedValue, actualValue);
    }
}