package com.seventhtill;

import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // I'm leaving this in for reference
//        AbstractFactory raceFactory = FactoryProducer.getFactory("elf");
//        Race character = raceFactory.getRace("woodelf");
//        System.out.println(character.getAbilities());

        // Set up the runtime using the command pattern
        Cli ui = new Cli();
        BuildCli setupUi = new BuildCli(ui);
        CommandInvoker command = new CommandInvoker();
        command.addCommand(setupUi);

        // Execute the commands that were set up
        command.executeCommands();
    }
}
