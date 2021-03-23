package com.seventhtill.item.armour;

import com.seventhtill.item.Item;

public interface Armour extends Item {
    int getBaseArmour();
    int getWeight();
    boolean isDisadvantage();

    default int getArmourClassModifier(int dexModifier) {
        return getBaseArmour() + dexModifier;
    }
}
