package com.seventhtill.dndclass.cleric;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.dndclass.Proficient;
import com.seventhtill.magic.Magical;

import java.util.ArrayList;

public abstract class Cleric extends DnDClass implements Magical {
    private HitDice hitdie = new HitDice();
    private Proficient proficienies = new Proficient();
    private String armour = "";
    private int health;
    private ArrayList<String> weapons = new ArrayList<>();
    private ArrayList<String> tools = new ArrayList<>();
    private ArrayList<String> savingThrows = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();

    public Cleric() {
        hitdie.setHitDie(8);
        health = hitdie.initHealth(hitdie.getHitDie());
        proficienies.setArmour("light");
        armour = proficienies.getArmour();
        proficienies.addWeapon("light hammer");
        weapons = proficienies.getWeapons();
        //proficienies.addTool("");
        tools = proficienies.getTools();
        proficienies.addSavingThrow("Wisdom");
        proficienies.addSavingThrow("Charisma");
        savingThrows = proficienies.getSavingThrows();
        //Choose 2 from History, Insight, Medicine, Persuasion and Religion, will need to change to user input later.
        proficienies.addSkill("Religion");
        proficienies.addSkill("Medicine");
        skills = proficienies.getSkills();
    }
}
