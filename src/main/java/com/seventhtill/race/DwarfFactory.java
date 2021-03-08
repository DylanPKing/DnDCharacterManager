package com.seventhtill.race;

import com.seventhtill.race.dwarf.HillDwarf;
import com.seventhtill.race.dwarf.MountainDwarf;

public class DwarfFactory extends AbstractFactory {
    @Override
    public Race getRace(String raceType) {
        if(raceType.equalsIgnoreCase("HILLDWARF")) {
            return new HillDwarf();
        }
        else if(raceType.equalsIgnoreCase(
                                        "MOUNTAINDWARF")) {
            return new MountainDwarf();
        }
        return null;
    }
}
