package com.seventhtill.race;

import com.seventhtill.race.human.StandardHuman;

public class HumanFactory extends AbstractFactory{
    @Override
    public Race getRace(String raceType) {
        if(raceType.equalsIgnoreCase("STANDARDHUMAN")) {
            return new StandardHuman();
        }
        return null;
    }
}
