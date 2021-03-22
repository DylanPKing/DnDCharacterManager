package com.seventhtill.dndclass;

import com.seventhtill.item.Armor;
import com.seventhtill.item.weapon.SimpleWeapon;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;

public interface DnDClass {
    void initHealth();
    void initHitDice();
    void initArmor();
    void initWeapon();
    void initTools();
    void initSavingThrows();
    void initSkills();

    int getHealth();
    int getHitDie();
    ArrayList<SimpleWeapon> getWeapons();
    ArrayList<String> getTools();
    ArrayList<String> getSavingThrows();
    ArrayList<String> getSkills();
}
