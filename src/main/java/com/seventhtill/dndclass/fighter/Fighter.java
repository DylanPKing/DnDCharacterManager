package com.seventhtill.dndclass.fighter;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.dndclass.Proficient;

import java.util.ArrayList;

public abstract class Fighter extends DnDClass {
    private HitDice hitdie = new HitDice();
    private Proficient proficienies = new Proficient();
    private String armour = "";
    private int health;
    private ArrayList<String> weapons = new ArrayList<>();
    private ArrayList<String> tools = new ArrayList<>();
    private ArrayList<String> savingThrows = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();

    public Fighter(){
        hitdie.setHitDie(10);
        health = hitdie.initHealth(hitdie.getHitDie());
        proficienies.setArmour("medium");
        armour = proficienies.getArmour();
        proficienies.addWeapon("longsword");
        weapons = proficienies.getWeapons();
        //proficienies.addTool("");
        tools = proficienies.getTools();
        proficienies.addSavingThrow("Strength");
        proficienies.addSavingThrow("Constitution");
        savingThrows = proficienies.getSavingThrows();
        //Choose 2 from Acrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival
        // will need to change to user input later.
        proficienies.addSkill("Animal Handling");
        proficienies.addSkill("Survival");
        skills = proficienies.getSkills();
    }

}
