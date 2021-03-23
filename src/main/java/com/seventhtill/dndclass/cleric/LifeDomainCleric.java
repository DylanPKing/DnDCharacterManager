package com.seventhtill.dndclass.cleric;

import com.seventhtill.dndclass.HitDice;
import com.seventhtill.item.armour.Armour;

import java.util.ArrayList;

public class LifeDomainCleric extends Cleric {
    private String name;
    private ArrayList<Armour> heavyArmor;

    public LifeDomainCleric() {
        super();
        initName();
        initArmor();
        addSpell("Bless");
        addSpell("Cure Wounds");
    }

    @Override
    public void initName(){this.name = "LIFEDOMAINCLERIC";}

    public void initArmor() {
        this.heavyArmor = new ArrayList<>();
    }

    @Override
    public String getName() {return name;}
}
