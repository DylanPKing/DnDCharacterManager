package com.seventhtill.dndclass.rogue;

public class ThiefRogue extends Rogue {
    private String name;
    public ThiefRogue() {
        super();
        initName();
    }

    @Override
    public void initName() {
        this.name = "THIEFROGUE";
    }

    @Override
    public String getName() {
        return name;
    }
}
