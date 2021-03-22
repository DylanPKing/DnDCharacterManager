package com.seventhtill;

import java.util.ArrayList;
import java.util.List;

// Command pattern invoker
public class CommandInvoker {
    private List<Command> commandList;

    // Constructor
    CommandInvoker() {
        initCommandList();
    }

    // Method allowing to add commands
    public void addCommand(Command command) {
        this.commandList.add(command);
    }

    // Method to execute all the orders in order
    public void executeCommands() {
        for(Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }

    // Initialise the list of commands
    private void initCommandList() {
        this.commandList = new ArrayList<>();
    }
}
