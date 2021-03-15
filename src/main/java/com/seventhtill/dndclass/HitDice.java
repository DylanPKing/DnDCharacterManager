package com.seventhtill.dndclass;

public class HitDice {
    //Hit Points
    private int hitDie = 0;

    public HitDice() {
        getHitDie();
    }

     public int getHitDie() {
        return hitDie;
    }
    public void setHitDie(int hitDie) { //Hit die for class
        this.hitDie = hitDie;
    }

    public int initHealth(int hitDie) {
        hitDie = (int)(Math.random() * getHitDie()) + 1;
        return  hitDie;
    }

    public int rollHitDie(int hitDie, int bonus) {
        hitDie = (int)(Math.random() * getHitDie()) + 1;
        hitDie = hitDie + bonus;
        return  hitDie;
    }
}
