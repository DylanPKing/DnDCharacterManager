package com.seventhtill.race;

import com.seventhtill.race.halfling.LightfootHalfling;
import com.seventhtill.race.halfling.StoutHalfling;

public class HalflingFactory extends AbstractFactory{
    @Override
    public Race getRace(String raceType) {
        if(raceType.equalsIgnoreCase(
                "LIGHTFOOTHALFLING")) {
            return new LightfootHalfling();
        }
        else if(raceType.equalsIgnoreCase(
                "STOUTHALFLING")) {
            return new StoutHalfling();
        }
        return null;
    }
}
