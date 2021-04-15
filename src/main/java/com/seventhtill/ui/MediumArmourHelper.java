package com.seventhtill.ui;

import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.MediumArmour;

import java.util.ArrayList;

public class MediumArmourHelper {
    public MediumArmourHelper() {

    }

    public ArrayList<Armour> init() {
        ArrayList<Armour> armourList = new ArrayList<>();
        armourList.add(new MediumArmour(12, "Hide", false, 12));
        armourList.add(new MediumArmour(13, "Chain shirt", false, 20));
        armourList.add(new MediumArmour(14, "Scale mail", true, 45));
        armourList.add(new MediumArmour(14, "Breastplate", false, 20));
        armourList.add(new MediumArmour(15, "Half plate", true, 40));
        return armourList;
    }
}
