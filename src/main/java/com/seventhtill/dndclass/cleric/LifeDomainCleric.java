package com.seventhtill.dndclass.cleric;

import com.seventhtill.dndclass.HitDice;
import com.seventhtill.item.armour.Armour;

import java.util.ArrayList;

public class LifeDomainCleric extends Cleric {
    private ArrayList<Armour> heavyArmor;
    public LifeDomainCleric() {
        super();
        initArmor();
        addSpell("Bless");
        addSpell("Cure Wounds");
    }

    public void initArmor() {
        this.heavyArmor = new ArrayList<>();
    }
}
