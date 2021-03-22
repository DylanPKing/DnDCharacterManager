package com.seventhtill.dndclass;

public class HitDice {
    //Hit Points
    private int hitDie;

    public HitDice() {
        this.hitDie = 0;
    }

    public int getHitDie() {
        return hitDie;
    }
    public void setHitDie(int hitDie) { //Hit die for class
        this.hitDie = hitDie;
    }

    public int rollHitDie(int hitDie, int bonus) {
        hitDie = (int)(Math.random() * hitDie) + 1;
        hitDie = hitDie + bonus;
        return  hitDie;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
