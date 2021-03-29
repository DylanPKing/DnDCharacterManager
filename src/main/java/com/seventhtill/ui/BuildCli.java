package com.seventhtill.ui;

// Command class implementing command
public class BuildCli  implements Command {
    private Cli ui;

    // Constructor
    public BuildCli(Cli ui) {
        this.ui = ui;
    }

    // The execute method knows about the presence of the ui member function
    // but doesn't know about the implementation
    public void execute() {
        this.ui.run();
    }
}
