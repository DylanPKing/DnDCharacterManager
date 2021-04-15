package com.seventhtill.race.human;

// Concrete standard human class that extends base human
public class StandardHuman extends Human {
    private String name;
    // Constructor
    public StandardHuman() {
        super();
        initName();
    }

    @Override
    public void initName() {
        this.name = "STANDARD HUMAN";
    }

    @Override
    public String getName() {
        return name;
    }
}
