package com.seventhtill.dndclass.cleric;

import com.seventhtill.item.armour.ArmourComposite;

public class LifeDomainCleric extends Cleric {
    private String name;
    private ArmourComposite armour;

    public LifeDomainCleric() {
        super();
        initName();
        initArmor();
        addSpell("Bless");
        addSpell("Cure Wounds");
    }

    @Override
    public void initName(){
        this.name = "LIFEDOMAINCLERIC";
    }

    public void initArmor() {
        this.armour = new ArmourComposite();
    }

    @Override
    public String getName() {
        return name;
    }
}
