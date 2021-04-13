package com.seventhtill.interceptor;

public class CharacterCreateInterceptor implements Interceptor {

    @Override
    public void onBeginning() {
        System.out.println("Creating character now");
    }

    @Override
    public void onEnd(CharacterContext character) {
        System.out.println(character);
    }
}