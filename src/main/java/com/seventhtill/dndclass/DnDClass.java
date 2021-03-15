package com.seventhtill.dndclass;

public abstract class DnDClass {
    private HitDice hitDie;
    private Proficient proficiencies;

    private int health;

    public DnDClass() {
        hitDie = new HitDice();
        //this.health = hitDie.initHealth();

    }


    public void setHitDie(HitDice hitDie) {
        this.hitDie = hitDie;
    }

    public HitDice getHitDie() {
        return hitDie;
    }

}
