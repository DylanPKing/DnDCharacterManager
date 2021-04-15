package com.seventhtill.item.armour;

import java.util.ArrayList;

public class ArmourComposite implements Armour {
    private int id;

    private ArrayList<Armour> armourCollection;

    public ArmourComposite() {
        armourCollection = new ArrayList<>();
    }

    public ArmourComposite(ArrayList<Armour> armourCollection) {
        this.armourCollection = armourCollection;
    }


    @Override
    public int getBaseArmour() {
        int totalBaseArmour = 0;

        for (Armour armour : armourCollection) {
            totalBaseArmour += armour.getBaseArmour();
        }

        return totalBaseArmour;
    }

    @Override
    public int getArmourClassModifier(int dexModifier) {
        int totalArmour = 0;

        for (Armour armour : armourCollection) {
            totalArmour += armour.getArmourClassModifier(dexModifier);
        }

        return totalArmour;
    }

    @Override
    public boolean isDisadvantage() {
        boolean result = false;

        for (Armour armour : armourCollection) {
            result |= armour.isDisadvantage();
        }

        return result;
    }

    @Override
    public int getWeight() {
        int totalWeight = 0;

        for (Armour armour : armourCollection) {
            totalWeight += armour.getWeight();
        }

        return totalWeight;
    }

    @Override
    public String getName() {
        String names = "";

        for (Armour armour : armourCollection) {
            names = names.concat(armour.getName() + ", ");
        }

        return names.substring(0, names.length() - 2);
    }

    public void add(Armour armour) {
        armourCollection.add(armour);
    }

    public void remove(Armour armour) {
        armourCollection.remove(armour);
    }

    public int getId() {
        return id;
    }
}
