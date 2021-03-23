package com.seventhtill.dndclass.fighter;

public class ChampionFighter extends baseFighter {
private String name;
    public ChampionFighter(){
        super();
        initName();
    }

    @Override
    public void initName() {this.name = "CHAMPIONFIGHTER";}

    @Override
    public String getName() {return name;}
}
