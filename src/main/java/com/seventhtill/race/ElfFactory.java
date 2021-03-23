package com.seventhtill.race;

import com.seventhtill.race.elf.HighElf;
import com.seventhtill.race.elf.WoodElf;

public class ElfFactory extends AbstractFactory{
    @Override
    public Race getRace(String raceType) {
        if(raceType.equalsIgnoreCase("HIGHELF")) {
            return new HighElf();
        }
        else if(raceType.equalsIgnoreCase(
                "WOODELF")) {
            return new WoodElf();
        }
        return null;
    }
}
