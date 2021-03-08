package com.seventhtill.magic;

import java.util.List;

public class Spell {
    public Spell(String magicSchool, int SpellLevel, String castingTime, int rangeDistInFeet, String spellShape,
                 String duration, boolean vocal, boolean somatic, boolean concentration, List<String> components,
                 String description, List<CastingClass> casterClasses){

    }
//    magicSchool will be the school of magic of the spell e.g.conjouration
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
