package com.seventhtill.dndclass.wizard;

public class EvocationWizard extends baseWizard {
    private String name;
    public EvocationWizard(){
        super();
        initName();
    }

    @Override
    public void initName() {
        this.name = "EVOCATIONWIZARD";
    }

    @Override
    public String getName() {
        return name;
    }
}
