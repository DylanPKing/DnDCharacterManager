package com.seventhtill.dndclass;

import com.seventhtill.dndclass.fighter.ChampionFighter;
import com.seventhtill.dndclass.fighter.Fighter;

public class FighterFactory extends AbstractFactoryDndClass {
    @Override
    public DnDClass getDndClass(String classType) {
        if(classType.equalsIgnoreCase("FIGHTER")) {
            return new Fighter();
        }
        else if(classType.equalsIgnoreCase(
                "CHAMPIONFIGHTER")) {
            return new ChampionFighter();
        }
        return null;
    }
}


