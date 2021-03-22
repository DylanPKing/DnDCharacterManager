package com.seventhtill.dndclass.wizard;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.item.Armor;
import com.seventhtill.item.weapon.SimpleWeapon;
import com.seventhtill.magic.Magical;

import java.util.ArrayList;

public abstract class baseWizard implements DnDClass, Magical {
    private int health;
    private HitDice hitDie;
    //Has to be updated after merge
    private ArrayList<Armor> wizardRobes;
    private ArrayList<SimpleWeapon> weapons;
    private ArrayList<String> tools;
    private ArrayList<String> savingThrows;
    private ArrayList<String> skills;
    //place holder for spell implementation
    private ArrayList<String> spells;

    baseWizard(){
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
        this.health = 6;
    }

    @Override
    public void initHitDice(){
        //1d6
        this.hitDie.setHitDie(6);
    }

    @Override
    public void initArmor(){
        //add method to populate chosen armour
        this.wizardRobes = new ArrayList<>();
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
        this.savingThrows.add("Intelligence");
    }

    @Override
    public void initSkills(){
        /*Skills: Choose two from Arcana, History, Insight,
        Investigation, Medicine, and Religion*/
        this.skills = new ArrayList<>();
    }

    public void initSpells(){
        this.spells = new ArrayList<>();
    }

    public void addSpell(String spell){
        this.spells.add(spell);
    }
}
