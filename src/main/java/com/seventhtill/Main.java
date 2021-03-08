package com.seventhtill;

import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        AbstractFactory raceFactory = FactoryProducer.getFactory("elf");
        Race character = raceFactory.getRace("woodelf");
        System.out.println(character.getAbilities());
    }
}
