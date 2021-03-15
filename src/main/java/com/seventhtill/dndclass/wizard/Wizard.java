package com.seventhtill.dndclass.wizard;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.dndclass.Proficient;
import com.seventhtill.magic.Magical;

import java.util.ArrayList;

public class Wizard extends DnDClass implements Magical {
    private HitDice hitdie = new HitDice();
    private Proficient proficienies = new Proficient();
    private String armour = "";
    private int health;
    private ArrayList<String> weapons = new ArrayList<>();
    private ArrayList<String> tools = new ArrayList<>();
    private ArrayList<String> savingThrows = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();

    public Wizard(){
        hitdie.setHitDie(6);
        health = hitdie.initHealth(hitdie.getHitDie());
        proficienies.setArmour("None");
        armour = proficienies.getArmour();
        proficienies.addWeapon("quarterstaff");
        weapons = proficienies.getWeapons();
        //proficienies.addTool();
        tools = proficienies.getTools();
        proficienies.addSavingThrow("Wisdom");
        proficienies.addSavingThrow("Intelligence");
        savingThrows = proficienies.getSavingThrows();
        //Choose two from Arcana, History, Insight,
        //Investigation, Medicine and Religion
        // will need to change to user input later.
        proficienies.addSkill("Arcana");
        proficienies.addSkill("Insight");
        skills = proficienies.getSkills();
    }
}
