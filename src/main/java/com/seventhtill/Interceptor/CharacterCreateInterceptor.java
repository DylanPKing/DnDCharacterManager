package com.seventhtill.Interceptor;

public class CharacterCreateInterceptor implements Interceptor {

    @Override
    public void onBeginning(Character character) {
        System.out.println("Creating character now");
    }

    @Override
    public void onEnd(Character character) {
        System.out.println("Character created!!!");
    }
}
