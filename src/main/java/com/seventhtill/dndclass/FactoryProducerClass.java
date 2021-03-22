package com.seventhtill.dndclass;

public class FactoryProducerClass {
    public static AbstractFactoryDndClass getFactory(String classType) {
        if(classType.equalsIgnoreCase("CLERIC")) {
            return new ClericFactory();
        }
        else if(classType.equalsIgnoreCase("FIGHTER")) {
            return new FighterFactory();
        }
        else if(classType.equalsIgnoreCase("ROGUE")) {
            return new RogueFactory();
        }
        else {
            return new WizardFactory();
        }
    }
}