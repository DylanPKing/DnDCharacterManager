package com.seventhtill.dndclass.wizard;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.magic.Magical;

import java.util.ArrayList;

public class Wizard extends baseWizard {

    public Wizard(){
        super();
        //Add level one spells
        addSpell("Spellcasting");
        addSpell("Divine Domain");
    }
}
