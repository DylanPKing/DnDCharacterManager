package com.seventhtill.dndclass;

import com.seventhtill.dndclass.cleric.Cleric;
import com.seventhtill.dndclass.cleric.LifeDomainCleric;

public class ClericFactory extends AbstractFactoryDndClass {
    @Override
    public DnDClass getDndClass(String classType) {
        if(classType.equalsIgnoreCase("CLERIC")) {
            return new Cleric();
        }
        else if(classType.equalsIgnoreCase(
                "LIFE DOMAIN CLERIC")) {
            return new LifeDomainCleric();
        }
        return null;
    }
}