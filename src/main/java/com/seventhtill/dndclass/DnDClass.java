package com.seventhtill.dndclass;

import com.seventhtill.item.Armor;

import java.util.ArrayList;

public interface DnDClass {
    void initHealth();
    void initHitDice();
    void initArmor();
    void initWeapon();
    void initTools();
    void initSavingThrows();
    void initSkills();
}
