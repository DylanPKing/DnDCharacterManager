package com.seventhtill.dndclass.rogue;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.dndclass.Proficient;

import java.util.ArrayList;

public abstract class Rogue extends DnDClass {
    private HitDice hitdie = new HitDice();
    private Proficient proficienies = new Proficient();
    private String armour = "";
    private int health;
    private ArrayList<String> weapons = new ArrayList<>();
    private ArrayList<String> tools = new ArrayList<>();
    private ArrayList<String> savingThrows = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();

    public Rogue(){
        hitdie.setHitDie(8);
        health = hitdie.initHealth(hitdie.getHitDie());
        proficienies.setArmour("Light");
        armour = proficienies.getArmour();
        proficienies.addWeapon("shortsword");
        weapons = proficienies.getWeapons();
        proficienies.addTool("Thieves' tools");
        tools = proficienies.getTools();
        proficienies.addSavingThrow("Dexterity");
        proficienies.addSavingThrow("Intelligence");
        savingThrows = proficienies.getSavingThrows();
        //Choose four from Acrobatics, Athletics, Deception, Insight, Intimidation, Investigation,
        //Perception, Performance, Persuasion, Sleight of Hand and Stealth
        // will need to change to user input later.
        proficienies.addSkill("Deception");
        proficienies.addSkill("Investigation");
        proficienies.addSkill("Sleight of Hand");
        proficienies.addSkill("Stealth");
        skills = proficienies.getSkills();
    }
}
