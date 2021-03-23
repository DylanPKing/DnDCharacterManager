package com.seventhtill;

        import com.seventhtill.dndclass.AbstractFactoryDndClass;
        import com.seventhtill.dndclass.FactoryProducerClass;
        import com.seventhtill.dndclass.DnDClass;

public class Main {
    public static void main(String[] args) {
        AbstractFactoryDndClass classFactory = FactoryProducerClass.getFactory("cleric");
        DnDClass character = classFactory.getDndClass("Cleric");
        System.out.println(character.getHealth());
        System.out.println(character.getHitDie());
        System.out.println(character.getSavingThrows());

        AbstractFactory raceFactory = FactoryProducer.getFactory("elf");
        Race character = raceFactory.getRace("woodelf");
        System.out.println(character.getAbilities());
    }
}
