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
    private ArrayList<String> abilities;

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
        this.hitDie = new HitDice();
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
        this.abilities = new ArrayList<>();
        this.abilities.add("Fighting Style");
        this.abilities.add("Second Wind");
    }

    public int getHealth() {
        return health;
    }

    public int getHitDie() {
        return hitDie.getHitDie();
    }

    public ArrayList<Armor> getLightArmor() {
        return lightArmor;
    }

    public ArrayList<Armor> getMediumArmor() {
        return mediumArmor;
    }

    public ArrayList<Armor> getHeavyArmor() {
        return heavyArmor;
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
