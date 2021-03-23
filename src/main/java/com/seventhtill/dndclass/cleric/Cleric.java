package com.seventhtill.dndclass.cleric;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.magic.Magical;

import java.util.ArrayList;

public class Cleric extends baseCleric implements DnDClass, Magical {

    public Cleric() {
        super();
        //Add level one spells
        addSpell("Spellcasting");
        addSpell("Divine Domain");
    }

    @Override
    public String getName() {
        return getName();
    }

}
