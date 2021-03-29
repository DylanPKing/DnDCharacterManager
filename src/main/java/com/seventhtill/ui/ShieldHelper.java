package com.seventhtill.ui;

import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.Shield;

import java.util.ArrayList;

public class ShieldHelper {
    ShieldHelper() {

    }

    public ArrayList<Armour> init() {
        ArrayList<Armour> shield = new ArrayList<>();
        shield.add(new Shield());
        return shield;
    }
}
