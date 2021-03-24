package com.seventhtill.dndclass.cleric;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.magic.Magical;

public class Cleric extends baseCleric implements DnDClass, Magical {

    public Cleric() {
        super();
        //Add level one spells
        addSpell("Spellcasting");
        addSpell("Divine Domain");
    }
}
