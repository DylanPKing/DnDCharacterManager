package com.seventhtill.dbManager;

import com.seventhtill.common.DamageType;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.item.Item;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.item.weapon.WeaponAttackType;
import com.seventhtill.race.Race;

import java.util.ArrayList;
import java.util.List;

public class DnDCharacterDTO {
    private String characterName;
    private Race characterRace;
    private DnDClass characterClass;
    private Item characterItem;
    private Weapon characterWeapon;
    private Armour characterArmour;
    //Add armour
    //private int armourId;
    private int baseArmour;
    private String armourName;
    private boolean disadvantage;
    private int armourWeight;
    //Add weapon
    //private int weaponId;
    private WeaponAttackType attackType;
    private int weaponWeight;
    private String weaponName;
    private List<String> properties;
    private int damageDie;
    private DamageType damageType;

    public DnDCharacterDTO(String characterName, Race characterRace, DnDClass characterClass, Item characterItem, Weapon characterWeapon, Armour characterArmour, int baseArmour, String armourName, boolean disadvantage, int armourWeight, WeaponAttackType attackType, int weaponWeight, String weaponName, List<String> properties, int damageDie, DamageType damageType) {
        this.characterName = characterName;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.characterItem = characterItem;
        this.characterWeapon = characterWeapon;
        this.characterArmour = characterArmour;
        //this.armourId = armourId;
        this.baseArmour = baseArmour;
        this.armourName = armourName;
        this.disadvantage = disadvantage;
        this.armourWeight = armourWeight;
        //this.weaponId = weaponId;
        this.attackType = attackType;
        this.weaponWeight = weaponWeight;
        this.weaponName = weaponName;
        this.properties = properties;
        this.damageDie = damageDie;
        this.damageType = damageType;
    }

    public void setCharacterName(String name) {
        characterName = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterRace(Race race) {
        characterRace = race;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    public void setCharacterClass(DnDClass aClass) {
        characterClass= aClass;
    }

    public DnDClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterItems(Item item) {
        characterItem = item;
    }

    public Item getCharacterItem() {
        return characterItem;
    }

    public void setCharacterWeapon(Weapon weapon) {
        characterWeapon = weapon;
    }

    public Weapon getCharacterWeapon() {
        return  characterWeapon;
    }

    public void setCharacterArmour(Armour armour) {
        characterArmour = armour;
    }

    public Armour getCharacterArmour() {
        return characterArmour;
    }

    public int getBaseArmour() {
        return baseArmour;
    }

    public void setBaseArmour(int baseArmour) {
        this.baseArmour = baseArmour;
    }

    public String getArmourName() {
        return armourName;
    }

    public void setArmourName(String armourName) {
        this.armourName = armourName;
    }

    public boolean isDisadvantage() {
        return disadvantage;
    }

    public void setDisadvantage(boolean disadvantage) {
        this.disadvantage = disadvantage;
    }

    public int getArmourWeight() {
        return armourWeight;
    }

    public void setArmourWeight(int armourWeight) {
        this.armourWeight = armourWeight;
    }

    public WeaponAttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(WeaponAttackType attackType) {
        this.attackType = attackType;
    }

    public int getWeaponWeight() {
        return weaponWeight;
    }

    public void setWeaponWeight(int weaponWeight) {
        this.weaponWeight = weaponWeight;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public List<String> getProperties() {
        return new ArrayList<>(properties);
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public void setDamageDie(int damageDie) {
        this.damageDie = damageDie;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

}
