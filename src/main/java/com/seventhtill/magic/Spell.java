package com.seventhtill.magic;

import java.util.List;

public class Spell {
    private String spellName;
    private String magicSchool;
    private int spellLevel;
    private String castingTime;
    private int rangeDistInFeet;
    private String spellShape;
    private String duration;
    private boolean vocal;
    private boolean somatic;
    private boolean concentration;
    private List<String> components;
    private String description;
    private List<String> casterClasses;

    public Spell(String spellName, String magicSchool, int spellLevel, String castingTime, int rangeDistInFeet, String spellShape,
                 String duration, boolean vocal, boolean somatic, boolean concentration, List<String> components,
                 String description, List<String> casterClasses) {

        this.spellName = spellName;
        this.magicSchool = magicSchool;
        this.spellLevel = spellLevel;
        this.castingTime = castingTime;
        this.rangeDistInFeet = rangeDistInFeet;
        this.spellShape = spellShape;
        this.duration = duration;
        this.vocal = vocal;
        this.somatic = somatic;
        this.concentration = concentration;
        this.components = components;
        this.description = description;
        this.casterClasses = casterClasses;
    }

    public String getSpellName() {
        return spellName;
    }

    public String getMagicSchool() {
        return magicSchool;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public int getRangeDistInFeet() {
        return rangeDistInFeet;
    }

    public String getSpellShape() {
        return spellShape;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isVocal() {
        return vocal;
    }

    public boolean isSomatic() {
        return somatic;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public List<String> getComponents() {
        return components;
    }

    public String getDescription() {
        return description;
    }

//    public boolean canCast(Character character) {
//        String charClass = character.getClass().getClassName();
//        return casterClasses.contains(charClass);
//    }

//    spellName is the name of the spell
//    magicSchool will be the school of magic of the spell e.g.conjuration
//    spellLevel is the spell level, 0-2 for this project
//    castingTime is the time taken to cast the spell, String because unit of time is action or bonus action etc.
//    rangeDistInFeet is the distance the spell has effect in or the max distance a target can be from the spellcaster
//    the target of a spell can be
//    spellShape is the shape the spell takes when cast, eg. cone or sphere.
//    duration is a string for a similar reason to castingTime it can be instantaneous and until dispelled
//    or a unit of time like 10 minutes or 8 hours
//    vocal is a boolean as some spells have a spoken component
//    somantic is also a bool and this is true if a spell requires a hand movement
//    concentration is if a spell needs the caster to concentrate on keeping it active for it's duration. A caster can
//    only cast 1 concentration spell at a time.
//    components are the items required for a spell, a string rather than an item because many are so small that they
//    are not recognised as items such as 'a tiny scrap of white cloth'
//    description is the spell description, which details the specifics of what the spell does and what dice need to be
//    rolled to cast the spell
//    casterClasses is a list of the classes that can cast the spell. Some spells can only be cast by one class,
//    others can be cast by multiple classes.
}
