package com.seventhtill.race;

public class FactoryProducer {
    public static AbstractFactory getFactory(String race) {
        if(race.equalsIgnoreCase("DWARF")) {
            return new DwarfFactory();
        }
        else if(race.equalsIgnoreCase("ELF")) {
            return new ElfFactory();
        }
        else if(race.equalsIgnoreCase("HALFLING")) {
            return new HalflingFactory();
        }
        else {
            return new HumanFactory();
        }
    }
}
