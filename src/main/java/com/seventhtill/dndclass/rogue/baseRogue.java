package com.seventhtill.dndclass.rogue;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.SimpleWeapon;

import java.util.ArrayList;

public abstract class baseRogue implements DnDClass {
    private int health;
    private HitDice hitDie;
    //Has to be updated after merge
    private ArrayList<Armour> lightArmor;
    private ArrayList<SimpleWeapon> weapons;
    private ArrayList<String> tools;
    private ArrayList<String> savingThrows;
    private ArrayList<String> skills;
    private ArrayList<String> abilities;

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
        this.hitDie = new HitDice();
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
        this.abilities = new ArrayList<>();
        this.abilities.add("Expertise");
        this.abilities.add("Sneak Attack");
        this.abilities.add("Thieves' Cant");
    }

    public int getHealth() {
        return health;
    }

    public int getHitDie() {
        return hitDie.getHitDie();
    }

    public ArrayList<Armour> getLightArmor() {
        return lightArmor;
    }

    public ArrayList<SimpleWeapon> getWeapons() {
        return weapons;
    }

    public ArrayList<String> getTools() {
        return tools;
    }

    public ArrayList<String> getSavingThrows() {
        return savingThrows;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }
}
