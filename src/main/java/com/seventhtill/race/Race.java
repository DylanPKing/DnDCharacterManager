package com.seventhtill.race;

import java.util.ArrayList;
import java.util.Map;

public interface Race {
    void initName();
    Map<String, Integer> getAbilityScoreIncrease();
    ArrayList<String> getAbilities();
    ArrayList<String> getLanguages();
    String getName();
}
