package com.seventhtill.dndclass.fighter;

import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.HitDice;
import com.seventhtill.item.Armor;
import com.seventhtill.item.weapon.SimpleWeapon;

import java.util.ArrayList;

public abstract class baseFighter implements DnDClass {
    private int health;
    private HitDice hitDie;
    //Has to be updated after merge
    private ArrayList<Armor> lightArmor;
    private ArrayList<Armor> mediumArmor;
    private ArrayList<Armor> heavyArmor;
    private ArrayList<SimpleWeapon> weapons;
    private ArrayList<String> tools;
    private ArrayList<String> savingThrows;
    private ArrayList<String> skills;

    baseFighter() {
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
        this.health = 10;
    }

    @Override
    public void initHitDice() {
        //1d10
        this.hitDie.setHitDie(10);
    }

    @Override
    public void initArmor() {
        this.lightArmor = new ArrayList<>();
        this.mediumArmor = new ArrayList<>();
        this.heavyArmor = new ArrayList<>();
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
    }

    @Override
    public void initSavingThrows() {
        this.savingThrows = new ArrayList<>();
        this.savingThrows.add("Strength");
        this.savingThrows.add("Constitution");
    }
    @Override
    public void initSkills() {
        /*
        Skills: Choose two skills from Acrobatics, Animal
        Handling, Athletics, History, Insight, Intimidation,
        Perception, and Survival
         */
        this.skills = new ArrayList<>();
    }

    public void initAbilities() {
        //Adding level one abilities
        this.skills = new ArrayList<>();
        this.skills.add("Fighting Style");
        this.skills.add("Second Wind");
    }
}
