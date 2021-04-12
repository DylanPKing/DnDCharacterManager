package com.seventhtill.ui;

import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.HeavyArmour;

import java.util.ArrayList;

public class HeavyArmourHelper {
    public HeavyArmourHelper() {

    }

    public ArrayList<Armour> init() {
        ArrayList<Armour> armourList = new ArrayList<>();
        armourList.add(new HeavyArmour(14, "Ring mail", true, 40));
        armourList.add(new HeavyArmour(16, "Chain mail", true, 55));
        armourList.add(new HeavyArmour(17, "Splint", true, 60));
        armourList.add(new HeavyArmour(18, "Plate", true, 65));
        return armourList;
    }
}
