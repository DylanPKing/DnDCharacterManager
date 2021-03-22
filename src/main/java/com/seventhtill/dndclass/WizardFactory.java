package com.seventhtill.dndclass;

import com.seventhtill.dndclass.wizard.EvocationWizard;
import com.seventhtill.dndclass.wizard.Wizard;

public class WizardFactory extends AbstractFactoryDndClass {
    @Override
    public DnDClass getDndClass(String classType) {
        if(classType.equalsIgnoreCase("WIZARD")) {
            return new Wizard();
        }
        else if(classType.equalsIgnoreCase(
                "EVOCATION WIZARD")) {
            return new EvocationWizard();
        }
        return null;
    }
}