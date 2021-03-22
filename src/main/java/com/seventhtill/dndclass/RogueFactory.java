package com.seventhtill.dndclass;


import com.seventhtill.dndclass.rogue.Rogue;
import com.seventhtill.dndclass.rogue.ThiefRogue;

public class RogueFactory extends AbstractFactoryDndClass {
    @Override
    public DnDClass getDndClass(String classType) {
        if(classType.equalsIgnoreCase("ROGUE")) {
            return new Rogue();
        }
        else if(classType.equalsIgnoreCase(
                "THIEF ROGUE")) {
            return new ThiefRogue();
        }
        return null;
    }
}