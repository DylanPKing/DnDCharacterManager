package com.seventhtill.dndclass;

import java.util.ArrayList;

public class Proficient {
    //Proficiencies
    private String armour = "";
    private String weapon = "";
    private ArrayList<String> weapons = new ArrayList<>();
    private ArrayList<String> tools = new ArrayList<>();
    private ArrayList<String> savingThrows = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();

    public void setArmour(String armour) {
        this.armour = armour;
    }

    public String getArmour() {
        return armour;
    }

    public void addWeapon(String weapon) {
        weapons.add(weapon);
    }

    public ArrayList<String> getWeapons() {
        return weapons;
    }

    public String getWeapon() {
        return weapon;
    }

    public void addTool(String tool) {
        tools.add(tool);
    }

    public ArrayList<String> getTools() {
        return tools;
    }

    public void addSavingThrow(String savingThrow) {
        savingThrows.add(savingThrow);
    }

    public ArrayList<String> getSavingThrows() {
        return savingThrows;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
}
