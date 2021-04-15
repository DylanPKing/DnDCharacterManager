package com.seventhtill.dndclass;

import com.seventhtill.item.weapon.SimpleWeapon;

import java.util.ArrayList;

public interface DnDClass {
    void initName();
    void initHealth();
    void initHitDice();
    void initArmor();
    void initWeapon();
    void initTools();
    void initSavingThrows();
    void initSkills();

    String getName();
    int getHealth();
    int getHitDie();
    ArrayList<SimpleWeapon> getWeapons();
    ArrayList<String> getTools();
    ArrayList<String> getSavingThrows();
    ArrayList<String> getSkills();

}
