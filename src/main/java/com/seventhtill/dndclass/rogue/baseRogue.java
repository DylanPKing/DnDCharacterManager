package com.seventhtill.dndclass.rogue;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.item.Armor;
import com.seventhtill.item.weapon.SimpleWeapon;

import java.util.ArrayList;

public abstract class baseRogue implements DnDClass {
    private int health;
    private HitDice hitDie;
    //Has to be updated after merge
    private ArrayList<Armor> lightArmor;
    private ArrayList<SimpleWeapon> weapons;
    private ArrayList<String> tools;
    private ArrayList<String> savingThrows;
    private ArrayList<String> skills;

    baseRogue() {
        initHealth();
        initHitDice();
        initArmor();
        initWeapon();
        initTools();
        initSavingThrows();
        initSkills();
        initAbilities();
    }

    @Override
    public void initHealth() {
        this.health = 8;
    }

    @Override
    public void initHitDice() {
        //1d8
        this.hitDie.setHitDie(8);
    }

    @Override
    public void initArmor() {
        this.lightArmor = new ArrayList<>();
        //add method to populate chosen armour
    }

    @Override
    public void initWeapon() {
        this.weapons = new ArrayList<>();
        //add method to populate chosen weapon
    }

    @Override
    public void initTools() {
        this.tools = new ArrayList<>();
        this.tools.add("Thieves' Tools");
    }

    @Override
    public void initSavingThrows() {
        this.savingThrows = new ArrayList<>();
        this.savingThrows.add("Dexterity");
        this.savingThrows.add("Intelligence");
    }

    @Override
    public void initSkills() {
        /*
        Skills: Choose four from Acrobatics, Athletics, Deception, Insight, Intimidation, Investigation,
        Perception, Performance, Persuasion, Sleight of Hand, and Stealth
         */
        this.skills = new ArrayList<>();
    }

    public void initAbilities() {
        //Adding level one abilities
        this.skills = new ArrayList<>();
        this.skills.add("Expertise");
        this.skills.add("Sneak Attack");
        this.skills.add("Thieves' Cant");
    }
}
