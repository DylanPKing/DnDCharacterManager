package com.seventhtill.ui;

import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.LightArmour;

import java.util.ArrayList;

public class LightArmourHelper {
    public LightArmourHelper() {

    }

    public ArrayList<Armour> init() {
        ArrayList<Armour> armourList = new ArrayList<>();
        armourList.add(new LightArmour(11, "Padded Armour", true, 8));
        armourList.add(new LightArmour(11, "Leather Armour", false, 10));
        armourList.add(new LightArmour(12, "Studded Leather Armour", false, 13));
        return armourList;
    }
}
