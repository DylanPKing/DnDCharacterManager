package com.seventhtill.dndclass.cleric;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.item.Armor;
import com.seventhtill.item.weapon.SimpleWeapon;
import com.seventhtill.magic.Magical;

import java.util.ArrayList;

public abstract class baseCleric implements DnDClass, Magical {
    private int health;
    private HitDice hitDie;
    //Has to be updated after merge
    private ArrayList<Armor> lightArmor;
    private ArrayList<Armor> mediumArmor;
    private ArrayList<SimpleWeapon> weapons;
    private ArrayList<String> tools;
    private ArrayList<String> savingThrows;
    private ArrayList<String> skills;
    //place holder for spell implementation
    private ArrayList<String> spells;

    baseCleric(){
        initHealth();
        initHitDice();
        initArmor();
        initWeapon();
        initTools();
        initSavingThrows();
        initSpells();
    }

    @Override
    public void initHealth(){
        this.health = 8;
    }

    @Override
    public void initHitDice(){
        //1d8
        this.hitDie.setHitDie(8);
    }

    @Override
    public void initArmor(){
        this.lightArmor = new ArrayList<>();
        this.mediumArmor = new ArrayList<>();
        //add method to populate chosen armour
    }

    @Override
    public void initWeapon(){
        this.weapons = new ArrayList<>();
        //add method to populate chosen weapon
    }

    @Override
    public void initTools(){
        this.tools = new ArrayList<>();
    }

    @Override
    public void initSavingThrows(){
        this.savingThrows = new ArrayList<>();
        this.savingThrows.add("Wisdom");
        this.savingThrows.add("Charisma");
    }

    @Override
    public void initSkills(){
        /*Skills: Choose two from History, Insight, Medicine,
        Persuasion, and Religion*/
        this.skills = new ArrayList<>();
    }

    public void initSpells(){
        this.spells = new ArrayList<>();
    }

    public void addSpell(String spell){
        this.spells.add(spell);
    }
}
